package com.web;
import java.sql.*;

public class ConnectionFactory {
	
	String connectionURL="jdbc:mysql://localhost:3306/mvcdb";
	String connectionUser="root";
	String connectionPassword="iamroot";
	
	  Connection con;
	  ResultSet rs;
	  PreparedStatement pst;
	
	public Boolean verifyLogin(Customer customer) {
		//TODO verify customer login information, return true if login is correct, false if incorrect
		return true;
	}
	public ResultSet getAllOrders() throws Exception {

		try{

			String selectQuery = "Select * from Orders";
			

				Class.forName("com.mysql.jdbc.Driver").newInstance(); 
				con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);	
				pst = con.prepareStatement(selectQuery);
				
				System.out.println(pst);
				
				rs = pst.executeQuery();

		}
		catch(Exception e){
			throw e;
		}
		return rs;
	}
	public ResultSet getOrders(Customer customer) throws Exception {

		try{

			String selectQuery = "Select * from Orders where CustomerId = ?";
			

				Class.forName("com.mysql.jdbc.Driver").newInstance(); 
				con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);	
				pst = con.prepareStatement(selectQuery);
				
				pst.setInt(1, customer.getCustomerID());
				
				System.out.println(pst);
				
				rs = pst.executeQuery();

		}
		catch(Exception e){
			throw e;
		}
		return rs;
	}
	
	public Shoe getShoe (int itemId) {
		Shoe shoe = new Shoe();
		try {
			String selectQuery = "SELECT * FROM SHOES WHERE itemId = ? ";
			con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
			pst = con.prepareStatement(selectQuery);
			
			pst.setInt(1,itemId);
					
			System.out.println(pst);
			
			rs = pst.executeQuery();
			
			while (rs.next()) 
			{
				shoe.setItemId(rs.getInt("itemId"));
				shoe.setItemName(rs.getString("itemName"));
				shoe.setCategory(rs.getString("category"));
				shoe.setShoeSize(rs.getInt("shoeSize"));
				shoe.setPrice(rs.getDouble("price"));
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}	
		return shoe;
	
}
	
public ResultSet getShoes(String Category) throws Exception{
		
		try {
			
			String selectQuery = "SELECT * FROM shoes WHERE category = ?";
					
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);	
			pst = con.prepareStatement(selectQuery);
			
			pst.setString(1, Category);
			
			System.out.println(pst);
			
			rs = pst.executeQuery();
		}
		catch(Exception e){
			throw e;
		}
		return rs;
		
	}

public ResultSet getAllShoes() throws Exception{
	
	try {
		
		String selectQuery = "SELECT * FROM shoes";
				
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);	
		pst = con.prepareStatement(selectQuery);
		
		System.out.println(pst);
		
		rs = pst.executeQuery();
	}
	catch(Exception e){
		throw e;
	}
	return rs;
	
}

public ResultSet getAllCustomers() throws Exception{
	try {
	//Creating database connection, query
	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);			
	pst=con.prepareStatement("SELECT * FROM CUSTOMERS");
	rs=pst.executeQuery();
	
	}
	catch(Exception e) {
		throw e;
	}
	
	return rs;
}
public Customer getCustomer(int customerID) throws Exception{
	Customer customer = new Customer();
	try {
	//Creating database connection, query
	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);			
	pst=con.prepareStatement("SELECT * FROM CUSTOMERS where customerId = ?");
	pst.setInt(1, customerID);

	rs=pst.executeQuery();
	
	while (rs.next()) 
	{
		customer.setCustomerID(rs.getInt("customerId"));
		customer.setUserName(rs.getString("userName"));
		customer.setPassword(rs.getString("password"));
		customer.setFirstName(rs.getString("firstName"));
		customer.setLastName(rs.getString("lastName"));
		customer.setAddress(rs.getString("address"));
		customer.setCity(rs.getString("city"));
		customer.setPostalCode(rs.getString("postalCode"));
		
	}
	
	}
	catch(Exception e) {
		throw e;
	}
	
	return customer;
}

public Customer getCustomer(String username, String password) throws Exception{
	Customer customer = new Customer();
	try {
	//Creating database connection, query
	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);			
	pst=con.prepareStatement("SELECT * FROM CUSTOMERS where userName = ? && password = ? ");
	pst.setString(1, username);
	pst.setString(2, password);
	rs=pst.executeQuery();
	
	while (rs.next()) 
	{
		customer.setCustomerID(rs.getInt("customerId"));
		customer.setUserName(rs.getString("userName"));
		customer.setPassword(rs.getString("password"));
		customer.setFirstName(rs.getString("firstName"));
		customer.setLastName(rs.getString("lastName"));
		customer.setAddress(rs.getString("address"));
		customer.setCity(rs.getString("city"));
		customer.setPostalCode(rs.getString("postalCode"));
		
	}
	
	}
	catch(Exception e) {
		throw e;
	}
	
	return customer;
}

public CSR getCSR(String username, String password) throws Exception {

	CSR csr = new CSR();
	try {
	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);			
	pst=con.prepareStatement("SELECT * FROM CSR where userName = ? && password = ? ");
	pst.setString(1, username);
	pst.setString(2, password);
	rs=pst.executeQuery();
	
	
	while (rs.next()) 
	{
		csr.setEmployeeId(rs.getInt("employeeId"));
		csr.setUserName(rs.getString("userName"));
		csr.setPassword(rs.getString("password"));
		csr.setFirstName(rs.getString("firstName"));
		csr.setLastName(rs.getString("lastName"));
	}
	
	}
	catch(Exception e) {
		throw e;
	}
	return csr;
}

public Boolean addOrder(Order order)throws Exception {
	
	//int customerId, int itemId, Date orderDate, int quantity 

	
	
	try {
		String insertQuery = "INSERT INTO ORDERS (customerId, itemId, orderDate, quantity, status) VALUES (?,?, CURDATE(),?, 'ORDER PLACED')";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
		pst = con.prepareStatement(insertQuery);
		
		pst.setInt(1, order.getCustomerId());
		pst.setInt(2, order.getItemId());
		pst.setInt(3, order.getQuantity());
		
		System.out.println(pst);
		
		pst.executeUpdate();
		
		return true;
	}catch(Exception e) {
		System.out.println(e);
		return false;
	}	
}

public Boolean updateOrder (Order order) {
	
	try {
		String insertQuery = "UPDATE ORDERS SET itemId = ?, quantity = ? WHERE orderId = ?";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
		pst = con.prepareStatement(insertQuery);
		
		
		pst.setInt(3, order.getOrderID());
		pst.setInt(1, order.getItemId());
		pst.setInt(2, order.getQuantity());
		
		System.out.println(pst);
		
		pst.executeUpdate();
		
		return true;
	}catch(Exception e) {
		System.out.println(e);
		return false;
	}	
}
public Boolean updateShoe (Shoe shoe) {
	
	try {
		String insertQuery = "UPDATE SHOES SET itemName = ?, category = ?, shoeSize = ?, price = ? WHERE itemId = ?";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
		pst = con.prepareStatement(insertQuery);
		
		
		pst.setString(1, shoe.getItemName());
		pst.setString(2, shoe.getCategory());
		pst.setInt(3, shoe.getShoeSize());
		pst.setDouble(4, shoe.getPrice());
		pst.setInt(3, shoe.getShoeSize());
		
		
		pst.executeUpdate();
		
		return true;
	}catch(Exception e) {
		System.out.println(e);
		return false;
	}
}

public Boolean addShoe (Shoe shoe) {
	
	try {
		String insertQuery = "INSERT INTO SHOES (itemName, category, shoeSize, price) VALUES (?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
		pst = con.prepareStatement(insertQuery);
		
		pst.setString(1, shoe.getItemName());
		pst.setInt(2, shoe.getItemId());
		pst.setDouble(3, shoe.getPrice());
		
		System.out.println(pst);
		
		pst.executeUpdate();
		
		return true;
	}catch(Exception e) {
		System.out.println(e);
		return false;
	}	
}
public Boolean deleteCustomer (Customer customer) {
	
	try {
		String deleteQuery = "DELETE FROM CUSTOMERS WHERE customerId = ?";
		con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
		pst = con.prepareStatement(deleteQuery);
		
		pst.setInt(1, customer.getCustomerID());
				
		System.out.println(pst);
		
		pst.executeUpdate();
		
		return true;
	}catch(Exception e) {
		System.out.println(e);
		return false;
	}	
}
public Boolean updateCustomer(Customer customer) {
	
	try {
		String insertQuery = "UPDATE Customers SET username = ?, password = ?, firstName = ?, lastName = ?, address = ?, city = ?, postalCode = ? WHERE customerId = ?";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
		pst = con.prepareStatement(insertQuery);
		
		pst.setInt(8, customer.getCustomerID());
		pst.setString(1, customer.getUserName());
		pst.setString(2, customer.getPassword());
		pst.setString(3, customer.getFirstName());
		pst.setString(4, customer.getLastName());
		pst.setString(5, customer.getAddress());
		pst.setString(6, customer.getCity());
		pst.setString(7, customer.getPostalCode());
		
		System.out.println(pst);
		
		pst.executeUpdate();
		
		
	}catch(Exception e) {
		System.out.println(e);
		return false;
	}	
	return true;
}
}

