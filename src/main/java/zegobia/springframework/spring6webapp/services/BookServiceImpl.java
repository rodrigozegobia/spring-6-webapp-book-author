package zegobia.springframework.spring6webapp.services;

import org.springframework.stereotype.Service;
import zegobia.springframework.spring6webapp.repositories.BookRepository;
import zegobia.springframework.spring6webapp.domain.Book;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
