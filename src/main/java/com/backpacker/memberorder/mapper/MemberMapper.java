package com.backpacker.memberorder.mapper;

import com.backpacker.memberorder.dto.MembersDto;
import com.backpacker.memberorder.entity.Members;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper extends GenericMapper<Members, MembersDto> {
}
