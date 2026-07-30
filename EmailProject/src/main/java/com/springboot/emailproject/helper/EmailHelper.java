package com.springboot.emailproject.helper;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmailHelper {
    private String message;
    private HttpStatus httpStatus;
    private boolean success=true;
}
