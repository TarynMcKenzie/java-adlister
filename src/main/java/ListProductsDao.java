import java.util.ArrayList;
import java.util.List;

public class ListProductsDao implements Products{

    //--------- INITIALIZE ------------
    private List<Product> products;


    //--------- CONSTRUCTOR METHOD ------------
    public ListProductsDao(){
        this.products = new ArrayList<>();

        // -----DUMMY DATA-------
        Product vaccum = new Product(); // new instance

        vaccum.setId(1); // create id
        vaccum.setTitle("Vaccum"); // create title
        vaccum.setPrice(60000); // create price
        vaccum.setDescription("Really expensive vaccum"); // create description

        products.add(vaccum); // place into the arraylist
    }

    //--------- IMPLEMENT METHODS ------------
    @Override
    public Product findById(long id) {
        // 1. return Product for id
        //    a. return entire row

        return products.get((int)id - 1); //cast to int --> subtract by 1 (zero index)
    }

    @Override
    public long createProduct(Product newProduct) {
        // 1. Create a Product
        // 2. Insert into ArrayList --> then insert into ArrayList
        // 3. Assign ID

        newProduct.setId(products.size() + 1); // creates unique ids
        products.add(newProduct); // add to ArrayList
        return newProduct.getId();
    }
}
