package Model;

public class Move {
	private Position fromPosition;
	private Position toPosition;
	private Piece piece;
	private Piece knockedOut;
	public  Move(Position fromPosition,Position toPosition,Piece piece)
	{
		this.fromPosition = fromPosition;
		this.toPosition = toPosition;
		this.piece = piece.clonePiece();	
	}
	public  Move(Position fromPosition,Position toPosition,Piece piece,Piece knockedOut)
	{
		this.fromPosition = fromPosition;
		this.toPosition = toPosition;
		this.piece = piece.clonePiece();
		this.knockedOut = knockedOut.clonePiece();
	}
	public Move()
	{
		//zeby buffer dziala
	}
	public Position fromPosition()
	{
		return fromPosition;
	}
	public Position toPosition()
	{
		return toPosition;
	}
	public void setFirstPosition(Position from)
	{
		fromPosition = new Position(from);
	}
	public void setSecondPosition(Position sec)
	{
		toPosition = new Position(sec);
	}
	public Piece getPiece()
	{
		return piece;
	}
	public void setPiece(Piece piece)
	{
		this.piece = piece;
	}
	public Piece getKnockedOut()
	{
		return knockedOut;
	}
	public void setKnockedOut(Piece knockedOut)
	{
		this.knockedOut = knockedOut;
	}
	public void clear()
	{
		toPosition = null;
		fromPosition = null;
	}
	public boolean bothPositions()
	{
		return ((toPosition != null) && (fromPosition !=null)); 
	}
}
