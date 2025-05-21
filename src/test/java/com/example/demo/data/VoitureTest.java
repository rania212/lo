package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture() {
        Voiture voiture = new Voiture("Toyota", 15000);
        voiture.setId(1);

        assertEquals("Toyota", voiture.getMarque());
        assertEquals(15000, voiture.getPrix());
        assertEquals(1, voiture.getId());
    }
}
