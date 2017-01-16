package net.net16.jeremiahlowe.bettercollections;

import net.net16.jeremiahlowe.bettercollections.vector.Vector2;

/**
 * Grid for holding values of a specified type
 * @author 
 * Jeremiah Lowe
 * @param <T>
 * T is the type for each cell of grid
 */
public class Grid<T>{
	private int width, height;
	private T[][] values;
	
	/**
	 * Constructor for creating a Grid with a specified size
	 * @param width
	 * The width of the grid
	 * @param height
	 * The height of the grid
	 */
	@SuppressWarnings("unchecked")
	public Grid(int width, int height){
		verifySize(width, height);
		this.width = width;
		this.height = height;
		values = (T[][]) new Object[width][height];
	}
	/**
	 * Constructor for creating a grid with a specified size
	 * @param size
	 * The width AND height of the grid
	 */
	public Grid(int size){
		this(size, size);
	}
	/**
	 * Gets a value at a specified location
	 * @param x
	 * The location on the x axis
	 * @param y
	 * The location on the y axis
	 * @return
	 * The value at said location
	 */
	public T get(int x, int y){
		return values[x][y];
	}
	/**
	 * Sets a value at a specified location
	 * @param loc
	 * The location in vector form
	 * @param val
	 * The value to set of type T
	 */
	public void set(Vector2 loc, T val){
		values[(int) loc.x][(int) loc.y] = val;
	}
	/**
	 * Gets a value at a specified location
	 * @param loc
	 * The location in vector form
	 * @return
	 * The value at said location
	 */
	public T get(Vector2 loc){
		return values[(int) loc.x][(int) loc.y];
	}
	/**
	 * Sets a value at a specified location
	 * @param x
	 * The location on the x axis
	 * @param y
	 * The location on the y axis
	 * @param val
	 * The value to set of type T
	 */
	public void set(int x, int y, T val){
		values[x][y] = val;
	}
	/**
	 * Sets every value in the grid to null
	 */
	public void clear(){
		for(int x = 0; x < width; x++) 
			for(int y = 0; y < height; y++) values[x][y] = null;
	}
	/**
	 * Resizes the grid and <bold>keeps all data possible</bold>
	 * @param newWidth
	 * The new width of the grid
	 * @param newHeight
	 * The new height of the grid
	 */
	public void resize(int newWidth, int newHeight){
		verifySize(newWidth, newHeight);
		@SuppressWarnings("unchecked")
		T[][] newValues = (T[][]) new Object[newWidth][newHeight];
		for(int x = 0; x < newWidth; x++){
			if(x >= width) break;
			for(int y = 0; y < newHeight; y++){
				if(y >= height) break;
				newValues[x][y] = values[x][y];
			}
		}
		this.width = newWidth;
		this.height = newHeight;
		values = newValues;
	}
	/**
	 * Resizes the grid and <bold>keeps all data possible</bold>
	 * @param size
	 * The new size in vector form
	 */
	public void resize(Vector2 size){
		resize((int) size.x, (int) size.y);
	}
	/**
	 * Returns the width of the grid
	 * @return
	 * The width
	 */
	public int getWidth(){
		return width;
	}
	/**
	 * Returns the height of the grid
	 * @return
	 * The height
	 */
	public int getHeight(){
		return height;
	}
	/**
	 * Returns the size of the grid as a Vector2
	 * @return
	 * The size
	 */
	public Vector2 getSize(){
		return new Vector2(getWidth(), getHeight());
	}
	/**
	 * Resizes the grid and <bold>keeps all data possible</bold>
	 * @param size
	 * The new width and height of the grid
	 */
	public void resize(int size){
		resize(size, size);
	}
	/**
	 * Gets the contents of the grid as a string
	 * @return
	 */
	public String getContentsAsString(){
		String out = "";
		for(int x = 0; x < width; x++){
			String tmp = "";
			for(int y = 0; y < height; y++) tmp += values[x][y] + ((y == height - 1) ? "" : ", ");
			out += tmp + '\n';
		}
		return out.trim();
	}
	/**
	 * Sets the internal values array
	 * @param values
	 * The new values array
	 */
	public void setFromArray(T[][] values){
		this.values = values;
	}
	/**
	 * Returns the internal values array
	 * @return
	 * The internal values array
	 */
	public T[][] toMultidimensionalArray(){
		return values;
	}
	/**
	 * Returns the grid as a single dimension array
	 * @return
	 * The single dimension array
	 */
	public Object[] toArray(){
		Object[] values = new Object[width * height];
		int iterator = 0;
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				values[iterator] = this.values[x][y];
				iterator++;
			}
		}
		return values;
	}
	/**
	 * Gets a row from the array
	 * @param y
	 * The y value of the row
	 * @return
	 * The row at the specified y value
	 */
	public T[] getRow(int y){
		if(y >= height) throw new ArrayIndexOutOfBoundsException("Invalid row " + y);
		return values[y];
	}
	/**
	 * Tells you if the arrays width and height are equal
	 * @return
	 * Returns true if width == height
	 */
	public boolean isPerfectSquare(){
		return width == height;
	}
	/**
	 * Method for verifying a new size
	 * @param width
	 * The width
	 * @param height
	 * The height
	 */
	public static void verifySize(int width, int height){
		if(width <= 0 || height <= 0) throw new ArrayIndexOutOfBoundsException("Invalid size: " + width + "x" + height);
	}
	/**
	 * Returns the area or amount of elements in the grid
	 * @return
	 */
	public int elements(){
		return getWidth() * getHeight();
	}
}