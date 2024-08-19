package org.gadgetgyrlreviews;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long>{

    Review findByGadgetName(String gadgetName);
}
