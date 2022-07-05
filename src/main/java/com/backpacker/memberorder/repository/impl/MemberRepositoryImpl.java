package com.backpacker.memberorder.repository.impl;

import com.backpacker.memberorder.entity.Members;
import com.backpacker.memberorder.repository.MemberRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.backpacker.memberorder.entity.QMembers.members;
import static com.backpacker.memberorder.entity.QOrders.orders;

public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberRepositoryCustom {

    public MemberRepositoryImpl() {
        super(Members.class);
    }

    @Override
    public Members findByIdWithOrders(Long memberId) {
        return from(members)
                .join(members.ordersSet, orders).fetchJoin()
                .where(members.id.eq(memberId))
                .fetchFirst();
    }

    @Override
    public List<Members> findAllMembersWithPaging(Pageable pageable, String email, String name) {
        return from(members)
                .where(predicateEmailAndName(email, name))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();
    }

    private Predicate predicateEmailAndName(String email, String name) {
        BooleanBuilder builder = new BooleanBuilder();

        if (StringUtils.isNotBlank(email)) {
            builder.and(members.email.eq(email));
        }

        if (StringUtils.isNotBlank(name)) {
            builder.and(members.name.eq(name));
        }

        return builder.getValue();
    }

}
