package random.sdjpaliquibase.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import random.sdjpaliquibase.domain.Book;
import random.sdjpaliquibase.repositories.BookRepository;

@Slf4j
@Component
@Profile({"local", "default"})
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) {
        bookRepository.deleteAll();

        bookRepository.save(new Book("Domain Driven Design", "123", "Random"));
        bookRepository.save(new Book("Spring In Action", "qqq", "o'reilly"));

        bookRepository.findAll().forEach(book -> log.info(book.toString()));
    }
}
