package com.sst.productservicesst.exceptionhandlers;

import com.sst.productservicesst.dto.ExceptionDto;
import com.sst.productservicesst.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handlerGeneralExceptionHandler(){
        ExceptionDto dto=new ExceptionDto();
        dto.setMessage("Something went wrong!");
        dto.setResolution("Exception");
        ResponseEntity<ExceptionDto> response =new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }


    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handlerArithmeticException(){
        ExceptionDto dto=new ExceptionDto();
        dto.setMessage("Something went wrong!");
        dto.setResolution("ArithmeticException");
        ResponseEntity<ExceptionDto> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }


    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> ArrayIndexOutOfBoundsException(){
        ExceptionDto dto=new ExceptionDto();
        dto.setMessage("Something went wrong!");
        dto.setResolution("ArrayIndexOutOfBoundsException");
        ResponseEntity<ExceptionDto> response=new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto dto=new ExceptionDto();
        dto.setMessage("Invalid product Id"+ productNotFoundException.getId()+ "passed");
        dto.setResolution("ProductNotFoundException caught");
        ResponseEntity<ExceptionDto> response=new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        return response;
        }
}
