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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.papkoulad.orgteh.models.UserTech;
import by.papkoulad.orgteh.repo.UserTechRepository;

@Controller
@RequestMapping("/usertech")
public class UserTechController {

    @Autowired
    private UserTechRepository userTechRepository;

    @GetMapping
	String get(Model model) {
		Iterable<UserTech> userTech = userTechRepository.findAll();
        model.addAttribute("usertech", userTech);
		return "usertech";
    }
    
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String create(@RequestParam String fio, @RequestParam Integer number, Model model) 
    {
        Iterable<UserTech> userTech;

        UserTech userTechs = new UserTech(fio, number);
        userTechRepository.save(userTechs);
        System.out.println("create");

        userTech = userTechRepository.findAll();
        model.addAttribute("userTech", userTech);

        return "redirect:/usertech";
    }
    
    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String edit(
    @RequestParam String fio, @RequestParam Integer number, @Param("id") Integer id) 
    {
        UserTech userTechs = userTechRepository.findById(id).isPresent() ? userTechRepository.findById(id).get() : null;
        userTechs.setFio(fio);
        userTechs.setNumber(number);
        userTechRepository.save(userTechs);

        System.out.println("edit");

        return "redirect:/usertech";
    }
    

    @RequestMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {

        userTechRepository.deleteById(id);

		return "redirect:/usertech";
	}    
}
