package com.masterwork.CarAnalyser.repository;

import com.masterwork.CarAnalyser.model.LastSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastSearchRepository extends JpaRepository<LastSearch, Long> {
}
