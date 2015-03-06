package Model;



public class Pawn extends Piece{

	public Pawn(boolean white)
	{
		super(white);
		this.pieceType = PieceType.PAWN;
	}
	public Pawn clonePiece()
	{
		Pawn clone =new Pawn(super.white);
		clone.setPosition(new Position(super.boardPosition.getX(),super.boardPosition.getY()));
		return clone;
	}
}
