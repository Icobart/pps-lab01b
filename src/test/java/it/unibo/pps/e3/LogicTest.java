package it.unibo.pps.e3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    @Test
    public void testHitMineResultsInLoss() {
        List<Pair<Integer, Integer>> mines = List.of(new Pair<>(1, 1));
        Logics logics = new LogicsImpl(3, mines);
        logics.hit(new Pair<>(1, 1));
        assertTrue(logics.isLost());
    }

    @Test
    public void testHitEmptyCellShouldNotResultInLoss() {
        List<Pair<Integer, Integer>> mines = List.of(new Pair<>(1, 1));
        Logics logics = new LogicsImpl(3, mines);
        logics.hit(new Pair<>(0, 0));
        assertFalse(logics.isLost());
    }

    @Test
    public void testHitCellWithZeroAdjacentMinesShouldTriggerCascade() {
        List<Pair<Integer, Integer>> mines = List.of(new Pair<>(0, 0));
        Logics logics = new LogicsImpl(3, mines);
        logics.hit(new Pair<>(2, 2));
        assertAll(
                () -> assertTrue(logics.isRevealed(new Pair<>(2, 2))),
                () -> assertTrue(logics.isRevealed(new Pair<>(0, 2))),
                () -> assertTrue(logics.isRevealed(new Pair<>(1, 1))),
                () -> assertFalse(logics.isRevealed(new Pair<>(0, 0)))
        );
    }

    @Test
    public void testHitCellWithAdjacentMinesShouldNotCascade() {
        List<Pair<Integer, Integer>> mines = List.of(new Pair<>(0, 0));
        Logics logics = new LogicsImpl(3, mines);
        logics.hit(new Pair<>(0, 1));
        assertAll(
                () -> assertTrue(logics.isRevealed(new Pair<>(0, 1))),
                () -> assertFalse(logics.isRevealed(new Pair<>(0, 2))),
                () -> assertFalse(logics.isRevealed(new Pair<>(1, 1)))
        );
    }
}
