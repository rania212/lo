package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
        assertEquals("Toyota", voiture.getMarque());
        assertEquals(15000, voiture.getPrix());
        assertEquals(1, voiture.getId());
    }
}
