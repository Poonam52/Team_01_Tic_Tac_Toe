package game;

public class Location {
	private final int r;
	private final int c;

	public int getRow() {
		return r;
	}

	public int getColumn() {
		return c;
	}

	public Location(int row, int column) {
		if(row<0 || column < 0 && row>2 || column>2){
			throw new IllegalArgumentException("Row or column number can not be negative");
		}
		r = row;
		c = column;
	}
}
