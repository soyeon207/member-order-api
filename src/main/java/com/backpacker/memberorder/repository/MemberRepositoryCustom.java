package com.backpacker.memberorder.repository;

import com.backpacker.memberorder.entity.Members;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberRepositoryCustom {

    Members findByIdWithOrders(Long memberId);

    List<Members> findAllMembersWithPaging(Pageable pageable, String email, String name);

}
