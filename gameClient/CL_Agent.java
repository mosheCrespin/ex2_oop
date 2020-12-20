package gameClient;

import api.directed_weighted_graph;
import api.edge_data;
import api.geo_location;
import api.node_data;
import gameClient.util.Point3D;
import org.json.JSONObject;

import java.util.Iterator;


public class CL_Agent {
		private int _id;
		private geo_location _pos;
		private double _speed;
		private edge_data _curr_edge;
		private node_data _curr_node;
		private directed_weighted_graph _gg;
		private CL_Pokemon _curr_fruit;
		private double _value;
		private int dest;


	/**
	 * This constructor get graph and agent's start node.the method update the agent to the start node.
	 * @param g
	 * @param start_node
	 */
		public CL_Agent(directed_weighted_graph g, int start_node) {
			_gg = g;
			setMoney(0);
			this._curr_node = _gg.getNode(start_node);
			_pos = _curr_node.getLocation();
			_id = -1;
			setSpeed(0);
			this.dest=-1;

		}

	/**
	 * this method get json String and update the agents data like id,speed,pos,src,dest and value.
	 * @param json
	 */
		public void update(String json) {
			JSONObject line;
			try {
				line = new JSONObject(json);
				JSONObject ttt = line.getJSONObject("Agent");
				int id = ttt.getInt("id");
				if(id==this.getID() || this.getID() == -1) {
					if(this.getID() == -1) {_id = id;}
					double speed = ttt.getDouble("speed");
					String p = ttt.getString("pos");
					Point3D pp = new Point3D(p);
					int src = ttt.getInt("src");
					int dest = ttt.getInt("dest");
					double value = ttt.getDouble("value");
					this._pos = pp;
					this.setCurrNode(src);
					this.setSpeed(speed);
					this.setMoney(value);
					if(dest!=this.dest&&dest!=-1) {
						System.out.println("agent: " + this._id +  " moved from: " +src + " to: " +dest);
					}
					this.dest = dest;

				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	//@Override
		public int getSrcNode() {return this._curr_node.getKey();}
		public String toJSON() {
			int d = this.getDest();
			String ans = "{\"Agent\":{"
					+ "\"id\":"+this._id+","
					+ "\"value\":"+this._value+","
					+ "\"src\":"+this._curr_node.getKey()+","
					+ "\"dest\":"+d+","
					+ "\"speed\":"+this.getSpeed()+","
					+ "\"pos\":\""+_pos.toString()+"\""
					+ "}"
					+ "}";
			return ans;	
		}
		private void setMoney(double v) {_value = v;}

		public void setCurrNode(int src) {
			this._curr_node = _gg.getNode(src);
		}
		public int getDest(){return this.dest;}

		public String toString() {
			String ans=""+this.getID()+","+dest +", "+","+this.getValue();
			return ans;
		}
		public int getID() {
			return this._id;
		}
	
		public geo_location getLocation() {
			return _pos;
		}


		public double getValue() {
			return this._value;
		}
		public double getSpeed() {
			return this._speed;
		}

		public void setSpeed(double v) {
			this._speed = v;
		}
		public CL_Pokemon get_curr_fruit() {
			return _curr_fruit;
		}
		public void set_curr_fruit(CL_Pokemon curr_fruit) {
			this._curr_fruit = curr_fruit;
		}
	}
