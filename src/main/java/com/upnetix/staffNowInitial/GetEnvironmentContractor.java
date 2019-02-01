package com.upnetix.staffNowInitial;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetEnvironmentContractor extends AbstractApiMethodV2 {
    public GetEnvironmentContractor() {
        super(null, "staffNow/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        //System.out.println(Configuration.getEnvArg("api_url"));


    }
}