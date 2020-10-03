
package nersa;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionImpl implements Sales{

//initializes the arraylist    
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        int columns;
        ResultSetMetaData md;
        ResultSet rs;

    @Override
    public void dbConnection() throws RemoteException {


try{        
         
//connection to database
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nersa", "root", "");
            Statement stmt = connection.createStatement();
            
//run query
            String sql = "select * from provincialsales;";
            rs = stmt.executeQuery(sql);
             md = rs.getMetaData();
             columns = md.getColumnCount();
            
            

            
            
            
}       catch (SQLException ex) {   
            Logger.getLogger(ConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
}
    
     @Override
    public void salesList() throws RemoteException {
  
        try{

//  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
            }

//  Get row data
            while (rs.next()) {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getObject(i));
                }

                data.add(row);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        
    }
 }

    @Override
    public void getCol() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCol() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
