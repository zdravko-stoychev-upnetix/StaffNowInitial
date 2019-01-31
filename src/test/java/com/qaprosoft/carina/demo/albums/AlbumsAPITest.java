package com.qaprosoft.carina.demo.albums;

import com.jayway.restassured.path.json.JsonPath;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.albums.GetAlbumMethod;
import com.qaprosoft.carina.demo.api.albums.PostAlbumMethod;
import org.testng.annotations.Test;

public class AlbumsAPITest extends AbstractTest {

    @Test
    public void createAlbumTest(){
        PostAlbumMethod postAlbumMethod = new PostAlbumMethod();
        postAlbumMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postAlbumMethod.callAPI();
        String rs = postAlbumMethod.callAPI().asString();
        postAlbumMethod.callAPI();
        postAlbumMethod.validateResponse();

        int albumId = new JsonPath(rs).getInt("albumId");
        GetAlbumMethod getAlbumMethod = new GetAlbumMethod(String.valueOf(albumId));
        getAlbumMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAlbumMethod.callAPI();
    }
}