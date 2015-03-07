package Model;

public class Position 
{
	private int x;
	private int y;
	public Position(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	public Position(Position from)
	{
		x = from.x;
		y = from.y;
	}
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public void setPosition(Position from)
	{
		x = from.x;
		y = from.y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public boolean equals(Position second)
	{
		return ((x==second.x)&&(y==second.y));
	}
}
