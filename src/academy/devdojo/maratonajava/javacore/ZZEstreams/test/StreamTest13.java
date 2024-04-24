package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion.NORMAL_PRICE;
import static academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion.UNDER_PROMOTION;

public class StreamTest13 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shitara", 8.99, Category.FANTASY),
            new LightNovel("Overlord", 3.99, Category.FANTASY),
            new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
            new LightNovel("No Game No Life", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal Alchemist", 6.99, Category.FANTASY),
            new LightNovel("Monogatari", 1.99, Category.FANTASY),
            new LightNovel("Kumo desuka", 1.00, Category.FANTASY),
            new LightNovel("Kumo desuka", 4.00, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        Map<Promotion, List<LightNovel>> collect = lightNovels
                .stream()
                .collect(Collectors.groupingBy(getPromotionFunction()
                ));
        System.out.println(collect);

        Map<Category, Map<Promotion, List<LightNovel>>> collected = lightNovels.stream().collect(Collectors.groupingBy(
                LightNovel::getCategory,
                Collectors.groupingBy(getPromotionFunction())));

        System.out.println(collected);
    }

    private static Function<LightNovel, Promotion> getPromotionFunction() {
        return ln -> ln.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE;
    }
}
