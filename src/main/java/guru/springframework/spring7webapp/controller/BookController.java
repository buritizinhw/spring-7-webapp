package guru.springframework.spring7webapp.controller;

import guru.springframework.spring7webapp.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {this.bookService = bookService;}

    @RequestMapping(path = "/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books" ;
    }
    
}
