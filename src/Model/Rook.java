package Model;



public class Rook extends Piece{
	
	public Rook(boolean white)
	{
		super(white);
		this.pieceType = PieceType.ROOK;
	}
	public Rook clonePiece()
	{
		Rook clone =new Rook(super.white);
		clone.setPosition(new Position(super.boardPosition.getX(),super.boardPosition.getY()));
		return clone;
	}
}
