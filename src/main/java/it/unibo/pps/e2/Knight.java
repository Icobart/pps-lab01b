package it.unibo.pps.e2;

public class Knight implements Piece{

    private final Pair<Integer, Integer> position;

    public Knight(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
}
