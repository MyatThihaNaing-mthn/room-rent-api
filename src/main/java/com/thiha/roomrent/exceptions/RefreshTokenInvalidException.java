package com.thiha.roomrent.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RefreshTokenInvalidException extends RuntimeException{
    private String errorMessage;
}
