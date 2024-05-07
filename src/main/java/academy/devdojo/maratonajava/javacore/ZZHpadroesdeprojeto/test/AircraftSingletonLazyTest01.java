package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonLazy;

public class AircraftSingletonLazyTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

     static void bookSeat(String seat){
        AircraftSingletonLazy aircraft = AircraftSingletonLazy.getINSTANCE();
        System.out.println(aircraft);
        System.out.println(aircraft.bookSeat(seat));
    }
}
