package net.net16.jeremiahlowe.bettercollections;

public final class MathUtility {
	public final static double map(double val, double min, double max, double newMin, double newMax){
		return ((newMax - newMin) * (val - min)) / (max - min) - newMin;
	}
	public final static float map(float val, float min, float max, float newMin, float newMax){
		return ((newMax - newMin) * (val - min)) / (max - min) - newMin;
	}
	public final static int map(int val, int min, int max, int newMin, int newMax){
		return ((newMax - newMin) * (val - min)) / (max - min) - newMin;
	}
	public final static long map(long val, long min, long max, long newMin, long newMax){
		return ((newMax - newMin) * (val - min)) / (max - min) - newMin;
	}
	public final static boolean isBetween(double val, double min, double max){
		return val > min && val < max;
	}
	public final static boolean isBetweenOrEqual(double val, double min, double max){
		return val >= min && val <= max;
	}
	public final static double clamp(double val, double min, double max){
		if(val < min) return min;
		if(val > max) return max;
		return val;
	}
	public final static int clamp(int val, int min, int max){
		if(val < min) return min;
		if(val > max) return max;
		return val;
	}
	public final static long clamp(long val, long min, long max){
		if(val < min) return min;
		if(val > max) return max;
		return val;
	}
	public final static float clamp(float val, float min, float max){
		if(val < min) return min;
		if(val > max) return max;
		return val;
	}
	public final static double clamp01(double val){return clamp(val, 0d, 1d);}
	public final static int clamp01(int val){return clamp(val, 0, 1);}
	public final static long clamp01(long val){return clamp(val, 0l, 1l);}
	public final static float clamp01(float val){return clamp(val, 0f, 1f);}
}
