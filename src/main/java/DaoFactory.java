public class DaoFactory {

    private static Products productsDao;

    public static Products getProductsDao(){

        // 1. if null --> create new instance of ListProductDao
        // 2. if not null --> return the instance of ListProductDao that already exists

        if(productsDao == null){
            productsDao = new ListProductsDao();
        }

        return productsDao;
    }
}
