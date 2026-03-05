package it.unibo.pps.e3;

import java.util.Collections;
import java.util.List;

public class LogicsImpl implements Logics {

    private final Grid grid;
    private boolean lost = false;

    public LogicsImpl(int size) {
        this.grid = new GridImpl(size, Collections.emptyList());
    }

    public LogicsImpl(int size, List<Pair<Integer, Integer>> mines) {
        this.grid = new GridImpl(size, mines);
    }

    @Override
    public void hit(Pair<Integer, Integer> cell) {
        Cell currentCell = this.grid.getCell(cell);
        currentCell.reveal();
        if (currentCell.isMine()) {
            this.lost = true;
        }
    }

    @Override
    public boolean isLost() {
        return this.lost;
    }
}
