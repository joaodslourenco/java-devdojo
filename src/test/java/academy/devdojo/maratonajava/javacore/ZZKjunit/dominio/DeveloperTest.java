package academy.devdojo.maratonajava.javacore.ZZKjunit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperTest {

    @Test
    public void instanceOf_ExecutesChildClassMethodWhenObjectIsOfChildType() {
        Employee employeeDeveloper = new Developer("1", "Java");

        if (employeeDeveloper instanceof Developer developer) {
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }

    }
}