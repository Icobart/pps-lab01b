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
        int emptyX = 3;
        int emptyY = 0;
        assertFalse(this.logics.hit(emptyX, emptyY));
    }

    @Test
    public void testKnightShouldMoveToANewEmptyCell() {
        int emptyX = 3;
        int emptyY = 0;
        this.logics.hit(emptyX, emptyY);
        assertTrue(this.logics.hasKnight(emptyX, emptyY));
    }

    @Test
    public void testKnightShouldNotBeInInitialPositionAfterMoving() {
        int emptyX = 3;
        int emptyY = 0;
        this.logics.hit(emptyX, emptyY);
        assertFalse(this.logics.hasKnight(INITIALKNIGHTPOSITION.getX(), INITIALKNIGHTPOSITION.getY()));
    }

    @Test
    public void testKnightShouldNotMoveIfInvalidCell() {
        int invalidX = 0;
        int invalidY = 0;
        this.logics.hit(invalidX, invalidY);
        assertFalse(this.logics.hasKnight(invalidX,invalidY));
    }

    @Test
    public void testShouldThrowExceptionIfHitNegativeCoordinates() {
        int negativeX = -1;
        int negativeY = -1;
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(negativeX, negativeY));
    }

    @Test
    public void testShouldThrowExceptionIfHitOutOfBoundsCoordinates() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(SIZE, SIZE));
    }

    @Test
    public void testKnightShouldHitPawn() {
        int pawnPositionX = 0;
        int pawnPositionY = 3;
        assertTrue(this.logics.hit(pawnPositionX, pawnPositionY));
    }

    @Test
    public void testKnightShouldBeInPawnPositionIfHit() {
        int pawnPositionX = 0;
        int pawnPositionY = 3;
        this.logics.hit(pawnPositionX, pawnPositionY);
        assertTrue(this.logics.hasKnight(pawnPositionX, pawnPositionY));
    }
}
