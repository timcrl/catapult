/**
 * Mathematical method creating a point of coordinates x and y
 * @author Chetanveer
 *
 */
public class APoint {
    
    public double x, y;
    /**
     * Constructor attributing the values
     * @param ax
     * @param ay
     */
    public APoint(double ax, double ay){
        x = ax;
        y = ay;
    }
    /**
     * Compute the distance between two APoint 
     * @param otherPoint
     * @return
     */
    public double distance( APoint otherPoint ) {
        double dx = x - otherPoint.x;
        double dy = y - otherPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    /**
     * Pythagorean method to compute distance between APoint and 2 coordinates values
     * @param x1
     * @param y1
     * @return distance
     */
	public double getDistance (double x1, double y1) {
		double xDist = x1-this.x;
		double yDist = y1-this.y;
		
		return Math.sqrt((Math.pow(xDist, 2)+Math.pow(yDist, 2)));
	}
    /**
     * To tell its coordinates
     */
    public String toString() {
        return  "[x=" + x + ",y=" + y + "]";
    }    
    
}
