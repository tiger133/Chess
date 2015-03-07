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
				return availableRook(x);
		case KNIGHT:
				return availableKnight(x);
		case BISHOP:
			break;
		case QUEEN:
			break;
		case KING:
			return availableKing(x);
		}
	return null;
	}
	public List<Position> availablePawn(Position x) //TO_DO bicie w przelocie, zamiana na damke
	{
		boolean isWhite = chessBoard.getPiece(x).isWhite();
		int step = isWhite ? -1 : 1;
		int secondLine = isWhite ? 6 : 1;
		List<Position> result = new ArrayList<Position>();
		Position a = new Position (x.getX(), x.getY()+step);
		Position b = new Position (x.getX(), x.getY()+step+step);
		Position c = new Position (x.getX()-1, x.getY()+step); // po skosie i w lewo
		Position d = new Position (x.getX()+1, x.getY()+step); // po skosie i w prawo
		
		if(inBounds(a) && !chessBoard.isPlaced(a))
				result.add(a);
		if(x.getY()==secondLine && inBounds(b) && !chessBoard.isPlaced(b) && !chessBoard.isPlaced(a))
				result.add(b);
		if(inBounds(c) && chessBoard.isPlaced(c) && chessBoard.getPiece(c).isWhite()!=isWhite)
				result.add(c);
		if(inBounds(d) && chessBoard.isPlaced(d) && chessBoard.getPiece(d).isWhite()!=isWhite)
			result.add(d);
		return result;
	}
	public List<Position> availableKnight(Position x)
	{
		boolean isWhite = chessBoard.getPiece(x).isWhite();
		List<Position> result = new ArrayList<Position>();
		for(int i = -1;i<2;i+=2)
		  {
		   for(int j=-1; j<2; j+=2)
		   {
		    Position a = new Position(x.getX()+i*1, x.getY()+j*2);
		    Position b = new Position(x.getX()+i*2, x.getY()+j*1);
		    
		    if(inBounds(a) && !chessBoard.isPlaced(a) ||(
		      inBounds(a) && chessBoard.isPlaced(a) && chessBoard.getPiece(a).isWhite()!=isWhite))
		     result.add(a);
		    if(inBounds(b) && !chessBoard.isPlaced(b) || (
		      inBounds(b) && chessBoard.isPlaced(b) && chessBoard.getPiece(b).isWhite()!=isWhite) )
		     result.add(b);
		   }
		  }
		return result;
	}
	public List<Position> availableKing(Position x)
	{
		boolean isWhite = chessBoard.getPiece(x).isWhite();
		List<Position> result = new ArrayList<Position>();
		for(int i = x.getX()-1; i<x.getX()+2;i++)
			for(int j = x.getY()-1;j<x.getY()+2;j++)
			{	
				Position a = new Position(i,j);
			    if(inBounds(a) && !chessBoard.isPlaced(a) ||
				  (inBounds(a) && chessBoard.isPlaced(a) && chessBoard.getPiece(a).isWhite()!=isWhite))
			    		result.add(a);	

			}
		return result;	
	}
	public List<Position> availableRook(Position x)
	{
		
		
		return null;
	}
}
