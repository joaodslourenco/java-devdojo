package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("luffy");

        for (String s : lista) {
            System.out.println(s);
        }


    }
}
