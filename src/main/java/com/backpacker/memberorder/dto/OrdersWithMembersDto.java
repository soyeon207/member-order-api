package com.backpacker.memberorder.dto;

import lombok.Getter;

@Getter
public class OrdersWithMembersDto extends OrdersDto{
    protected MembersDto membersDto;
}
