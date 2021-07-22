package com.bnamericas.helper;

import com.google.gson.Gson;
import static com.bnamericas.api.DefaultResponseCode.SUCCESS_CODE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Component
@Slf4j
public class PerformMockMvcComponent {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    HttpMockMvcComponent httpMockMvcComponent;

    public void performAdd(String uri, Object model) throws Exception {
        Gson gson = new Gson();
        String o = gson.toJson(model);

        mockMvc.perform(httpMockMvcComponent.post(uri, o))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(SUCCESS_CODE));
    }

    public void performGetAll(String uri) throws Exception {
        mockMvc.perform(httpMockMvcComponent.getAll(uri))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(SUCCESS_CODE));
    }

    public void performGetOne(String uri, Long id) throws Exception {
        mockMvc.perform(httpMockMvcComponent.getById(uri, id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(SUCCESS_CODE));
    }

    public void performEdit(String uri, Object model) throws Exception {
        Gson gson = new Gson();
        String o = gson.toJson(model);

        mockMvc.perform(httpMockMvcComponent.put(uri, o))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(SUCCESS_CODE));
    }

    public void performDelete(String uri, Long id) throws Exception {
        mockMvc.perform(httpMockMvcComponent.delete(uri, id))
                .andExpect(status().isOk());
    }
}
