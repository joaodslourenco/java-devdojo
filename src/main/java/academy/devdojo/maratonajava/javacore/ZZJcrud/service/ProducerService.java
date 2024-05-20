package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.ProducerRepository;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Scanner;

@Log4j2
public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);




    public static void findByName() {
        System.out.print("Enter the producer's name or leave empty to get all: ");
        String name = SCANNER.nextLine();

        String loadingMsg = !name.isBlank() ? "Searching producers by name '%s'".formatted(name) : "Searching for all producers";

        log.info(loadingMsg);

        List<Producer> producersByName = ProducerRepository.findByName(name);

        producersByName.forEach(producer -> System.out.printf("[%d] %s \n", producer.getId(), producer.getName()));

        System.out.println("--------------------- \n");
    }

    public static void createProducer() {
        System.out.print ("Enter the new producer's name: ");
        String name = SCANNER.nextLine();
        Producer producer = Producer.builder().name(name).build();

        ProducerRepository.create(producer);
        System.out.printf("Producer %s created successfully! \n", producer.getName());
    }

    public static void updateProducer() {
        System.out.print("Enter the ID of the producer you want to update: ");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Enter the new name of the producer: ");
        String name = SCANNER.nextLine();

        ProducerRepository.update(id, name);

        System.out.printf("Producer ID '%d' updated successfully! \n", id);
    }


    public static void deleteById() {
        System.out.print("Enter the producer's ID to delete: ");
        int id = Integer.parseInt(SCANNER.nextLine());

        ProducerRepository.delete(id);

        System.out.printf("Producer ID '%d' deleted successfully!  \n", id);
    }
}
