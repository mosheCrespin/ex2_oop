package gameClient.util;
/**
 * This class represents a simple 1D range of shape [min,max]
 * @author boaz_benmoshe
 *
 */
public class Range {
	private double _min, _max;
	public Range(double min, double max) {
		set_min(min);
		set_max(max);
	}

	/**
	 *this method get Range x and update set_min and set_max  by calling Range method in line 9.
	 * @param x
	 */
	public Range(Range x) {
		this(x._min, x._max);
	}

	/**
	 * this method get a number and return true if the number is in the Range between the variables of this
	 * class (_min, _max),else return false.
	 * @param d
	 * @return
	 */
	public boolean isIn(double d) {
		boolean inSide = false;
		if(d>=this.get_min() && d<=this.get_max()) {inSide=true;}
		return inSide;
	}

	/**
	 * this method return a String if the isEmpty() method is true this method return "Empty Range"
	 * else return a String with _min and _max
	 * @return
	 */
	public String toString() {
		String ans = "["+this.get_min()+","+this.get_max()+"]";
		if(this.isEmpty()) {ans = "Empty Range";}
		return ans;
	}

	/**
	 * this method check if the _min variable bigger than _max if so return true .else false.
	 * @return
	 */
	public boolean isEmpty() {
		return this.get_min()>this.get_max();
	}
	public double get_max() {
		return _max;
	}
	public double get_length() {
		return _max-_min;
	}

	private void set_max(double _max) {
		this._max = _max;
	}
	public double get_min() {
		return _min;
	}
	private void set_min(double _min) {
		this._min = _min;
	}
	public double getPortion(double d) {
		double d1 = d-_min;
		double ans = d1/get_length();
		return ans;
	}
	public double fromPortion(double p) {
		return _min+p* get_length();
	}
}