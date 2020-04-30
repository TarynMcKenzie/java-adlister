package modals;

import java.util.List;

public interface Ads{

    // ---- GET ALL ADS -----
    List<Ad> all();

    // ---- INSERT A NEW AD -----
    Long insert(Ad ad);
}
