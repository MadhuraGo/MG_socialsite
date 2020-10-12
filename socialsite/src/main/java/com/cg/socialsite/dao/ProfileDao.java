package com.cg.socialsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.socialsite.entities.Profile;

public interface ProfileDao extends JpaRepository<Profile, Integer>{

}
