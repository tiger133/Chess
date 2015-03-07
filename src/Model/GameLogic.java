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
	private MoveBuffer moveBuffer;
	
	
	public GameLogic()
	{
		chessBoard = new ChessBoard();
		moveBuffer = new MoveBuffer(chessBoard);
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
	public void turn(Position x)
	{
		
		moveBuffer.add(x,whitePlaying);
		
		if(moveBuffer.isBothSet())
		{
			//TO-DO
			
			
			
			moveBuffer.clearBuffer();
		}
	}
	

	public boolean select(Position x)
	{
		return chessBoard.select(x,true);	
	}
	
	public boolean unselect(Position x)
	{
		return chessBoard.select(x,false);
	}

}
