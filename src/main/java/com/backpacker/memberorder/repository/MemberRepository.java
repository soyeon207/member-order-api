package com.backpacker.memberorder.repository;

import com.backpacker.memberorder.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Members, Long>, MemberRepositoryCustom {

    Members findByEmail(String email);

}
