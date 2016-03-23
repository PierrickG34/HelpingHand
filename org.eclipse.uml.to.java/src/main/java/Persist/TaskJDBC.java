package Persist;

import java.sql.SQLException;

import Core.Task;
import Excpetion.AlreadyExistException;

public class TaskJDBC extends Task {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	//public JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	public TaskJDBC() {
		super();
	}

	public TaskJDBC(String name, String description) {
		super(name, description);
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO task VALUES (DEFAULT, '"+ name + "','"+ description +"','4')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new AlreadyExistException("Your task is already used, please choose an other.");
		}
	}
}