package com.upnetix.staffNowTestSuit;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.upnetix.staffNowInitial.PutUpateContractorProfile;
import org.testng.annotations.Test;

import static com.upnetix.staffNowTestSuit.PostAutenticationUser.authentication;
import static com.upnetix.staffNowTestSuit.PostAutenticationUser.testPostAutToken;


public class PUT_UpdateContractorProfileTest extends AbstractTest {

    @Test
    public void testPutUpdateContractor(){
        PutUpateContractorProfile putUpateContractorProfile =new PutUpateContractorProfile();
     putUpateContractorProfile.expectResponseStatus(HttpResponseStatusType.OK_200);
        testPostAutToken();
       putUpateContractorProfile.request.headers("authorization", authentication);
       putUpateContractorProfile.setBodyContent("{\n" +
               "  \"profile\": {\n" +
               "    \"firstName\": \"Jack\",\n" +
               "    \"lastName\": \"Wick\",\n" +
               "    \"birthDate\": \"1978-01-30\"\n" +
               "  },\n" +
               "  \"contractor\": {\n" +
               "    \"presentation\": \"test presentation\",\n" +
               "    \"experience\": 1,\n" +
               "    \"ameTypeId\": 1,\n" +
               "    \"ameLicenseId\": 2,\n" +
               "    \"airplanes\": [\n" +
               "      1\n" +
               "    ],\n" +
               "    \"otherAirplanes\": \"Space X\"\n" +
               "  }\n" +
               "}") ;
       putUpateContractorProfile.callAPI();
        //putUpateContractorProfile.validateResponse();

    }
}



