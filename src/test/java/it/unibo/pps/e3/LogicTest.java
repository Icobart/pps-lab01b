package it.unibo.pps.e3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    public static final int DEFAULT_TEST_GRID_SIZE = 3;
    public static final Pair<Integer, Integer> TOP_LEFT_MINE = new Pair<>(0, 0);
    public static final Pair<Integer, Integer> BOTTOM_RIGHT_SAFE = new Pair<>(2, 2);
    public static final Pair<Integer, Integer> TOP_RIGHT_SAFE = new Pair<>(0, 2);
    public static final Pair<Integer, Integer> CENTER_SAFE = new Pair<>(1, 1);

    @Test
    public void testHitMineResultsInLoss() {
        List<Pair<Integer, Integer>> mines = List.of(CENTER_SAFE);
        Logics logics = new LogicsImpl(DEFAULT_TEST_GRID_SIZE, mines);
        logics.hit(CENTER_SAFE);
        assertTrue(logics.isLost());
    }

    @Test
    public void testHitEmptyCellShouldNotResultInLoss() {
        List<Pair<Integer, Integer>> mines = List.of(CENTER_SAFE);
        Logics logics = new LogicsImpl(DEFAULT_TEST_GRID_SIZE, mines);
        logics.hit(TOP_LEFT_MINE);
        assertFalse(logics.isLost());
    }

    @Test
    public void testHitCellWithZeroAdjacentMinesShouldTriggerCascade() {
        List<Pair<Integer, Integer>> mines = List.of(TOP_LEFT_MINE);
        Logics logics = new LogicsImpl(DEFAULT_TEST_GRID_SIZE, mines);
        logics.hit(BOTTOM_RIGHT_SAFE);
        assertAll(
                () -> assertTrue(logics.isRevealed(BOTTOM_RIGHT_SAFE)),
                () -> assertTrue(logics.isRevealed(TOP_RIGHT_SAFE)),
                () -> assertTrue(logics.isRevealed(CENTER_SAFE)),
                () -> assertFalse(logics.isRevealed(TOP_LEFT_MINE))
        );
    }

    @Test
    public void testHitCellWithAdjacentMinesShouldNotCascade() {
        List<Pair<Integer, Integer>> mines = List.of(TOP_LEFT_MINE);
        Logics logics = new LogicsImpl(DEFAULT_TEST_GRID_SIZE, mines);
        Pair<Integer, Integer> cellAdjacentMine = new Pair<>(0, 1);
        logics.hit(cellAdjacentMine);
        assertAll(
                () -> assertTrue(logics.isRevealed(cellAdjacentMine)),
                () -> assertFalse(logics.isRevealed(TOP_RIGHT_SAFE)),
                () -> assertFalse(logics.isRevealed(CENTER_SAFE))
        );
    }

    @Test
    public void testVictoryCondition() {
        List<Pair<Integer, Integer>> mines = List.of(TOP_LEFT_MINE);
        int smallGridSize = 2;
        Logics logics = new LogicsImpl(smallGridSize, mines);
        Pair<Integer, Integer> firstCell = new Pair<>(0, 1);
        logics.hit(firstCell);
        logics.hit(CENTER_SAFE);
        Pair<Integer, Integer> secondCell = new Pair<>(1, 0);
        logics.hit(secondCell);
        assertTrue(logics.isWon());
    }
}
