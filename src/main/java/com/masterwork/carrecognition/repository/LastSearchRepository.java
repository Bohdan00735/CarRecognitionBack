package com.masterwork.carrecognition.repository;

import com.masterwork.carrecognition.model.LastSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastSearchRepository extends JpaRepository<LastSearch, Long> {
}
