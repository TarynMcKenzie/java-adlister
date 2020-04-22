import java.io.Serializable;

public class Product implements Serializable {

    // =================================
    // =========== THE BEAN ============
    // =================================

    //--------- INITIALIZE ------------
    private long id;
    private String title;
    private long price;
    private String description;


    //--------- CONSTRUCTOR METHOD ------------
    public Product(){
        // for JVM to reserve space in memory
    }


    //-----------GET & SET------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
