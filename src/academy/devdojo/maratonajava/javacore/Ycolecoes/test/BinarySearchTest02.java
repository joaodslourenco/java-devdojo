package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "One Piece", 19.9));
        mangas.add(new Manga(3L, "Cowboy Bebop", 19.9));
        mangas.add(new Manga(4L, "Evangelion", 19.9));
        mangas.add(new Manga(1L, "Hunter x Hunter", 22.9));
        mangas.add(new Manga(2L, "Dorohedoro", 7.9));


        MangaByIdComparator mangaByIdComparator = new MangaByIdComparator();
        // Collections.sort(mangas);
        mangas.sort(mangaByIdComparator);


        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga mangaToSearch = new Manga(2L, "Dorohedoro", 7.9);

        int result = Collections.binarySearch(mangas, mangaToSearch, mangaByIdComparator);


        System.out.println(result);

    }

}
