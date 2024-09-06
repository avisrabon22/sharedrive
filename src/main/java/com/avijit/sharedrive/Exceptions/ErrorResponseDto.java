package com.avijit.sharedrive.Exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    private int statusCode;
    private String message;

    public ErrorResponseDto(int statusCode,String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
