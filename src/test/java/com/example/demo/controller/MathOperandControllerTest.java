package com.example.demo.controller;

import com.example.demo.dto.DoMathRequestDto;
import com.example.demo.utils.ApiResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathOperandControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void doMathRequest_OperationSuccess(){
        DoMathRequestDto dto = new DoMathRequestDto(2, 5, "+");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/do_math",dto,ApiResponse.class);

        assertEquals(200, response.getStatusCode().value());
    }
}