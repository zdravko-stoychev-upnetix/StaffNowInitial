package com.qaprosoft.carina.demo.api.weather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetWeatherData extends AbstractApiMethodV2 {
    public GetWeatherData() {
        super(null, "/home/valentina.baliyska/IdeaProjects/carina-demo/src/test/resources/api/weather/rs.json", new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
