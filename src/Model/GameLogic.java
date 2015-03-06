package Model;

import java.util.List;

public class GameLogic {
	public enum GameState {
		InPlay, CheckMate,StaleMate,BeforeGame
	}
	
	private ChessBoard chessBoard;
	private Player whitePlayer;
	private Player blackPlayer;
	private GameState gameState;
	private boolean whitePlaying = true;
	private Move moveBuffer = new Move();
	
	
	public GameLogic()
	{
		chessBoard = new ChessBoard();
		gameState = GameState.BeforeGame;
		whitePlayer = new Player(true);
		blackPlayer = new Player(false);
		List<Piece> pieces = chessBoard.getPieces();
		whitePlayer.setPieces(pieces);
		blackPlayer.setPieces(pieces);
		
	}
	public ChessBoard getChessBoard()
	{
		return chessBoard;
	}
	public void startGame()
	{
		gameState = GameState.InPlay;
	}
	public GameState getGameState()
	{
		return gameState;
	}
	
	
	public void select(int x, int y)
	{
		boolean isPlaced = chessBoard.select(x,y,true);
		if((moveBuffer.fromPosition()==null)&&isPlaced) moveBuffer.setFirstPosition(new Position(x,y));
		else if((!isPlaced)&&moveBuffer.toPosition()==null&&moveBuffer.toPosition()==null){
			unselect(x,y);
			moveBuffer.clear();
			return;
		}
		else if((!isPlaced)&&moveBuffer.toPosition()==null) 
			 moveBuffer.setSecondPosition(new Position(x,y));
		//Turn : 
		
		
		//End turn;
		 if(moveBuffer.bothPositions())
		{
			
			unselect(moveBuffer.fromPosition().getX(),moveBuffer.fromPosition().getY());
			unselect(moveBuffer.toPosition().getX(),moveBuffer.toPosition().getY());
			moveBuffer.clear();
		}
		
		
	}
	
	public void unselect(int x, int y)
	{
		chessBoard.select(x,y,false);
	}

}
