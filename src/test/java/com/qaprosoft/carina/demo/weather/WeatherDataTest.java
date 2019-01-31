package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.weather.GetWeatherData;
import org.testng.annotations.Test;

@Test
public class WeatherDataTest extends AbstractTest {
    public void testWeatherData(){
        GetWeatherData getWeatherData = new GetWeatherData();
        getWeatherData.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherData.callAPI();
        //getWeatherData.validateResponseAgainstJSONSchema("/home/valentina.baliyska/IdeaProjects/carina-demo/src/test/resources/api/weather/rs.schema");
    }
}
