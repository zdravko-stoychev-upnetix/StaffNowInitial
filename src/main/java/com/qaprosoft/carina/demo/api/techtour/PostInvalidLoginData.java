package com.qaprosoft.carina.demo.api.techtour;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PostInvalidLoginData extends AbstractApiMethodV2 {
    public PostInvalidLoginData() {
        super(null, "api/techtour/_post/rs.json", "api/techtour/_post/logindata.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
