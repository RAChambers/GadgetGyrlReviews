package org.gadgetgyrlreviews;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class GadgetCategoryStorage {

    private GadgetCategoryRepository gadgetCategoryRepo;

    public GadgetCategoryStorage(GadgetCategoryRepository gadgetCategoryRepo) {
        this.gadgetCategoryRepo = gadgetCategoryRepo;
    }

    public GadgetCategory findGadgetCategoryByGadgetType(String gadgetType) {
        return gadgetCategoryRepo.findByGadgetType(gadgetType);
    }
    GadgetCategory findGadgetCategoryById(long id){

        Optional<GadgetCategory> gadgetCategoryOptional = gadgetCategoryRepo.findById(id);
        GadgetCategory retrievedGadgetCategory;
        if (gadgetCategoryOptional.isEmpty()) {
            throw new ResourceNotFoundException("Gadget Category is not found.");
        } else {
            retrievedGadgetCategory = gadgetCategoryOptional.get();
        }
        return retrievedGadgetCategory;
    }
    public Iterable<GadgetCategory> findAllGadgetCategories(){
        return gadgetCategoryRepo.findAll();
    }

}
