package com.masterwork.carrecognition.repository;

import com.masterwork.carrecognition.model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

    @Query(value = "select favourite from Favourite favourite where favourite.user.id = ?1")
    List<Favourite> findAllByUserId(Long userId);
}
