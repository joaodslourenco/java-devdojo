package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.services.ProducerService;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Doido").build();
        Producer producer2 = Producer.builder().name("Studio Massa").build();
        Producer producer3 = Producer.builder().name("Studio Interessante").build();
        Producer producer4 = Producer.builder().name("white fox").build();

        ProducerService.saveTransaction(List.of(producer, producer2, producer4,producer3));

    }
}
