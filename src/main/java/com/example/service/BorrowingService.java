package com.example.service;

import com.example.entity.Book;
import com.example.entity.Borrowing;
import com.example.entity.Client;
import com.example.repository.BookRepository;
import com.example.repository.BorrowingRepository;
import com.example.repository.ClientRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BorrowingService {

  private final BorrowingRepository borrowingRepository;
  private final ClientRepository clientRepository;
  private final BookRepository bookRepository;

  public BorrowingService(
      BorrowingRepository borrowingRepository,
      ClientRepository clientRepository,
      BookRepository bookRepository
  ) {
    this.borrowingRepository = borrowingRepository;
    this.clientRepository = clientRepository;
    this.bookRepository = bookRepository;
  }

  // Выдать книгу клиенту
  public void borrowBook(Long clientId, Long bookId) {
    Client client = clientRepository.findById(clientId)
        .orElseThrow(() -> new RuntimeException("Client not found"));
    Book book = bookRepository.findById(bookId)
        .orElseThrow(() -> new RuntimeException("Book not found"));

    Borrowing borrowing = new Borrowing();
    borrowing.setClient(client);
    borrowing.setBook(book);
    borrowing.setBorrowDate(LocalDateTime.now());

    borrowingRepository.save(borrowing);
  }

  // Получить список всех читающих клиентов
  public List<Borrowing> getAllBorrowings() {
    return borrowingRepository.findAllByOrderByBorrowDateDesc();
  }
}