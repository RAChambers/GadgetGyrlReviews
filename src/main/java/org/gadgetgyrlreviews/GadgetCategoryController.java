package org.gadgetgyrlreviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GadgetCategoryController {

    private GadgetCategoryStorage gadgetCategoryStorage;

    public GadgetCategoryController(GadgetCategoryStorage gadgetCategoryStorage) {
        this.gadgetCategoryStorage = gadgetCategoryStorage;
    }

    @RequestMapping("categories/{gadgetCategory}")
    public String viewGadgetType(@PathVariable String gadgetCategory, Model model){
       model.addAttribute("gadgetCategory", gadgetCategoryStorage.findGadgetCategoryByGadgetType(gadgetCategory));
       model.addAttribute("gadgetCategories", gadgetCategoryStorage.findAllGadgetCategories());
       return "category-template";
    }

    @RequestMapping("categories")
    public String viewAllGadgetTypes(Model model) {
        model.addAttribute("gadgetCategories", gadgetCategoryStorage.findAllGadgetCategories());
        return "index-template";
    }
}
