package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.ChessBoard;

public class SimpleChessBoardRender implements Renderer{

	private ChessBoard chessBoard;
	private BufferedImage bufferedImageOfPieces;
	public SimpleChessBoardRender(ChessBoard chessBoard)
	{
			this.chessBoard = chessBoard;
			try {
				bufferedImageOfPieces = ImageIO.read(new File("pieces.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	@Override
	public void render(Graphics g) {
		ChessBoard.Square[][] gird = chessBoard.getGird();
		g.setColor(new Color(146,105,10));
		for(int i = 0; i<8;i++)
			for(int j = 0; j<8;j++)
			{

				if(gird[i][j].isWhite())
				{
					g.setColor(new Color(228,176,57));
					if(gird[i][j].isSelected()) g.setColor(new Color(106,176,76));
					g.fillRect(i*80, j*80, 80, 80);
				}else 
				{
					g.setColor(new Color(146,105,10));
					if(gird[i][j].isSelected()) g.setColor(new Color(90,148,66));
					g.fillRect(i*80, j*80, 80, 80);
				}
				
				if(gird[i][j].isPlaced())
				{
					int white = 0 ; // 0 - black 
					if(gird[i][j].getPiece().isWhite()) white = 100;
				
					switch(gird[i][j].getPiece().getPieceType()){
						case PAWN:
							g.drawImage(bufferedImageOfPieces.getSubimage(0,  white, 100, 100).
									   getScaledInstance(80, 80, Image.SCALE_SMOOTH) , 
									   i*80, 
									   j*80, 
									   null);
							break;
						case KING:
							g.drawImage(bufferedImageOfPieces.getSubimage(500, white, 100, 100).
									   getScaledInstance(80, 80, Image.SCALE_SMOOTH) , 
									   i*80, 
									   j*80,
									   null);
							
							break; 
						case QUEEN:
							g.drawImage(bufferedImageOfPieces.getSubimage(400, white, 100, 100).
									   getScaledInstance(80, 80, Image.SCALE_SMOOTH) , 
									   i*80, 
									   j*80, 
									   null);
							break;
						case ROOK:
							g.drawImage(bufferedImageOfPieces.getSubimage(100, white, 100, 100).
									   getScaledInstance(80, 80, Image.SCALE_SMOOTH) , 
									   i*80, 
									   j*80,
									   null);
							break;
						case KNIGHT:
							g.drawImage(bufferedImageOfPieces.getSubimage(200,  white, 100, 100).
									   getScaledInstance(80, 80, Image.SCALE_SMOOTH) , 
									   i*80, 
									   j*80,
									   null);
							break;
						case BISHOP:
							g.drawImage(bufferedImageOfPieces.getSubimage(300,  white, 100, 100).
									   getScaledInstance(80, 80, Image.SCALE_SMOOTH) , 
									   i*80, 
									   j*80,
									   null);
							break;
					}
			
				}
			}
		//chess	
	}

}
