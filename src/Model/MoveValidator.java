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
		
		List<Position> result = new ArrayList<Position>();
		if(chessBoard.getPiece(x).isWhite())
		{
			if(x.getY() == 6)
			{
				result.add(new Position(x.getX(),5));
				result.add(new Position(x.getX(),4));
			}else{
				
				
			}
		}else
		{
			if(x.getY() == 1)
			{
				result.add(new Position(x.getX(),2));
				result.add(new Position(x.getX(),3));
			}
		}
	
		return result;
	}
}
