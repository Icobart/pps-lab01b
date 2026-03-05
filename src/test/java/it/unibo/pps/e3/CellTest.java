package it.unibo.pps.e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private Cell emptyCell;
    private Cell mineCell;

    @BeforeEach
    public void init() {
        this.emptyCell = new CellImpl(CellType.EMPTY);
        this.mineCell = new CellImpl(CellType.MINE);
    }

    @Test
    public void testEmptyCellShouldBeCreatedHidden() {
        assertFalse(this.emptyCell.isRevealed());
    }

    @Test
    public void testEmptyCellShouldBeCreatedUnflagged() {
        assertFalse(this.emptyCell.isFlagged());
    }

    @Test
    public void testEmptyCellShouldBeCreatedWithoutAMine() {
        assertFalse(this.emptyCell.isMine());
    }

    @Test
    public void testMineCellShouldContainAMine() {
        assertTrue(this.mineCell.isMine());
    }
}
