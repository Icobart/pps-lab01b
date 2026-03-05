package it.unibo.pps.e3;

import it.unibo.pps.e2.Pair;

import java.util.List;

public interface Grid {
    Cell getCell(Pair<Integer, Integer> cell);

    List<Pair<Integer, Integer>> getAdjacentPositions(Pair<Integer, Integer> cell);

    int countAdjacentMines(Pair<Integer, Integer> cell);
}
