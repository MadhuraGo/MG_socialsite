package com.cg.socialsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.socialsite.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
