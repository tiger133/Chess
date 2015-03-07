package Model;

public abstract class Piece {
	public enum PieceType {
		PAWN(1),
		ROOK(5),
		KNIGHT(3),
		BISHOP(3),
		QUEEN(9),
		KING(Integer.MAX_VALUE);
		private final int id;
		PieceType(int id)
		{
			this.id = id;
		}
		public int getValue()
		{
			return id;
		}
	}
	protected PieceType pieceType;
	protected boolean white;
	protected Position boardPosition = new Position(0,0);
	
	protected Piece(boolean white)
	{
		this.white = white;
	}
	public boolean isWhite()
	{
		return white;
	}
	public void setPieceType(PieceType pieceType)
	{
		this.pieceType = pieceType;
	}
	public PieceType getPieceType()
	{
		return pieceType;
	}
	public void setPosition(Position newPosition)
	{
		boardPosition.setPosition(newPosition);
	}
	public String toString()
	{
		String tmp = "Pos [" + boardPosition.getX() + ", " + boardPosition.getY()+"] "+pieceType;
		return tmp;
	}
	public abstract Piece clonePiece();
}
