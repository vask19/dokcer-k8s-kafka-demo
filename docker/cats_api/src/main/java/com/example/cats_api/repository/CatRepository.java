package com.example.cats_api.repository;

import com.example.cats_api.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CatRepository extends JpaRepository<Cat,Integer> {
}
