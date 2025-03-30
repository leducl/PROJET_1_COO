package canards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInteractionType {


    private Canard canard1;
    private Canard canard2;
    private Canard canard3;

    @BeforeEach
    void setUp() {
        canard1 = new CanardFeu("BOB", 100, 10, 1.5);
        canard2 = new CanardGlace("BILL", 10, 8, 1.2);
        canard3 = new CanardVent("POLO", 100, 10, 1.5);
    }

    @Test
    void testAttaqueFaiblesse() {
        canard1.attaquer(canard2);
        assertTrue(canard2.getPointsDeVie() <= 76);
    }

    @Test
    void testAttaqueResistance() {
        canard2.attaquer(canard1);
        assertTrue(canard1.getPointsDeVie() >= 70);
    }

    @Test
    void testAttaqueNormale() {
        canard3.attaquer(canard1);
        assertTrue(canard1.getPointsDeVie() <= 100);
    }
}
