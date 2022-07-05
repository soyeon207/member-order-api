package com.backpacker.memberorder.controller;

import com.backpacker.memberorder.dto.MemberCreateRequest;
import com.backpacker.memberorder.dto.MemberLoginRequest;
import com.backpacker.memberorder.dto.MemberRequest;
import com.backpacker.memberorder.service.MembersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1_0/members")
@RequiredArgsConstructor
public class MembersController {

    private final MembersService membersService;

    @PostMapping
    @Operation(summary = "회원가입 API")
    public ResponseEntity<?> createMember(@Valid @RequestBody MemberCreateRequest memberCreateRequest) {
        return membersService.createMember(memberCreateRequest);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인 API", description = "hello 샘플 예제입니다. ")
    public ResponseEntity<?> login(@Valid @RequestBody MemberLoginRequest memberLoginRequest) {
        return membersService.loginMember(memberLoginRequest);
    }

    @GetMapping("/{memberId}")
    @PreAuthorize("isAuthenticated() and hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "단일 회원 상세 정보 조회 API")
    public ResponseEntity<?> getMember(@PathVariable("memberId") Long memberId) {
        return membersService.getMember(memberId);
    }

    @GetMapping("/{memberId}/orders")
    @PreAuthorize("isAuthenticated() and hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "단일 회원 주문 목록 조회 API")
    public ResponseEntity<?> getOrdersByMember(@PathVariable("memberId") Long memberId) {
        return membersService.getOrdersByMember(memberId);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated() and hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "여러 회원 목록 조회 API")
    public ResponseEntity<?> getMembers(@RequestBody MemberRequest memberRequest, @PageableDefault Pageable pageable) {
        return membersService.getMembers(memberRequest, pageable);
    }

}
