package net.net16.jeremiahlowe.bettercollections;

public class Vector2Int {
	public int x = 0, y = 0;
	public Vector2Int(){}
	public Vector2Int(int x, int y){
		this.x = x; 
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public Vector2 toVector2(){
		return new Vector2(x, y);
	}
	public static double distance(Vector2Int a, Vector2Int b){
		return Math.sqrt(distance2(a, b));
	}
	public static double distance2(Vector2Int a, Vector2Int b){
		double x = Math.pow((b.x - a.x), 2);
		double y = Math.pow((b.y - a.y), 2);
		return x + y;
	}
	public static Vector2Int midpoint(Vector2Int a, Vector2Int b){
		Vector2Int out = new Vector2Int();
		out.x = Math.round((a.x + b.x) / 2f);
		out.y = Math.round((a.y + b.y) / 2f);
		return out;
	}
}
