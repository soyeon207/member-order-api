package com.backpacker.memberorder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberWithOrdersDto extends MembersDto {

    protected Set<OrdersDto> ordersDtoSet;

}
