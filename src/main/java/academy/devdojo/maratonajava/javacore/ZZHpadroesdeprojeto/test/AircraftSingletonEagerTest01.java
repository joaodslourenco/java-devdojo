package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonEager;

public class AircraftSingletonEagerTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");

        AircraftSingletonEager.getINSTANCE().bookSeat("1A");

    }

     static void bookSeat(String seat){
        AircraftSingletonEager aircraft = AircraftSingletonEager.getINSTANCE();
        System.out.println(aircraft);
        System.out.println(aircraft.bookSeat(seat));
    }
}
