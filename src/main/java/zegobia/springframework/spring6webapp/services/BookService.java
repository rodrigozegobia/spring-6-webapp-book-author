package zegobia.springframework.spring6webapp.services;
import zegobia.springframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
