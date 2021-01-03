package by.papkoulad.orgteh.controller;

import by.papkoulad.orgteh.models.TechAttribut;
import by.papkoulad.orgteh.models.Technics;
import by.papkoulad.orgteh.models.Viewg;
import by.papkoulad.orgteh.repo.TechAttributRepository;
import by.papkoulad.orgteh.repo.TechnicsRepository;
import by.papkoulad.orgteh.repo.ViewgRepository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainControllers {

    @Autowired
    private ViewgRepository viewgRepository;

    @Autowired
    private TechAttributRepository techAttRepository;

    @Autowired
    private TechnicsRepository techincsRepository;

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Viewg> viewgs = viewgRepository.findAll();

        model.addAttribute("viewgs", viewgs);
        return "testmain";
    }
    
    @GetMapping("/testmain")
    public String mainGet(Model model) {

        Iterable<Viewg> viewgs = viewgRepository.findAll();

        model.addAttribute("viewgs", viewgs);
        return "testmain";
    }

    @GetMapping("/testadd")
    public String addGet(Model model) {
        return "testadd";
    }

    @GetMapping("/testfilter")
    public String filterGet(Model model) {
        return "testfilter";
    }

    @GetMapping("/testtechnics")
    public String mainTechnik(Model model) {

        Iterable<TechAttribut> techAttribut = techAttRepository.findAll();
        model.addAttribute("techattributs", techAttribut);

        Iterable<Technics> technicsAttribute = techincsRepository.findAll();
        model.addAttribute("technicsAttribute", technicsAttribute);

        return "testtechnics";
    }

    @PostMapping("addtechik")
    public String addTechincs(@RequestParam String techName, @RequestParam String techInventory, @RequestParam String techCategory, 
    @RequestParam String techData, @RequestParam String techCharact, @RequestParam String techLocation, 
    Model model) 
    {
        Iterable<TechAttribut> techAttribut;

        TechAttribut techAttributs = new TechAttribut(techName, techInventory, techCategory, techData, techCharact, techLocation);
        techAttRepository.save(techAttributs);

        techAttribut = techAttRepository.findAll();
        model.addAttribute("techattributs", techAttribut);

        return "testtechnics";
    }


    @PostMapping("addposta")
    public String addPost(@RequestParam String textviewg, @RequestParam Integer idview, Model model) {
        Viewg viewg = new Viewg(textviewg, idview);
        viewgRepository.save(viewg);
        return "testadd";
    }

    
    @GetMapping("/testtechnics/{id}/edit")
    public String bolckEdit(Model model) {

        Iterable<TechAttribut> techAttribut = techAttRepository.findAll();
        model.addAttribute("techattributs", techAttribut);

        return "testtechnics";
    }

    @PostMapping("filter")
    public String filterPost(@RequestParam String filter, Model model) {
        Iterable<Viewg> viewgs;
        if (filter != null && !filter.isEmpty()){
            viewgs = viewgRepository.findByViewg(filter);
        } else {
            viewgs = viewgRepository.findAll();
        }

        model.addAttribute("viewgs", viewgs);

        return "testfilter";
    }

    // @PostMapping("techatt")
    // public String filterTechPost(@RequestParam String techatt, Model model) {
    //     Iterable<TechAttribut> techatts;
    //     if (techatt != null && !techatt.isEmpty()){
    //         techatts = techAttRepository.findByViewg(techatt);
    //     } else {
    //         techatts = techAttRepository.findAll();
    //     }

    //     model.addAttribute("techatt", techatts);

    //     return "testtechnics";
    // }

}