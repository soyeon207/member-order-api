package com.backpacker.memberorder.mapper;

import com.backpacker.memberorder.dto.MemberWithOrdersDto;
import com.backpacker.memberorder.entity.Members;
import com.backpacker.memberorder.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberWithOrdersMapper extends GenericMapper<Members, MemberWithOrdersDto> {

    MemberWithOrdersDto toDTO(Set<Orders> ordersDtoSet, Members member);

}
