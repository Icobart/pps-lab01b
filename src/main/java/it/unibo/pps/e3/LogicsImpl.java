package it.unibo.pps.e3;

import java.util.Collections;
import java.util.List;

public class LogicsImpl implements Logics {

    private final Grid grid;
    private final int size;
    private final int totalMines;
    private boolean lost = false;

    public LogicsImpl(int size) {
        this.grid = new GridImpl(size, Collections.emptyList());
        this.size = size;
        this.totalMines = 0;
    }

    public LogicsImpl(int size, List<Pair<Integer, Integer>> mines) {
        this.grid = new GridImpl(size, mines);
        this.size = size;
        this.totalMines = mines.size();
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

    @Override
    public boolean isFlagged(Pair<Integer, Integer> cell) {
        return this.grid.getCell(cell).isFlagged();
    }

    @Override
    public int getAdjacentMinesCount(Pair<Integer, Integer> cell) {
        return this.grid.countAdjacentMines(cell);
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> cell) {
        this.grid.getCell(cell).toggleFlag();
    }

    @Override
    public boolean isWon() {
        if (this.lost) {
            return false;
        }
        int revealedCount = 0;
        int totalCells = this.size * this.size;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.isRevealed(new Pair<>(i, j))) {
                    revealedCount++;
                }
            }
        }
        return revealedCount == (totalCells - this.totalMines);
    }
}
