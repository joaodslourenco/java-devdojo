package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {
//    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
//            new LightNovel("Tensei Shitara", 10, Category.FANTASY),
//            new LightNovel("Overlord", 3.99, Category.FANTASY),
//            new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
//            new LightNovel("No Game No Life", 2.99, Category.FANTASY),
//            new LightNovel("Fullmetal Alchemist", 6.99, Category.FANTASY),
//            new LightNovel("Monogatari", 1.99, Category.FANTASY),
//            new LightNovel("Kumo desuka", 1.00, Category.FANTASY),
//            new LightNovel("Kumo desuka", 4.00, Category.ROMANCE)
//    ));

    public static void main(String[] args) {
        long num = 100_000_000;

        sumFor(num);
        System.out.println("-------------");
        sumStreamIterate(num);
        System.out.println("-------------");
        sumParallelStreamIterate(num);
        System.out.println("-------------");
        sumLongStreamIterate(num);
        System.out.println("-------------");
        sumParallelLongStreamIterate(num);

    }

    private static void sumFor(long num) {
        System.out.println("Sum for");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 0; i <= num; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void sumStreamIterate(long num) {
        System.out.println("Sum Stream Iterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void sumParallelStreamIterate(long num) {
        System.out.println("Sum Parallel Stream Iterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void sumLongStreamIterate(long num) {
        System.out.println("Sum Long Stream Iterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void sumParallelLongStreamIterate(long num) {
        System.out.println("Sum Parallel Long Stream Iterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

}
