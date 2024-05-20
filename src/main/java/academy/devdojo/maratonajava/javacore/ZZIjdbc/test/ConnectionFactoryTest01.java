package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.services.ProducerService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Maneiro").build();

        ProducerService.save(producer);

//        ProducerService.update(11, "Studio Zika");

//        List<Producer> producerList = ProducerService.findAll();

//        log.info(producerList);

//        List<Producer> studioZika = ProducerService.findByNameAndUpdateToUppercase("Studio Zika");

//        log.info(studioZika);

//        ProducerService.showTableMetaData();
//        ProducerService.showDriverMetaData();
//        ProducerService.showTypeScrollWorking();

//        List<Producer> tchongo = ProducerService.findByNameAndInsertWhenNotFound("Tchongo");

//        ProducerService.findByNameAndDelete("Tchongo");

//        List<Producer> zika = ProducerService.findByNamePreparedStmt("Zi");

//        log.info(zika);

    }
}
