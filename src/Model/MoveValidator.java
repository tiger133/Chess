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
	
}
