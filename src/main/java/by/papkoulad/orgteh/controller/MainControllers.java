package by.papkoulad.orgteh.controller;

import by.papkoulad.orgteh.models.TechAttribut;
import by.papkoulad.orgteh.models.Viewg;
import by.papkoulad.orgteh.repo.TechAttributRepository;
import by.papkoulad.orgteh.repo.ViewgRepository;

import java.util.List;
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

    @Autowired
    private TechAttributRepository techAttRepository;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        return "testhome";
    }
    @GetMapping("/testhome")
    public String homeGet(Map<String, Object> model) {
        return "testhome";
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

    @GetMapping("/testfilter")
    public String filterGet(Map<String, Object> model) {
        return "testfilter";
    }

    @GetMapping("/testtechnics")
    public String mainTechnik(Map<String, Object> model) {

        Iterable<TechAttribut> techAttribut = techAttRepository.findAll();
        model.put("techattributs", techAttribut);

        return "testtechnics";
    }

    @PostMapping("addtechik")
    public String addTechincs(@RequestParam String techName, @RequestParam String techInventory, @RequestParam String techCategory, 
    @RequestParam String techData, @RequestParam String techCharact, @RequestParam String techLocation, 
    Map<String, Object> model) 
    {
        Iterable<TechAttribut> techAttribut;

        TechAttribut techAttributs = new TechAttribut(techName, techInventory, techCategory, techData, techCharact, techLocation);
        techAttRepository.save(techAttributs);

        techAttribut = techAttRepository.findAll();
        model.put("techattributs", techAttribut);

        return "testtechnics";
    }


    @PostMapping("addposta")
    public String addPost(@RequestParam String textviewg, @RequestParam Integer idview, Map<String, Object> model) {
        Viewg viewg = new Viewg(textviewg, idview);
        viewgRepository.save(viewg);
        return "testadd";
    }

    @PostMapping("/deletPost")
    public String deletPost(Map<String, Object> model) {
        return "testadd";
    }

    @PostMapping("filter")
    public String filterPost(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Viewg> viewgs;
        if (filter != null && !filter.isEmpty()){
            viewgs = viewgRepository.findByViewg(filter);
        } else {
            viewgs = viewgRepository.findAll();
        }

        model.put("viewgs", viewgs);

        return "testfilter";
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