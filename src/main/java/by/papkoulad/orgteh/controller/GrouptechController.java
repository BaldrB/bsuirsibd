package by.papkoulad.orgteh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.papkoulad.orgteh.models.Grouptech;
import by.papkoulad.orgteh.repo.GrouptechRepository;
import by.papkoulad.orgteh.service.GrouptechServices;

@Controller
@RequestMapping("/grouptech")
public class GrouptechController {

    @Autowired
    GrouptechServices grouptechServices;

    @Autowired
    GrouptechRepository grouptechRepository;

    @GetMapping
	String getGrouptech(Model model) {
        Iterable<Grouptech> grouptech = grouptechRepository.findAll();
        model.addAttribute("grouptech", grouptech);
		// model.addAttribute("list", grouptechServices.repository.findAll());
		return "grouptech";
    }
    
    @RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createGrouptech(@RequestParam String name) throws Exception {

        Grouptech grouptech = new Grouptech(name);
        grouptechRepository.save(grouptech);
        
		return "redirect:/grouptech";
	}
    
}
