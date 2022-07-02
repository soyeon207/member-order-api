package com.backpacker.memberorder.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrdersDto {
    protected Long id;
    protected String orderNumber;
    protected String productName;
    protected LocalDateTime paymentDateTime;
}
