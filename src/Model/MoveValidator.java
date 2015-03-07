package Model;

import java.util.ArrayList;
import java.util.List;

public class MoveValidator {
	private ChessBoard chessBoard;
	public MoveValidator(ChessBoard chessBoard)
	{
		this.chessBoard = chessBoard;
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
		List<Position> result = new ArrayList<Position>();
		
		if(isWhite)
		{
			if(x.getY()-1 >= 0 && !chessBoard.isPlaced(new Position(x.getX(), x.getY()-1)))
				result.add(new Position(x.getX(), x.getY()-1));
			if(x.getY() == 6 && !chessBoard.isPlaced(new Position(x.getX(), 4)))
				result.add(new Position(x.getX(),4));
		}
		else
		{
			if(x.getY()+1 <8 && !chessBoard.isPlaced(new Position(x.getX(), x.getY()+1)))
				result.add(new Position(x.getX(), x.getY()+1));
			if(x.getY() == 1 && !chessBoard.isPlaced(new Position(x.getX(), 3)))
				result.add(new Position(x.getX(),3));
		}
		
		return result;
	}
}
