package it.unibo.pps.e2;

public class Board {

    private final int size;

    public Board(int size) {
        this.size = size;
    }

    public boolean isInside(Pair<Integer, Integer> position) {
        return position.getX() >= 0 && position.getY() >= 0 && position.getX() < this.size && position.getY() < this.size;
    }
}
