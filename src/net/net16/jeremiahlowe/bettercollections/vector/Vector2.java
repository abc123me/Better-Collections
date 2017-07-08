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
	/**
	 * Adds this vector to antother vector
	 * @param b
	 * @return
	 * The result of this + b
	 */
	public Vector2 add(Vector2 b){
		return new Vector2(x + b.x, y + b.y);
	}
	/**
	 * Subtracts this vector by another vector
	 * @param b
	 * @return
	 * The result of this - b
	 */
	public Vector2 subtract(Vector2 b){
		return new Vector2(x - b.x, y - b.y);
	}
	/**
	 * Adds this vector a to vector b
	 * @param b
	 * @return
	 * The result of a + b
	 */
	public static Vector2 add(Vector2 a, Vector2 b){
		return new Vector2(a.x + b.x, a.y + b.y);
	}
	/**
	 * Subtracts vector a by vector b
	 * @param b
	 * @return
	 * The result of a - b
	 */
	public static Vector2 subtract(Vector2 a, Vector2 b){
		return new Vector2(a.x - b.x, a.y - b.y);
	}
	/**
	 * Translates the vector by another vector
	 * @param by
	 */
	public void translate(Vector2 by){
		x += by.x; y += by.y;
	}
	/**
	 * Translates the vector by a specific x and y value
	 * @param x
	 * amount to move on x axis
	 * @param y
	 * amount to move on y axis
	 */
	public void translate(float x, float y){
		this.x += x; this.y += y; 
	}
	/**
	 * Converts the vector to a string
	 */
	@Override
	public String toString(){
		return "Vector2 (" + x + ", " + y + ")";
	}
	public boolean sameAs(Vector2 a) {
		return x == a.x && y == a.y;
	}
}
