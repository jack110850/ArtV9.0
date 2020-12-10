package tw.group4._35_.routePlanning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tw.group4.util.IdentityFilter;

@Controller
public class RoutePlanningEntry {

	@GetMapping(value = "/35/routePlanningEntry")
	public String routePlanningEntry() {
		
		return IdentityFilter.loginID + "35/routePlanning/allRoutes";
	}
}
