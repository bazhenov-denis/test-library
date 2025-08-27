package com.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BorrowingDto {
  private String clientFullName;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate clientBirthDate;

  private String bookTitle;
  private String bookAuthor;
  private String bookIsbn;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime borrowDate;

  // Конструкторы
  public BorrowingDto() {
  }

  public BorrowingDto(
      String clientFullName, LocalDate clientBirthDate,
      String bookTitle, String bookAuthor, String bookIsbn,
      LocalDateTime borrowDate
  ) {
    this.clientFullName = clientFullName;
    this.clientBirthDate = clientBirthDate;
    this.bookTitle = bookTitle;
    this.bookAuthor = bookAuthor;
    this.bookIsbn = bookIsbn;
    this.borrowDate = borrowDate;
  }

  // Геттеры и сеттеры
  public String getClientFullName() {
    return clientFullName;
  }

  public void setClientFullName(String clientFullName) {
    this.clientFullName = clientFullName;
  }

  public LocalDate getClientBirthDate() {
    return clientBirthDate;
  }

  public void setClientBirthDate(LocalDate clientBirthDate) {
    this.clientBirthDate = clientBirthDate;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public String getBookAuthor() {
    return bookAuthor;
  }

  public void setBookAuthor(String bookAuthor) {
    this.bookAuthor = bookAuthor;
  }

  public String getBookIsbn() {
    return bookIsbn;
  }

  public void setBookIsbn(String bookIsbn) {
    this.bookIsbn = bookIsbn;
  }

  public LocalDateTime getBorrowDate() {
    return borrowDate;
  }

  public void setBorrowDate(LocalDateTime borrowDate) {
    this.borrowDate = borrowDate;
  }
}