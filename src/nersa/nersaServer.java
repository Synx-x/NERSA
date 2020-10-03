
package nersa;

import java.awt.Frame;
import java.awt.TextArea;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class nersaServer extends ConnectionImpl {
  
//initializes server GUI
    public Frame serverGUI = new Frame("Server GUI"); 
    public TextArea serverConsole = new TextArea();


	public nersaServer() throws RemoteException
	{
    
    serverGUI.setVisible(true);//makes gui visable
    serverGUI.setSize(300,300);//set size
    serverConsole.setBounds(30,240,250,110);
    serverConsole.setEditable(false);//uneditable text area
    serverGUI.add(serverConsole);
    serverConsole.append("\nStarting Server...");
    }
        
        public static void main(String args[])
	{
		try
		{
		nersaServer ns=new nersaServer();
                System.setProperty("java.rmi.server.hostname","192.168.1.2");
		java.rmi.Naming.rebind("nersaServer",ns);
		System.out.println("Server is Ready");
	 }
	    catch(RemoteException RE)
	    {
			System.out.println("Remote Server Error:"+ RE.getMessage());
			System.exit(0);
		}
		catch(MalformedURLException ME)
		{
			System.out.println("Invalid URL!!");
		}
	}
    
    
}
