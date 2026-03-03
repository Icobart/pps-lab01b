package it.unibo.pps.e2;

public interface Piece {

    Pair<Integer, Integer> getPosition();

    boolean canMove(Pair<Integer, Integer> target);

    void move(Pair<Integer, Integer> newPosition);

}
