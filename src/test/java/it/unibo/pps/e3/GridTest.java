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

    @Test
    public void testAdjacentPositionsForCenterCell() {
        this.grid = new GridImpl(3, List.of());
        List<Pair<Integer, Integer>> neighbours = this.grid.getAdjacentPositions(new Pair<>(1, 1));
        assertEquals(8, neighbours.size());
    }

    @Test
    public void testAdjacentPositionsForCornerCell() {
        this.grid = new GridImpl(3, List.of());
        List<Pair<Integer, Integer>> neighbours = this.grid.getAdjacentPositions(new Pair<>(0, 0));
        assertEquals(3, neighbours.size());
    }

    @Test
    public void testAdjacentPositionsForEdgeCell() {
        this.grid = new GridImpl(3, List.of());
        List<Pair<Integer, Integer>> neighbours = this.grid.getAdjacentPositions(new Pair<>(0, 1));
        assertEquals(5, neighbours.size());
    }

    @Test
    public void testAdjacentMinesShouldBeZeroWhenNearbyThereAreNone() {
        this.grid = new GridImpl(SIZE, List.of(new Pair<>(0, 0)));
        assertEquals(0, this.grid.countAdjacentMines(new Pair<>(2, 2)));
    }

    @Test
    public void testAdjacentMinesShouldBeNonZeroWhenNearbyThereAreAtLeastOne() {
        this.grid = new GridImpl(SIZE, List.of(new Pair<>(0, 0), new Pair<>(0, 1), new Pair<>(0, 2)));
        assertEquals(3, this.grid.countAdjacentMines(new Pair<>(1, 1)));
    }

}
