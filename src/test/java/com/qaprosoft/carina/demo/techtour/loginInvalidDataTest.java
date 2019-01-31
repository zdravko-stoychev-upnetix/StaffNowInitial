package com.qaprosoft.carina.demo.techtour;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.techtour.PostInvalidLoginData;
import org.testng.annotations.Test;



public class loginInvalidDataTest extends AbstractTest {
    @Test
    public void testGetLoginForm() {
        PostInvalidLoginData postInvalidLoginData = new PostInvalidLoginData();
        postInvalidLoginData.expectResponseStatus(HttpResponseStatusType.UNAUTHORIZED_401);
        postInvalidLoginData.callAPI();
        postInvalidLoginData.validateResponse();
        //postInvalidLoginData.validateResponseAgainstJSONSchema("api/techtour/_post/rs.schema");
    }
}

