package it.unibo.pps.e2;

public class Knight implements Piece{

    private Pair<Integer, Integer> position;

    public Knight(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean canMove(Pair<Integer, Integer> target) {
        int x = target.getX() - this.getPosition().getX();
        int y = target.getY() - this.getPosition().getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }

    @Override
    public void move(Pair<Integer, Integer> newPosition) {
        this.position = newPosition;
    }
}
