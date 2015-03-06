package Model;



public class Queen  extends Piece{

	public Queen(boolean white)
	{
		super(white);
		this.pieceType = PieceType.QUEEN;
	}
	public Queen clonePiece()
	{
		Queen clone =new Queen(super.white);
		clone.setPosition(new Position(super.boardPosition.getX(),super.boardPosition.getY()));
		return clone;
	}
}
