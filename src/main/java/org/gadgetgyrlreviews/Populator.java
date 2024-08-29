package org.gadgetgyrlreviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    GadgetCategoryRepository gadgetCategoryRepo;
    @Autowired
    ReviewRepository reviewRepo;
    @Autowired
    HashTagRepository hashTagRepo;

    @Override
    public void run(String... args) throws Exception{
        GadgetCategory Educational = new GadgetCategory(("Educational"));
        GadgetCategory Home = new GadgetCategory(("Home"));
        GadgetCategory Personal = new GadgetCategory(("Personal"));
        GadgetCategory Entertainment = new GadgetCategory(("Entertainment"));
        GadgetCategory Productivity = new GadgetCategory(("Productivity"));
        gadgetCategoryRepo.save(Educational);
        gadgetCategoryRepo.save(Home);
        gadgetCategoryRepo.save(Personal);
        gadgetCategoryRepo.save(Entertainment);
        gadgetCategoryRepo.save((Productivity));
        HashTag hashTag1 = new HashTag("MustHave");
        HashTag hashTag2 = new HashTag("Organization");
        HashTag hashTag3 = new HashTag("trending");

        Review review1 = new Review("FullStar Vegetable Chopper", "Kitchen Appliance" , "Different size cuts, bowls and shapes",20, 5,"Didn't really work well",Home);
        Review review2 = new Review("Ninja AirFryer", "Kitchen Appliance", "Small, but space for large food. Various settings", 89, 9,"I really like this airfryer. I does the job!", Home);
        Review review3 = new Review("Video Ring Light", "Office", "It has different light settings, sits on your desk, compact", 19, 5, "I had a hard time putting it together",Productivity);

        reviewRepo.save(review1);
        reviewRepo.save(review2);
        reviewRepo.save(review3);
    }
    }


