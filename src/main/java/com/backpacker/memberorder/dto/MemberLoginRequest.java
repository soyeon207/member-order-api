package com.backpacker.memberorder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberLoginRequest {

    @NotNull(message = "이메일은 필수값입니다.")
    @Size(max = 100, message = "이메일은 100자까지만 입력가능합니다.")
    @Email
    protected String email;

    @NotNull(message = "비밀번호는 필수값입니다.")
    @Size(min = 10, message = "비밀번호는 10자 이상 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{10,}", message = "비밀번호에는 영문 대문자, 영문 소문자, 특수 문자, 숫자 각 1개 이상씩 포함해야합니다.")
    protected String password;

}
