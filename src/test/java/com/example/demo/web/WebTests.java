@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetStatistique() throws Exception {
        Echantillon echantillonMock = new Echantillon(3, 10000);
        when(statistiqueImpl.prixMoyen()).thenReturn(echantillonMock);

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(3))
                .andExpect(jsonPath("$.prixMoyen").value(10000));
    }

    @Test
    void testPostVoiture() throws Exception {
        String voitureJson = "{\"marque\":\"Peugeot\", \"prix\":12000}";

        mockMvc.perform(post("/voiture")
                .contentType(MediaType.APPLICATION_JSON)
                .content(voitureJson))
                .andExpect(status().isOk());

        verify(statistiqueImpl, times(1))
                .ajouter(any(Voiture.class));
    }
}
