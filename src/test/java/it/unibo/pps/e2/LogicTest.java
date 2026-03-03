package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private Logics logics;
    public static final int SIZE = 5;
    public static final Pair<Integer, Integer> INITIALPAWNPOSITION = new Pair<>(1, 3);
    public static final Pair<Integer, Integer> INITIALKNIGHTPOSITION = new Pair<>(1, 1);

    @BeforeEach
    public void init() {
        this.logics = new LogicsImpl(SIZE, INITIALPAWNPOSITION, INITIALKNIGHTPOSITION);
    }

    @Test
    public void testCorrectCreationOfPawn() {
        assertTrue(logics.hasPawn(INITIALPAWNPOSITION.getX(), INITIALPAWNPOSITION.getY()));
    }

    @Test
    public void testCorrectCreationOfKnight() {
        assertTrue(logics.hasKnight(INITIALKNIGHTPOSITION.getX(), INITIALKNIGHTPOSITION.getY()));
    }
}
