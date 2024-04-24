package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class StreamTest08 {
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
        lightNovels.stream().map(LightNovel::getPrice).filter(price -> price > 3).reduce(Double::sum).ifPresent(System.out::println);

        DoubleStream doubleStream = lightNovels.stream().mapToDouble(LightNovel::getPrice);
        double sum = doubleStream.filter(price -> price > 3).sum();

        System.out.println(sum);
    }
}
