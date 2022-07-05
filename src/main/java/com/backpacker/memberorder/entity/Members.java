package com.backpacker.memberorder.entity;

import com.backpacker.memberorder.enumeration.Gender;
import com.backpacker.memberorder.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {
        @Index(name = "members_email_uindex", columnList = "email", unique = true),
        @Index(name = "members_name_email_index", columnList = "name, email")
})
public class Members extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "nickname")
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name="user_role")
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Column(name = "last_ordered_at")
    private LocalDateTime lastOrderedAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "members")
    private Set<Orders> ordersSet;

}
