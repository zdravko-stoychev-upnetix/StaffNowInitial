package com.upnetix.staffNowTestSuit;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.upnetix.staffNowInitial.GetEnvironmentContractor;
import org.testng.annotations.Test;

public class GetEnvironmentContractorTest extends AbstractTest {
    @Test
    public void testGetEnvResponse(){
        GetEnvironmentContractor getEnvContractor = new GetEnvironmentContractor();
        //getEnvContractor.expectResponseStatus(HttpResponseStatusType.OK_200);
        getEnvContractor.callAPI();
        getEnvContractor.validateResponse();

    }
}

