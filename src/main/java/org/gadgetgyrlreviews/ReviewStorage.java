package org.gadgetgyrlreviews;


import org.springframework.stereotype.Service;

@Service
public class ReviewStorage {

    ReviewRepository reviewRepo;
    public ReviewStorage(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    };
    public Review findReviewByGadgetName(String gadgetName) {
        return reviewRepo.findByGadgetName(gadgetName);
    }
    public Iterable<Review> findAllReviews() {
        return reviewRepo.findAll();
    }
    public void save(Review reviewToAddHashTag) {
        reviewRepo.save(reviewToAddHashTag);
    }
}
