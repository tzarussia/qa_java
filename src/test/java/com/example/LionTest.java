package com.example;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


@RunWith(MockitoJUnitRunner.class)
public class LionTest extends TestCase {
    private Lion lion;
    private static final String MALE = "Самец";

    @Mock
    Feline feline;
    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion(MALE, feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveManeException() {
        Throwable throwable = catchThrowable(() -> {
            lion = new Lion("unsupported sex", feline);
        });
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage("Используйте допустимые значения пола животного - самец или самка");
    }

    @Test
    public void testGetFood() throws Exception {
        lion = new Lion(MALE, feline);

        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
    @Test
    public void shouldBeMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean hasMane = lion.doesHaveMane();
        assertFalse(hasMane);
    }
}