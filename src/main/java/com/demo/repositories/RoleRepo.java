package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}