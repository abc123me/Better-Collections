package net.net16.jeremiahlowe.bettercollections.vector;

/**
 * @deprecated
 * A custom Vector2 for storing x and y values
 * <br>Also includes special maths such as distance
 * @see Vector2
 * @author Jeremiah Lowe
 *
 * @param <T>
 * The type of custom vector, must extend Number
 */
public class CustomVector2<T extends Number>{
	public static final CustomVector2<Number> UP = new CustomVector2<Number>(0, 1);
	public static final CustomVector2<Number> DOWN = new CustomVector2<Number>(0, -1);
	public static final CustomVector2<Number> LEFT = new CustomVector2<Number>(-1, 0);
	public static final CustomVector2<Number> RIGHT = new CustomVector2<Number>(1, 0);
	public static final CustomVector2<Number> POSITIVE = new CustomVector2<Number>(1, 1);
	public static final CustomVector2<Number> NEGATIVE = new CustomVector2<Number>(-1, 1);
	public static final CustomVector2<Number> UNDEFINED = new CustomVector2<Number>(0, Float.POSITIVE_INFINITY);
	public static final CustomVector2<Number> ZERO = new CustomVector2<Number>(0, 0);
	
	/**
	 * The x value of the vector
	 */
	public Number x = 0;
	/**
	 * The y value of the vector
	 */
	public Number y = 0;
	/**
	 * Makes a vector2 with x and y values being 0
	 */
	public CustomVector2(){}
	/**
	 * Makes a pre-defined vector
	 * @param x
	 * @param y
	 */
	public CustomVector2(T x, T y){
		this.x = x; 
		this.y = y;
	}
	/**
	 * Makes a pre-defined vector
	 * @param all
	 * The x and y value
	 */
	public CustomVector2(T all){this(all, all);}
	/**
	 * Gets x as a Number
	 * @return
	 */
	public Number getX(){
		return x;
	}
	/**
	 * Gets y as a Number
	 * @return
	 */
	public Number getY(){
		return y;
	}
	/**
	 * Sets x
	 * @param x
	 */
	public void setX(T x){
		this.x = x;
	}
	/**
	 * Sets y
	 * @param y
	 */
	public void setY(T y){
		this.y = y;
	}
	/**
	 * Gets the distance between 2 vectors of type U
	 * @param a
	 * @param b
	 * @return
	 * The distance between a and b
	 * @param <U>
	 * The type must extend Number
	 */
	public static <U extends Number> double distance(CustomVector2<U> a, CustomVector2<U> b){
		return Math.sqrt(distance2(a, b));
	}
	/**
	 * Gets the distance <b>squared</b> between 2 vectors of type U
	 * @param a
	 * @param b
	 * @return
	 * The distance <b>squared</b> between a and b
	 * @param <U>
	 * The type must extend Number
	 */
	public static <U extends Number> double distance2(CustomVector2<U> a, CustomVector2<U> b){
		double x = Math.pow((b.x.doubleValue() - a.x.doubleValue()), 2);
		double y = Math.pow((b.y.doubleValue() - a.y.doubleValue()), 2);
		return x + y;
	}
	/**
	 * Gets the midpoint of vectors a and b of type U
	 * @param a
	 * @param b
	 * @return
	 * The midpoint of vectors a and b as type U 
	 * @param <U>
	 * The type must extend Number
	 */
	public static <U extends Number> CustomVector2<U> midpoint(CustomVector2<U> a, CustomVector2<U> b){
		CustomVector2<U> out = new CustomVector2<U>();
		out.x = (a.x.doubleValue() + b.x.doubleValue()) / 2;
		out.y = (a.y.doubleValue() + b.y.doubleValue()) / 2;
		return out;
	}
}
