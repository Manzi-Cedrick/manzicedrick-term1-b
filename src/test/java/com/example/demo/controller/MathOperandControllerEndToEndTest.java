package com.example.demo.controller;
import com.example.demo.dto.DoMathRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MathOperandControllerEndToEndTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testAddition_OperationSuccess() throws Exception {
        DoMathRequestDto doMathRequestDto = new DoMathRequestDto(4, 4, "+");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/do_math")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(doMathRequestDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value(8));
    }

    @Test
    public void testSubstraction_OperationSuccess() throws Exception {
        DoMathRequestDto doMathRequestDto = new DoMathRequestDto(18, 4, "-");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/do_math")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(doMathRequestDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value(16.0));
    }

    @Test
    public void testDivision_OperationSuccess() throws Exception {
        DoMathRequestDto doMathRequestDto = new DoMathRequestDto(16, 4, "/");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/do_math")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(doMathRequestDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value(4.0));
    }

    @Test
    public void testMultiplication_OperationSuccess() throws Exception {
        DoMathRequestDto doMathRequestDto = new DoMathRequestDto(2, 4, "*");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/do_math")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(doMathRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(8.0));
    }

    @Test
    public void testInvalid_OperationFailure() throws Exception {
        DoMathRequestDto doMathRequestDto = new DoMathRequestDto(18, 4, "$");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/do_math")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(doMathRequestDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("An error occurred during the math operation."));
    }
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
