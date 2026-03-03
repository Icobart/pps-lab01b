package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

    private Piece knight;
    public static final Pair<Integer, Integer> INITIALPOSITION = new Pair<>(1, 1);

    @BeforeEach
    public void init() {
        this.knight = new Knight(INITIALPOSITION);
    }

    @Test
    public void testInitialPosition() {
        assertEquals(INITIALPOSITION, this.knight.getPosition());
    }

    @Test
    public void testValidMoveShouldUpdatePosition() {
        this.knight.move(new Pair<>(3, 0));
        assertEquals(new Pair<>(3, 0), this.knight.getPosition());
    }

    @Test
    public void testKnightShouldNotBeAbleToPerformInvavlidMoves() {
        assertFalse(this.knight.canMove(new Pair<>(0, 0)));
    }

    @Test
    public void testKnightShouldMoveOnlyWithingTheValidMoves() {
        assertTrue(this.knight.canMove(new Pair<>(3, 0)));
    }
}
