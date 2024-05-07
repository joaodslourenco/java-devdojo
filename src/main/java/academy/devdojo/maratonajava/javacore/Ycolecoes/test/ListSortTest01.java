package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("One Piece");
        mangas.add("Cowboy Bebop");
        mangas.add("Evangelion");
        mangas.add("Hunter x Hunter");
        mangas.add("Dorohedoro");

        Collections.sort(mangas);


        for (String manga : mangas) {
            System.out.println(manga);
        }

        List<Double> entradas = new ArrayList<>();
        entradas.add(10.5);
        entradas.add(5.5);
        entradas.add(3000.75);

        System.out.println(entradas);
        Collections.sort(entradas);
        System.out.println(entradas);


    }
}
