package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new LinkedList<>();
        mangas.add(new Manga(5L, "One Piece", 19.9, 6));
        mangas.add(new Manga(3L, "Cowboy Bebop", 19.9, 5));
        mangas.add(new Manga(4L, "Evangelion", 19.9, 3));
        mangas.add(new Manga(1L, "Hunter x Hunter", 22.9, 0));
        mangas.add(new Manga(2L, "Dorohedoro", 7.9, 0));

        Iterator<Manga> mangaIterator = mangas.iterator();

        while (mangaIterator.hasNext()) {
            if (mangaIterator.next().getQuantidade() == 0) mangaIterator.remove();
        }
        System.out.println(mangas);

        mangas.removeIf(manga -> manga.getQuantidade() == 0);

    }
}
