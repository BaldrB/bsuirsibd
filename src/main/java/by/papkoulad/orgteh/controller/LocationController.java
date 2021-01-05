package by.papkoulad.orgteh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.papkoulad.orgteh.models.Location;
import by.papkoulad.orgteh.repo.LocationRepository;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
	String get(Model model) {
		Iterable<Location> location = locationRepository.findAll();
        model.addAttribute("location", location);
		return "location";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
    public String create(@RequestParam String locationname, Model model) 
    {
        Iterable<Location> location;

        Location locations = new Location(locationname);
        locationRepository.save(locations);

        location = locationRepository.findAll();
        model.addAttribute("location", location);

        return "redirect:/location";
    }
    
    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String edit(
    @RequestParam String locationname, @Param("id") Integer id) 
    {
        Location location = locationRepository.findById(id).isPresent() ? locationRepository.findById(id).get() : null;
        location.setLocationname(locationname);
        locationRepository.save(location);

        System.out.println("edit");

        return "redirect:/location";
    }

    @RequestMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {

        locationRepository.deleteById(id);

		return "redirect:/location";
	}


    
}
