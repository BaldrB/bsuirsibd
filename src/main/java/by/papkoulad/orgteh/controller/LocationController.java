package by.papkoulad.orgteh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.papkoulad.orgteh.models.Location;
import by.papkoulad.orgteh.repo.LocationRepository;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
	String getLocation(Model model) {
		Iterable<Location> location = locationRepository.findAll();
        model.addAttribute("location", location);
		return "location";
	}

	@PostMapping("addlocation")
    public String addLocation(@RequestParam String locationname, Model model) 
    {
        Iterable<Location> location;

        Location locations = new Location(locationname);
        locationRepository.save(locations);

        location = locationRepository.findAll();
        model.addAttribute("location", location);

        return "redirect:/location";
    }


    
}
