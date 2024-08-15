package org.gadgetgyrlreviews;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String gadgetName;
    private String gadgetType;
    private String features;
    private int price;
    private int userRating;
    private String userReviewComment;

    @ManyToOne
    private GadgetCategory gadgetCategory;

    protected Review(){

    }
    public Review(String gadgetName, String gadgetType, String features, int price, int userRating, String userReviewComment, GadgetCategory gadgetCategory ){
        this.gadgetCategory = gadgetCategory;
        this.gadgetName = gadgetName;
        this.features = features;
        this.price = price;
        this.userRating = userRating;
        this.userReviewComment = userReviewComment;
    }
    public String getGadgetName(){
        return gadgetName;
    }
    public String getFeatures(){
        return features;
    }
    public int getPrice(){
        return price;
    }
    public int getUserRating(){
        return userRating;
    }
    public GadgetCategory getGadgetCategory(){
        return gadgetCategory;
    }
    public String getUserReviewComment(){
        return userReviewComment;
    }
    public Long getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", gadgetCategory='" + gadgetCategory + '\'' +
                ", gadgetName='" + gadgetName + '\'' +
                ", features='" + features + '\'' +
                ", price='" + price + '\'' +
                ", userRating='" + userRating + '\'' +
                ", userReviewComment='" + userReviewComment + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id &&
                Objects.equals(gadgetName, review.gadgetName) &&
                Objects.equals(features, review.features) &&
                Objects.equals(price, review.price) &&
                Objects.equals(userRating, review.userRating) &&
                Objects.equals(userReviewComment, review.userReviewComment) &&
                Objects.equals(gadgetCategory, review.gadgetCategory);
    }

}
