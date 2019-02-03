package com.upnetix.staffNowTestSuit;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.upnetix.staffNowInitial.PostAuthenticationToken;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.net.URLEncoder;


public class PostAutenticationUser extends AbstractTest {

    public static String authentication;

    @Test
    public static void testPostAutToken(){

        PostAuthenticationToken postAuthenticationToken=new PostAuthenticationToken();
        postAuthenticationToken.request.formParam( "grant_type","password");
        postAuthenticationToken.request.formParam( "client_id","staffnow");
        postAuthenticationToken.request.formParam("client_secret","a9513f37-7aab-46fa-a884-8becf81decdd");
        postAuthenticationToken.request.formParam("username","staffnowtest+1@gmail.com");
        postAuthenticationToken.request.formParam("password","111111");

        Response accesstokenrequest = postAuthenticationToken.callAPI();
        String strAuthentication = accesstokenrequest.getBody().asString();

        try {
            JSONObject js = new JSONObject(strAuthentication);
            strAuthentication = js.getString("access_token");

        }catch (JSONException e)
        {
            System.out.println("error " + e.getMessage());
        }

        authentication = "Bearer " + strAuthentication;


    }
}
