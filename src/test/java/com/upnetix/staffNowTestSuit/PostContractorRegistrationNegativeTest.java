package com.upnetix.staffNowTestSuit;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.upnetix.staffNowInitial.PostContractorRegistrationNegative;
import org.testng.annotations.Test;


public class PostContractorRegistrationNegativeTest extends AbstractTest {

    @Test
    public void testPostRegistrationNegativeRequest(){
        PostContractorRegistrationNegative postContractorRegistrationNegative =new PostContractorRegistrationNegative();
        postContractorRegistrationNegative.request.expect().statusCode(409).statusLine("HTTP/1.1 409 ");//expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postContractorRegistrationNegative.setBodyContent("{\n" +
                "  \"email\" : \"staffnowtest.79122@gmail.com\",\n" +
                "  \"password\": \"222222\",\n" +
                "  \"termsAgreement\": true,\n" +
                "  \"newsletterAgreement\": true\n" +
                "}")  ;
       postContractorRegistrationNegative.callAPI();
        //postContractorRegistration.validateResponse();

    }
}



