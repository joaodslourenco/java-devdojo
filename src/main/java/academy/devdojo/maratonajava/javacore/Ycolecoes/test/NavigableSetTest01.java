package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneMarcaComparator implements Comparator<Smartphone> {

    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}


public class NavigableSetTest01 {
    public static void main(String[] args) {
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "Nokia");
        set.add(smartphone);

        System.out.println(set);

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L, "One Piece", 19.9));
        mangas.add(new Manga(3L, "Cowboy Bebop", 19.8));
        mangas.add(new Manga(4L, "Evangelion", 19.6));
        mangas.add(new Manga(1L, "Hunter x Hunter", 22.9));
        mangas.add(new Manga(2L, "Dorohedoro", 7.8));
        mangas.add(new Manga(2L, "Dorohedoro", 7.9));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }


        System.out.println("---------");

    }
}
