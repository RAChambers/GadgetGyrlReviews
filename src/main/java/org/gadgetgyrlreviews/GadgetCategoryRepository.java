package org.gadgetgyrlreviews;

import org.springframework.data.repository.CrudRepository;

public interface GadgetCategoryRepository extends CrudRepository<GadgetCategory,Long> {

    GadgetCategory findByGadgetType(String gadgetCategoryType);

}
