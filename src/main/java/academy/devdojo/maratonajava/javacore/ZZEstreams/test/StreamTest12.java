package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {
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
        Map<Category, List<LightNovel>> categoryLightNovelMap = new HashMap<>();
        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> drama = new ArrayList<>();
        List<LightNovel> romance = new ArrayList<>();

        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategory()) {
                case DRAMA:
                    drama.add(lightNovel);
                    break;
                case FANTASY:
                    fantasy.add(lightNovel);
                    break;
                case ROMANCE:
                    romance.add(lightNovel);
                    break;
            }
        }

        categoryLightNovelMap.put(Category.FANTASY, fantasy);
        categoryLightNovelMap.put(Category.DRAMA, drama);
        categoryLightNovelMap.put(Category.ROMANCE, romance);

        System.out.println(fantasy);
        System.out.println(drama);
        System.out.println(romance);

        System.out.println(categoryLightNovelMap);

        Map<Category, List<LightNovel>> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        System.out.println(collect);
    }
}
