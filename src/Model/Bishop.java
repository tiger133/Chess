package Model;

public class Bishop  extends Piece{

	public Bishop(boolean white)
	{
		super(white);
		this.pieceType = PieceType.BISHOP;
	}
	public Bishop clonePiece()
	{
		Bishop clone =new Bishop(super.white);
		clone.setPosition(new Position(super.boardPosition.getX(),super.boardPosition.getY()));
		return clone;
	}
}
