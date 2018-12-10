package ie.gmit.sw.RestJersey;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.rmi.DatabaseService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws Exception 
     * @throws RemoteException 
     * @throws MalformedURLException 
     */
	
	// Returns all bookings
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/allbooking")
    public List<Order> getIt() throws MalformedURLException, RemoteException, Exception {
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");

    	//ds.read();
        return ds.read();
    }
	
	
	// Search by booking id
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/Searchbooking/{orderID}")
	public Order getOrder(@PathParam("orderID") int orderID) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		DatabaseService ds;
		ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");

		return ds.getBooking(orderID);
	}
	
	
	//Create order
	@POST
	@Path("/CreateOrder")
	//@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createOrder(@FormParam("CustID") int CustID,@FormParam("CarNO") int CarID,@FormParam("hireDate") String hireDate,@FormParam("returnDate") String returnDate) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		//System.setSecurityManager(new RMISecurityManager());
		DatabaseService ds;
		ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
		
		
		ds.createBooking(new Order(CarID,CustID,hireDate,returnDate));

	}
	
	//Delete order
	@POST
	@Path("/DeleteOrder")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void deleteOrder(@FormParam("orderID") int orderID) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		
		DatabaseService ds;
		ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
		ds.deleteOrder(new Order(orderID));
	}
	
	
	@POST
	@Path("/UpdateOrder")
	//@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void UpdateOrder(@FormParam("custID") int CustID,@FormParam("carNO") int CarID,@FormParam("hireDate") String hireDate,@FormParam("returnDate") String returnDate) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		DatabaseService ds;
		ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
		ds.updateOrder(new Order(CustID,CarID,hireDate,returnDate));
	}
	


}
