package com.upnetix.staffNowInitial;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostContractorRegistration  extends AbstractApiMethodV2{


    public PostContractorRegistration() {
        super("staffNow/postRegistrationRq.json" ,null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        //System.out.println(Configuration.getEnvArg("api_url"));


    }
    }

