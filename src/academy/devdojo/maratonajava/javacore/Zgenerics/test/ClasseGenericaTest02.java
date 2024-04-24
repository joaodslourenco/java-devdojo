package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest02 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Mercedes")));
        List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));

        RentalService<Carro> rentalService1 = new RentalService<>(carrosDisponiveis);
        RentalService<Barco> rentalService2 = new RentalService<>(barcosDisponiveis);

        Carro carro = rentalService1.buscarObjetoDisponivel();
        System.out.println("Usando carro por um mês...");
        rentalService1.retornarObjetoAlugado(carro);


        System.out.println("---------");

        Barco barco = rentalService2.buscarObjetoDisponivel();
        System.out.println("Usando barco por um mês");
        rentalService2.retornarObjetoAlugado(barco);
    }
}
