package it.unibo.pps.e3;

import it.unibo.pps.e2.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridImpl implements Grid {

    private final Map<Pair<Integer, Integer>, Cell> cells;
    private final int size;

    public GridImpl(int size,  List<Pair<Integer, Integer>> mines) {
        this.size = size;
        this.cells = new HashMap<>();
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                Pair<Integer, Integer> currentPosition = new Pair<>(row, col);
                if (mines.contains(currentPosition)) {
                    this.cells.put(currentPosition, new CellImpl(CellType.MINE));
                } else {
                    this.cells.put(currentPosition, new CellImpl(CellType.EMPTY));
                }
            }
        }
    }

    @Override
    public Cell getCell(Pair<Integer, Integer> cell) {
        return this.cells.get(cell);
    }
}
