package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Piece pawn;
	private final Piece knight;
	private final Board board;
	 
    public LogicsImpl(int size){
    	this.board = new Board(size);
        PositionGenerator generator = new RandomPositionGenerator();
        this.pawn = new Pawn(generator.generate(size));
        this.knight = new Knight(generator.generateExcluding(size, this.pawn.getPosition()));
    }

    public LogicsImpl(int size, Pair<Integer, Integer> initialPawnPosition, Pair<Integer, Integer> initialKnightPosition) {
        this.board = new Board(size);
        this.pawn = new Pawn(initialPawnPosition);
        this.knight = new Knight(initialKnightPosition);
    }
    
	@Override
	public boolean hit(int row, int col) {
        Pair<Integer, Integer> newPosition = new Pair<>(row, col);
        if (!this.board.isInside(newPosition)) {
			throw new IndexOutOfBoundsException();
		}
		if (this.knight.canMove(newPosition)) {
			this.knight.move(newPosition);
			return this.pawn.getPosition().equals(this.knight.getPosition());
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}
}
