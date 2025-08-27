package com.example.controller;

import com.example.entity.Book;
import com.example.entity.Client;
import com.example.service.BookService;
import com.example.service.BorrowingService;
import com.example.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

  private final BookService bookService;
  private final ClientService clientService;
  private final BorrowingService borrowingService;

  public MainController(BookService bookService, ClientService clientService, BorrowingService borrowingService) {
    this.bookService = bookService;
    this.clientService = clientService;
    this.borrowingService = borrowingService;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("books", bookService.findAll());
    model.addAttribute("clients", clientService.findAll());
    model.addAttribute("borrowings", borrowingService.getAllBorrowings());
    model.addAttribute("newBook", new Book());
    model.addAttribute("newClient", new Client());
    return "index";
  }

  // Операции с книгами
  @PostMapping("/books")
  public String addBook(@ModelAttribute("newBook") Book book, RedirectAttributes redirectAttributes) {
    try {
      bookService.save(book);
      redirectAttributes.addFlashAttribute("successMessage", "Книга успешно добавлена!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при добавлении книги: " + e.getMessage());
    }
    return "redirect:/";
  }

  @GetMapping("/books/{id}/edit")
  @ResponseBody
  public Book getBookForEdit(@PathVariable Long id) {
    return bookService.findById(id).orElse(new Book());
  }

  @PostMapping("/books/{id}/edit")
  public String updateBook(@PathVariable Long id, @ModelAttribute Book book, RedirectAttributes redirectAttributes) {
    try {
      book.setId(id);
      bookService.save(book);
      redirectAttributes.addFlashAttribute("successMessage", "Книга успешно обновлена!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при обновлении книги: " + e.getMessage());
    }
    return "redirect:/";
  }

  @PostMapping("/books/{id}/delete")
  public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    try {
      bookService.deleteById(id);
      redirectAttributes.addFlashAttribute("successMessage", "Книга успешно удалена!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при удалении книги: " + e.getMessage());
    }
    return "redirect:/";
  }

  // Операции с клиентами
  @PostMapping("/clients")
  public String addClient(@ModelAttribute("newClient") Client client, RedirectAttributes redirectAttributes) {
    try {
      clientService.save(client);
      redirectAttributes.addFlashAttribute("successMessage", "Клиент успешно добавлен!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при добавлении клиента: " + e.getMessage());
    }
    return "redirect:/";
  }

  @GetMapping("/clients/{id}/edit")
  @ResponseBody
  public Client getClientForEdit(@PathVariable Long id) {
    return clientService.findById(id).orElse(new Client());
  }

  @PostMapping("/clients/{id}/edit")
  public String updateClient(@PathVariable Long id, @ModelAttribute Client client, RedirectAttributes redirectAttributes) {
    try {
      client.setId(id);
      clientService.save(client);
      redirectAttributes.addFlashAttribute("successMessage", "Клиент успешно обновлен!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при обновлении клиента: " + e.getMessage());
    }
    return "redirect:/";
  }

  @PostMapping("/clients/{id}/delete")
  public String deleteClient(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    try {
      clientService.deleteById(id);
      redirectAttributes.addFlashAttribute("successMessage", "Клиент успешно удален!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при удалении клиента: " + e.getMessage());
    }
    return "redirect:/";
  }

  // Операции с выдачей книг
  @PostMapping("/borrowings")
  public String borrowBook(@RequestParam Long clientId, @RequestParam Long bookId, RedirectAttributes redirectAttributes) {
    try {
      borrowingService.borrowBook(clientId, bookId);
      redirectAttributes.addFlashAttribute("successMessage", "Книга успешно выдана!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при выдаче книги: " + e.getMessage());
    }
    return "redirect:/";
  }
}