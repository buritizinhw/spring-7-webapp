package guru.springframework.spring7webapp.service;

import guru.springframework.spring7webapp.domain.Book;
import org.springframework.stereotype.Service;

public interface BookService {



    Iterable<Book> findAll();

}
