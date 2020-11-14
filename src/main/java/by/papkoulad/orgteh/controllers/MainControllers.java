package by.papkoulad.orgteh.controllers;

import by.papkoulad.orgteh.models.Viewg;
import by.papkoulad.orgteh.repo.ViewgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControllers {

    @Autowired
    private ViewgRepository viewgRepository;

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Viewg> viewgs = viewgRepository.findAll();
        model.addAttribute("post", viewgs);
        return "main";
    }

    @GetMapping("/add")
    public String addmain(Model model) {
        return "add";
    }

    @PostMapping("/add")
    public String orgPostAdd(@RequestParam String title, @RequestParam Integer idview, Model model) {
        Viewg viewg = new Viewg(title, idview);
        viewgRepository.save(viewg);
        return "redirect:/";
    }

}