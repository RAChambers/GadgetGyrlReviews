package org.gadgetgyrlreviews;

import javax.persistence.*;
import java.util.*;

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

    @ManyToMany
    private Collection<HashTag> hashTags;

    protected Review(){

    }
    public Review(String gadgetName, String gadgetType, String features, int price, int userRating, String userReviewComment, GadgetCategory gadgetCategory ){
        this.gadgetCategory = gadgetCategory;
        this.gadgetName = gadgetName;
        this.gadgetType = gadgetType;
        this.features = features;
        this.price = price;
        this.userRating = userRating;
        this.userReviewComment = userReviewComment;
        this.hashTags = new HashSet<>(hashTags);
    }
    public String getGadgetName(){
        return gadgetName;
    }
    public String getGadgetType() { return gadgetType;}
    public String getFeatures(){
        return features;
    }
    public int getPrice(){ return price;}
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
    public Collection<HashTag> getHashTags(){ return hashTags;}

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", gadgetCategory='" + gadgetCategory + '\'' +
                ", gadgetName='" + gadgetName + '\'' +
                ", gadgetType='" + gadgetType + '\'' +
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
                Objects.equals(gadgetType, review.gadgetType) &&
                Objects.equals(features, review.features) &&
                Objects.equals(price, review.price) &&
                Objects.equals(userRating, review.userRating) &&
                Objects.equals(userReviewComment, review.userReviewComment) &&
                Objects.equals(gadgetCategory, review.gadgetCategory);
    }
//    @Override
//    public int hashcode() {
//        return Objects.hash(id, gadgetName, gadgetType, features, price, userRating, userReviewComment, gadgetCategory);
//    }

    public void addHashTag(HashTag hashTagToAdd) {
        hashTags.add(hashTagToAdd);
    }


}
