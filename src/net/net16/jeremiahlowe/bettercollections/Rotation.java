package net.net16.jeremiahlowe.bettercollections;

import net.net16.jeremiahlowe.bettercollections.vector.Vector2;

public class Rotation implements Cloneable{
	/**
	 * Constants for direction
	 */
	public static final Rotation NORTH = new Rotation(0);
	public static final Rotation SOUTH = new Rotation(180);
	public static final Rotation EAST = new Rotation(90);
	public static final Rotation WEST = new Rotation(270);
	public static final Rotation NORTH_EAST = new Rotation(45);
	public static final Rotation SOUTH_EAST = new Rotation(135);
	public static final Rotation NORTH_WEST = new Rotation(45);
	public static final Rotation SOUTH_WEST = new Rotation(135);
	/**
	 * The actual rotation (in degrees [for extra accuracy])
	 */
	private float rotation = 0;
	/**
	 * Creates a new Rotation with the predefined angle
	 * @param rotation
	 * The angle of the Rotation (in degrees)
	 */
	public Rotation(float rotation){
		float newRot = correctAngleDegrees(rotation);
		this.rotation = newRot;
	}
	/**
	 * Creates a new Rotation with the angle of zero degrees
	 */
	public Rotation(){this(0);}
	/**
	 * Gets the angle of the rotation (in degrees)
	 * @return
	 */
	public float getAngleDegrees(){
		return rotation;
	}
	/**
	 * Sets the angle of rotation (in degrees)
	 * @param rotation
	 */
	public void setAngleDegrees(float rotation){
		this.rotation = rotation;
	}
	/**
	 * Turns the angle into a 0 to 360 degree format
	 * @param angle
	 * @return
	 */
	public static float correctAngleDegrees(float angle){
		while(angle > 360) angle -= 360;
		while(angle < 0) angle += 360;
		return angle;
	}
	/**
	 * Turns the angle into a 0 to 2PI radian format
	 * @param angle
	 * @return
	 */
	public static float correctAngleRadians(float angle){
		float j = (float) Math.toRadians(360);
		while(angle > j) angle -= j;
		while(angle < 0) angle += j;
		return angle;
	}
	/**
	 * Gets the angle of the Rotation in radians
	 * @return
	 */
	public float getAngleRadians() {
		return (float) Math.toRadians(rotation);
	}
	/**
	 * Sets the angle of the Rotation in radians
	 * @param rotation
	 */
	public void setAngleRadians(float rotation){
		this.rotation = (float) Math.toDegrees(rotation);
	}
	//Directions
	/**
	 * Converts the Rotation to a direction (basically inverse of atan2)
	 * @param length
	 * @return
	 */
	public Vector2 toDirection(float length){
		float x = (float) (length * Math.cos(getAngleRadians()));
		float y = (float) (length * -Math.sin(getAngleRadians()));
		return new Vector2(x, y);
	}
	/**
	 * Converts the Rotation to a direction (basically inverse of atan2)
	 * @param r
	 * @param length
	 * @return
	 */
	public static Vector2 toDirection(Rotation r, float length){
		float x = (float) (length * Math.cos(r.getAngleRadians()));
		float y = (float) (length * -Math.sin(r.getAngleRadians()));
		return new Vector2(x, y);
	}
	/**
	 * Converts the Rotation to a direction wwith length of 1 (basically inverse of atan2)
	 * @param r
	 * @return
	 */
	public static Vector2 toDirection(Rotation r){
		return toDirection(r, 1);
	}
	/**
	 * Converts the Rotation to a direction wwith length of 1 (basically inverse of atan2)
	 * @return
	 */
	public Vector2 toDirection(){
		return toDirection(1);
	}
	/**
	 * Gets the rotation between two points (using atan2)
	 * @param origin
	 * The starting point
	 * @param target
	 * The target
	 * @return
	 */
	public static Rotation pointTo(Vector2 origin, Vector2 target){
		Vector2 atan2Pos = new Vector2(target.x - origin.x, target.y - origin.y);
		double radAtan2 = Math.atan2(atan2Pos.x, atan2Pos.y);
		Rotation out = new Rotation((float) Math.toDegrees(radAtan2));
		out.rotateBy(-90);
		return out;
	}
	/**
	 * Returns the rotation as a string
	 */
	@Override
	public String toString(){
		return (getAngleDegrees() + "°");
	}
	/**
	 * Translates the rotation by angle
	 * @param angle
	 * The angle to translate by (in degrees)
	 */
	public void rotateBy(float angle){
		rotation = correctAngleDegrees(rotation + angle);
	}
	/**
	 * Cone method
	 */
	@Override
	public Rotation clone(){
		return new Rotation(rotation);
	}
}
