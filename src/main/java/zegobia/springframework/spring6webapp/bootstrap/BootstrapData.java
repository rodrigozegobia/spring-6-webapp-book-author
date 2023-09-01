//inicialização de dados no banco de dados durante a inicialização do aplicativo
package zegobia.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zegobia.springframework.spring6webapp.domain.Author;
import zegobia.springframework.spring6webapp.domain.Book;
import zegobia.springframework.spring6webapp.domain.Publisher;
import zegobia.springframework.spring6webapp.repositories.AuthorRepository;
import zegobia.springframework.spring6webapp.repositories.BookRepository;
import zegobia.springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastname("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Publisher Nova = new Publisher();
        Nova.setPublisherName("Nova");
        Nova.setAddress("Fourth Avenue");
        Nova.setCity("Los Angeles");
        Nova.setState("CA");
        Nova.setZipCode("99382");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        Publisher novaSaved = publisherRepository.save(Nova);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastname("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
