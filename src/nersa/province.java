
package nersa;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;


public class province extends ConnectionImpl implements Serializable {
Vector columnNamesVector = new Vector();
Vector dataVector = new Vector();
    JTable table;
    public void getCol(){
// parse elements from ArrayLists to Vectors to get database column data
       

        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++) {
            columnNamesVector.add(columnNames.get(i));
        }
}
    
       public void setCol(){
//  Create table with database data    
        JTable table = new JTable(dataVector, columnNamesVector) {
         
            public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);

                    if (o != null) {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
      
}
    
}
