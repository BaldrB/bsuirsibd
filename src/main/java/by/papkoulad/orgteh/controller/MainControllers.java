package by.papkoulad.orgteh.controller;

import by.papkoulad.orgteh.models.NameTech;
import by.papkoulad.orgteh.models.Status;
import by.papkoulad.orgteh.models.Technics;
import by.papkoulad.orgteh.models.UserTech;
import by.papkoulad.orgteh.models.Location;
import by.papkoulad.orgteh.repo.LocationRepository;
import by.papkoulad.orgteh.repo.NameTechRepository;
import by.papkoulad.orgteh.repo.StatusRepository;
import by.papkoulad.orgteh.repo.TechnicsRepository;
import by.papkoulad.orgteh.repo.UserTechRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllers {

    @Autowired
    TechnicsRepository technicsRepository;

    @Autowired
    NameTechRepository nameTechRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserTechRepository userTechRepository;

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Technics> technics = technicsRepository.findAll();
        model.addAttribute("technics", technics);

        Iterable<NameTech> nameTech = nameTechRepository.findAll();
        model.addAttribute("nametechs", nameTech);

        Iterable<Status> status = statusRepository.findAll();
        model.addAttribute("statuss", status);

        Iterable<Location> location = locationRepository.findAll();
        model.addAttribute("locations", location);

        Iterable<UserTech> userTech = userTechRepository.findAll();
        model.addAttribute("usertechs", userTech);

		return "technics";
    }
    
    // @GetMapping("/testmain")
    // public String mainGet(Model model) {

    //     Iterable<Viewg> viewgs = viewgRepository.findAll();

    //     model.addAttribute("viewgs", viewgs);
    //     return "testmain";
    // }

    // @GetMapping("/testadd")
    // public String addGet(Model model) {
    //     return "testadd";
    // }

    // @GetMapping("/testfilter")
    // public String filterGet(Model model) {
    //     return "testfilter";
    // }

    // @GetMapping("/testtechnics")
    // public String mainTechnik(Model model) {

    //     Iterable<TechAttribut> techAttribut = techAttRepository.findAll();
    //     model.addAttribute("techattributs", techAttribut);

    //     Iterable<Technics> technicsAttribute = techincsRepository.findAll();
    //     model.addAttribute("technicsAttribute", technicsAttribute);

    //     return "testtechnics";
    // }

    // @PostMapping("addtechik")
    // public String addTechincs(@RequestParam String techName, @RequestParam String techInventory, @RequestParam String techCategory, 
    // @RequestParam String techData, @RequestParam String techCharact, @RequestParam String techLocation, 
    // Model model) 
    // {
    //     Iterable<TechAttribut> techAttribut;

    //     TechAttribut techAttributs = new TechAttribut(techName, techInventory, techCategory, techData, techCharact, techLocation);
    //     techAttRepository.save(techAttributs);

    //     techAttribut = techAttRepository.findAll();
    //     model.addAttribute("techattributs", techAttribut);

    //     return "testtechnics";
    // }


    // @PostMapping("addposta")
    // public String addPost(@RequestParam String textviewg, @RequestParam Integer idview, Model model) {
    //     Viewg viewg = new Viewg(textviewg, idview);
    //     viewgRepository.save(viewg);
    //     return "testadd";
    // }

    
    // @GetMapping("/testtechnics/{id}/edit")
    // public String bolckEdit(Model model) {

    //     Iterable<TechAttribut> techAttribut = techAttRepository.findAll();
    //     model.addAttribute("techattributs", techAttribut);

    //     return "testtechnics";
    // }

    // @PostMapping("filter")
    // public String filterPost(@RequestParam String filter, Model model) {
    //     Iterable<Viewg> viewgs;
    //     if (filter != null && !filter.isEmpty()){
    //         viewgs = viewgRepository.findByViewg(filter);
    //     } else {
    //         viewgs = viewgRepository.findAll();
    //     }

    //     model.addAttribute("viewgs", viewgs);

    //     return "testfilter";
    // }

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