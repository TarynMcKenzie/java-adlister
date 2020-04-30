package modals;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    //--------INITIALIZE----------
    private Connection connection = null;

    //--------CONSTRUCTOR METHOD----------
    public MySQLAdsDao(Config configuration) throws SQLException {

        try {
            // SETUP DATABASE DRIVER
            DriverManager.registerDriver(new Driver());

            // SETUP DATABASE DRIVER
            connection = DriverManager.getConnection(
                    configuration.getUrl(),
                    configuration.getUsername(),
                    configuration.getPassword()
            );

        }catch (SQLException e) {

            // ERROR MESSAGE IF CANNOT CONNECT
            throw new RuntimeException("Cannot connect to the database", e);

        }

    }

    //--------CLASS METHODS----------
    @Override
    public List<Ad> all() {

        List<Ad> output = new ArrayList<>();

        // Query the SQL DB table for all ads
        String query = "SELECT * FROM ads";

        //Take into account the SQL Exception that needs to be handled
        try {
            // Create a statement object
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Iterate through our result set and add each ad to our contact bean
            while (rs.next()) {
                output.add(
                        new Ad(
                                rs.getLong("id"), // id
                                rs.getLong("userId"), //first-name
                                rs.getString("title"), //last-name
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output; // returns the List<Ad> of all the ads we imported from the MySQL database
    }

    @Override
    public Long insert(Ad ad) {

        // we need to insert that info into a new row in the database, then return the generated id (Primary key)
        // Instantiate a new Contact Object
        //INSERT INTO contacts (username, title, description) values ('%s', '%s', '%s')"
        long newlyCreatedUserId = 0;

        String addContactQuery = String.format("INSERT INTO contacts (username, title, description) VALUES ('%s', '%s', '%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription()
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
                ad.setId(newlyCreatedUserId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return the newly inserted user's id
        return newlyCreatedUserId;
    }

}
