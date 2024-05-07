package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        Stream.iterate(2, n -> n + 2).limit(10).forEach(System.out::println);


        Stream.iterate(new ArrayList<>(List.of(0, 1)), n -> new ArrayList<>(List.of(n.get(1),n.get(0)+n.get(1)))).limit(9).forEach(System.out::println);
    }
}
