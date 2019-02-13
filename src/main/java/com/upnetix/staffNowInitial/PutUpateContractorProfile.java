package com.upnetix.staffNowInitial;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;



public class PutUpateContractorProfile extends AbstractApiMethodV2 {



    public PutUpateContractorProfile() {
        super("api/staffNow/putUpdateContractorProfileRq.json" ,null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));


    }

}
