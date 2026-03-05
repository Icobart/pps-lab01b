package it.unibo.pps.e3;

public class CellImpl implements Cell {

    private final CellType cellType;
    private CellState cellState;

    public CellImpl(CellType cellType) {
        this.cellType = cellType;
        this.cellState = CellState.HIDDEN;
    }

    @Override
    public boolean isRevealed() {
        return this.cellState.equals(CellState.REVEALED);
    }

    @Override
    public boolean isFlagged() {
        return this.cellState.equals(CellState.FLAGGED);
    }

    @Override
    public boolean isMine() {
        return this.cellType.equals(CellType.MINE);
    }

    @Override
    public void reveal() {
        if (this.cellState.equals(CellState.HIDDEN)) {
            this.cellState = CellState.REVEALED;
        }
    }

    @Override
    public void toggleFlag() {
        if (this.cellState.equals(CellState.HIDDEN)) {
            this.cellState = CellState.FLAGGED;
        } else if (this.cellState.equals(CellState.FLAGGED)) {
            this.cellState = CellState.HIDDEN;
        }
    }
}
