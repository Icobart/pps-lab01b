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
        assertFalse(this.pawn.canMove(new Pair<>(1,3)));
    }

    @Test
    public void testShouldThrowExceptionIfPawnTriesToMove() {
        assertThrows(UnsupportedOperationException.class, () -> this.pawn.move(new Pair<>(1, 3)));
    }
}
