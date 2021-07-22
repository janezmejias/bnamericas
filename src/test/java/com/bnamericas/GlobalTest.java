package com.bnamericas;

import com.bnamericas.helper.CleanUpTest;
import com.bnamericas.modularTest.HolidaysTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@RunWith(Suite.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.integration.properties")
@Suite.SuiteClasses({
    CleanUpTest.class,
    HolidaysTest.class
})
public class GlobalTest {
}
