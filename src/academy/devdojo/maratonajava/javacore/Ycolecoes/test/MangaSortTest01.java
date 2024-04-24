package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class MangaByIdComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga o1, Manga o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L,"One Piece", 19.9));
        mangas.add(new Manga(3L, "Cowboy Bebop", 19.9));
        mangas.add(new Manga(4L,"Evangelion", 19.9));
        mangas.add(new Manga(1L,"Hunter x Hunter", 22.9));
        mangas.add(new Manga(2L,"Dorohedoro", 7.9));
        System.out.println(mangas);

        Collections.sort(mangas);
        System.out.println(mangas);

        MangaByIdComparator meuComparadoido = new MangaByIdComparator();

        Collections.sort(mangas, meuComparadoido);

        mangas.sort(meuComparadoido);
        System.out.println(mangas);
    }
}
