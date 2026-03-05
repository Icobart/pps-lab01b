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
        if (!currentCell.isRevealed() && !currentCell.isFlagged()) {
            currentCell.reveal();
            if (currentCell.isMine()) {
                this.lost = true;
            } else if (this.grid.countAdjacentMines(cell) == 0) {
                for (Pair<Integer, Integer> neighbour : this.grid.getAdjacentPositions(cell)) {
                    this.hit(neighbour);
                }
            }
        }
    }

    @Override
    public boolean isLost() {
        return this.lost;
    }

    @Override
    public boolean isRevealed(Pair<Integer, Integer> cell) {
        return this.grid.getCell(cell).isRevealed();
    }
}
