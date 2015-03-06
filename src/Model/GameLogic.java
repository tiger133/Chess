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
	private Move bufferMove;
	
	
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
		chessBoard.select(x,y,true);
	}
	
	private void unselect(int x, int y)
	{
		chessBoard.select(x,y,false);
	}

}
