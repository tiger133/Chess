package Model;

import java.util.ArrayList;
import java.util.List;



public class ChessBoard 
{
	public class Square {
		private boolean colour;
		private Position squarePosition;
		private Piece placed;
		private boolean selected;
		public Square(boolean black,Position from)
		{
			colour = black;
			squarePosition = new Position(from);
			selected = false;
		};
		public boolean isWhitePieceOn()
		{
			if((placed!=null)&&placed.isWhite()) return true;
			
			return false;
		}
		public boolean isWhite()
		{
			return colour;
		}
		public Piece getPiece()
		{
			return placed;
		}
		public void setPiece(Piece toPlaced)
		{
			placed = toPlaced;
			toPlaced.setPosition(squarePosition);
		}
		public boolean isPlaced()
		{
			return placed!=null;
		}
		public void removePiece()
		{
			placed = null;
		}
		public boolean isSelected()
		{
			return selected;
		}
		public void setSelected(boolean selected)
		{
			this.selected = selected;
		}
	}

	private Square[][] gird;
	private List<Move> history = new ArrayList<Move>();
	
	public ChessBoard()
	{
		gird = new Square[8][8];
		
		for(int i = 0 ; i< 8; i++)
			for(int j = 0; j<8;j++)
			{
				gird[i][j] = new Square((i+j)%2==0,new Position(i,j));
			}
		//Pawns
		for(int i = 0; i <8 ; i++)
		{
			gird[i][1].setPiece(new Pawn(false));
			gird[i][6].setPiece(new Pawn(true));
		}
		
		
		for(int i =0 ; i<8 ; i+=7)
		{
			//Rooks
			gird[0][i].setPiece(new Rook(i!=0));
			gird[7][i].setPiece(new Rook(i!=0));
			//Knights
			gird[1][i].setPiece(new Knight(i!=0));
			gird[6][i].setPiece(new Knight(i!=0));
			//Bishops
			gird[2][i].setPiece(new Bishop(i!=0));
			gird[5][i].setPiece(new Bishop(i!=0));	
			
			gird[4][i].setPiece(new Queen(i!=0));
			gird[3][i].setPiece(new King(i!=0));
		}
	}
	
	public Square[][] getGird()
	{
		return gird;
	}

	public List<Piece> getPieces()
	{
		List<Piece> result = new ArrayList<Piece>();
		for(int i = 0;i<8;i++)
			for(int j = 0; j<8;j++)
			{
				if(gird[i][j].isPlaced()) result.add(gird[i][j].getPiece());
			}
		return result;
	}
	public Piece getPiece(Position x)
	{
		return gird[x.getX()][x.getY()].getPiece();
	}
	public void movePiece(Position from, Position to)
	{
		history.add(new Move(from,to,gird[from.getX()][from.getY()].getPiece()));
		Piece tmp = gird[from.getX()][from.getY()].getPiece();
		gird[from.getX()][from.getY()].removePiece();
		gird[to.getX()][to.getY()].setPiece(tmp);
	}
	public void removePiece(Square toRemoveFrom)
	{
		toRemoveFrom.removePiece();
	}
	public boolean select(Position x, boolean selected)
	{
		gird[x.getX()][x.getY()].setSelected(selected);
		return gird[x.getX()][x.getY()].isPlaced();
	}
	public boolean isPlaced(Position x)
	{
		return gird[x.getX()][x.getY()].isPlaced();
	}
}
