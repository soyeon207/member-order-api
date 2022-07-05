package com.backpacker.memberorder.dto;

import com.backpacker.memberorder.enumeration.Gender;
import com.backpacker.memberorder.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Optional;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberCreateRequest extends MemberLoginRequest {

    @NotNull(message = "별명은 필수값입니다.")
    @Size(max = 20, message = "별명은 30자까지만 입력가능합니다.")
    @Pattern(regexp = "^[a-z]+$", message = "별명은 소문자만 가능합니다.")
    protected String nickname;

    @NotNull(message = "전화번호는 필수값입니다.")
    @Size(max = 20, message = "전화번호는 20자까지만 입력가능합니다.")
    @Pattern(regexp = "^[0-9]+$", message = "전화번호는 숫자만 입력 가능합니다.")
    protected String phone;

    @NotNull(message = "이름은 필수값입니다.")
    @Size(max = 20, message = "이름은 20자까지만 입력가능합니다.")
    @Pattern(regexp = "^[ㄱ-ㅎ|가-힣|a-z|A-Z|]+$", message = "이름은 한글, 영어, 대소문자만 가능합니다.")
    protected String name;

    protected Gender gender;

    protected UserRole userRole;

    public UserRole convertUserRole() {
        return Optional.ofNullable(this.getUserRole()).orElse(UserRole.USER);
    }
}
