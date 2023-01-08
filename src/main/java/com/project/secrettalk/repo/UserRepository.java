package com.project.secrettalk.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.secrettalk.model.Member;

public interface UserRepository extends JpaRepository<Member, Integer>{
	
	Optional<Member> findByEmail(String email);
	
}
