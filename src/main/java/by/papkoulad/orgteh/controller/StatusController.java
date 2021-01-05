package by.papkoulad.orgteh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.papkoulad.orgteh.models.Status;
import by.papkoulad.orgteh.repo.StatusRepository;

@Controller
@RequestMapping("/status")
public class StatusController {
    
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
	String get(Model model) {
		Iterable<Status> status = statusRepository.findAll();
        model.addAttribute("status", status);
		return "status";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
    public String create(@RequestParam String statusname, Model model) 
    {
        Iterable<Status> status;

        Status statuss = new Status(statusname);
        statusRepository.save(statuss);

        status = statusRepository.findAll();
        model.addAttribute("status", status);

        return "redirect:/status";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam String statusname, @Param("id") Integer id) 
    {
        Status statuss = statusRepository.findById(id).isPresent() ? statusRepository.findById(id).get() : null;
        statusRepository.save(statuss);
        statuss.setStatusname(statusname);
        statusRepository.save(statuss);

        System.out.println("edit");

        return "redirect:/status";
    }

    @RequestMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {

        statusRepository.deleteById(id);

		return "redirect:/status";
	}
}
