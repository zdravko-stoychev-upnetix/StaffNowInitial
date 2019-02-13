
package com.upnetix.staffNowInitial;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethod;

    public class PostAuthenticationToken  extends AbstractApiMethod {


        public PostAuthenticationToken() {
            super("application/x-www-form-urlencoded");
            replaceUrlPlaceholder("base_url", "https://test2-staffnow.upnetix.tech");
            //System.out.println(Configuration.getEnvArg("api_url"));


        }
    }


