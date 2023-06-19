package com.kipas.miniprojectrestapi.dtos.response;


import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponseDTO<T> {
    private HttpStatus httpStatus;
    private String message;
    private T data;
}
