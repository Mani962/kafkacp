package application;

import component.BookPublisher;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@ComponentScan("component")
public class Library {

    @Autowired
    private BookPublisher bookPublisher;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Library.class).web(false).run(args);
        context.getBean(Library.class).run(context);
        context.close();
    }

    private void run(ConfigurableApplicationContext context) {

        System.out.println("Inside ProducerApplication run method...");

        MessageChannel producerChannel = context.getBean("producerChannel", MessageChannel.class);

        List books = bookPublisher.getBooks();

        for (Object book1 : books) {
            Book book = (Book) book1;
            Map<String, Object> headers = Collections.singletonMap(KafkaHeaders.TOPIC, book.getGenre().toString());
            producerChannel.send(new GenericMessage<>(book.toString(), headers));

        }
        System.out.println("Finished ProducerApplication run method...");
    }
}