/**
 * This class represents a 3D point in space.
 */
package gameClient.util;

import api.geo_location;

import java.io.Serializable;

public class Point3D implements geo_location, Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * Simple set of constants - should be defined in a different class (say class Constants).*/
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    /**
     * This field represents the origin point:[0,0,0]
     */
    public static final Point3D ORIGIN = new Point3D(0,0,0);
    private double _x,_y,_z;

    /**
     * constructor that get 3 double numbers and update the variable of this class.
     * @param x
     * @param y
     * @param z
     */
    public Point3D(double x, double y, double z) {
        _x=x;
        _y=y;
        _z=z;
    }

    /**
     *this method get point in 3D and update this point .
     * @param p
     */
    public Point3D(Point3D p) {
        this(p.x(), p.y(), p.z());
    }

    /**
     * this method get x and y and update the point in point 3D.
     * @param x
     * @param y
     */
    public Point3D(double x, double y) {this(x,y,0);}

    /**
     * this method get a String and split the string to array,and from the array to variable  _x, _y and _z
     * @param s
     */
    public Point3D(String s) { try {
        String[] a = s.split(",");
        _x = Double.parseDouble(a[0]);
        _y = Double.parseDouble(a[1]);
        _z = Double.parseDouble(a[2]);
    }
    catch(IllegalArgumentException e) {
        System.err.println("ERR: got wrong format string for Point3D init, got:"+s+"  should be of format: x,y,x");
        throw(e);
    }
    }
    @Override
    public double x() {return _x;}
    @Override
    public double y() {return _y;}
    @Override
    public double z() {return _z;}


    public String toString() { return _x+","+_y+","+_z; }

    /**
     * this method get geo_location point, calculate and return the distance between this point location to the variable location
     * the class hold  (_x,_y and _z).
     * @param p2
     * @return
     */
    @Override
    public double distance(geo_location p2) {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double dz = this.z() - p2.z();
        double t = (dx*dx+dy*dy+dz*dz);
        return Math.sqrt(t);
    }

    /**
     * this method get object and check if the object's location is equal to the  variable _x, _y and _z ,if so return true
     * else return false.
     * @param p
     * @return
     */

    public boolean equals(Object p) {
        if(p==null || !(p instanceof geo_location)) {return false;}
        Point3D p2 = (Point3D)p;
        return ( (_x==p2._x) && (_y==p2._y) && (_z==p2._z) );
    }

    /**
     * this method get boolean and print the variable _x, _y and _z ,if the boolean the method get is true print the variable
     * in double else print it in int.
     * @param all
     * @return
     */
    public String toString(boolean all) {
        if(all) return "[" + _x + "," +_y+","+_z+"]";
        else return "[" + (int)_x + "," + (int)_y+","+(int)_z+"]";
    }
}