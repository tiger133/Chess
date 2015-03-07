package Model;

import java.util.ArrayList;
import java.util.List;

public class MoveValidator {
	private ChessBoard chessBoard;
	public MoveValidator(ChessBoard chessBoard)
	{
		this.chessBoard = chessBoard;
	}
	public List<Position> availableTurns(Position x,boolean whitePlaying)
	{
		List<Position> result = new ArrayList<Position>();
		switch(chessBoard.getPiece(x).getPieceType())
		{
		case PAWN:
				result.addAll(availablePawn(x,whitePlaying));
			break;
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
	
		return result;
	}
	public List<Position> availablePawn(Position x,boolean whitePlaying)
	{
		List<Position> result = new ArrayList<Position>();
		if(whitePlaying)
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
