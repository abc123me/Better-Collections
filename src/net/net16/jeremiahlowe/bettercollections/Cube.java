package net.net16.jeremiahlowe.bettercollections;

import net.net16.jeremiahlowe.bettercollections.vector.Vector3;

/**
 * Cube for holding values of a specified type
 * @author 
 * Jeremiah Lowe
 * @param <T>
 * T is the type for each cell of cube
 */
public class Cube<T>{
	private int width, height, length;
	private T[][][] values;
	
	/**
	 * Constructor for creating a cube with a specified size
	 * @param width
	 * The width of the cube
	 * @param height
	 * The height of the cube
	 * @param length
	 * The length of the cube
	 */
	@SuppressWarnings("unchecked")
	public Cube(int width, int height, int length){
		verifySize(width, height, length);
		this.width = width;
		this.height = height;
		this.length = length;
		values = (T[][][]) new Object[width][height][length];
	}
	/**
	 * Constructor for creating a cube with a specified size
	 * @param size
	 * The width, height, and length of the cube
	 */
	public Cube(int size){
		this(size, size, size);
	}
	/**
	 * Gets a value at a specified location
	 * @param x
	 * The location on the x axis
	 * @param y
	 * The location on the y axis
	 * @param z
	 * The location on the z axis
	 * @return
	 * The value at said location
	 */
	public T get(int x, int y, int z){
		return values[x][y][z];
	}
	/**
	 * Sets a value at a specified location
	 * @param loc
	 * The location in vector form
	 * @param val
	 * The value to set of type T
	 */
	public void set(Vector3 loc, T val){
		values[(int) loc.x][(int) loc.y][(int) loc.z] = val;
	}
	/**
	 * Gets a value at a specified location
	 * @param loc
	 * The location in vector form
	 * @return
	 * The value at said location
	 */
	public T get(Vector3 loc){
		return values[(int) loc.x][(int) loc.y][(int) loc.z];
	}
	/**
	 * Sets a value at a specified location
	 * @param x
	 * The location on the x axis
	 * @param y
	 * The location on the y axis
	 * @param z
	 * The location on the z axis
	 * @param val
	 * The value to set of type T
	 */
	public void set(int x, int y, int z,T val){
		values[x][y][z] = val;
	}
	/**
	 * Sets every value in the cube to null
	 */
	public void clear(){
		for(int x = 0; x < width; x++) 
			for(int y = 0; y < height; y++)
				for(int z = 0; z < length; z++) values[x][y][z] = null;
	}
	/**
	 * Resizes the cube and <bold>keeps all data possible</bold>
	 * @param newWidth
	 * The new width of the cube
	 * @param newHeight
	 * The new height of the cube
	 * @param newLength
	 * The new length of the cube
	 */
	public void resize(int newWidth, int newHeight, int newLength){
		verifySize(newWidth, newHeight, newLength);
		@SuppressWarnings("unchecked")
		T[][][] newValues = (T[][][]) new Object[newWidth][newHeight][newLength];
		for(int x = 0; x < newWidth; x++){
			if(x >= width) break;
			for(int y = 0; y < newHeight; y++){
				if(y >= height) break;
				for(int z = 0; z < newLength; z++){
					if(z >= length) break;
					newValues[x][y][z] = values[x][y][z];
				}
			}
		}
		this.width = newWidth;
		this.height = newHeight;
		this.length = newLength;
		values = newValues;
	}
	/**
	 * Resizes the cube and <bold>keeps all data possible</bold>
	 * @param size
	 * The new size in vector form
	 */
	public void resize(Vector3 size){
		resize((int) size.x, (int) size.y, (int) size.z);
	}
	/**
	 * Returns the width of the cube
	 * @return
	 * The width
	 */
	public int getWidth(){
		return width;
	}
	/**
	 * Returns the height of the cube
	 * @return
	 * The height
	 */
	public int getHeight(){
		return height;
	}
	/**
	 * Returns the length of the cube
	 * @return
	 * The length
	 */
	public int getLength(){
		return length;
	}
	/**
	 * Returns the size of the cube as a Vector3
	 * @return
	 * The size
	 */
	public Vector3 getSize(){
		return new Vector3(getWidth(), getHeight(), getLength());
	}
	/**
	 * Resizes the cube and <bold>keeps all data possible</bold>
	 * @param size
	 * The new width and height of the cube
	 */
	public void resize(int size){
		resize(size, size, size);
	}
	/**
	 * Sets the internal values array
	 * @param values
	 * The new values array
	 */
	public void setFromArray(T[][][] values){
		this.values = values;
	}
	/**
	 * Returns the internal values array
	 * @return
	 * The internal values array
	 */
	public T[][][] toMultidimensionalArray(){
		return values;
	}
	/**
	 * Returns the cube as a single dimension array
	 * @return
	 * The single dimension array
	 */
	public Object[] toArray(){
		Object[] values = new Object[width * height * length];
		int iterator = 0;
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				for(int z = 0; z < length; z++){
					values[iterator] = this.values[x][y];
					iterator++;
				}
			}
		}
		return values;
	}
	/**
	 * Tells you if the arrays width, height, and length are equal
	 * @return
	 * Returns true if width == height == length
	 */
	public boolean isPerfectCube(){
		return width == height && width == length;
	}
	/**
	 * Method for verifying a new size
	 * @param width
	 * The width
	 * @param height
	 * The height
	 */
	public static void verifySize(int width, int height, int length){
		if(width <= 0 || height <= 0 || length <= 0) throw new ArrayIndexOutOfBoundsException("Invalid size: " + width + "x" + height + "x" + length);
	}
	/**
	 * Returns the area or amount of elements in the cube
	 * @return
	 */
	public int elements(){
		return getWidth() * getHeight() * getLength();
	}
}
