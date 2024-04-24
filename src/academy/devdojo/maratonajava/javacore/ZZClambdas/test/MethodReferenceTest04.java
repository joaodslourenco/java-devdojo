package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MethodReferenceTest04 {
    public static void main(String[] args) {

        Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new;
        AnimeComparators animeComparators = newAnimeComparators.get();
        List<Anime> animes = new ArrayList<>(List.of(new Anime("One Piece", 1101), new Anime("Cowboy Bebop", 26), new Anime("Dorohedoro", 24)));

        animes.sort(animeComparators::compareByEpisodesNonStatic);

        System.out.println(animes);

        BiFunction<String, Integer, Anime> animeBiFunction = Anime::new;

        Anime superSuper = animeBiFunction.apply("Super Super", 20);
        System.out.println(superSuper);

    }
}
