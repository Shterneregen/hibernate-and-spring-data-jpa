package random.sdjpaflyway.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import random.sdjpaflyway.domain.AuthorUuid;
import random.sdjpaflyway.domain.Book;
import random.sdjpaflyway.domain.BookUuid;
import random.sdjpaflyway.repositories.AuthorUuidRepository;
import random.sdjpaflyway.repositories.BookRepository;
import random.sdjpaflyway.repositories.BookUuidRepository;

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
