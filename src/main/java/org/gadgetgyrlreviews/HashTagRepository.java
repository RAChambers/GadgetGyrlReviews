package org.gadgetgyrlreviews;

import org.springframework.data.repository.CrudRepository;

public interface HashTagRepository extends CrudRepository<HashTag, Long> {
    HashTag findByHashTag(String hashTag);
}
