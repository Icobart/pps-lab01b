package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private Logics logics;
    public static final int SIZE = 5;
    public static final Pair<Integer, Integer> INITIALPAWNPOSITION = new Pair<>(0, 3);
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

    @Test
    public void testKnightShouldNotRemovePawnAfterMovingInEmptyCell() {
        assertFalse(this.logics.hit(3, 0));
    }

    @Test
    public void testKnightShouldMoveToANewEmptyCell() {
        this.logics.hit(3, 0);
        assertTrue(this.logics.hasKnight(3, 0));
    }

    @Test
    public void testKnightShouldNotBeInInitialPositionAfterMoving() {
        this.logics.hit(3, 0);
        assertFalse(this.logics.hasKnight(INITIALKNIGHTPOSITION.getX(), INITIALKNIGHTPOSITION.getY()));
    }

    @Test
    public void testKnightShouldNotMoveIfInvalidCell() {
        this.logics.hit(0,0);
        assertFalse(this.logics.hasKnight(0,0));
    }

    @Test
    public void testShouldThrowExceptionIfHitNegativeCoordinates() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(-1, -1));
    }

    @Test
    public void testShouldThrowExceptionIfHitOutOfBoundsCoordinates() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(SIZE, SIZE));
    }

    @Test
    public void testKnightShouldHitPawn() {
        assertTrue(this.logics.hit(0, 3));
    }

    @Test
    public void testKnightShouldBeInPawnPositionIfHit() {
        this.logics.hit(0, 3);
        assertTrue(this.logics.hasKnight(0,3));
    }
}
