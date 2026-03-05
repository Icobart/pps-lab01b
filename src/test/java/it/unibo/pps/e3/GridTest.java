package it.unibo.pps.e3;

import it.unibo.pps.e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    public static final int SIZE = 3;
    private Grid grid;

    @Test
    public void testMineCellCorrectlyInitialized() {
        this.grid = new GridImpl(SIZE, List.of(new Pair<>(1, 1)));
        assertTrue(this.grid.getCell(new Pair<>(1, 1)).isMine());
    }

    @Test
    public void testEmptyCellCorrectlyInitialized() {
        this.grid = new GridImpl(SIZE, List.of(new Pair<>(1, 1)));
        assertFalse(this.grid.getCell(new Pair<>(0, 0)).isMine());
    }
}
