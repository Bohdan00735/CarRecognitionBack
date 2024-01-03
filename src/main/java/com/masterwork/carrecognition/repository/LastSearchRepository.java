package com.masterwork.carrecognition.repository;

import com.masterwork.carrecognition.model.LastSearch;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LastSearchRepository extends JpaRepository<LastSearch, Long> {

    @Query(value = "select search from LastSearch search where search.user.id = ?1")
    List<LastSearch> findAllByUserId(Long userId);

    @Query("SELECT search FROM LastSearch search WHERE search.user.id = ?1 ORDER BY search.date DESC")
    List<LastSearch> findTopNByUserIdOrderByDateDesc(Long userId, Pageable pageable);

}
