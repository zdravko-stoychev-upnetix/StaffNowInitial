package com.qaprosoft.carina.demo.techtour;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.qaprosoft.carina.browsermobproxy.ProxyPool;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.proxy.SystemProxy;

import net.lightbody.bmp.BrowserMobProxy;

public class validateHeadersTest {
    private static String header = "Accdfdsept";
    private static String headerValue = "application/json";
    private static String testUrl = "https://demo-techtour-app-1.upnetix.tech";
    private static String filterKey = "</html>";
    private static String requestMethod = "POST";

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        R.CONFIG.put("browsermob_proxy", "true");
        R.CONFIG.put("browsermob_port", "0");
        R.CONFIG.put("proxy_set_to_system", "true");
        R.CONFIG.put("browsermob_disabled_mitm", "false");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        ProxyPool.stopAllProxies();
    }


    public void testIsBrowserModStarted() {
        initialize();
        Assert.assertTrue(ProxyPool.getProxy().isStarted(), "BrowserMobProxy is not started!");
    }


    public void testBrowserModProxySystemIntegration() {
        initialize();
        Assert.assertEquals(Configuration.get(Parameter.PROXY_HOST), System.getProperty("http.proxyHost"));
        Assert.assertEquals(Configuration.get(Parameter.PROXY_PORT), System.getProperty("http.proxyPort"));
    }

    @Test
    public void testBrowserModProxyHeader() {
        initialize();
        Map<String, String> headers = ProxyPool.getProxy().getAllHeaders();
        Assert.assertTrue(headers.containsKey(header), "There is no custom header: " + header);
        Assert.assertTrue(headers.get(header).equals(headerValue), "There is no custom header value: " + headerValue);

        ProxyPool.getProxy().removeHeader(header);
        if (ProxyPool.getProxy().getAllHeaders().size() != 0) {
            Assert.fail("Custom header was not removed: " + header);
        }
    }


    public void testBrowserModProxyRegisteration() {
        BrowserMobProxy proxy = ProxyPool.startProxy();
        ProxyPool.registerProxy(proxy);
        Assert.assertTrue(ProxyPool.isProxyRegistered(), "Proxy wasn't registered in ProxyPool!");
        ProxyPool.stopAllProxies();
        Assert.assertFalse(ProxyPool.isProxyRegistered(), "Proxy wasn't stopped!");
    }

    private void initialize() {
        ProxyPool.setupBrowserMobProxy();
        SystemProxy.setupProxy();

        BrowserMobProxy proxy = ProxyPool.getProxy();
        proxy.addHeader(header, headerValue);
    }


    private void makeHttpRequest(String requestUrl, String requestMethod) {
        URL url;
        HttpURLConnection con;
        Integer httpResponseStatus;
        try {
            url = new URL(requestUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(requestMethod);
            httpResponseStatus = con.getResponseCode();
            Assert.assertTrue(httpResponseStatus < 399, "Response code is not as expected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
