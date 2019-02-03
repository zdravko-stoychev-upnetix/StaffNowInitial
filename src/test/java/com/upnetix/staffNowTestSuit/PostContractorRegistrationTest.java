package com.upnetix.staffNowTestSuit;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import org.testng.annotations.Test;
import com.upnetix.staffNowInitial.PostContractorRegistration;


public class PostContractorRegistrationTest extends AbstractTest {

    @Test
    public void testPostRegistrationRequest(){
        PostContractorRegistration postContractorRegistration =new PostContractorRegistration();
        //getEnvContractor.expectResponseStatus(HttpResponseStatusType.OK_200);
        postContractorRegistration.callAPI();
        postContractorRegistration.validateResponse();

    }
}



