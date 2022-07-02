package com.backpacker.memberorder.dto;

import com.backpacker.memberorder.enumeration.Gender;
import com.backpacker.memberorder.enumeration.UserRole;
import lombok.Getter;


@Getter
public class MembersDto {
    protected Long id;
    protected String name;
    protected String nickname;
    protected String password;
    protected String email;
    protected Gender gender;
    protected UserRole userRole;
}
