package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.AnimeRepository;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Log4j2
public class AnimeService {
    private static final Scanner SCANNER = new Scanner(System.in);


    public static void findByName() {
        System.out.print("Enter the anime's name or leave empty to get all: ");
        String name = SCANNER.nextLine();

        String loadingMsg = !name.isBlank() ? "Searching animes by name '%s'".formatted(name) : "Searching for all animes";

        log.info(loadingMsg);

        List<Anime> animeByName = AnimeRepository.findByName(name);

        animeByName.forEach(anime -> System.out.printf("[%d] %s | Episodes: %d | Producer: %s \n", anime.getId(), anime.getName(), anime.getEpisodes(), anime.getProducer().getName()));

        System.out.println("--------------------- \n");
    }

    public static void createAnime() {
        System.out.print("Enter the new anime's name: ");
        String name = SCANNER.nextLine();
        System.out.print("Enter the new anime's episodes quantity: ");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Enter the new anime's producer ID: ");
        int producerId = Integer.parseInt(SCANNER.nextLine());
        Anime anime = Anime
                .builder()
                .name(name)
                .episodes(episodes)
                .producer(Producer.builder().id(producerId).build())
                .build();

        AnimeRepository.create(anime);
        System.out.printf("Anime %s created successfully! \n", anime.getName());
    }

    public static void updateAnime() {
        System.out.print("Enter the ID of the anime you want to update: ");
        int id = Integer.parseInt(SCANNER.nextLine());
        Optional<Anime> animeOptional = AnimeRepository.findById(id);
        if (animeOptional.isEmpty()) {
            System.out.println("Anime not found.");
            return;
        }
        Anime animeFromDb = animeOptional.get();
        System.out.print("Enter the new name of the anime or leave empty to keep the same: ");
        String name = SCANNER.nextLine();
        name = name.isBlank() ? animeFromDb.getName() : name;

        System.out.print("Enter the new number of episodes or leave empty to keep the same: ");
        String episodesString = SCANNER.nextLine();
        episodesString = episodesString.isBlank() ? String.valueOf(animeFromDb.getEpisodes()) : episodesString;
        int episodes = Integer.parseInt(episodesString);

        System.out.print("Enter the new producer's ID or leave empty to keep the same: ");
        String producerIdString = SCANNER.nextLine();
        producerIdString = producerIdString.isBlank() ? String.valueOf(animeFromDb.getProducer().getId()) : producerIdString;
        int producerId = Integer.parseInt(producerIdString);

        AnimeRepository.update(id, name, episodes, producerId);

        System.out.printf("Anime ID '%d' updated successfully! \n", id);
    }


    public static void deleteById() {
        System.out.print("Enter the anime's ID to delete: ");
        int id = Integer.parseInt(SCANNER.nextLine());

        AnimeRepository.delete(id);

        System.out.printf("Anime ID '%d' deleted successfully!  \n", id);
    }
}
