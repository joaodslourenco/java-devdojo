package academy.devdojo.maratonajava.javacore.ZZBcomportamentos.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.dominio.Car;
import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
    private static final List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {
        List<Car> greenCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });

        List<Car> redCars = filter(cars, car -> car.getColor().equals("red"));
        List<Car> carsBefore2015 = filter(cars, car -> car.getYear() < 2015);


        System.out.println(greenCars);
        System.out.println(redCars);
        System.out.println(carsBefore2015);
    }

    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
        List<Car> filteredCars = new ArrayList<>();

        for (Car car : cars) {
            if (carPredicate.test(car)) filteredCars.add(car);
        }
        return filteredCars;
    }


}
