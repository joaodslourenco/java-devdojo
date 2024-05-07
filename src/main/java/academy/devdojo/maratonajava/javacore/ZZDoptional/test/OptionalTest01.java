package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {

        Optional<String> o1 = Optional.of("tome");
        System.out.println(o1);
        Optional<String> nameOptional = findName("doido");
        String elsy = nameOptional.orElse("");



    }

    private static Optional<String> findName(String name) {
        List<String> list = List.of("joau", "nicolle");
        int i = list.indexOf(name);
        if (i > 0) {
            return Optional.of(list.get(i));
        }
        return Optional.empty();
    }
}
