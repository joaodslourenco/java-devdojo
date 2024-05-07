package academy.devdojo.maratonajava.javacore.Zgenerics.test;

abstract class Animal {
    public abstract void consulta();


}


class Cachorro extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando doguinho!");
    }
}

class Gato extends Animal{
    @Override
    public void consulta() {
        System.out.println("Consultando gatinho!");
    }
}


public class WildcardTest01 {
    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};
        Animal[] animals = {new Gato(), new Cachorro()};

        printConsulta(cachorros);
        printConsulta(gatos);
        System.out.println("-------");
        printConsulta(animals);
    }

    private static void printConsulta(Animal[] animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }
//        animals[1] = new Gato();



    }

}
