package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animes = new ArrayList<>(List.of(new Anime("One Piece", 1101), new Anime("Cowboy Bebop", 26), new Anime("Dorohedoro", 24)));
//        Collections.sort(animes, (a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
//        Collections.sort(animes, AnimeComparators::compareByTitle);
        animes.sort(AnimeComparators::compareByEpisodes);

        System.out.println(animes);
    }
}
