package modals;

public class Contact {

    //---------------------------------------------
    //----------------CONTACT BEAN-----------------
    //---------------------------------------------

    //--------INITIALIZE----------
    private long id; // defaults to zero
    public String firstName;
    public String lastName;
    public String phoneNumber;

    //--------ZERO ARGUMENT - CONSTRUCTOR METHOD----------
    public Contact() { } // Reserve space in memory

    //--------CONSTRUCTOR METHOD----------
    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //--------CONSTRUCTOR METHOD----------
    public Contact(long id,String firstName, String lastName, String phoneNumber) {
        this.id= id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //--------GET & SET----------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

