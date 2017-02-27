package net.net16.jeremiahlowe.bettercollections;

import net.net16.jeremiahlowe.bettercollections.vector.Vector2;

public class Line {
	public static final Line POSITIVE = new Line(1, 0);
	public static final Line NEGATIVE = new Line(-1, 0);
	public static final Line VERTICAL = new Line(Float.POSITIVE_INFINITY, 0);
	public static final Line HORIZONTAL = new Line(0, 0);
	
	private float yIntercept = 0;
	private float slope = 0;
	
	/**
	 * Constructor for creating a 2-dimensional line in <b>point to point</b> format
	 * @param x1
	 * @param y1
	 * The first point of the line
	 * @param x2
	 * @param y2
	 * The second point of the line
	 */
	public Line(float x1, float y1, float x2, float y2){
		this(new Vector2(x1, y1), new Vector2(x2, y2));
	}
	/**
	 * Constructor for creating a 2-dimensional line in <b>point to point</b> format
	 * @param pos1
	 * The first point of the line
	 * @param pos2
	 * The second point of the line
	 */
	public Line(Vector2 pos1, Vector2 pos2){
		slope = (pos2.y - pos1.y) / (pos2.x - pos1.x);
		float mx = pos1.x * slope;
		yIntercept = pos1.y - mx;
	}
	/**
	 * Constructor for creating a 2-dimensional line in <b>Y = MX + B</b> format
	 * @param slope
	 * The slope or m
	 * @param yIntercept
	 * The y-intercept or b
	 */
	public Line(float slope, float yIntercept){
		this.slope = slope;
		this.yIntercept = yIntercept;
	}
	/**
	 * Method for getting y at a given x<br>
	 * y = mx + b
	 * @param x
	 * The x value
	 * @return
	 * The y value at x
	 */
	public float getY(float x){
		return slope * x + yIntercept;
	}
	/**
	 * Method for getting x at a given y<br>
	 * (y - b) / m
	 * @param y
	 * The y value
	 * @return
	 * The x value at y
	 */
	public float getX(float y){
		return (y - yIntercept) / slope;
	}
}
