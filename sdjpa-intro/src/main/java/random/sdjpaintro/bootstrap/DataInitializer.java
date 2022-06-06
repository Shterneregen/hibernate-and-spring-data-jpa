package random.sdjpaintro.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import random.sdjpaintro.domain.Book;
import random.sdjpaintro.repositories.BookRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) {
        Book bookDDD = new Book("Domain Driven Design", "123", "Random");
        Book savedDDD = bookRepository.save(bookDDD);
        log.info("savedDDD: {}", savedDDD.getId());

        Book bookSIA = new Book("Spring In Action", "qqq", "o'reilly");
        Book savedSIA = bookRepository.save(bookSIA);
        log.info("savedSIA: {}", savedSIA.getId());

        bookRepository.findAll().forEach(book -> log.info(book.toString()));
    }
}
