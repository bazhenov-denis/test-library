package com.example.controller;

import com.example.dto.BorrowingDto;
import com.example.entity.Borrowing;
import com.example.service.BorrowingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BorrowingRestController {

  private final BorrowingService borrowingService;

  public BorrowingRestController(BorrowingService borrowingService) {
    this.borrowingService = borrowingService;
  }

  @GetMapping("/borrowings")
  public List<BorrowingDto> getAllBorrowings() {
    List<Borrowing> borrowings = borrowingService.getAllBorrowings();

    return borrowings.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
  }

  private BorrowingDto convertToDto(Borrowing borrowing) {
    BorrowingDto dto = new BorrowingDto();
    dto.setClientFullName(borrowing.getClient().getFullName());
    dto.setClientBirthDate(borrowing.getClient().getBirthDate());
    dto.setBookTitle(borrowing.getBook().getTitle());
    dto.setBookAuthor(borrowing.getBook().getAuthor());
    dto.setBookIsbn(borrowing.getBook().getIsbn());
    dto.setBorrowDate(borrowing.getBorrowDate());
    return dto;
  }
}