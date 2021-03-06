package com.backpacker.memberorder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto {
    protected Long id;
    protected String orderNumber;
    protected String productName;
    protected LocalDateTime paymentDateTime;
}
