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
        int newPositionX = 3;
        int newPositionY = 0;
        this.knight.move(new Pair<>(newPositionX, newPositionY));
        assertEquals(new Pair<>(newPositionX, newPositionY), this.knight.getPosition());
    }

    @Test
    public void testKnightShouldNotBeAbleToPerformInvalidMoves() {
        int invalidX = 0;
        int invalidY = 0;
        assertFalse(this.knight.canMove(new Pair<>(invalidX, invalidY)));
    }

    @Test
    public void testKnightShouldMoveOnlyWithingTheValidMoves() {
        int validX = 3;
        int validY = 0;
        assertTrue(this.knight.canMove(new Pair<>(validX, validY)));
    }
}
