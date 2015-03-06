package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Piece> pieces = new ArrayList<>();
	private boolean white;
	private int score;
	
	public Player(boolean white)
	{
		this.white = white;
	}
	public void setPieces(List<Piece> pieces)
	{
		for(Piece piece : pieces)
		{
			if(white&&piece.isWhite()) this.pieces.add(piece);
			else if((!white)&&(!piece.isWhite()))this.pieces.add(piece);	
		}
	}
	public void removePiece(Piece p)
	{
		 pieces.remove(p);
	
	}
	
}
