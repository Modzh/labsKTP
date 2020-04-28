package lab3;

/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    /**
     * checks transferred object instance of Location
     * then checks both xCoord and yCoord with "=="
     * @param object to compare with
     * @return false if object is not instance of Location.class
     * or if this.xCoord/yCoord is different from object.xCoord/yCoord]
     * otherwise true;
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Location)) return false;
        return ((Location) object).xCoord == this.xCoord
                && ((Location) object).yCoord == this.yCoord;
    }

    /**
     * since we need to get the same hashcode for points with equal coordinates,
     * hashcode calculation is based on both X and Y;
     * 1000x multiplier added to decrease amount of collisions
     * within cases like (2;0) vs (1;1)
     * this would improve speed for map sizes up to 1000*1000
     * after that the f(size), where f() is speed will slowly drop from
     * O(1) as for hashmap to O(n) as for LinkedList
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return 1000 * xCoord + yCoord;
    }
}