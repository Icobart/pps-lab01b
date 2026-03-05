package it.unibo.pps.e3;

public interface Logics {

    void hit(Pair<Integer, Integer> cell);

    boolean isLost();

    boolean isRevealed(Pair<Integer, Integer> cell);

    boolean isFlagged(Pair<Integer, Integer> cell);

    int getAdjacentMinesCount(Pair<Integer, Integer> cell);

    void toggleFlag(Pair<Integer, Integer> cell);

    boolean isWon();

    boolean hasMine(Pair<Integer, Integer> cell);
}
