package com.example.blogshashi.repositories;

import com.example.blogshashi.entities.User;
import lombok.extern.log4j.Log4j;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
