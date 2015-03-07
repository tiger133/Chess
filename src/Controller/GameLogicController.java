package Controller;


import Model.GameLogic;
import Model.Position;


public class GameLogicController {
	private GameLogic gameLogic;
	public GameLogicController(GameLogic gameLogic)
	{
		this.gameLogic = gameLogic;
	}
	public void onClick(int x, int y)
	{
			int xx = x/80;
			int yy = y/80;
			gameLogic.turn(new Position(xx,yy));
	}
	
}
