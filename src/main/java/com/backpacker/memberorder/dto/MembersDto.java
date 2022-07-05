package com.backpacker.memberorder.dto;

import com.backpacker.memberorder.enumeration.Gender;
import com.backpacker.memberorder.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembersDto {
    protected long id;
    protected String name;
    protected String nickname;
    protected String email;
    protected Gender gender;
    protected UserRole userRole;
    protected LocalDateTime lastOrderedAt;
}
