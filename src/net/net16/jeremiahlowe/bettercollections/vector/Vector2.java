package net.net16.jeremiahlowe.bettercollections.vector;

/**
 * A Vector2 for storing a x, and y values
 * <br>Also includes special maths such as distance
 * @author Jeremiah Lowe
 *
 */
public class Vector2 implements Cloneable{
	public static final Vector2 UP = new Vector2(0, 1);
	public static final Vector2 DOWN = new Vector2(0, -1);
	public static final Vector2 LEFT = new Vector2(-1, 0);
	public static final Vector2 RIGHT = new Vector2(1, 0);
	public static final Vector2 POSITIVE = new Vector2(1, 1);
	public static final Vector2 NEGATIVE = new Vector2(-1, 1);
	public static final Vector2 UNDEFINED = new Vector2(0, Float.POSITIVE_INFINITY);
	public static final Vector2 ZERO = new Vector2(0, 0);
	
	/**
	 * The x value of the vector as a float
	 */
	public float x = 0;
	/**
	 * The y value of the vector as a float
	 */
	public float y = 0;
	/**
	 * Makes a vector2 with x and y as zero
	 */
	public Vector2(){}
	/**
	 * Makes a pre-defined vector2
	 * @param x
	 * @param y
	 */
	public Vector2(float x, float y){
		this.x = x; 
		this.y = y;
	}
	/**
	 * Makes a pre-defined vector2 with x and y as the specified value
	 * @param all
	 * the value to set x and y as
	 */
	public Vector2(float all){this(all, all);}
	/**
	 * Returns the x value of the vector2
	 * @return
	 */
	public float getX(){
		return x;
	}
	/**
	 * Returns the y value of the vector2
	 * @return
	 */
	public float getY(){
		return y;
	}
	/**
	 * Returns the x value of the vector2 as an integer (rounded)
	 * @return
	 */
	public int getXI(){
		return Math.round(x);
	}
	/**
	 * Returns the y value of the vector2 as an integer (rounded)
	 * @return
	 */
	public int getYI(){
		return Math.round(y);
	}
	/**
	 * Sets x the x value of the vector2
	 * @param x
	 */
	public void setX(float x){
		this.x = x;
	}
	/**
	 * Sets the y value of the vector2
	 * @param y
	 */
	public void setY(float y){
		this.y = y;
	}
	/**
	 * Gets the distance between vectors a and b
	 * @param a
	 * @param b
	 * @return
	 */
	public static double distance(Vector2 a, Vector2 b){
		return Math.sqrt(distance2(a, b));
	}
	/**
	 * Gets the distance <b>squared</b> between vectors a and b
	 * Useful for quick distance comparisons because square roots are cpu taxing
	 * @param a
	 * @param b
	 * @return
	 * the distance <b>squared</b>
	 */
	public static double distance2(Vector2 a, Vector2 b){
		double x = Math.pow((b.x - a.x), 2);
		double y = Math.pow((b.y - a.y), 2);
		return x + y;
	}
	/**
	 * Gets the midpoint between two vectors
	 * @param a
	 * @param b
	 * @return
	 */
	public static Vector2 midpoint(Vector2 a, Vector2 b){
		Vector2 out = new Vector2();
		out.x = (a.x + b.x) / 2;
		out.y = (a.y + b.y) / 2;
		return out;
	}
	/**
	 * Makes a new vector with the same values as the vector that was cloned
	 * @return the new vector
	 * @see Cloneable
	 */
	@Override
	public Vector2 clone(){
		return new Vector2(x, y);
	}
}
