package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamTest06 {
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
        boolean exists = lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8);
        boolean allmatch = lightNovels.stream().allMatch(ln -> ln.getPrice() > 0);
        boolean nonmatch = lightNovels.stream().noneMatch(ln -> ln.getPrice() < 0);
        boolean nonmatch2 = !lightNovels.stream().allMatch(ln -> ln.getPrice() < 0);

        lightNovels.stream().filter(ln -> ln.getPrice() > 3).findAny().ifPresent(System.out::println);
        lightNovels.stream().filter(ln -> ln.getPrice() > 3).max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);



        System.out.println(exists);
        System.out.println(allmatch);
        System.out.println(nonmatch);
        System.out.println(nonmatch2);
    }

}
