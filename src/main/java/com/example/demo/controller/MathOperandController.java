package com.example.demo.controller;
import com.example.demo.dto.DoMathRequestDto;
import com.example.demo.exceptions.InvalidOperationException;
import com.example.demo.services.IMathOperatorService;
import com.example.demo.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MathOperandController {
    @Autowired
    private IMathOperatorService mathOperatorService;
    @PostMapping("/do_math")
    public ResponseEntity<ApiResponse> create(@RequestBody DoMathRequestDto doMathRequestDto) throws InvalidOperationException {
        return ResponseEntity.ok(ApiResponse.success(mathOperatorService.doMath(doMathRequestDto.getOperand1(), doMathRequestDto.getOperand2(), doMathRequestDto.getOperation())));
    }
}