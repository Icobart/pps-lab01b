package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Piece pawn;
	private Piece knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = new Pawn(this.randomEmptyPosition());
        this.knight = new Knight(this.randomEmptyPosition());
    }

    public LogicsImpl(int size, Pair<Integer, Integer> initialPawnPosition, Pair<Integer, Integer> initialKnightPosition) {
        this.size = size;
        this.pawn = new Pawn(initialPawnPosition);
        this.knight = new Knight(initialKnightPosition);
    }
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
        Pair<Integer, Integer> newPosition = new Pair<>(row, col);
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
