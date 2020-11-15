package by.papkoulad.orgteh.controller;

import by.papkoulad.orgteh.models.Viewg;
import by.papkoulad.orgteh.repo.ViewgRepository;

import java.util.Map;

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

    @GetMapping("/test")
    public String main(@RequestParam(name="name", required = false, defaultValue = "World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "test";
    }
    
    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Viewg> viewgs = viewgRepository.findAll();

        model.put("viewgs", viewgs);
        return "testmain";
    }

    @GetMapping("/testmain")
    public String mainGet(Map<String, Object> model) {
        Iterable<Viewg> viewgs = viewgRepository.findAll();

        model.put("viewgs", viewgs);
        return "testmain";
    }

    @GetMapping("/testadd")
    public String addGet(Map<String, Object> model) {
        return "testadd";
    }


    @PostMapping("/testadd")
    public String addPost(@RequestParam String textviewg, @RequestParam Integer idview, Map<String, Object> model) {
        Viewg viewg = new Viewg(textviewg, idview);
        viewgRepository.save(viewg);
        return "testmain";
    }

    @GetMapping("/testfilter")
    public String filter(Map<String, Object> model) {
        Iterable<Viewg> viewgs = viewgRepository.findAll();
        
        model.put("viewgs", viewgs);
        return "testmain";
    }

    // @GetMapping("/")
    // public String main(Model model) {
    //     Iterable<Viewg> viewgs = viewgRepository.findAll();
    //     model.addAttribute("post", viewgs);
    //     return "main";
    // }

    // @GetMapping("/add")
    // public String addmain(Model model) {
    //     return "add";
    // }

    // @PostMapping("/add")
    // public String orgPostAdd(@RequestParam String title, @RequestParam Integer idview, Model model) {
    //     Viewg viewg = new Viewg(title, idview);
    //     viewgRepository.save(viewg);
    //     return "redirect:/";
    // }

}