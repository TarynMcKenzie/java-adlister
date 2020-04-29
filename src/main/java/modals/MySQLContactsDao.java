package modals;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLContactsDao implements Contacts {

    //--------INITIALIZE----------
    private Connection connection;


    //--------CONSTRUCTOR METHOD----------
    public MySQLContactsDao() throws SQLException {

        // INITIALIZE CONFIG
        Config configuration = new Config();

        // SETUP DATABASE DRIVER
        DriverManager.registerDriver(new Driver());

        // SETUP DATABASE DRIVER
        Connection connector = DriverManager.getConnection(
                configuration.getUrl(),
                configuration.getUsername(),
                configuration.getPassword()
        );

    }

    //--------IMPLEMENTED METHODS----------
    @Override
    public List<Contact> getContacts() {
        List<Contact> output = new ArrayList<>();
        // Query the SQL DB table for all contacts
        String query = "SELECT * FROM contacts";
        //Take into account the SQL Exception that needs to be handled
        try {
            // Create a statement object
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Iterate through our result set and add each contact to our contact bean
            while (rs.next()) {
                output.add(
                        new Contact(
                                rs.getLong("id"), // id
                                rs.getString("first_name"), //first-name
                                rs.getString("last_name"), //last-name
                                rs.getString("phone_number") // phone number
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output; // returns the List<Contact> of all the contacts we imported from the MySQL database
    }

    @Override
    public long saveContact(Contact contact) {
        // a Contact object sent in with first/last/phone,
        // we need to insert that info into a new row in the database, then return the generated id (Primary key)
        // Instantiate a new Contact Object
        //INSERT INTO contacts (first_name, last_name, phone_number) values
        long newlyCreatedUserId = 0;
        String addContactQuery = String.format("INSERT INTO contacts (first_name, last_name, phone_number) VALUES ('%s', '%s', '%s')",
                contact.getFirstName(),
                contact.getLastName(),
                contact.getPhoneNumber()
        );
        try {
            Statement stmt = connection.createStatement();
            // NOW let's actually execute this SQL query to add the new contact to our database
            stmt.executeUpdate(addContactQuery, Statement.RETURN_GENERATED_KEYS);
            // If we add Statement.RETURN_GENERATED_KEYS, we can work with the actual MySQL DB table row ID's, and reassign those ID's to our Contact objects here in our Java code
            long insertedRowId = 0;
            ResultSet ks = stmt.getGeneratedKeys();
            if (ks.next()) {
                newlyCreatedUserId = ks.getLong(1); // This will save the MySQL row ID to a variable
                System.out.println("The ID of the newly inserted row is: " + ks.getLong(1));
            }
            // Check to see if the id was returned, or if insertedRowId is still at its default of '0'
            if (newlyCreatedUserId != 0) {
                contact.setId(newlyCreatedUserId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return the newly inserted user's id
        return newlyCreatedUserId;
    }


    @Override
    public void deleteContactById(long id) {
        // 'id' passed in is the id of the row we want to delete from our DB table
        // SQL equivalent for deleting row by id: DELETE FROM contacts WHERE id = sentInId
        String query = String.format("DELETE FROM contacts WHERE id = %d", id);
        try {
            Statement statement = connection.createStatement();
            boolean success = statement.execute(query);
            if (success) {
                System.out.println("Contact has been deleted.");
            } else {    //when unsuccessful
                System.out.println("Contact was not deleted - check for syntax errors.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Contact getContactById(long id) {
        Contact returnContact = new Contact();
        String query = String.format("SELECT * FROM contacts WHERE id = %d", id);
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) { //this means we found a match!
                returnContact.setId(id);
                returnContact.setFirstName(rs.getString("first_name"));
                returnContact.setLastName(rs.getString("last_name"));
                returnContact.setPhoneNumber(rs.getString("phone_number"));
            } else { // there was no match for the id that was sent in
                System.out.println("Supplied user id found no contact matches.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnContact;
    }
}

