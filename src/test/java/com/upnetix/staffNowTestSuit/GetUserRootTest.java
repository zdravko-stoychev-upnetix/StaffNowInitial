package com.upnetix.staffNowTestSuit;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.upnetix.staffNowInitial.GetUserROOT;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.upnetix.staffNowTestSuit.PostAutenticationUser.authentication;

public class GetUserRootTest extends AbstractTest {

    public GetUserRootTest() {
    }

    public static int contractorID;



    @Test
    public void testGetRootUser() throws JSONException {
        GetUserROOT getUserROOT = new GetUserROOT();
        //getEnvContractor.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserROOT.request.expect().statusCode(200).statusLine("HTTP/1.1 200 ");
        PostAutenticationUser.testPostAutToken();
        //bearerToken = authentication;
        getUserROOT.request.headers("authorization", authentication);
        Response myProfileRequest = getUserROOT.callAPI();
        String strMyProfile = myProfileRequest.getBody().asString();


        try {
            JSONObject js = new JSONObject(strMyProfile);
            //strMyProfile = js.getString("_links");
            JSONObject links = js.getJSONObject("_links");
            JSONObject myProfile = links.getJSONObject("myProfile");
            String link = myProfile.getString("href");
            String[] path = link.split("/");
            String last=path[(path.length-1)];
            System.out.println("\n\n\n");
            System.out.println( Arrays.toString(path));

            System.out.println("\n\n\n");
            System.out.println(last);


            contractorID= Integer.parseInt(last) ;


        } catch (JSONException e) {
            System.out.println("error " + e.getMessage());
        }

    }
}
