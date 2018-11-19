/*
 * 
 */
package truckingcompanymanagementsystem;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author justin
 */
public final class UserAccounts {

    private UserAccounts() {
        //constructor
        
    }

    public static UserAccounts getInstance() {
        
        return UserAccountsHolder.INSTANCE;
    }

    private static class UserAccountsHolder {

        private static final UserAccounts INSTANCE = new UserAccounts();
    }

    Database connection = Database.getInstance();

    static String stored_username;
    static String position;
    static String access_level;
    private int access;
    private int id;
    static boolean has_logged_in = false;
    static boolean user_authenticated = false;

    public void userAuthentication(String username, String password) {
        ResultSet login = null;
        String loginQuery = "SELECT username FROM Personnel_Data";
        
        try {
            connection.startConnection();
            login = connection.getGenericResultSet(loginQuery);
        } catch (SQLException ex) {
            Logger.getLogger(UserAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean found = false;
        user_authenticated = false;

        try {
            while (login.next()) {
                String database_username = login.getString("username");

                if (username.equals(database_username)) {
                    found = true;
                    break;
                }
            }

            if (found) {

                login = connection.getGenericResultSet("SELECT password, "
                        + "employee_id_number, access FROM Personnel_Data WHERE username = '"
                        + username + "'");
                while (login.next()) {
                    String database_password = login.getString("password");
                    id = login.getInt("employee_id_number");
                    access = login.getInt("access");
                    if (password.equals(database_password)) {
                        user_authenticated = true;
                        has_logged_in = true;
                        stored_username = username;
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getID() {
        return id;
    }

    public int getAccess() {
        return access;
    }

}
