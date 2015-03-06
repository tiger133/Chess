import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Controller.GameEngine;


public class Chess extends Applet implements Runnable{


	private static final long serialVersionUID = 1L;
	private GameEngine engine = new GameEngine();

	public void start()
	{
		new Thread(this).start();
	}
	
	
	@Override
	public void run() {
		setSize(640,640);
		
		BufferedImage screen = new BufferedImage(640,640,BufferedImage.TYPE_INT_RGB);
		Graphics g = screen.getGraphics();
		Graphics appletGraphics = getGraphics();
		
		long delta = 0L;
		
		while(true)
		{
			long lastTime = System.nanoTime();
			
			g.setColor(new Color(228,176,57));
			g.fillRect(0, 0, 640, 640);
			
			engine.update(delta);
			engine.render(g);
				
			//drawing results:
			appletGraphics.drawImage(screen, 0, 0, null);
			
			delta = System.nanoTime() - lastTime;
			if(delta < 20000000L)
			{
				try {
					Thread.sleep((20000000L-delta)/1000000L);
				} catch (InterruptedException e) {
					//nothing
				}
				
			}
			if(!isActive())
			{
				return;
			}
		}
		
	}
	public boolean handleEvent(Event e)
	{
		return engine.handleEvent(e);
	}
	

}
