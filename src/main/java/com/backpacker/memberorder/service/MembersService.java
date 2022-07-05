package com.backpacker.memberorder.service;

import com.backpacker.memberorder.dto.MemberCreateRequest;
import com.backpacker.memberorder.dto.MemberLoginRequest;
import com.backpacker.memberorder.dto.MemberRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface MembersService {

    ResponseEntity<?> createMember(MemberCreateRequest request);

    ResponseEntity<?> loginMember(MemberLoginRequest request);

    ResponseEntity<?> getMember(Long memberId);

    ResponseEntity<?> getOrdersByMember(Long memberId);

    ResponseEntity<?> getMembers(MemberRequest memberRequest, Pageable pageable);
}
