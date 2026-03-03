package it.unibo.pps.e2;

import java.util.Random;

public class RandomPositionGenerator implements PositionGenerator{

    private final Random random = new Random();

    @Override
    public Pair<Integer, Integer> generate(int size) {
        return new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    }

    @Override
    public Pair<Integer, Integer> generateExcluding(int size, Pair<Integer, Integer> position) {
        Pair<Integer,Integer> newPosition = this.generate(size);
        // the recursive call below prevents clash with an existing pawn
        return position !=null && position.equals(newPosition) ? generateExcluding(size, position) : newPosition;
    }
}
