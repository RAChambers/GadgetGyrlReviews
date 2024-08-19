package org.gadgetgyrlreviews;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class GadgetCategory {
    @Id
    @GeneratedValue
    private Long id;
    private String gadgetType;
    @OneToMany(mappedBy = "gadgetCategory")
    private Collection<Review> reviews;

    protected GadgetCategory(){
    }

    public GadgetCategory(String gadgetType) {
        this.gadgetType = gadgetType;
    }
    public Long getId() {
        return id;
    }

    public String getGadgetType(){
        return gadgetType;
    }
    public Collection<Review> getReviews() {
        return reviews;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GadgetCategory gadgetCategory = (GadgetCategory) o;

        if (id != gadgetCategory.id) return false;
        if (!Objects.equals(gadgetType, gadgetCategory.gadgetType))
            return false;

        return false;
    }
    @Override
    public String toString() {
        return "GadgetCategory{" +
                "id=" + id +
                ", gadgetType='" + gadgetType + '\'' +
                ", reviews=" + reviews +
                '}';
    }
//    @Override
//    public int hashcode(){
//        int result = (int) (id^(id>>>32));
//        result = 31*result + (gadgetType != null ? gadgetType.hashCode() :0);
//        return result;
//    }

}

