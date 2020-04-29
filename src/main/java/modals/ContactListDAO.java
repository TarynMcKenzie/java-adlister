package modals;

import java.util.ArrayList;
import java.util.List;

public class ContactListDAO implements Contacts {


    //--------INITIALIZE----------
    private List<Contact> contactList = new ArrayList<>();


    //--------CONSTRUCTOR METHOD----------
    public ContactListDAO() { }

    //--------CLASS METHODS----------
    @Override
    public List<Contact> getContacts() {
        return contactList;
    }

    @Override
    public long saveContact(Contact contact) {
        // List begins with 0 but the incremented id begins with 1 -- > add 1
        if (contact.getId() == 0) {  // if the contact had a NO ID
            contact.setId(contactList.size() + 1); // -- > add 1 to id
            contactList.add(contact); // --> add contact to list
        } else {
            contactList.set((int) contact.getId(), contact); //--> add contact to list
        }
        return contact.getId();
    }

    @Override
    public void deleteContactById(long id) {
        contactList.remove((int)id - 1);
    }

    @Override
    public Contact getContactById(long id) {
        return contactList.get((int) id - 1);
    }

    public static void main(String[] args) {
        Contacts contactsDao= new ContactListDAO();

        List<Contact> allContacts = contactsDao.getContacts();


    }
}