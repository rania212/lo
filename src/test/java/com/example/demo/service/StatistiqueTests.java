package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Test
    public void testPrixMoyenAvecMock() {
        // Création d’un faux Echantillon à retourner
        Echantillon fauxEchantillon = new Echantillon(3, 20000);

        // Simulation du comportement de la méthode prixMoyen()
        when(statistiqueImpl.prixMoyen()).thenReturn(fauxEchantillon);

        // Appel de la méthode mockée
        Echantillon resultat = statistiqueImpl.prixMoyen();

        // Vérifications
        assertEquals(3, resultat.getNombreDeVoitures());
        assertEquals(20000, resultat.getPrixMoyen());
    }
}
