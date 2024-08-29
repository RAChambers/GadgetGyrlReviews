package org.gadgetgyrlreviews;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

    private final GadgetCategoryRepository gadgetCategoryRepo;
    private final HashTagRepository hashTagRepo;

    public HomeController(GadgetCategoryRepository gadgetCategoryRepo, HashTagRepository hashTagRepo){
        this.gadgetCategoryRepo = gadgetCategoryRepo;
        this.hashTagRepo = hashTagRepo;
    }

    @RequestMapping({"","/"})
    public String routeToCategories(Model model){
        model.addAttribute("gadgetCategories", gadgetCategoryRepo.findAll());
        model.addAttribute("hashTags", hashTagRepo.findAll());
        return "index-template";
    }
}
