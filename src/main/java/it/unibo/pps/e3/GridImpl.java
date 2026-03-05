package it.unibo.pps.e3;

import java.util.ArrayList;
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

    @Override
    public List<Pair<Integer, Integer>> getAdjacentPositions(Pair<Integer, Integer> cell) {
        List<Pair<Integer, Integer>> neighbours = new ArrayList<>();
        int row = cell.getX();
        int col = cell.getY();
        for (int coordRow = -1; coordRow <= 1; coordRow++) {
            for (int coordCol = -1; coordCol <= 1; coordCol++) {
                if (coordRow != 0 || coordCol != 0) {
                    int newX = coordRow + row;
                    int newY = coordCol + col;
                    if (newX >= 0 && newY >= 0 && newX < this.size && newY < this.size) {
                        neighbours.add(new Pair<>(newX, newY));
                    }
                }
            }
        }
        return neighbours;
    }

    @Override
    public int countAdjacentMines(Pair<Integer, Integer> cell) {
        int count = 0;
        for (Pair<Integer, Integer> neighboursPosition: this.getAdjacentPositions(cell)) {
            if (this.getCell(neighboursPosition).isMine()) {
                count++;
            }
        }
        return count;
    }

}
