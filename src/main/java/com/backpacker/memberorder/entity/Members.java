package com.backpacker.memberorder.entity;

import com.backpacker.memberorder.enumeration.Gender;
import com.backpacker.memberorder.enumeration.UserRole;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(indexes = {
        @Index(name = "members_email_uindex", columnList = "email", unique = true),
        @Index(name = "members_name_email_index", columnList = "name, email")
})
public class Members extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Builder
    private Members(String name, String nickname, String password, String email, Gender gender, UserRole userRole) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.userRole = userRole;
    }

}
