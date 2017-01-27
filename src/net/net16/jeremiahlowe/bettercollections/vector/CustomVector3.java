package net.net16.jeremiahlowe.bettercollections.vector;

/**
 * @deprecated
 * A custom Vector3 for storing x, y, and z values
 * <br>Also includes special maths such as distance
 * @see Vector3
 * @author Jeremiah Lowe
 *
 * @param <T>
 * The type of custom vector, must extend Number
 */
public class CustomVector3<T extends Number> extends CustomVector2<T>{
	public static final CustomVector3<Number> UP = new CustomVector3<Number>(0, 1, 0);
	public static final CustomVector3<Number> DOWN = new CustomVector3<Number>(0, -1, 0);
	public static final CustomVector3<Number> LEFT = new CustomVector3<Number>(-1, 0, 0);
	public static final CustomVector3<Number> RIGHT = new CustomVector3<Number>(1, 0, 0);
	public static final CustomVector3<Number> FORWARD = new CustomVector3<Number>(0, 0, 1);
	public static final CustomVector3<Number> BACKWARD = new CustomVector3<Number>(0, 0, -1);
	public static final CustomVector3<Number> ZERO = new CustomVector3<Number>(0, 0, 0);
	
	Number z = 0;
	public CustomVector3(Number x, Number y, Number z){
		super.x = x; 
		super.y = y; 
		this.z = z;
	}
	public CustomVector3(){this(0, 0, 0);}
	public CustomVector3(Number x, Number y){this(x, y, 0);}
	public CustomVector3(Number all){this(all, all, all);}
	public CustomVector3(CustomVector2<Number> in, Number z){this(in.x, in.y, z);}
	public CustomVector3(CustomVector2<Number> in){this(in.x, in.y, 0);}
	
	public void setZ(Number z){this.z = z;}
	public Number getZ(){return z;}
	/**
	 * Gets the distance between 2 vectors of type U
	 * @param a
	 * @param b
	 * @return
	 * The distance between a and b
	 * @param <U>
	 * The type must extend Number
	 */
	public static <U extends Number> double distance(CustomVector3<U> a, CustomVector3<U> b){
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
	public static <U extends Number> double distance2(CustomVector3<U> a, CustomVector3<U> b){
		double x = Math.pow((b.x.doubleValue() - a.x.doubleValue()), 2);
		double y = Math.pow((b.y.doubleValue() - a.y.doubleValue()), 2);
		double z = Math.pow((b.z.doubleValue() - a.z.doubleValue()), 2);
		return x + y + z;
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
	public static <U extends Number> CustomVector3<U> midpoint(CustomVector3<U> a, CustomVector3<U> b){
		CustomVector3<U> out = new CustomVector3<U>();
		out.x = (a.x.doubleValue() + b.x.doubleValue()) / 2;
		out.y = (a.y.doubleValue() + b.y.doubleValue()) / 2;
		out.z = (a.z.doubleValue() + b.z.doubleValue()) / 2;
		return out;
	}
}
