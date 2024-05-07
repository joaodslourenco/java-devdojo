package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
    public static void main(String[] args) {
        IntStream.range(1, 50).filter(i -> i % 2 == 0).forEach(System.out::println);

        Stream.of("Eleve ", " O", " Cosmo").map(String::toUpperCase).forEach(s -> System.out.print(s + " "));

        int[] num = {1, 2, 3, 4, 5};

        Arrays.stream(num).average().ifPresent(System.out::println);


    }
}
