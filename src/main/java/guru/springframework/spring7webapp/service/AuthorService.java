package guru.springframework.spring7webapp.service;

import guru.springframework.spring7webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();

}
