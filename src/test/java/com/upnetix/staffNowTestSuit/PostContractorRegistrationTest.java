package com.upnetix.staffNowTestSuit;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.upnetix.staffNowInitial.PostContractorRegistration;
import org.testng.annotations.Test;

import static com.upnetix.staffNowInitial.EmailGenerator.generateRandomEmail;


public class PostContractorRegistrationTest extends AbstractTest {

    @Test
    public void testPostRegistrationRequest(){
        PostContractorRegistration postContractorRegistration =new PostContractorRegistration();
        postContractorRegistration.request.expect().statusCode(201).statusLine("HTTP/1.1 201 ");//expectResponseStatus(HttpResponseStatusType.CREATED_201);
        String email= generateRandomEmail(9);
        System.out.println(email);
        postContractorRegistration.setBodyContent("{\n" +
                "  \"email\" : \"staffnowtest.${generated_word}@gmail.com\",\n" +
                "  \"password\": \"222222\",\n" +
                "  \"termsAgreement\"" +
                "" +
                ": true,\n" +
                "  \"newsletterAgreement\": true\n" +
                "}")  ;
       postContractorRegistration.callAPI();
        //postContractorRegistration.validateResponse();

    }
}



