package com.upnetix.staffNowTestSuit;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.upnetix.staffNowInitial.GetEnvironmentContractor;
import com.upnetix.staffNowInitial.GetUserROOT;
import com.upnetix.staffNowTestSuit.PostAutenticationUser;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class GetUserRootTest extends AbstractTest {
    @Test
    public void testGetRootUser(){
        GetUserROOT getUserROOT= new GetUserROOT();
        //getEnvContractor.expectResponseStatus(HttpResponseStatusType.OK_200);
        PostAutenticationUser.testPostAutToken();
        String bearer = PostAutenticationUser.authentication;
        getUserROOT.request.headers("authorization",bearer);
        Response myProfileRequest = getUserROOT.callAPI();
        String strMyProfile = myProfileRequest.getBody().asString();

        try {
            JSONObject js = new JSONObject(strMyProfile);
            strMyProfile = js.getString("myProfile");

        }catch (JSONException e)
        {
            System.out.println("error " + e.getMessage());
        }
        System.out.println("Moqt profile " + strMyProfile);
       // getUserROOT.validateResponse();

    }
}

