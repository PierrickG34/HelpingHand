package Persist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Core.Product;
import Core.Task;
import Excpetion.AlreadyExistException;

/**
 * The Class TaskJDBC.
 * @author Helping Hand
 */
public class TaskJDBC extends Task {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	/**
	 * Instantiates a new taskJDBC.
	 */
	public TaskJDBC() {
		super();
	}

	/**
	 * Instantiates a new taskJDBC.
	 *
	 * @param idProduct the id product
	 */
	public TaskJDBC(int idProduct) {
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO contain VALUES ((SELECT CURRVAL(pg_get_serial_sequence('task','idtask'))), '"+idProduct+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Instantiates a new taskJDBC.
	 *
	 * @param name the name
	 * @param description the description
	 * @param idProduct the id product
	 * @param idPlan the id plan
	 */
	public TaskJDBC(String name, String description, int idProduct, int idPlan) {
		super(name, description);
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO task VALUES (DEFAULT, '"+ name + "','"+ description +"','"+idPlan+"')");
		} catch (SQLException e) {
			throw new AlreadyExistException("Your task is already used, please choose an other.");
		}
	}

	/* (non-Javadoc)
	 * @see Core.Task#getAllTask()
	 */
	@Override
	public List<Task> getAllTask() {
		List<Task> list = new ArrayList<Task>();
		list = this.jDBConnexions.getAllTask("SELECT * FROM task");
		return list;
	}

	/**
	 * Modify task.
	 *
	 * @param task the task
	 * @param description the description
	 * @param product the product
	 */
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
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see Core.Task#delete()
	 */
	@Override
	public void delete() {
		this.jDBConnexions.delete("DELETE FROM task where idtask =" + this.getIdTask());
	}

	/* (non-Javadoc)
	 * @see Core.Task#getTaskForPlan(java.lang.Integer)
	 */
	@Override
	public List<Task> getTaskForPlan(Integer idPlan) {
		List<Task> list = new ArrayList<Task>();
		list = this.jDBConnexions.getTaskForPlan("SELECT t.name, description FROM Task t, Plan p WHERE t.idplan = p.idplan AND p.idplan = "+idPlan+";");
		return list;
	}
}