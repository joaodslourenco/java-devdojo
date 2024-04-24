package academy.devdojo.maratonajava.javacore.ZZBcomportamentos.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    private static final List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {
        List<Car> cars1 = filterCarByColor(cars, "green");
        List<Car> cars2 = filterCarByColor(cars, "red");
        List<Car> cars3 = filterByYearBefore(cars, 2015);

        System.out.println(cars1);
        System.out.println(cars2);
        System.out.println(cars3);

    }

    private static List<Car> filterCarByColor(List<Car> cars, String color) {
        List<Car> filteredCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getColor().equals(color)) filteredCars.add(car);
        }
        return filteredCars;
    }

    private static List<Car> filterByYearBefore(List<Car> cars, int year) {
        List<Car> filteredCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getYear() < year) filteredCars.add(car);
        }
        return filteredCars;
    }


}
