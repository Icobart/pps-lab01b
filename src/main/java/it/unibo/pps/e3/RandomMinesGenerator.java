package it.unibo.pps.e3;

import java.util.*;

public class RandomMinesGenerator implements MinesGenerator {

    @Override
    public List<Pair<Integer, Integer>> generate(int size, int minesCount) {
        Set<Pair<Integer, Integer>> randomMines = new HashSet<>();
        Random random = new Random();
        while (randomMines.size() < minesCount) {
            randomMines.add(new Pair<>(random.nextInt(size), random.nextInt(size)));
        }
        return new ArrayList<>(randomMines);
    }

}
