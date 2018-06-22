package com.debugnotes.example.consumer.controller;

import com.debugnotes.example.consumer.ConsumerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ConsumerApplication.class})    // extended info may not be required
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = {"com.debugnotes.example:producer:+:stubs:8081"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
//@DirtiesContext // use only if the application context needs to be reset after these tests
public class DefaultControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRemoteServer() throws Exception {
        String expectedContent = "{&quot;cards&quot;:[],&quot;id&quot;:101}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        if (result == null || result.length() <= 0)
            result = "<EMPTY>";
        if (result.contains(expectedContent) == false) {
            throw new Exception("Error - expected content: " + expectedContent + " result: " + result);
        }
    }

}
