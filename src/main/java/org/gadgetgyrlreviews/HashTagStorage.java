package org.gadgetgyrlreviews;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HashTagStorage {

    private HashTagRepository hashTagRepo;

    public HashTagStorage(HashTagRepository hashTagRepo) {
        this.hashTagRepo = hashTagRepo;
    }

    public HashTag findHashTagById(Long id) {
        Optional<HashTag> hashTagOptional = hashTagRepo.findById(id);
        HashTag retrievedHashTag;
        if (hashTagOptional.isEmpty()) {
            throw new ResourceNotFoundException("HashTag is not found.");

        } else {
            retrievedHashTag = hashTagOptional.get();
        }
        return retrievedHashTag;
    }
    public void save(HashTag hashTagToSave){
        hashTagToSave.save(hashTagToSave);
    }
}
