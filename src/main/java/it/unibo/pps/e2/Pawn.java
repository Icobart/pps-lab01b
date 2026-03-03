package it.unibo.pps.e2;

public class Pawn implements Piece{

    private final Pair<Integer, Integer> position;

    public Pawn(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean canMove(Pair<Integer, Integer> target) {
        return false;
    }

    @Override
    public void move(Pair<Integer, Integer> newPosition) {
        throw new UnsupportedOperationException();
    }
}
