package Model;

public class Move {
	private Position fromPosition;
	private Position toPosition;
	private Piece piece;
	public  Move(Position fromPosition,Position toPosition,Piece piece)
	{
		this.fromPosition = fromPosition;
		this.toPosition = toPosition;
		this.piece = piece.clonePiece();
	
	}
	public Position fromPosition()
	{
		return fromPosition;
	}
	public Position toPosition()
	{
		return toPosition;
	}
	
}
