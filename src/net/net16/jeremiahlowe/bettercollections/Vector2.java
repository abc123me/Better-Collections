package net.net16.jeremiahlowe.bettercollections;

public class Vector2 {
	public float x = 0, y = 0;
	public Vector2(){}
	public Vector2(float x, float y){
		this.x = x; 
		this.y = y;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	public Vector2Int toVector2Int(){
		return new Vector2Int(Math.round(x), Math.round(y));
	}
	public static double distance(Vector2 a, Vector2 b){
		return Math.sqrt(distance2(a, b));
	}
	public static double distance2(Vector2 a, Vector2 b){
		double x = Math.pow((b.x - a.x), 2);
		double y = Math.pow((b.y - a.y), 2);
		return x + y;
	}
	public static Vector2 midpoint(Vector2 a, Vector2 b){
		Vector2 out = new Vector2();
		out.x = (a.x + b.x) / 2;
		out.y = (a.y + b.y) / 2;
		return out;
	}
}
