package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        Person person = Person.PersonBuilder
                .aPerson()
                .withFirstName("Joau")
                .withLastName("Lourenço")
                .withEmail("joaodslourenco@gmail.com")
                .withUsername("joaodslourenco")
                .build();


        System.out.println(person);
    }


}
