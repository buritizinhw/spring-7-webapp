package guru.springframework.spring7webapp.bootstrap;

import guru.springframework.spring7webapp.domain.Author;
import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.domain.Publisher;
import guru.springframework.spring7webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.spring7webapp.repository.AuthorRepository;
import guru.springframework.spring7webapp.repository.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author clarice = new Author();
        clarice.setFirstName("Clarice");
        clarice.setLastName("Lispector");

        Book hde = new Book();
        hde.setTitle("Hora da Estrela");
        hde.setIsbn("123456");

        Author clariceSaved = authorRepository.save(clarice);
        Book hdeSaved = bookRepository.save(hde);

        Author eduardo = new Author();
        eduardo.setFirstName("Eduardo");
        eduardo.setLastName("Guerra");

        Book dpj = new Book();
        dpj.setTitle("Design Patterns com Java");
        dpj.setIsbn("789123");

        Author eduardoSaved = authorRepository.save(eduardo);
        Book dpjSaved = bookRepository.save(dpj);

        clariceSaved.getBooks().add(hdeSaved);
        eduardoSaved.getBooks().add(dpjSaved);
        hdeSaved.getAuthors().add(clariceSaved);
        dpjSaved.getAuthors().add(eduardoSaved);


        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Editora Rocco");
        publisher1.setAddress("Rua dos bobos, 0");
        publisher1.setCity("Campina Grande");
        publisher1.setState("PB");
        publisher1.setZip("12345678");
        Publisher publisher1Saved = publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("Editora Intriseca");
        Publisher publisher2Saved = publisherRepository.save(publisher2);

        hdeSaved.setPublisher(publisher1Saved);
        dpjSaved.setPublisher(publisher2Saved);

        authorRepository.save(clariceSaved);
        authorRepository.save(eduardoSaved);
        bookRepository.save(hdeSaved);
        bookRepository.save(dpjSaved);

        System.out.println("Bootstrap data here");
        System.out.println("Authors:"+ authorRepository.count());
        System.out.println("Books: "+ bookRepository.count());
        System.out.println("Publisher: "+ publisherRepository.count());

    }
}
