package com.backpacker.memberorder.service.impl;

import com.backpacker.memberorder.config.JwtConfig;
import com.backpacker.memberorder.dto.*;
import com.backpacker.memberorder.entity.Members;
import com.backpacker.memberorder.mapper.MemberMapper;
import com.backpacker.memberorder.mapper.MemberWithOrdersMapper;
import com.backpacker.memberorder.repository.MemberRepository;
import com.backpacker.memberorder.service.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembersServiceImpl implements MembersService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtConfig jwtConfig;
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final MemberWithOrdersMapper memberWithOrdersMapper;

    @Override
    public ResponseEntity<?> createMember(MemberCreateRequest request) {
        Members members = memberRepository.save(Members.builder()
                                                        .name(request.getName())
                                                        .nickname(request.getNickname())
                                                        .password(bCryptPasswordEncoder.encode(request.getPassword()))
                                                        .email(request.getEmail())
                                                        .gender(request.getGender())
                                                        .userRole(request.convertUserRole())
                                                        .build());

        return ResponseDto.success(memberMapper.toDto(members), "???????????? ??????");
    }

    @Override
    public ResponseEntity<?> loginMember(MemberLoginRequest request) {
        Members members = Optional
                            .ofNullable(memberRepository.findByEmail(request.getEmail()))
                            .orElseThrow(()->new BadCredentialsException("???????????? ?????? ???????????????. ???????????? ?????? ??????????????????."));

        if (!bCryptPasswordEncoder.matches(request.getPassword(), members.getPassword())) {
            throw new BadCredentialsException("??????????????? ??????????????????.");
        }

        JwtTokenInfo jwtTokenInfo = jwtConfig.createToken(members.getEmail(), Collections.singletonList(members.getUserRole().toString()));
        return ResponseDto.success(jwtTokenInfo, "????????? ??????");
    }

    @Override
    public ResponseEntity<?> getMember(Long memberId) {
        Members members = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new BadCredentialsException("??????????????? ?????? ??? ????????????."));

        return ResponseDto.success(memberMapper.toDto(members), "???????????? ???????????? ??????");
    }

    @Override
    public ResponseEntity<?> getOrdersByMember(Long memberId) {
        Members members = Optional
                .ofNullable(memberRepository.findByIdWithOrders(memberId))
                .orElseThrow(() -> new BadCredentialsException("??????????????? ?????? ??? ????????????."));

        return ResponseDto.success(memberWithOrdersMapper.toDTO(members.getOrdersSet(), members), "???????????? ???????????? ??????");
    }

    @Override
    public ResponseEntity<?> getMembers(String name, String email, Pageable pageable) {
        List<Members> membersList = memberRepository.findAllMembersWithPaging(pageable, email, name);
        List<MembersDto> membersDtoList = membersList
                .stream()
                .map(memberMapper::toDto)
                .collect(Collectors.toList());

        Page<MembersDto> membersDtoPage = new PageImpl<>(membersDtoList, pageable, membersDtoList.size());
        return ResponseDto.success(membersDtoPage.getContent(), "???????????? ???????????? ??????");
    }

}
