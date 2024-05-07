package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(16);
        List<String> nomes2 = new ArrayList<>(16);
        nomes.add("joau");
        nomes.add("lourenço");
        nomes2.add("nicolle");
        nomes2.add("saguado");

        boolean ok = nomes.remove("joau");

        nomes.addAll(nomes2);

        System.out.println(ok);

        for (String nome : nomes) {
            System.out.println(nome);

        }

        System.out.println(nomes);
    }
}
