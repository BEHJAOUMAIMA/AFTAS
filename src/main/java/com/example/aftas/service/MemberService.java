package com.example.aftas.service;

import com.example.aftas.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {
    Member save(Member member);
    List<Member> findAll();
    Optional<Member> findById(Long id);
    Member update(Member memberUpdated);
    void delete(Long id);

}
