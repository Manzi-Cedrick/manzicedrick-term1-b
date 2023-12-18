package com.example.demo.service;
import com.example.demo.exceptions.InvalidOperationException;
import com.example.demo.services.impls.MathOperatorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorServiceTest {
    @Mock
    private MathOperatorServiceImpl mathOperatorService;
    @Test
    public void OnAdditionOperation_Should_AddProperly() throws InvalidOperationException {
        double operator1 = 20;
        double operator2 = 9;
        String operation = "+";
        double expectedResult = 29.0;

        when(mathOperatorService.doMath(operator1, operator2, operation)).thenReturn(expectedResult);
        double actualMathResult = mathOperatorService.doMath(operator1, operator2, operation);
        assertThat(actualMathResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operator1, operator2, operation);
    }

    @Test
    public void OnSubtractionOperation_Should_SubstractProperly() throws InvalidOperationException {
        double operator1 = 20;
        double operator2 = 9;
        String operation = "-";
        double expectedResult = 11.0;

        when(mathOperatorService.doMath(operator1, operator2, operation)).thenReturn(expectedResult);
        double actualMathResult = mathOperatorService.doMath(operator1, operator2, operation);
        assertThat(actualMathResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operator1, operator2, operation);
    }

    @Test
    public void OnDivideOperation_Should_DivideProperly() throws InvalidOperationException {
        double operator1 = 20;
        double operator2 = 10;
        String operation = "/";
        double expectedResult = 2.0;

        when(mathOperatorService.doMath(operator1, operator2, operation)).thenReturn(expectedResult);
        double actualMathResult = mathOperatorService.doMath(operator1, operator2, operation);
        assertThat(actualMathResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operator1, operator2, operation);
    }

    @Test
    public void OnMultiplicationOperation_Should_MultiplyProperly() throws InvalidOperationException {
        double operator1 = 20;
        double operator2 = 2;
        String operation = "*";
        double expectedResult = 40.0;

        when(mathOperatorService.doMath(operator1, operator2, operation)).thenReturn(expectedResult);
        double actualMathResult = mathOperatorService.doMath(operator1, operator2, operation);
        assertThat(actualMathResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operator1, operator2, operation);
    }
}