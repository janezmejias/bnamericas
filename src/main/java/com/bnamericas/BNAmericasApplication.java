package com.bnamericas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author janezmejias.09@gmail.com
 * @version 1.0
 * @see 
 */
@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
public class BNAmericasApplication {

    public static void main(String[] args) {
        SpringApplication.run(BNAmericasApplication.class, args);
    }

}
