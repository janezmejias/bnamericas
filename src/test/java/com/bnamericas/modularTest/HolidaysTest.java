package com.bnamericas.modularTest;

import com.bnamericas.api.Constants;
import com.bnamericas.helper.HttpMockMvcComponent;
import com.bnamericas.holidays.model.Holidays;
import com.bnamericas.holidays.service.HolidaysService;
import com.bnamericas.holidays.service.external.HerokuHolidayServiceHandler;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.integration.properties")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@Disabled
public class HolidaysTest {

    private static final String URI = Constants.URI_HOLIDAYS;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    HolidaysService holidaysService;

    @Autowired
    HerokuHolidayServiceHandler herokuHolidayServiceHandler;

    @Autowired
    HttpMockMvcComponent mvcComponent;

    @Test
    public void runAllCases() throws Exception {
        herokuHolidayServiceHandler.holidays().forEach(holiday -> {
            try {
                add(holiday);

                //not-required (additional in this test)
                edit();
                findAll();
                findOne();
                delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void add(Holidays model) throws Exception {
        performAdd(model);
    }

    public void edit() throws Exception {
        Holidays model = holidaysService.findAll().get(0);
        model.setTitle("Año Nuevo - Vida Nueva");

        performEdit(model);
    }

    public void findAll() throws Exception {
        performGetAll();
    }

    public void findOne() throws Exception {
        Holidays model = holidaysService.findAll().get(0);
        performGetOne(model.getId());
    }

    public void delete() throws Exception {
        Holidays model = holidaysService.findAll().get(0);
        performDelete(model.getId());
    }

    private void performAdd(Holidays model) throws Exception {
        Gson gson = new Gson();
        String o = gson.toJson(model);

        mockMvc.perform(mvcComponent.post(URI, o))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performGetAll() throws Exception {
        mockMvc.perform(mvcComponent.getAll(URI))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performGetOne(Long id) throws Exception {
        mockMvc.perform(mvcComponent.getById(URI, id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performEdit(Holidays model) throws Exception {
        Gson gson = new Gson();
        String o = gson.toJson(model);

        mockMvc.perform(mvcComponent.put(URI, o))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performDelete(Long id) throws Exception {
        mockMvc.perform(mvcComponent.delete(URI, id))
                .andExpect(status().isOk());
    }
}
