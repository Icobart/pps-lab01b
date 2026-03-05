package it.unibo.pps.e3;

import it.unibo.pps.e2.Pair;

public interface Grid {
    Cell getCell(Pair<Integer, Integer> cell);
}
