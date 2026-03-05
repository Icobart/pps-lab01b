package it.unibo.pps.e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    public static final int SIZE = 3;
    public static final Pair<Integer, Integer> CENTER_POSITION = new Pair<>(1, 1);
    public static final Pair<Integer, Integer> CORNER_POSITION = new Pair<>(0, 0);
    public static final Pair<Integer, Integer> EDGE_POSITION = new Pair<>(0, 1);
    public static final Pair<Integer, Integer> OPPOSITE_CORNER_CORNER = new Pair<>(2, 2);
    private Grid grid;

    @Test
    public void testMineCellCorrectlyInitialized() {
        this.grid = new GridImpl(SIZE, List.of(CENTER_POSITION));
        assertTrue(this.grid.getCell(CENTER_POSITION).isMine());
    }

    @Test
    public void testEmptyCellCorrectlyInitialized() {
        this.grid = new GridImpl(SIZE, List.of(CENTER_POSITION));
        assertFalse(this.grid.getCell(CORNER_POSITION).isMine());
    }

    @Test
    public void testAdjacentPositionsForCenterCell() {
        this.grid = new GridImpl(SIZE, List.of());
        List<Pair<Integer, Integer>> neighbours = this.grid.getAdjacentPositions(CENTER_POSITION);
        int expectedAdjacentCells = 8;
        assertEquals(expectedAdjacentCells, neighbours.size());
    }

    @Test
    public void testAdjacentPositionsForCornerCell() {
        this.grid = new GridImpl(SIZE, List.of());
        List<Pair<Integer, Integer>> neighbours = this.grid.getAdjacentPositions(CORNER_POSITION);
        int expectedAdjacentCells = 3;
        assertEquals(expectedAdjacentCells, neighbours.size());
    }

    @Test
    public void testAdjacentPositionsForEdgeCell() {
        this.grid = new GridImpl(SIZE, List.of());
        List<Pair<Integer, Integer>> neighbours = this.grid.getAdjacentPositions(EDGE_POSITION);
        int expectedAdjacentCells = 5;
        assertEquals(expectedAdjacentCells, neighbours.size());
    }

    @Test
    public void testAdjacentMinesShouldBeZeroWhenNearbyThereAreNone() {
        this.grid = new GridImpl(SIZE, List.of(CORNER_POSITION));
        int expectedMinesNumber = 0;
        assertEquals(expectedMinesNumber, this.grid.countAdjacentMines(OPPOSITE_CORNER_CORNER));
    }

    @Test
    public void testAdjacentMinesShouldBeNonZeroWhenNearbyThereAreAtLeastOne() {
        this.grid = new GridImpl(SIZE, List.of(CORNER_POSITION, EDGE_POSITION, new Pair<>(0, 2)));
        int expectedMines = 3;
        assertEquals(expectedMines, this.grid.countAdjacentMines(CENTER_POSITION));
    }

}
