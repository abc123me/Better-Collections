package net.net16.jeremiahlowe.bettercollections.vector;

/**
 * A Vector3 for storing an x, y and z values
 * <br>Also includes special maths such as distance
 * @author Jeremiah Lowe
 *
 */
public class Vector3 extends Vector2 implements Cloneable{
	public static final Vector3 UP = new Vector3(0, 1, 0);
	public static final Vector3 DOWN = new Vector3(0, -1, 0);
	public static final Vector3 LEFT = new Vector3(-1, 0, 0);
	public static final Vector3 RIGHT = new Vector3(1, 0, 0);
	public static final Vector3 FORWARD = new Vector3(0, 0, 1);
	public static final Vector3 BACKWARD = new Vector3(0, 0, -1);
	public static final Vector3 ZERO = new Vector3(0, 0, 0);
	
	/**
	 * The z value of the vector as a float
	 */
	public float z = 0;
	/**
	 * Makes a pre-defined vector3
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector3(float x, float y, float z){
		super.x = x; 
		super.y = y; 
		this.z = z;
	}
	/**
	 * Makes a vector3 with all zeroes
	 */
	public Vector3(){this(0, 0, 0);}
	/**
	 * Makes a vector3 with a pre-defined x and y value
	 * z is set to 0
	 * @param x
	 * @param y
	 */
	public Vector3(float x, float y){this(x, y, 0);}
	/**
	 * Makes a pre-defined vector3 with all the same values
	 * @param all 
	 * the value to set x, y, and z to
	 */
	public Vector3(float all){this(all, all, all);}
	/**
	 * Makes a vector3 but with a vector2 for the x and y values and z for the z value
	 * @param in
	 * @param z
	 */
	public Vector3(Vector2 in, float z){this(in.x, in.y, z);}
	/**
	 * Makes a vector3 with a vector2 for the x and y values and z as 0
	 * @param in
	 */
	public Vector3(Vector2 in){this(in.x, in.y, 0);}
	
	/**
	 * Sets the z value
	 * @param z
	 */
	public void setZ(float z){this.z = z;}
	/**
	 * Gets the z value
	 * @return
	 */
	public float getZ(){return z;}
	/**
	 * Gets the z value as an integer (rounded)
	 * @return
	 */
	public int getZI(){return Math.round(z);}
	/**
	 * Gets the distance between two vectors
	 * @param a
	 * @param b
	 * @return the distance as a double
	 */
	public static double distance(Vector3 a, Vector3 b){
		return Math.sqrt(distance2(a, b));
	}
	/**
	 * Gets the distance <b>squared</b> between two vectors
	 * Useful for quick distance comparisons because square roots are cpu-taxing
	 * @param a
	 * @param b
	 * @return
	 * The distance <b>squared</b>
	 */
	public static double distance2(Vector3 a, Vector3 b){
		double x = Math.pow((b.x - a.x), 2);
		double y = Math.pow((b.y - a.y), 2);
		double z = Math.pow((b.z - a.z), 2);
		return x + y + z;
	}
	/**
	 * Gets the midpoint between point a and point b
	 * @param a
	 * @param b
	 * @return
	 * the midpoint of a and b
	 */
	public static Vector3 midpoint(Vector3 a, Vector3 b){
		Vector3 out = new Vector3();
		out.x = (a.x + b.x) / 2;
		out.y = (a.y + b.y) / 2;
		out.z = (a.z + b.z) / 2;
		return out;
	}
	/**
	 * Makes a new vector with the same values as the vector that was cloned
	 * @return the new vector
	 * @see Cloneable
	 */
	@Override
	public Vector3 clone(){
		return new Vector3(x, y, z);
	}
	/**
	 * Adds this vector to antother vector
	 * @param b
	 * @return
	 * The result of this + b
	 */
	public Vector3 add(Vector3 b){
		return new Vector3(x + b.x, y + b.y, z + b.z);
	}
	/**
	 * Subtracts this vector by another vector
	 * @param b
	 * @return
	 * The result of this - b
	 */
	public Vector3 subtract(Vector3 b){
		return new Vector3(x - b.x, y - b.y, z - b.z);
	}
	/**
	 * Adds this vector a to vector b
	 * @param b
	 * @return
	 * The result of a + b
	 */
	public static Vector3 add(Vector3 a, Vector3 b){
		return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
	}
	/**
	 * Subtracts vector a by vector b
	 * @param b
	 * @return
	 * The result of a - b
	 */
	public static Vector3 subtract(Vector3 a, Vector3 b){
		return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
	}
	/**
	 * Translates the vector by another vector
	 * @param by
	 */
	public void translate(Vector3 by){
		x += by.x; y += by.y; z += by.z;
	}
	/**
	 * Translates the vector by a specific x and y value
	 * @param x
	 * amount to move on x axis
	 * @param y
	 * amount to move on y axis
	 * @param z
	 * amount to move on z axis
	 */
	public void translate(float x, float y, float z){
		this.x += x; this.y += y; this.z += z;
	}
	/**
	 * Converts the vector to a string
	 */
	@Override
	public String toString(){
		return "Vector3 (" + x + ", " + y + ", " + z + ")";
	}
}
