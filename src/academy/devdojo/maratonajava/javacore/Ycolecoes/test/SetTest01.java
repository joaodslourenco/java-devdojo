package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        Set<Manga> mangas = new LinkedHashSet<>();
        mangas.add(new Manga(5L, "One Piece", 19.9));
        mangas.add(new Manga(3L, "Cowboy Bebop", 19.9));
        mangas.add(new Manga(4L, "Evangelion", 19.9));
        mangas.add(new Manga(1L, "Hunter x Hunter", 22.9));
        mangas.add(new Manga(2L, "Dorohedoro", 7.9));
        mangas.add(new Manga(2L, "Dorohedoro", 7.9));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
