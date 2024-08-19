package org.gadgetgyrlreviews;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
    ReviewStorage reviewStorage;
    GadgetCategoryStorage gadgetCategoryStorage;


    public ReviewController(ReviewStorage reviewStorage, GadgetCategoryStorage gadgetCategoryStorage){
        this.reviewStorage = reviewStorage;
        this.gadgetCategoryStorage = gadgetCategoryStorage;

    }
    @RequestMapping("reviews/{gadgetName")
    public String viewReview(@PathVariable String gadgetName, Model model){
        model.addAttribute("reviewDisplay", reviewStorage.findReviewByGadgetName(gadgetName));
        model.addAttribute("gadgetCategories", gadgetCategoryStorage.findAllGadgetCategories());
        return "review-template";
    }
    @PostMapping("reviews/add")
    public String addReview(String gadgetName, String gadgetType, String features, Integer price, Integer userRating, String userReviewComment, long gadgetCategoryId){
        GadgetCategory reviewGadgetCategory = gadgetCategoryStorage.findGadgetCategoryById(gadgetCategoryId);

        reviewStorage.save(new Review(gadgetName,gadgetType,features,price,userRating,userReviewComment, reviewGadgetCategory));
        return "redirect:/categories/"+ reviewGadgetCategory.getGadgetType();
    }

}
