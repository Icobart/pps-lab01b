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
}
