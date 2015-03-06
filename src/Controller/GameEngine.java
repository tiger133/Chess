package Controller;

//HALO HALO HALO TU ASIA :D

import java.awt.Event;
import java.awt.Graphics;

import Model.*;
import View.Renderer;
import View.SimpleChessBoardRender;

public class GameEngine {
	
	private Renderer renderer;
	private GameLogic gameLogic;
	private GameLogicController controller;
	
	public GameEngine()
	{
		gameLogic = new GameLogic();
		renderer = new SimpleChessBoardRender(gameLogic.getChessBoard());
		controller = new GameLogicController(gameLogic);
	}
	
	public void update(float delta)//24/s
	{
			
	}
	
	public void render(Graphics g)
	{
		 renderer.render(g);
	}
	public boolean handleEvent(Event e)
	{
		switch(e.id){
			case Event.MOUSE_DOWN:
				controller.onClick(e.x, e.y);
				break;
		}
		return false;
		
	}
	
}
