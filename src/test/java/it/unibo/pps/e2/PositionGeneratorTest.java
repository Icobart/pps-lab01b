package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionGeneratorTest {

    private PositionGenerator generator;

    @BeforeEach
    public void init() {
        this.generator = new RandomPositionGenerator();
    }

    @Test
    public void testGeneratesWithinBounds() {
        int size = 5;
        for (int i = 0; i < 100; i++) {
            Pair<Integer, Integer> position = this.generator.generate(size);
            assertTrue(position.getX() >= 0 && position.getX() < size
                        && position.getY() >= 0 && position.getY() < size);
        }
    }

    @Test
    public void testGeneratesCorrectlyWithSizeOne() {
        int size = 1;
        Pair<Integer, Integer> position = this.generator.generate(size);
        int expectedX = 0;
        int expectedY = 0;
        assertEquals(new Pair<>(expectedX, expectedY), position);
    }

    @Test
    public void testExcludesGivenPosition() {
        int size = 2;
        int pawnPositionX = 0;
        int pawnPositionY = 0;
        Pair<Integer, Integer> pawnPosition = new Pair<>(pawnPositionX, pawnPositionY);
        for (int i = 0; i < 50; i++) {
            Pair<Integer, Integer> position = this.generator.generateExcluding(size, pawnPosition);
            assertNotEquals(pawnPosition, position);
        }
    }
}
