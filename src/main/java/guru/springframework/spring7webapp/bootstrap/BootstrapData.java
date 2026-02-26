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

        Publisher editoraTeste = new Publisher();
        editoraTeste.setPublisherName("Editora Rocco");
        editoraTeste.setAddress("Rua dos bobos, 0");
        editoraTeste.setCity("Campina Grande");
        editoraTeste.setState("PB");
        editoraTeste.setZip("12345678");

        publisherRepository.save(editoraTeste);




        System.out.println("Bootstrap data here");
        System.out.println("Authors:"+ authorRepository.count());
        System.out.println("Books: "+ bookRepository.count());
        System.out.println("Publisher: "+ publisherRepository.count());

    }
}
