package it.unibo.pps.e3;

public interface Logics {

    void hit(Pair<Integer, Integer> cell);

    boolean isLost();

    boolean isRevealed(Pair<Integer, Integer> cell);
}
