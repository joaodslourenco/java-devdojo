package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repository.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Overlord");
        mangaByTitle.ifPresent(m -> m.setTitle(m.getTitle() + 2));

        System.out.println(mangaByTitle);


        Optional<Manga> mangaById = MangaRepository.findById(5);
        mangaById.orElseThrow(IllegalArgumentException::new);

    }
}
