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
        Pair<Integer, Integer> position = this.generator.generate(1);
        assertEquals(new Pair<>(0, 0), position);
    }

    @Test
    public void testExcludesGivenPosition() {
        int size = 2;
        Pair<Integer, Integer> pawnPosition = new Pair<>(0, 0);
        for (int i = 0; i < 50; i++) {
            Pair<Integer, Integer> position = this.generator.generateExcluding(size, pawnPosition);
            assertNotEquals(pawnPosition, position);
        }
    }
}
