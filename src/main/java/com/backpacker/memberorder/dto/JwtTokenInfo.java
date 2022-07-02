package com.backpacker.memberorder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtTokenInfo {
    String accessToken;
    String refreshToken;
}
