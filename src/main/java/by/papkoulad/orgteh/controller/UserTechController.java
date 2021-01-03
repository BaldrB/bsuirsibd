package by.papkoulad.orgteh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.papkoulad.orgteh.models.UserTech;
import by.papkoulad.orgteh.repo.UserTechRepository;

@Controller
@RequestMapping("/usertech")
public class UserTechController {

    @Autowired
    private UserTechRepository userTechRepository;

    @GetMapping
	String getLocation(Model model) {
		Iterable<UserTech> userTech = userTechRepository.findAll();
        model.addAttribute("usertech", userTech);
		return "usertech";
	}

	@PostMapping("addusertech")
    public String addLocation(@RequestParam String fio, @RequestParam Integer number, Model model) 
    {
        Iterable<UserTech> userTech;

        UserTech userTechs = new UserTech(fio, number);
        userTechRepository.save(userTechs);

        userTech = userTechRepository.findAll();
        model.addAttribute("userTech", userTech);

        return "redirect:/usertech";
    }


    
}
