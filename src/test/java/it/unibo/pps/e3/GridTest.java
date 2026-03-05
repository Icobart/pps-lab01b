package it.unibo.pps.e3;

import it.unibo.pps.e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridTest {

    private Grid grid;

    @Test
    public void testMineCellCorrectlyInitialized() {
        this.grid = new GridImpl(3, List.of(new Pair<>(1, 1)));
        assertTrue(this.grid.getCell(new Pair<>(1, 1)).isMine());
    }
}
