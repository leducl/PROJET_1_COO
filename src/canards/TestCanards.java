package canards;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCanards {
    private Canard canard1;
    private Canard canard2;

    @BeforeEach
    void setUp() {
        canard1 = new CanardEau("BOB", 100, 10, 1.5);
        canard2 = new CanardGlace("BILL", 80, 8, 1.2);
    }

    @Test
    void testAttributionDesValeurs() {
        assertEquals("BOB", canard1.getNom());
        assertEquals(TypeCanard.EAU, canard1.getType());
        assertEquals(100, canard1.getPointsDeVie());
        assertEquals(10, canard1.getPointsAttaque());
        assertEquals(1.5, canard1.getVitesseAttaque());
        assertEquals(StatutCanard.HEUREUX, canard1.getStatut());
    }

    @Test
    void testAttaque() {
        canard1.attaquer(canard2);
        assertTrue(canard2.getPointsDeVie() <= 70);
    }

    @Test
    void testSubirDegats() {
        canard2.subirDegats(20);
        assertEquals(60, canard2.getPointsDeVie());
    }

    @Test
    void testEstKO() {
        canard2.subirDegats(80);
        assertTrue(canard2.estKO());
    }

    @Test
    void testSetAction() {
        canard1.SetAction(1);
        assertEquals(1, canard1.getAction());
    }

    @Test
    void testSetStatut() {
        canard1.SetStatut(StatutCanard.BRULE);
        assertEquals(StatutCanard.BRULE, canard1.getStatut());
    }

}
