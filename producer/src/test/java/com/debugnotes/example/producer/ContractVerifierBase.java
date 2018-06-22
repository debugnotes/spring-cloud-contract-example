package com.debugnotes.example.producer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest (classes=ProducerApplication.class)
public abstract class ContractVerifierBase {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);       // mocks all controllers
        // RestAssuredMockMvc.standaloneSetup(new ServerDefaultController());  // mocks specific controller
    }
}
