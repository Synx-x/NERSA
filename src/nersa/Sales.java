
package nersa;

public interface Sales extends java.rmi.Remote{
 public void salesList() 
        throws java.rmi.RemoteException;
 
 public void dbConnection() 
        throws java.rmi.RemoteException;     

public void getCol()
        throws java.rmi.RemoteException;

public void setCol()
        throws java.rmi.RemoteException;

}
 
