package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Country;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Currency;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.USA);

        System.out.println(currency.getSymbol());
    }
}
