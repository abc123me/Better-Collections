package net.net16.jeremiahlowe.bettercollections;

/**
 * A general class for extra Math utilities
 * @author Jeremiah Lowe
 *
 */
public final class MathUtility {
	/**
	 * Maps a value between a min and max to a newMin and newMax
	 * @param val
	 * @param min
	 * @param max
	 * @param newMin
	 * @param newMax
	 * @return the new (mapped) value
	 */
	public final static double map(double val, double min, double max, double newMin, double newMax){
		return ((newMax - newMin) * (val - min)) / (max - min) - newMin;
	}
	/**
	 * Maps a value between a min and max to a newMin and newMax
	 * @param val
	 * @param min
	 * @param max
	 * @param newMin
	 * @param newMax
	 * @return the new (mapped) value
	 */
	public final static float map(float val, float min, float max, float newMin, float newMax){
		return ((newMax - newMin) * (val - min)) / (max - min) - newMin;
	}
	/**
	 * Maps a value between a min and max to a newMin and newMax
	 * @param val
	 * @param min
	 * @param max
	 * @param newMin
	 * @param newMax
	 * @return the new (mapped) value
	 */
	public final static int map(int val, int min, int max, int newMin, int newMax){
		return ((newMax - newMin) * (val - min)) / (max - min) - newMin;
	}
	/**
	 * Maps a value between a min and max to a newMin and newMax
	 * @param val
	 * @param min
	 * @param max
	 * @param newMin
	 * @param newMax
	 * @return the new (mapped) value
	 */
	public final static long map(long val, long min, long max, long newMin, long newMax){
		return ((newMax - newMin) * (val - min)) / (max - min) - newMin;
	}
	/**
	 * Checks if a number is between a min and max
	 * @param val
	 * @param min
	 * @param max
	 * @return
	 */
	public final static boolean isBetween(double val, double min, double max){
		return val > min && val < max;
	}
	/**
	 * Checks if a number is between or equal to a min and max
	 * @param val
	 * @param min
	 * @param max
	 * @return
	 */
	public final static boolean isBetweenOrEqual(double val, double min, double max){
		return val >= min && val <= max;
	}
	/**
	 * Clamps a value to a min and max
	 * If it is over the max returns max, otherwise if it is under the min returns the min, else it will return the value
	 * @param val
	 * @param min
	 * @param max
	 * @return
	 */
	public final static double clamp(double val, double min, double max){
		if(val < min) return min;
		if(val > max) return max;
		return val;
	}
	/**
	 * Clamps a value to a min and max
	 * If it is over the max returns max, otherwise if it is under the min returns the min, else it will return the value
	 * @param val
	 * @param min
	 * @param max
	 * @return
	 */
	public final static int clamp(int val, int min, int max){
		if(val < min) return min;
		if(val > max) return max;
		return val;
	}
	/**
	 * Clamps a value to a min and max
	 * If it is over the max returns max, otherwise if it is under the min returns the min, else it will return the value
	 * @param val
	 * @param min
	 * @param max
	 * @return
	 */
	public final static long clamp(long val, long min, long max){
		if(val < min) return min;
		if(val > max) return max;
		return val;
	}
	/**
	 * Clamps a value to a min and max
	 * If it is over the max returns max, otherwise if it is under the min returns the min, else it will return the value
	 * @param val
	 * @param min
	 * @param max
	 * @return
	 */
	public final static float clamp(float val, float min, float max){
		if(val < min) return min;
		if(val > max) return max;
		return val;
	}
	/**
	 * Clamps a value between 1 and 0
	 * If it is over 1 returns 1, otherwise if it is under 0 returns 0, else it will return the value
	 * @param val
	 * @param min
	 * @param max
	 * @return
	 */
	public final static double clamp01(double val){return clamp(val, 0d, 1d);}
	/**
	 * Clamps a value between 1 and 0
	 * If it is over 1 returns 1, otherwise if it is under 0 returns 0, else it will return the value
	 * @param val
	 * @param min
	 * @param max
	 * @return
	 */
	public final static int clamp01(int val){return clamp(val, 0, 1);}
	/**
	 * Clamps a value between 1 and 0
	 * If it is over 1 returns 1, otherwise if it is under 0 returns 0, else it will return the value
	 * @param val
	 * @param min
	 * @param max
	 * @return
	 */
	public final static long clamp01(long val){return clamp(val, 0l, 1l);}
	/**
	 * Clamps a value between 1 and 0
	 * If it is over 1 returns 1, otherwise if it is under 0 returns 0, else it will return the value
	 * @param val
	 * @param min
	 * @param max
	 * @return
	 */
	public final static float clamp01(float val){return clamp(val, 0f, 1f);}
}
