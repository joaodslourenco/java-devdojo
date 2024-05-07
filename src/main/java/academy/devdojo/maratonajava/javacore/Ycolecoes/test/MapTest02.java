package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Joau");
        Consumidor consumidor2 = new Consumidor("Nicolle");


        Manga manga1 = new Manga(5L, "One Piece", 19.9);
        Manga manga2 = new Manga(3L, "Cowboy Bebop", 19.9);
        Manga manga3 = new Manga(4L, "Evangelion", 19.9);
        Manga manga4 = new Manga(1L, "Hunter x Hunter", 22.9);
        Manga manga5 = new Manga(2L, "Dorohedoro", 7.9);

        Map<Consumidor, List<Manga>> consumidorManga = new HashMap<>();

        List<Manga> mangaConsumidor1List = List.of(manga1, manga2, manga3);
        List<Manga> mangaConsumidor2List = List.of(manga4, manga5);

        consumidorManga.put(consumidor1, mangaConsumidor1List);
        consumidorManga.put(consumidor2, mangaConsumidor2List);

        for (Map.Entry<Consumidor, List<Manga>> entry : consumidorManga.entrySet()) {
            System.out.println(entry.getKey().getNome());
            System.out.println(entry.getValue());
        }
    }
}
