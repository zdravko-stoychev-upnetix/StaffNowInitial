
package com.upnetix.staffNowInitial;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethod;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;

import com.qaprosoft.carina.core.foundation.utils.Configuration;

    public class PostAuthenticationToken  extends AbstractApiMethod {


        public PostAuthenticationToken() {
            super("application/x-www-form-urlencoded");
            //super(  "staffNow/postRegistrationRq.json" ,null);
            replaceUrlPlaceholder("base_url", "https://test2-staffnow.upnetix.tech");
            //System.out.println(Configuration.getEnvArg("api_url"));


        }
    }


