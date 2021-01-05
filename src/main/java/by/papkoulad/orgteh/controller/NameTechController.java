package by.papkoulad.orgteh.controller;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.data.repository.query.Param;

import by.papkoulad.orgteh.models.NameTech;
import by.papkoulad.orgteh.models.Grouptech;
import by.papkoulad.orgteh.repo.GrouptechRepository;
import by.papkoulad.orgteh.repo.NameTechRepository;

@Controller
@RequestMapping("/nametech")
public class NameTechController {
    
    @Autowired
    NameTechRepository nameTechRepository;

    @Autowired
    GrouptechRepository grouptechRepository;

    @GetMapping
	String getGrouptech(Model model) {
        Iterable<NameTech> nameTech = nameTechRepository.findAll();
        model.addAttribute("nameTech", nameTech);

        Iterable<Grouptech> grouptechs = grouptechRepository.findAll();
        model.addAttribute("grouptechs", grouptechs);
		// model.addAttribute("list", grouptechServices.repository.findAll());
		// model.addAttribute("list", grouptechServices.repository.findAll());
		return "nametech";
    }
    
    @RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createGrouptech(@RequestParam String nametech, @RequestParam String charact,  @RequestParam Integer grouptechId) {

        Grouptech grouptech;
        grouptech = grouptechRepository.findById(grouptechId).isPresent() ? grouptechRepository.findById(grouptechId).get() : null;
        System.out.println(grouptech);
        NameTech nameTech = new NameTech(nametech, charact, grouptech);
        
        nameTechRepository.save(nameTech);
        
		return "redirect:/nametech";
	}
}
