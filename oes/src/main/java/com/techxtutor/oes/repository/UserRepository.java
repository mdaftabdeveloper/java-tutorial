package com.techxtutor.oes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techxtutor.oes.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
