package academy.devdojo.maratonajava.javacore.ZZClambdas.test;


import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animes = new ArrayList<>(List.of(new Anime("One Piece", 1101), new Anime("Cowboy Bebop", 26), new Anime("Dorohedoro", 24)));
        animes.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animes);
    }
}
