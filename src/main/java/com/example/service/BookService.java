package com.example.service;


import com.example.entity.Book;
import com.example.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public Optional<Book> findById(Long id) {
    return bookRepository.findById(id);
  }

  public void save(Book book) {
    bookRepository.save(book);
  }

  public void deleteById(Long id) {
    bookRepository.deleteById(id);
  }
}
