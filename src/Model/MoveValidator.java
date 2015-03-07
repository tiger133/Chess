package Model;

import java.util.ArrayList;
import java.util.List;

public class MoveValidator {
	private ChessBoard chessBoard;
	public MoveValidator(ChessBoard chessBoard)
	{
		this.chessBoard = chessBoard;
	}
	public boolean inBounds(Position a)
	{
		return (a.getX()>=0 && a.getX()<=7 && a.getY()>=0 && a.getY()<=7);
	}
	public boolean outOfBounds(Position a)
	{
		return !inBounds(a);
	}
	public List<Position> availableTurns(Position x)
	{
		switch(chessBoard.getPiece(x).getPieceType())
		{
		case PAWN:
				return availablePawn(x);
		case ROOK:
			break;
		case KNIGHT:
			break;
		case BISHOP:
			break;
		case QUEEN:
			break;
		case KING:
			break;
		}
	return null;
	}
	public List<Position> availablePawn(Position x)
	{
		boolean isWhite = chessBoard.getPiece(x).isWhite();
		int step = isWhite ? -1 : 1;
		int secondLine = isWhite ? 6 : 1;
		List<Position> result = new ArrayList<Position>();
		Position a = new Position (x.getX(), x.getY()+step);
		Position b = new Position (x.getX(), x.getY()+step+step);
		
		if(inBounds(a) && !chessBoard.isPlaced(a))
				result.add(a);
		if(x.getY()==secondLine && inBounds(b) && !chessBoard.isPlaced(b) && !chessBoard.isPlaced(a))
				result.add(b);

		return result;
	}
}
