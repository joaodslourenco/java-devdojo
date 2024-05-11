package academy.devdojo.maratonajava.javacore.ZZIjdbc.services;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepositoryRowset;

import java.util.List;

public class ProducerServiceRowset {

    public static List<Producer> findByNameJdbcRowset(String name) {
        return ProducerRepositoryRowset.findByNameJdbcRowset(name);
    }

    public static void updateJdbcRowset(Integer id, String name) {
        ProducerRepositoryRowset.updateJdbcRowset(id, name);
    }

    public static void updateCachedRowset(Integer id, String name) {
        ProducerRepositoryRowset.updateCachedRowset(id, name);
    }

}
