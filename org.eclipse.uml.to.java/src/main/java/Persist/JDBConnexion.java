/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Core.ActivityCategory;
import Core.Plan;
import Core.Product;
import Core.Task;
import Core.User;


/**
 * Description of JDBConnexion.
 * 
 * @author Helping Hand
 */
public class JDBConnexion {
	
	/** The connection */
	private Connection conn;
	
	/** The result meta. */
	private ResultSetMetaData resultMeta;
	
	/** The resulSet. */
	private ResultSet rs;
	
	/** The map. */
	private HashMap m;
	// End of user code
	
	/** Chek if is already connected. */
	private static boolean isConnected = false;
	
	/** The connexion. */
	private static JDBConnexion connexion;

	/**
	 * The constructor to connect to the database.
	 */
	private JDBConnexion() {
		super();
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:postgresql://ec2-54-227-245-197.compute-1.amazonaws.com:5432/d4i5fck68498ce?sslmode=require";
		String user = "ambpfzhcrpupmx";
		String passwd = "PeSnt07zQFVWKQrsqcRd1GzW6I";

		try {
			this.openConnexion(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates the connect.
	 *
	 * @return the JDB connexion
	 */
	public static JDBConnexion createConnect() {
		if (!isConnected) {
			connexion = new JDBConnexion();
			isConnected = true;
		}
		return connexion;
	}

	
	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public HashMap getM() {
		return m;
	}


	/**
	 * Sets the map.
	 *
	 * @param m the new map
	 */
	public void setM(HashMap m) {
		this.m = m;
	}


	/**
	 * Description of the method openConnexion.
	 *
	 * @param url the url
	 * @param user the user
	 * @param passwd the password
	 * @return true if the connexion is established
	 * @throws SQLException the SQL exception
	 */
	public Boolean openConnexion(String url, String user, String passwd) throws SQLException {
		boolean isConnected = false;
		this.conn = DriverManager.getConnection(url, user, passwd);
		isConnected = true;

		return(isConnected);
	}

	/**
	 * Extract the data from the database.
	 *
	 * @return a map with the data
	 * @throws SQLException the SQL exception
	 */
	public Map extractData() throws SQLException {
		Map m = new HashMap();
		
		while(this.rs.next()){
			for(int i = 1; i <= this.resultMeta.getColumnCount(); i++) {
				m.put(this.resultMeta.getColumnName(i), this.rs.getObject(i).toString());
			}
		}
		rs.close();
		
		return m;
	}


	/**
	 * Description of the method close.
	 */
	public void close() {
	}

	/**
	 * Description of the method executeRequest.
	 *
	 * @param request the request
	 * @throws SQLException the SQL exception
	 */
	public void executeRequest(String request) throws SQLException {
		java.sql.Statement stmt = null;
		stmt = this.conn.createStatement();
		this.rs = stmt.executeQuery(request);
		this.resultMeta = this.rs.getMetaData();

		this.m = (HashMap) extractData();
	}
	
	/**
	 * Gets the all activity category.
	 *
	 * @param request the request
	 * @return the all activity category
	 */
	public List<ActivityCategory> getAllActivityCategory(String request) {
		List<ActivityCategory> list = new ArrayList<ActivityCategory>();
		java.sql.Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			this.rs = stmt.executeQuery(request);
			while ( rs.next() ) {
				ActivityCategory activityCategory = new ActivityCategoryJDBC();
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("activitycategory1")) {
					activityCategory.setIdActivityCategory((int) rs.getObject("idactivitycategory"));
					activityCategory.setName((String) rs.getObject("name"));
					activityCategory.setShortDetail((String) rs.getObject("shortdetail"));
					activityCategory.setLongDetail((String) rs.getObject("longdetail"));
					list.add(activityCategory);
				}
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * Gets the all users.
	 *
	 * @param request the request
	 * @return the all users
	 */
	public List<User> getAllUsers(String request) {
		List<User> list = new ArrayList<User>();
		java.sql.Statement stmt = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			stmt = this.conn.createStatement();
			this.rs = stmt.executeQuery(request);
			while ( rs.next() ) {
				ResultSetMetaData resultMeta = rs.getMetaData();
				User user = new UserJDBC();
				if (resultMeta.getTableName(1).equals("person")) {
					user.setIdUser(Integer.parseInt(rs.getObject("iduser").toString()));
					user.setFirstName(rs.getObject("firstname").toString());
					user.setSurName(rs.getObject("surname").toString());
					user.setMobile(rs.getObject("mobile").toString());
					user.setMailAddress(rs.getObject("email").toString());
					user.setAddress(rs.getObject("addressuser").toString());
					try {
						Date date = formatter.parse(rs.getObject("dateofbirth").toString());
						user.setDateOfBirth(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					user.setPassword(rs.getObject("password").toString());
					list.add(user);
				}
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	/**
	 * Gets the all product.
	 *
	 * @param request the request
	 * @return the all product
	 */
	public List<Product> getAllProduct(String request) {
		List<Product> list = new ArrayList<Product>();
		java.sql.Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			this.rs = stmt.executeQuery(request);
			while ( rs.next() ) {
				Product product = new ProductJDBC();
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("product")) {
					product.setId((Integer) rs.getObject("idp"));
					product.setNameProduc((String) rs.getObject("name"));
					product.setQuantity((int) rs.getObject("quantity"));
					product.setPrice((double) rs.getObject("price"));
					product.setCategory((String) rs.getObject("category"));
					product.setQuantity((int) rs.getObject("quantity"));
					list.add(product);
				}
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Gets the all task.
	 *
	 * @param request the request
	 * @return the all task
	 */
	public List<Task> getAllTask(String request) {
		List<Task> list = new ArrayList<Task>();
		java.sql.Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			this.rs = stmt.executeQuery(request);
			while ( rs.next() ) {
				Task task = new TaskJDBC();
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("task")) {
					task.setIdTask((int) rs.getObject("idtask"));
					task.setName((String) rs.getObject("name"));
					task.setDescription((String) rs.getObject("description"));
					task.setIdPlan((int) rs.getObject("idplan"));
					list.add(task);
				}
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * Gets the all plan.
	 *
	 * @param request the request
	 * @return the all plan
	 */
	public List<Plan> getAllPlan(String request) {
		List<Plan> list = new ArrayList<Plan>();
		java.sql.Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			this.rs = stmt.executeQuery(request);
			while ( rs.next() ) {
				Plan plan = new PlanJDBC();
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("plan")) {
					plan.setIdPlan((int) rs.getObject("idplan"));
					plan.setNamePlan((String) rs.getObject("name"));
					plan.setObservationPlan((String) rs.getObject("observations"));
					plan.setDeadline((Date) rs.getObject("deadline"));
					plan.setPublic((Boolean) rs.getObject("public"));
					plan.setTutorial((Boolean) rs.getObject("tutorial"));
					plan.setIdUserCreatePlan((int) rs.getObject("iduser"));
					plan.setActivityCategory((String) rs.getObject("nameactivitycategory"));
					list.add(plan);
				}
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * Gets the random plan.
	 *
	 * @param request the request
	 * @return the random plan
	 */
	public List<Plan> getRandomPlan(String request) {
		List<Plan> list = new ArrayList<Plan>();
		java.sql.Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			this.rs = stmt.executeQuery(request);
			while ( rs.next() ) {
				Plan plan = new PlanJDBC();
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("plan")) {
					plan.setIdPlan((int) rs.getObject("idplan"));
					plan.setNamePlan((String) rs.getObject("name"));
					plan.setObservationPlan((String) rs.getObject("observations"));
					plan.setDeadline((Date) rs.getObject("deadline"));
					plan.setPublic((Boolean) rs.getObject("public"));
					plan.setTutorial((Boolean) rs.getObject("tutorial"));
					plan.setIdUserCreatePlan((int) rs.getObject("iduser"));
					plan.setActivityCategory((String) rs.getObject("nameactivitycategory"));
					list.add(plan);
				}
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * Gets the my plan.
	 *
	 * @param request the request
	 * @return the my plan
	 */
	public List<Plan> getMyPlan(String request) {
		List<Plan> list = new ArrayList<Plan>();
		java.sql.Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			this.rs = stmt.executeQuery(request);
			while ( rs.next() ) {
				Plan plan = new PlanJDBC();
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("plan")) {
					plan.setIdPlan((int) rs.getObject("idplan"));
					plan.setNamePlan((String) rs.getObject("name"));
					plan.setObservationPlan((String) rs.getObject("observations"));
					plan.setDeadline((Date) rs.getObject("deadline"));
					plan.setPublic((Boolean) rs.getObject("public"));
					plan.setTutorial((Boolean) rs.getObject("tutorial"));
					plan.setIdUserCreatePlan((int) rs.getObject("iduser"));
					plan.setActivityCategory((String) rs.getObject("nameactivitycategory"));
					list.add(plan);
				}
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * Delete.
	 *
	 * @param request the request
	 */
	public void delete(String request)
	{
		java.sql.Statement stmt = null;
			try {
				stmt = this.conn.createStatement();
				stmt.executeUpdate(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Execute update.
	 *
	 * @param request the request
	 * @throws SQLException the SQL exception
	 */
	public void executeUpdate(String request) throws SQLException {
		java.sql.Statement stmt = null;
		stmt = this.conn.createStatement();
		stmt.executeUpdate(request);
	}

	/**
	 * Description of the method fetchArray.
	 */
	public void fetchArray() {
	}

	/**
	 * Description of the method nbReponse.
	 *
	 * @return the integer
	 */
	public Integer nbReponse() {
		Integer nbReponse = Integer.valueOf(0);
		return nbReponse;
	}

	/**
	 * Gets the task for plan.
	 *
	 * @param request the request
	 * @return the task for plan
	 */
	public List<Task> getTaskForPlan(String request) {
		List<Task> list = new ArrayList<Task>();
		java.sql.Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			this.rs = stmt.executeQuery(request);
			while ( rs.next() ) {
				Task task = new TaskJDBC();
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("task")) {
					task.setName((String) rs.getObject("name"));
					task.setDescription((String) rs.getObject("description"));
					list.add(task);
				}
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
