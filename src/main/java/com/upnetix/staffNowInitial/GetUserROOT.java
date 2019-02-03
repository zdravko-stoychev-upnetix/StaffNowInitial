package com.upnetix.staffNowInitial;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetUserROOT extends AbstractApiMethodV2 {
public GetUserROOT() {
        super(null, null);

        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        //System.out.println(Configuration.getEnvArg("api_url"));


        }
        }
