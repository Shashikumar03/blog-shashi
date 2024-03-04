package com.example.blogshashi.repositories;

import com.example.blogshashi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo  extends JpaRepository<Role, Integer> {

}