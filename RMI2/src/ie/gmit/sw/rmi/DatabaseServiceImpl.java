package ie.gmit.sw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carbookingsystem?useSSL=false", "root", "");
		// TODO Auto-generated constructor stub
	}
	
	// Reads resultset and adds to 
	@Override
	public List<Order> read() throws RemoteException, SQLException {
		System.out.println("In read");

		stmt = conn.createStatement();

		List<Order> List = new ArrayList<Order>();
		//String strSelect = "select * from orders";
		String strSelect = "Select * from orders;";

		ResultSet rset = stmt.executeQuery(strSelect);
		Customer c = new Customer();

		while (rset.next()) { 

			int OrderID = rset.getInt("BookingID");
			int cust = rset.getInt("CustID");
			String HireDate = rset.getString("HireDate");
			String ReturnDate = rset.getString("ReturnDate");
			int carID = rset.getInt("CarID");
			Order s = new Order(OrderID,cust,HireDate,ReturnDate,carID);
			List.add(s);
		}
		return List;
	}

	@Override
	public Order getBooking(int orderNo) throws RemoteException, SQLException {
		System.out.println("In get booking by order no");
		stmt = conn.createStatement();
		String strSelect = "select * from orders WHERE BookingID =" + orderNo + ";";
		ResultSet rset = stmt.executeQuery(strSelect);
		Order s = new Order();
		
		
		while (rset.next()) { 
			int BookingID = rset.getInt("BookingID");
			int cust = rset.getInt("CustID");
			String HireDate = rset.getString("HireDate");
			String ReturnDate = rset.getString("ReturnDate");
			int carID = rset.getInt("CarID");
			
			s = new Order(BookingID,cust,HireDate,ReturnDate,carID);
			
		}
		
		return s;
		
	}
	
	
	public void createBooking(Order order) throws RemoteException {
		
		
		System.out.println("In createBooking");

		boolean rset;
		try {
			stmt = conn.createStatement();
			//String strSelect = "INSERT INTO orders (Date,CustID,CarID) VALUES " + "(" + localDate + "," + order.getCust() + "," + order.getCar() + ");";
			String strSelect = "INSERT INTO orders (HireDate,ReturnDate,CustID,CarID) VALUES " + "(" + "'" + order.getHireDate() + "'" + "," + "'" + order.getReturnDate() + "'" + "," + order.getCustID() + "," + order.getCarID() + ");";
			System.out.println(strSelect);
			rset = stmt.execute(strSelect);
			//System.out.println(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteOrder(Order order) throws RemoteException, SQLException {
		System.out.println("In deleteBooking");
		
		boolean rset;
		try {
			stmt = conn.createStatement();
			//String strSelect = "INSERT INTO orders (Date,CustID,CarID) VALUES " + "(" + localDate + "," + order.getCust() + "," + order.getCar() + ");";
			String strSelect = "DELETE FROM Orders WHERE BookingID = " + order.getOrderID() + ";";
			System.out.println(strSelect);
			rset = stmt.execute(strSelect);
			//System.out.println(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	@Override
	public void updateOrder(Order order) throws RemoteException, SQLException {
		System.out.println("In updateBooking");
		
		boolean rset;
		try {
			stmt = conn.createStatement();
			//String strSelect = "INSERT INTO orders (Date,CustID,CarID) VALUES " + "(" + localDate + "," + order.getCust() + "," + order.getCar() + ");";
			String strSelect = "UPDATE Orders SET CarID = " + order.getCarID() +", HireDate = " + "'" + order.getHireDate() + "' , ReturnDate = " + "'" + order.getReturnDate() + "'" +" WHERE CustID = " + order.getCustID() +";";
			System.out.println(strSelect);
			rset = stmt.execute(strSelect);
			//System.out.println(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	

}
