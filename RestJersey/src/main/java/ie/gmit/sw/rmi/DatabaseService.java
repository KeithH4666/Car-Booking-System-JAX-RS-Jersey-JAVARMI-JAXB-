package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Order;

public interface DatabaseService extends Remote {
	
	public List<Order> read() throws RemoteException, SQLException;
	
	public Order getBooking(int orderNo) throws RemoteException, SQLException;
	
	public void createBooking(Order order) throws RemoteException, SQLException;
	
	public void deleteOrder(Order order) throws RemoteException, SQLException;
	
	public void updateOrder(Order order) throws RemoteException, SQLException;
}
