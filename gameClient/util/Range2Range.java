package gameClient.util;

import api.geo_location;

/**
 * This class represents a simple world 2 frame conversion (both ways).
 * @author boaz.benmoshe
 *
 */

public class Range2Range {
	private Range2D _world, _frame;

	/**
	 * this method get Range2D w and f ,he update _world and _frame.
	 * @param w
	 * @param f
	 */
	public Range2Range(Range2D w, Range2D f) {
		_world = new Range2D(w);
		_frame = new Range2D(f);
	}

	/**
	 * this method get geo_location point and change this point from 2D to 3D.this method also return
	 * this point 3d.
	 * @param p
	 * @return
	 */
	public geo_location world2frame(geo_location p) {
		Point3D d = _world.getPortion(p);
		Point3D ans = _frame.fromPortion(d);
		return ans;
	}

	/**
	 * this method return _world in 2D
	 * @return
	 */
	public Range2D getWorld() {
		return _world;
	}

	/**
	 * this method return _frame in 2D.
	 * @return
	 */
	public Range2D getFrame() {
		return _frame;
	}
}