package academy.devdojo.maratonajava.javacore.ZZJcrud.test;

import academy.devdojo.maratonajava.javacore.ZZJcrud.service.AnimeService;
import academy.devdojo.maratonajava.javacore.ZZJcrud.service.ProducerService;

import java.util.Scanner;


public class CrudTest01 {
    public static void main(String[] args) {
        initialMenu();

    }

    public static void initialMenu() {
        final Scanner SCANNER = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome back!");
            System.out.println("Enter the number of your operation:");
            System.out.println("\t 1. Manage Producers");
            System.out.println("\t 2. Manage Animes");
            System.out.println("\t 0. Exit");

            int op = Integer.parseInt(SCANNER.nextLine());

            switch (op) {
                case 0 -> {
                    System.out.println("Exiting.");
                    isRunning = false;
                }
                case 1 -> producerMenu();
                case 2 -> animeMenu();
                default -> throw new IllegalArgumentException("Invalid option.");
            }

        }
    }


    public static void producerMenu() {
        final Scanner SCANNER = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("PRODUCERS MANAGEMENT");
            System.out.println("Enter the number of your operation:");
            System.out.println("\t 1. Search for producer");
            System.out.println("\t 2. Create a producer");
            System.out.println("\t 3. Update a producer");
            System.out.println("\t 4. Delete a producer");
            System.out.println("\t 0. Go back");

            int op = Integer.parseInt(SCANNER.nextLine());

            switch (op) {
                case 0 -> {
                    System.out.println("Exiting.");
                    isRunning = false;
                }
                case 1 -> ProducerService.findByName();
                case 2 -> ProducerService.createProducer();
                case 3 -> ProducerService.updateProducer();
                case 4 -> ProducerService.deleteById();
                default -> throw new IllegalArgumentException("Invalid option.");
            }

        }
    }

    public static void animeMenu() {
        final Scanner SCANNER = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("ANIMES MANAGEMENT");
            System.out.println("Enter the number of your operation:");
            System.out.println("\t 1. Search for anime");
            System.out.println("\t 2. Create a anime");
            System.out.println("\t 3. Update a anime");
            System.out.println("\t 4. Delete a anime");
            System.out.println("\t 0. Go back");

            int op = Integer.parseInt(SCANNER.nextLine());

            switch (op) {
                case 0 -> {
                    System.out.println("Exiting.");
                    isRunning = false;
                }
                case 1 -> AnimeService.findByName();
                case 2 -> AnimeService.createAnime();
                case 3 -> AnimeService.updateAnime();
                case 4 -> AnimeService.deleteById();
                default -> throw new IllegalArgumentException("Invalid option.");
            }

        }
    }

}
