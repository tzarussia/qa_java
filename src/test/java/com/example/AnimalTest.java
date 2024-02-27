package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
public class AnimalTest {

    Animal animal;
    @Before
    public void setUp() {
        animal = new Animal();
    }
    @Test
    public void testGetFoodException() {
        Throwable throwable = catchThrowable(() -> {
            animal.getFood("unsupported animal kind");
        });
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");
    }
    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();

        assertEquals("Ответ не соответствует ожидаемому!",
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actual);
    }
}
