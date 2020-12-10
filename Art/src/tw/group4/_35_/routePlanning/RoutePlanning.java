package tw.group4._35_.routePlanning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.group4._35_.geo.model.Position;
import tw.group4._35_.geo.model.PositionService;

@RestController
public class RoutePlanning {
	
	@Autowired
	PositionService service;
	
	@PostMapping(value = "/35/routePlanning.ctrl")
	public Map<String, String> routePlanningPost(@RequestBody String str){
		System.out.println("post連上線了");
		return null;
	}
	
	@GetMapping(value = "/35/routePlanning/{userLocation}/{userDistance}"+".ctrl")
	public Map<String, Object> routePlanningGetAll(@PathVariable String userLocation, @PathVariable String userDistance){

		Map<String, Double> userCoords = service.getUserCoords(userLocation);
		List<Position> list = service.selectNearActsByDistance(userLocation, userDistance);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userCoords", userCoords);
		map.put("nearActs", list);
		
		return map;
	}
}
