package tn.esprit.spring.entities;

import java.util.HashMap;

public class MapsCoordonnees {

	private HashMap<City,CoordonneeCity>map  = new HashMap<>();
	
	
	public MapsCoordonnees(){
		this.map.put(City.Ariana, new CoordonneeCity(36.8689216,10.1353404));
		this.map.put(City.BenArous, new CoordonneeCity(36.7465169,10.2171373));
		this.map.put(City.Bizerte, new CoordonneeCity(37.2811363,9.8264848));
		this.map.put(City.Béja, new CoordonneeCity(36.729743,9.1700926));
		this.map.put(City.ElKef, new CoordonneeCity(36.1668945,8.6848115));
		this.map.put(City.Gabés, new CoordonneeCity(33.8893134,10.0851486));	
		this.map.put(City.Sousse, new CoordonneeCity(35.8283991,10.5830349));	
	}


	public HashMap<City, CoordonneeCity> getMap() {
		return map;
	}


	public void setMap(HashMap<City, CoordonneeCity> map) {
		this.map = map;
	}
	
	
	
}
