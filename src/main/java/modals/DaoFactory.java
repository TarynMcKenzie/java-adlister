package modals;

public class DaoFactory {
    private static Ads adsDao;
    private static Contacts contactsDAO;


    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

    public static Contacts getContactsDAO() {
        if (contactsDAO == null) {
            contactsDAO = new ContactListDAO();
        }
        return contactsDAO;
    }
}
