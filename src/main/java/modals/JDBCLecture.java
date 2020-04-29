package modals;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class JDBCLecture {

    public static void main(String[] args) throws SQLException {
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

        // CREATE STATEMENT
        Statement stat = connector.createStatement();

        // EXECUTE SORT QUERY
        String contactsQuery = "SELECT * FROM contacts";

        ResultSet result = stat.executeQuery(contactsQuery);

        // DISPLAY RESULT
        while (result.next()) {
            System.out.println(result.getString("first_name") +
                    " " + result.getString("last_name") +
                    " " + result.getString("phone_number"));
        }

        // NEU CONTACT LIST DAO
        Contacts clDao = DaoFactory.getContactsDAO();

        // NEU CONTACT OBJECT
        Contact notCasey = new Contact("Casey", "not", "2105557777");

        // SAVE CONTACT OBJECT
        long newContact = clDao.saveContact(notCasey);
        Contact addContact = clDao.getContactById(newContact);

        // INSERT CONTACT OBJECT
        // INSERT INTO contacts(first_name, last_name, phone_number) VALUES ('casey', 'not', '2105557777');

        String addContactQuery = String.format(
                "INSERT INTO contacts (first_name, last_name, phone_number)" +
                        " VALUES ('%s','%s','%s') ",
                addContact.getFirstName(),
                addContact.getLastName(),
                addContact.getPhoneNumber(),
                addContact.getId()
        );

        // EXECUTE SQL QUERY
        int numRows = stat.executeUpdate(addContactQuery, Statement.RETURN_GENERATED_KEYS);
        System.out.println("Rows affected: " + numRows);

        // EXECUTE SQL QUERY
        long insertedRowId = 0;

        ResultSet theKeys = stat.getGeneratedKeys();

        if (theKeys.next()) {
            insertedRowId = theKeys.getLong(1);
            System.out.println("The ID in the MySQL table row (new) is: " + theKeys.getLong(1));
        }

        if (insertedRowId != 0)
            addContact.setId(insertedRowId);

    }
}
