package com.example.demo.controller;
import com.example.demo.dto.DoMathRequestDto;
import com.example.demo.exceptions.InvalidOperationException;
import com.example.demo.services.impls.MathOperatorServiceImpl;
import com.example.demo.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final MathOperatorServiceImpl mathOperatorService;

    @PostMapping("/do_math")
    public ResponseEntity<ApiResponse> create(@RequestBody DoMathRequestDto doMathRequestDto) throws InvalidOperationException {
        try {
            double result = mathOperatorService.doMath(doMathRequestDto.getOperand1(), doMathRequestDto.getOperand2(), doMathRequestDto.getOperation());
            return ResponseEntity.ok(ApiResponse.success(result));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(ApiResponse.fail("An error occurred during the math operation."));
        }
    }
}