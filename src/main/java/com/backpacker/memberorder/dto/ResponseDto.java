package com.backpacker.memberorder.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseDto {

    @Getter
    @Builder
    private static class Body {
        private int state;
        private Object data;
        private String massage;
    }

    public static ResponseEntity<?> success(Object data, String msg) {
        return ResponseEntity.ok(Body.builder()
                                    .state(HttpStatus.OK.value())
                                    .data(data)
                                    .massage(msg)
                                    .build());
    }

}
