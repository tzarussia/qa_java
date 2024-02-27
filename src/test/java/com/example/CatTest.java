package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Cat cat;
    @Mock
    Feline feline;
    @Before
    public void setCat(){
        cat = new Cat(feline);
    }
    @Test
    public void testGetSound() {
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void testGetFood() throws Exception {
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}
