package by.papkoulad.orgteh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping
	String getGrouptech(Model model) {
		model.addAttribute("list", grouptechServices.repository.findAll());
		return "grouptech-list";
    }
    
    @RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createOrUpdate(Grouptech entity) throws Exception {
		grouptechServices.create(entity);
		return "redirect:/grouptech-list";
	}
    
}
