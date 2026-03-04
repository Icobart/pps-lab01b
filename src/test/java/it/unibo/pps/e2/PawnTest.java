package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    private Piece pawn;
    public static final Pair<Integer, Integer> INITIALPOSITION = new Pair<>(0, 3);

    @BeforeEach
    public void init() {
        this.pawn = new Pawn(INITIALPOSITION);
    }

    @Test
    public void testInitialPosition() {
        assertEquals(INITIALPOSITION, this.pawn.getPosition());
    }

    @Test
    public void testPawnCannotMove() {
        int positionX = 1;
        int positionY = 3;
        assertFalse(this.pawn.canMove(new Pair<>(positionX, positionY)));
    }

    @Test
    public void testShouldThrowExceptionIfPawnTriesToMove() {
        int positionX = 1;
        int positionY = 3;
        assertThrows(UnsupportedOperationException.class, () -> this.pawn.move(new Pair<>(positionX, positionY)));
    }
}
