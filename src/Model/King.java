package Model;



public class King  extends Piece{

	public King(boolean white)
	{
		super(white);
		this.pieceType = PieceType.KING;
	}
	public King clonePiece()
	{
		King clone =new King(super.white);
		clone.setPosition(new Position(super.boardPosition.getX(),super.boardPosition.getY()));
		return clone;
	}
}
