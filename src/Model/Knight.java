package Model;


public class Knight extends Piece {
	
	public Knight(boolean white)
	{
		super(white);
		this.pieceType = PieceType.KNIGHT;
	}
	public Knight clonePiece()
	{
		Knight clone =new Knight(super.white);
		clone.setPosition(new Position(super.boardPosition.getX(),super.boardPosition.getY()));
		return clone;
	}

}
