package it.unibo.pps.e3;

import java.util.List;

public interface MinesGenerator {

    List<Pair<Integer, Integer>> generate(int size, int minesCount);

}
