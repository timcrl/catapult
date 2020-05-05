
public class APoint {
    
    public double x, y;
    
    public APoint(double ax, double ay){
        x = ax;
        y = ay;
    }
            
    public double distance( APoint otherPoint ) {
        double dx = x - otherPoint.x;
        double dy = y - otherPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
	public double getDistance (double x1, double y1) {
		double xDist = x1-this.x;
		double yDist = y1-this.y;

		return Math.sqrt((Math.pow(xDist, 2)+Math.pow(yDist, 2)));
	}
    
    public String toString() {
        return  "[x=" + x + ",y=" + y + "]";
    }    
    
}
