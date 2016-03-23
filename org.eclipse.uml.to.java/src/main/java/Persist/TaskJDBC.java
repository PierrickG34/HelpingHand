package Persist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Core.ActivityCategory;
import Core.Product;
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

	@Override
	public List<Task> getAllTask() {
		List<Task> list = new ArrayList<Task>();
		list = this.jDBConnexions.getAllTask("SELECT * FROM task");
		return list;
	}

	public void modifyTask(Task task, String description, Product product) {
		if (description.isEmpty()) {
			description = this.getDescription();
		}
		else {
			this.setDescription(description);
		}
		try {
			this.jDBConnexions.executeUpdate("UPDATE task SET description = '"+ description +"' where idtask = '"+task.getIdTask()+"'");
			this.jDBConnexions.executeUpdate(("UPDATE contain SET idproduct = '"+product.getId()+"' WHERE idtask = '"+task.getIdTask()+"'"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}