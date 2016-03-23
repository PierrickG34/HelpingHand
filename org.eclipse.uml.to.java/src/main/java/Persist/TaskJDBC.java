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

	public TaskJDBC(int idProduct) {
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO contain VALUES ((SELECT CURRVAL(pg_get_serial_sequence('task','idtask'))), '"+idProduct+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public TaskJDBC(String name, String description, int idProduct, int idPlan) {
		super(name, description);
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO task VALUES (DEFAULT, '"+ name + "','"+ description +"','"+idPlan+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new AlreadyExistException("Your task is already used, please choose an other.");
		}
	}
}