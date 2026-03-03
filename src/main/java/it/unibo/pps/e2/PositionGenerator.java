package it.unibo.pps.e2;

public interface PositionGenerator {

    Pair<Integer, Integer> generate(int size);

    Pair<Integer, Integer> generateExcluding(int size, Pair<Integer, Integer> position);
}
