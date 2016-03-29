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

import Core.Plan;
import Core.PlanFacade;
import Core.Task;
import Core.TaskFacade;
import Core.User;

public class PlanDeleteView extends JPanel implements ActionListener {
	
	JButton delete = new JButton("Delete");
	
	/**
	 * Descriptions for the windows
	 */
	JLabel deleteTask = new JLabel(" Delete a Plan :");
	
	/**
	 * Define the drop down menu with the task
	 */
	JComboBox<String> comboPlan = new JComboBox<String>();
	
	/**
	 * Text to choose the activity category to delete
	 */
	JLabel choosePlan = new JLabel("Choose a Plan to delete:");
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public PlanFacade planFacades = new PlanFacade(this);

	/**
	 * Contain all the activity category of the database
	 */
	List<Plan> allPlan = new ArrayList<Plan>();
	
	
	private User currentUser;
	private ViewController vc;
	private MenuAdminView menuAdminView;
	
	public PlanDeleteView(User currentUser, ViewController vc) {
//		super("Plan"); // Name of the frame
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(this.vc);
		this.add(menuAdminView);
        
        /*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel(new GridLayout(2, 1));
		JPanel panelComboBoxPlan = new JPanel(new GridLayout(2, 1));
		JPanel panelComboBoxAllPlan = new JPanel();
		JPanel panelButtonDelete = new JPanel();
		
		//Recuperate the task and add to the combobox
		this.allPlan = this.planFacades.getAllPlan();
		for (int i = 0; i< this.allPlan.size(); i++) {
			this.comboPlan.addItem(this.allPlan.get(i).getNamePlan());
		}
		panelComboBoxPlan.add(this.choosePlan);
		panelComboBoxPlan.add(this.comboPlan);
		panelComboBoxAllPlan.add(panelComboBoxPlan);
		
		panelButtonDelete.add(this.delete);
		this.delete.addActionListener(this);
		
		panelAll.add(panelComboBoxAllPlan);
		panelAll.add(panelButtonDelete);
		
//		contentPane.add(panelAll, BorderLayout.WEST);
		this.add(panelAll, BorderLayout.WEST);
        
      //Display
//        setSize(400,120);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Delete") {
			this.planFacades.deleteTask(this.allPlan.get(this.comboPlan.getSelectedIndex()));
		}
	}
}