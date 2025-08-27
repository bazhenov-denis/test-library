package com.example.repository;

import com.example.entity.Borrowing;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
  List<Borrowing> findAllByOrderByBorrowDateDesc();

}
