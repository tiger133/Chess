package Model;

import java.util.ArrayList;
import java.util.List;

public class MoveBuffer {
	private Position first;
	private Position second;
	private List<Position> availableTurns = new ArrayList<Position>();
	private ChessBoard chessBoard;

	public MoveBuffer(ChessBoard chessBoard)
	{
		this.chessBoard = chessBoard;
	}
	public Position getFirst()
	{
		return first;
	}
	public Position getSecond()
	{
		return second;
	}
	public boolean isNoneSet()
	{
		return ((first==null) && (second ==null));
	}
	public boolean isOneSet()
	{
		return ((first!=null)&&(second==null))||((first==null)&&(second!=null));
	}
	public boolean isBothSet()
	{
		return ((first!=null)&&(second!=null));
	}
	public void setFirst(Position x)
	{
		first = new Position(x);
	}
	public void setSecond(Position x)
	{
		second = new Position(x);
	}
	public void add(Position x,boolean whitePlaying)
	{
		if(isNoneSet()) 
		{
			if(chessBoard.isPlaced(x))
			{
				if((whitePlaying && chessBoard.getPiece(x).isWhite())
				 ||(!whitePlaying && !chessBoard.getPiece(x).isWhite()))
				{	//black or white 
					setFirst(x); 
					chessBoard.select(x,true);

				}
			}
		}else if(isOneSet())
		{
			if(chessBoard.isPlaced(x))
			{	
				if((whitePlaying && !chessBoard.getPiece(x).isWhite())
					||(!whitePlaying && chessBoard.getPiece(x).isWhite()))
				{ // playerWhite xor whitePiece
					setSecond(x);
					chessBoard.select(x,true);
				}
			}
			else{
				setSecond(x);
				chessBoard.select(x,true);
			}
				
		}
	}
	public void addAvailableTurns(List<Position> x)
	{
		availableTurns.addAll(x);
		for(Position pos: availableTurns)
		{
			chessBoard.select(pos, true);
		}
	}
	public void clearBuffer()
	{
		chessBoard.select(first, false);
		chessBoard.select(second, false);
		for(Position pos: availableTurns)
		{
			chessBoard.select(pos, false);
		}
		availableTurns.clear();
		first = null;
		second = null;
	}
}
