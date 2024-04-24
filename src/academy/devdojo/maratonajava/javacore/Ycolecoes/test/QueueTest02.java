package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {
        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L, "One Piece", 19.9));
        mangas.add(new Manga(3L, "Cowboy Bebop", 19.8));
        mangas.add(new Manga(4L, "Evangelion", 19.6));
        mangas.add(new Manga(1L, "Hunter x Hunter", 22.9));
        mangas.add(new Manga(2L, "Dorohedoro", 7.8));


        while (!mangas.isEmpty()) {
            System.out.println(mangas.poll());
        }

    }

}
