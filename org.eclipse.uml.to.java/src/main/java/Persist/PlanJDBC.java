package Persist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Core.ActivityCategory;
import Core.Plan;
import Core.Product;
import Core.Task;
import Excpetion.AlreadyExistException;

public class PlanJDBC extends Plan {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	//public JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	/**
	 * 
	 */
	public PlanJDBC() {
		super();
	}
	
	public PlanJDBC(String name, String observation, Date deadline, boolean tutorial, boolean isPublic,
			ActivityCategory ac, int idUser) {
		super(name, observation, deadline, tutorial, isPublic, ac, idUser);
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO Plan VALUES (DEFAULT, '"+ name + "','"+ observation +"','" + deadline + "','" + isPublic + "','false','RIEN',"+ idUser +",'"+ac.getName()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Plan> getAllPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public List<Task> getAllTask() {
//		List<Task> list = new ArrayList<Task>();
//		list = this.jDBConnexions.getAllTask("SELECT * FROM task");
//		return list;
//	}
//
//	public void modifyTask(Task task, String description, Product product) {
//		if (description.isEmpty()) {
//			description = this.getDescription();
//		}
//		else {
//			this.setDescription(description);
//		}
//		try {
//			this.jDBConnexions.executeUpdate("UPDATE task SET description = '"+ description +"' where idtask = '"+task.getIdTask()+"'");
//			this.jDBConnexions.executeUpdate(("UPDATE contain SET idproduct = '"+product.getId()+"' WHERE idtask = '"+task.getIdTask()+"'"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void delete() {
//		this.jDBConnexions.delete("DELETE FROM task where idtask =" + this.getIdTask());
//	}
//
//	public void modifyPlan(Plan plan, String name, String observation, Date deadline, boolean tutorial,
//			boolean isPublic, ActivityCategory ac) {
//	}
}