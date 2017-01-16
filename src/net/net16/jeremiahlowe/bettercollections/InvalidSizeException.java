package net.net16.jeremiahlowe.bettercollections;

public class InvalidSizeException extends RuntimeException{
	public InvalidSizeException(int size){
		super("Invalid size " + size);
	}
}
