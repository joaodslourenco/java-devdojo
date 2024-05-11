package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepositoryRowset;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.services.ProducerServiceRowset;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        ProducerServiceRowset.updateCachedRowset(1, "Toei mesmo mesmo");


        //

//        List<Producer> producers = ProducerServiceRowset.findByNameJdbcRowset("Toei");

//        log.info(producers);


    }
}
