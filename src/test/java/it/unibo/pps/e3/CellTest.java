package it.unibo.pps.e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private Cell cell;

    @BeforeEach
    public void init() {
        this.cell = new CellImpl();
    }

    @Test
    public void testEmptyCellShouldBeCreatedHidden() {
        assertFalse(this.cell.isRevealed());
    }
}
