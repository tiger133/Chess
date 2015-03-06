package Model;

public abstract class Piece {
	public enum PieceType {
		PAWN,
		ROOK,
		KNIGHT,
		BISHOP,
		QUEEN,
		KING;
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
