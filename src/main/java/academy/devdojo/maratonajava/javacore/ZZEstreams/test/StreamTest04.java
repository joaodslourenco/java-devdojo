package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>();
        List<String> graphicDesigners = List.of("Fulano UX", "Fulano UX 2", "Fulano UX 3");
        List<String> developers = List.of("Fulano DEV", "Fulano DEV 2", "Fulano DEV 3");
        List<String> students = List.of("Fulano STUDAS", "Fulano STUDAS 2", "Fulano STUDAS 3");

        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(students);

        System.out.println(devdojo);

        devdojo.stream().flatMap(Collection::stream).forEach(System.out::println);


    }
}
