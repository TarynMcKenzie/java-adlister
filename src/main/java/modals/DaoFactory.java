package modals;

import java.sql.SQLException;

public class DaoFactory {

    // ---- INITIALIZE -----
    private static Ads adsDao;

    // ---- NEW INSTANCE OF CONFIG -----
    private static Config configuration = new Config();


    // ---- GET ADS DAO -----
    public static Ads getAdsDao() throws SQLException {

        if (adsDao == null) { // if no ads in the adsdao -->
            adsDao = new MySQLAdsDao(configuration); // new instance
        }


        return adsDao;
    }

}
