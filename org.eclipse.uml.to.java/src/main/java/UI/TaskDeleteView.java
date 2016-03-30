package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.Task;
import Core.TaskFacade;
import Core.User;

public class TaskDeleteView extends JPanel implements ActionListener {
	
	JButton delete = new JButton("Delete");
	
	/**
	 * Descriptions for the windows
	 */
	JLabel deleteTask = new JLabel("  Delete a Task :");
	
	/**
	 * Define the drop down menu with the task
	 */
	JComboBox<String> comboTask = new JComboBox<String>();
	
	/**
	 * Text to choose the activity category to delete
	 */
	JLabel chooseTask = new JLabel("Choose a Task to delete:");
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public TaskFacade taskFacades = new TaskFacade(this);

	/**
	 * Contain all the activity category of the database
	 */
	List<Task> allTask = new ArrayList<Task>();
	
	
	private User currentUser;
	private ViewController vc;
	private MenuAdminView menuAdminView;
	
	
	public TaskDeleteView(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(vc);
		this.add(menuAdminView);
		
        /*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel();
		JPanel panelComboBoxTask = new JPanel(new GridLayout(2, 1));
		JPanel panelComboBoxAllTask = new JPanel();
		JPanel panelButtonDelete = new JPanel();
		
		//Recuperate the task and add to the combobox
		this.allTask = this.taskFacades.getAllTask();
		for (int i = 0; i< this.allTask.size(); i++) {
			this.comboTask.addItem(this.allTask.get(i).getName());
		}
		panelComboBoxTask.add(this.chooseTask);
		panelComboBoxTask.add(this.comboTask);
		panelComboBoxAllTask.add(panelComboBoxTask);
		
		panelButtonDelete.add(this.delete);
		this.delete.addActionListener(this);
		
		panelAll.add(panelComboBoxAllTask);
		panelAll.add(panelButtonDelete);
		
		this.add(panelAll, BorderLayout.WEST);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Delete") {
			this.taskFacades.deleteTask(this.allTask.get(this.comboTask.getSelectedIndex()));
			this.vc.TaskDeleteView();
		}
	}
}