package com.example.AliNet.repository;

import com.example.AliNet.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Item,Long> {

}
