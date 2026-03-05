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
}
