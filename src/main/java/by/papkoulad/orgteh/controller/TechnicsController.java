package by.papkoulad.orgteh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import by.papkoulad.orgteh.models.NameTech;
import by.papkoulad.orgteh.models.Status;
import by.papkoulad.orgteh.models.Technics;
import by.papkoulad.orgteh.models.UserTech;
import by.papkoulad.orgteh.models.Location;
import by.papkoulad.orgteh.repo.LocationRepository;
import by.papkoulad.orgteh.repo.NameTechRepository;
import by.papkoulad.orgteh.repo.StatusRepository;
import by.papkoulad.orgteh.repo.TechnicsRepository;
import by.papkoulad.orgteh.repo.UserTechRepository;

@Controller
@RequestMapping("/technics")
public class TechnicsController {

    @Autowired
    TechnicsRepository technicsRepository;

    @Autowired
    NameTechRepository nameTechRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserTechRepository userTechRepository;

    @GetMapping
	String get(Model model) {
        Iterable<Technics> technics = technicsRepository.findAll();
        model.addAttribute("technics", technics);

        Iterable<NameTech> nameTech = nameTechRepository.findAll();
        model.addAttribute("nametechs", nameTech);

        Iterable<Status> status = statusRepository.findAll();
        model.addAttribute("statuss", status);

        Iterable<Location> location = locationRepository.findAll();
        model.addAttribute("locations", location);

        Iterable<UserTech> userTech = userTechRepository.findAll();
        model.addAttribute("usertechs", userTech);

		return "technics";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String create(@RequestParam String serial, @RequestParam Integer inventory,  
    @RequestParam Integer nametechId, @RequestParam Integer statusId, @RequestParam Integer usertechId,
    @RequestParam Integer locationId) {

        NameTech nameTech = nameTechRepository.findById(nametechId).isPresent() ? nameTechRepository.findById(nametechId).get() : null;
        Status status = statusRepository.findById(statusId).isPresent() ? statusRepository.findById(statusId).get() : null;
        Location location = locationRepository.findById(locationId).isPresent() ? locationRepository.findById(locationId).get() : null;
        UserTech userTech = userTechRepository.findById(usertechId).isPresent() ? userTechRepository.findById(usertechId).get() : null;

        Technics technics = new Technics(serial, inventory, nameTech, status, location, userTech);
        
        technicsRepository.save(technics);
        
		return "redirect:/technics";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam String serial, @RequestParam Integer inventory,  
    @RequestParam Integer nametechId, @RequestParam Integer statusId, @RequestParam Integer usertechId,
    @RequestParam Integer locationId, @Param("id") Integer id) 
    {


        Technics technics = technicsRepository.findById(id).isPresent() ? technicsRepository.findById(id).get() : null;
        technics.setSerial(serial);
        technics.setInventory(inventory);
        technics.setNametech(nameTechRepository.findById(nametechId).isPresent() ? nameTechRepository.findById(nametechId).get() : null);
        technics.setStatus(statusRepository.findById(statusId).isPresent() ? statusRepository.findById(statusId).get() : null);
        technics.setUsertech(userTechRepository.findById(usertechId).isPresent() ? userTechRepository.findById(usertechId).get() : null);
        technics.setLocation(locationRepository.findById(locationId).isPresent() ? locationRepository.findById(locationId).get() : null);
        technicsRepository.save(technics);

        System.out.println("edit");

        return "redirect:/technics";
    }
    
    @RequestMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {

        technicsRepository.deleteById(id);

		return "redirect:/technics";
	}
    
}
