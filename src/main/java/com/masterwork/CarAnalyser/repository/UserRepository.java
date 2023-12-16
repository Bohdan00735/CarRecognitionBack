package com.masterwork.CarAnalyser.repository;

import com.masterwork.CarAnalyser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
