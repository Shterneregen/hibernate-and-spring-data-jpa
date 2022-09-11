package random.jpaflyway.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import random.jpaflyway.domain.AuthorUuid;
import random.jpaflyway.domain.Book;
import random.jpaflyway.domain.BookUuid;
import random.jpaflyway.repositories.AuthorUuidRepository;
import random.jpaflyway.repositories.BookRepository;
import random.jpaflyway.repositories.BookUuidRepository;

@Slf4j
@Component
@Profile({"local", "default"})
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorUuidRepository authorUuidRepository;
    private final BookUuidRepository bookUuidRepository;

    @Override
    public void run(String... args) {
        bookRepository.deleteAll();
        authorUuidRepository.deleteAll();

        bookRepository.save(new Book("Domain Driven Design", "123", "Random", null));
        bookRepository.save(new Book("Spring In Action", "qqq", "o'reilly", null));

        bookRepository.findAll().forEach(book -> log.info("Saved Book: {}", book.toString()));

        AuthorUuid authorUuid = new AuthorUuid().setFirstName("Joe").setLastName("Buck");
        AuthorUuid savedAuthor = authorUuidRepository.save(authorUuid);
        log.info("Saved Author: {}", savedAuthor);

        BookUuid bookUuid = new BookUuid().setTitle("All About UUIDs");
        BookUuid savedBookUuid = bookUuidRepository.save(bookUuid);
        log.info("Saved Book: {}", savedBookUuid);
    }
}
