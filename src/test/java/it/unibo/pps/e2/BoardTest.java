package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    public static final int SIZE = 5;

    @BeforeEach
    public void init() {
        board = new Board(SIZE);
    }

    @Test
    public void testInsideBounds() {
        int positionX = 2;
        int positionY = 2;
        assertTrue(board.isInside(new Pair<>(positionX, positionY)));
    }

    @Test
    public void testOutOfBounds() {
        int invalidX = -1;
        int positionY = 0;
        assertFalse(board.isInside(new Pair<>(invalidX, positionY)));
    }
}
