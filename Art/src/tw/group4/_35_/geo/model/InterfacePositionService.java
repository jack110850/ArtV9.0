package tw.group4._35_.geo.model;

import java.util.List;
import java.util.Map;

public interface InterfacePositionService {

	List<Position> getPositionBean();

	List<Position> getNoNullPositionBean();
	
	Map<String, Double> getUserCoords(String userLocation);

	Double getDistance(Double lat1, Double lon1, Double lat2, Double lon2);

	List<Position> setDistance(String userLocation);
	
	List<Position> selectNearActs(String userLocation);
	
	List<Position> selectNearActsByDistance(String userLocation, String userDistance);

//	List<Activity> selectDistinctToAct();

	List<Position> recommendList();

	int[] produceRandomArray(int count);

}