package com.bnamericas.helper;

import com.bnamericas.api.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@Component
@Slf4j
public class HttpMockMvcComponent {

    /**
     * @param uri END_POINT to send GET request. i.e "holidays"
     * @return RequestBuilder
     */
    public RequestBuilder getAll(String uri) {
        return MockMvcRequestBuilders
                .get(uri + Constants.HTTP_GET_ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

    /**
     * @param id Key of POJO with Long data type
     * @param uri END_POINT to send GET request. i.e "holiday"
     * @return RequestBuilder
     */
    public RequestBuilder getById(String uri, Long id) {
        return MockMvcRequestBuilders
                .get(uri + "/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

    /**
     * @param content POJO with JSON format
     * @param uri END_POINT to send POST request. i.e "holiday"
     * @return RequestBuilder
     */
    public RequestBuilder post(String uri, String content) {
        return MockMvcRequestBuilders
                .post(uri + Constants.HTTP_POST, content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
    }

    /**
     * @param content POJO with JSON format
     * @param uri END_POINT to send PUT request. i.e "holiday"
     * @return RequestBuilder
     */
    public RequestBuilder put(String uri, String content) {
        return MockMvcRequestBuilders
                .put(uri + Constants.HTTP_PUT, content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
    }

    /**
     * @param uri END_POINT to send PUT request. i.e "holiday"
     * @param id Key of POJO with Long data type
     * @return
     */
    public RequestBuilder delete(String uri, Long id) {
        return MockMvcRequestBuilders
                .delete(uri + Constants.HTTP_DELETE + "?id=" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

}
