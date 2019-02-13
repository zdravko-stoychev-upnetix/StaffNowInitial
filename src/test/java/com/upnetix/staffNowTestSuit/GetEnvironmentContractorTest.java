package com.upnetix.staffNowTestSuit;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.upnetix.staffNowInitial.GetEnvironmentContractor;
import org.testng.annotations.Test;

public class GetEnvironmentContractorTest extends AbstractTest {
    @Test
    public void testGetEnvResponse(){
        GetEnvironmentContractor getEnvContractor = new GetEnvironmentContractor();
        getEnvContractor.request.expect().statusCode(200).statusLine("HTTP/1.1 200 ");//expectResponseStatus(HttpResponseStatusType.valueOf("HTTP/1.1 200"));
        getEnvContractor.callAPI();
        getEnvContractor.validateResponse();

    }
}

