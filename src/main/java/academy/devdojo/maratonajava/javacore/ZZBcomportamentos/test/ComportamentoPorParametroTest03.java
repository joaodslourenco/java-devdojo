package academy.devdojo.maratonajava.javacore.ZZBcomportamentos.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest03 {
    private static final List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {


        List<Car> greenCars = filter(cars, car -> car.getColor().equals("green"));
        List<Car> redCars = filter(cars, car -> car.getColor().equals("red"));
        List<Car> carsBefore2015 = filter(cars, car -> car.getYear() < 2015);


        System.out.println(greenCars);
        System.out.println(redCars);
        System.out.println(carsBefore2015);


        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> numbersBiggerThan5 = filter(nums, num -> num > 5);
        System.out.println(numbersBiggerThan5);
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) filteredList.add(t);
        }
        return filteredList;

    }

}
