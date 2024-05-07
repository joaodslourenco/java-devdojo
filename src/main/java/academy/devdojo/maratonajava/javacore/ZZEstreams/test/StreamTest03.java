package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shitara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game No Life", 2.99),
            new LightNovel("Fullmetal Alchemist", 6.99),
            new LightNovel("Monogatari", 1.99),
            new LightNovel("Kumo desuka", 1.00),
            new LightNovel("Kumo desuka", 4.00)
    ));

    public static void main(String[] args) {
        Stream<LightNovel> stream = lightNovels.stream();
        lightNovels.forEach(System.out::println);
        long count = stream.filter(ln -> ln.getPrice() <= 4).count();
        long count2 = lightNovels.stream().distinct().filter(ln -> ln.getPrice() <= 4).count();
        System.out.println(count);
        System.out.println(count2);


//        System.out.println(titles);
    }

}
