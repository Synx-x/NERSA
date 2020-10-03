
package nersa;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;





public class nersaClient extends JFrame {
   
        
         public void display(){
          JTable table = null;
        province provObj = new province();
        provObj.table = table;     
             
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        //sets the tables size
        this.setBounds(10, 10, 1370, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    
   public static void main(String args[])
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try{
			nersaClient nersaClient=new nersaClient();
                        ConnectionImpl ci = new ConnectionImpl();
                        province p = new province();
                        ci.dbConnection();
                        ci.salesList();
                        p.getCol();
                        p.setCol();
                        nersaClient.display();
                      	nersaClient.setVisible(true);
			nersaClient.setSize(500,250);
                        

			}
			catch (Exception e) {
				e.printStackTrace();
			}
				}
			});
		}
   
    
}
