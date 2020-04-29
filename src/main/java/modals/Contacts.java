package modals;

import java.util.List;

public interface Contacts {

    // List all contacts
    List<Contact> getContacts();

    //Get the length of the contact List
    long saveContact(Contact contact);

    // Delete contacts
    void deleteContactById(long id);

    //Getting contact by ID
    Contact getContactById(long id);
}
