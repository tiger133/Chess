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
	private MoveValidator moveValidator;
	
	public GameLogic()
	{
		chessBoard = new ChessBoard();
		moveBuffer = new MoveBuffer(chessBoard);
		moveValidator = new MoveValidator(chessBoard);
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
	private void move()
	{
		chessBoard.movePiece(moveBuffer.getFirst(), moveBuffer.getSecond());
		whitePlaying = !whitePlaying;
	}
	public void turn(Position x)
	{
		
		moveBuffer.add(x,whitePlaying);
		
		if(moveBuffer.isBothSet())
		{
			move();
			
			
			moveBuffer.clearBuffer();
		}else if(moveBuffer.isOneSet())
		{
			moveBuffer.addAvailableTurns(moveValidator.availableTurns(x));;
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
