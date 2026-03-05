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
}
