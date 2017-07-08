package net.net16.jeremiahlowe.bettercollections;

import net.net16.jeremiahlowe.bettercollections.vector.Vector2;

/**
 * A line object for doing line things!
 * @author Jeremiah Lowe
 *
 */
public class Line implements Cloneable{
	private Vector2 startPoint, endPoint;
	private Line(){}
	public Line(Vector2 startPoint, Vector2 endPoint){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	public static Line createYIntercept(float slope, float yIntercept){
		Line l = new Line();
		l.startPoint = new Vector2(0, yIntercept);
		l.endPoint = new Vector2(1, slope + yIntercept);
		return l;
	}
	public static Line createXIntercept(float slope, float xIntercept){
		Line l = new Line();
		l.startPoint = new Vector2(xIntercept, 0);
		l.endPoint = new Vector2(slope + xIntercept, 1);
		return l;
	}
	public Vector2 getStart(){return startPoint;}
	public Vector2 getEnd(){return endPoint;}
	public void setStart(Vector2 startPoint) {this.startPoint = startPoint;}
	public void setEnd(Vector2 endPoint) {this.endPoint = endPoint;}
	public float getStartX(){return startPoint.x;}
	public float getStartY(){return startPoint.y;}
	public void setStartX(float x){startPoint.x = x;}
	public void setStartY(float y){startPoint.y = y;}
	public float getEndX(){return endPoint.x;}
	public float getEndY(){return endPoint.y;}
	public void setEndX(float x){endPoint.x = x;}
	public void setEndY(float y){endPoint.y = y;}
	public float getRun(){return endPoint.x - startPoint.x;}	
	public float getRise(){return endPoint.y - startPoint.y;}
	public Vector2 getDirection(){return new Vector2(getRun(), getRise());}
	public float getSlope(){return getRise() / getRun();}
	public float getSlopeInf(){
		float rise = getRise(), run = getRun();
		if(run != 0) return rise / run;
		else if(rise == 0) return 0;
		else if(rise < 0) return Float.NEGATIVE_INFINITY;
		else return Float.POSITIVE_INFINITY;
	}
	public float getYIntercept(){
		return startPoint.y - getSlopeInf() * startPoint.x;
	}
	public float getXIntercept(){
		return startPoint.x - getSlopeInf() * startPoint.y;
	}
	public float interpolateX(float y){
		return getSlopeInf() * y + getXIntercept();
	}
	public float interpolateY(float x){
		return getSlopeInf() * x + getYIntercept();
	}
	public void setRise(float rise){
		endPoint = startPoint.clone();
		endPoint.translate(0, rise);
	}
	public void setRun(float run){
		endPoint = startPoint.clone();
		endPoint.translate(run, 0);
	}
	public void setDirection(Vector2 dir){
		endPoint = startPoint.clone();
		endPoint.translate(dir);
	}
	public void setDirection(float x, float y){
		endPoint = startPoint.clone();
		endPoint.translate(x, y);
	}
	public void translate(float x, float y){
		endPoint.translate(x, y);
		startPoint.translate(x, y);
	}
	public void reflectX(){endPoint.x = -endPoint.x;}
	public void reflectY(){endPoint.y = -endPoint.y;}
	public void setRotation(Rotation r){
		endPoint = startPoint.clone();
		endPoint.translate(r.toDirection());
	}
	public Rotation getRotation(){
		Rotation r = new Rotation();
		r.setAngleRadians((float) atan2());
		return r;
	}
	public double atan2(){
		float x = getEndX() - getStartX();
		float y = getEndY() - getStartY();
		return Math.atan2(y, x);
	}
	public boolean sameAs(Line l){
		return l.getSlope() == getSlope();
	}
	public boolean isBetweeen(Line a, Line b){
		float x = endPoint.x, y = endPoint.y;
		float ay = a.interpolateY(x), by = b.interpolateY(x);
		float max = Math.max(ay, by), min = Math.min(ay, by);
		return MathUtility.isBetween(y, min, max);
	}
	public boolean isBetweeenOrEqualTo(Line a, Line b){
		float ay = a.interpolateY(endPoint.x), by = b.interpolateY(endPoint.x);
		float max = Math.max(ay, by), min = Math.min(ay, by);
		return MathUtility.isBetweenOrEqual(endPoint.y, min, max);
	}
	
	@Override
	public Line clone(){
		Line l = new Line();
		l.startPoint = startPoint.clone();
		l.endPoint = endPoint.clone();
		return l;
	}
}
