package gameClient.util;
import api.geo_location;

/**
 * This class represents a 2D Range, composed from two 1D Ranges.
 */
public class Range2D {
	private Range _y_range;
	private Range _x_range;

	/**
	 * constructor for this class that get Range x and Range y this method update the _min, _max
	 * for x and also for y.
	 * @param x
	 * @param y
	 */
	public Range2D(Range x, Range y) {
		_x_range = new Range(x);
		_y_range = new Range(y);
	}

	/**
	 * this method get Range2D and update the variables of this class _x_range and _y_range.
	 * @param w
	 */
	public Range2D(Range2D w) {
		_x_range = new Range(w._x_range);
		_y_range = new Range(w._y_range);
	}


	public Point3D getPortion(geo_location p) {
		double x = _x_range.getPortion(p.x());
		double y = _y_range.getPortion(p.y());
		return new Point3D(x,y,0);
	}


	public Point3D fromPortion(geo_location p) {
		double x = _x_range.fromPortion(p.x());
		double y = _y_range.fromPortion(p.y());
		return new Point3D(x,y,0);
	}
}