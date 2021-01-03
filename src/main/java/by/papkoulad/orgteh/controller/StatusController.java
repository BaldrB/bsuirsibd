package by.papkoulad.orgteh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.papkoulad.orgteh.models.Status;
import by.papkoulad.orgteh.repo.StatusRepository;

@Controller
@RequestMapping("/status")
public class StatusController {
    
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
	String getStatus(Model model) {
		Iterable<Status> status = statusRepository.findAll();
        model.addAttribute("status", status);
		return "status";
	}

	@PostMapping("addstatus")
    public String addStatus(@RequestParam String statusname, Model model) 
    {
        Iterable<Status> status;

        Status statuss = new Status(statusname);
        statusRepository.save(statuss);

        status = statusRepository.findAll();
        model.addAttribute("status", status);

        return "redirect:/status";
    }
}
