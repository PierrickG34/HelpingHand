package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.Plan;
import Core.PlanFacade;
import Core.User;

/**
 * The Class PlanDeleteView.
 * 
 * @author HelpingHand
 */
public class PlanDeleteView extends JPanel implements ActionListener {

	/** The delete button. */
	JButton delete = new JButton("Delete");

	/** Descriptions for the windows. */
	JLabel deleteTask = new JLabel(" Delete a Plan :");

	/** Define the drop down menu with the task. */
	JComboBox<String> comboPlan = new JComboBox<String>();

	/** Text to choose the plan to delete. */
	JLabel choosePlan = new JLabel("Choose a Plan to delete:");

	/**
	 * Description of the property PlanFacades.
	 */
	public PlanFacade planFacades = new PlanFacade(this);

	/** Contain all the plan of the database. */
	List<Plan> allPlan = new ArrayList<Plan>();


	/** The current user. */
	private User currentUser;

	/** The ViewController. */
	private ViewController vc;

	/** The menu admin view. */
	private MenuAdminView menuAdminView;

	/**
	 * Instantiates a new plan delete view.
	 *
	 * @param currentUser the current user
	 * @param vc the ViewController
	 */
	public PlanDeleteView(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(this.vc);
		this.add(menuAdminView);

		/*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel();
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

		this.add(panelAll, BorderLayout.WEST);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Delete") {
			this.planFacades.deleteTask(this.allPlan.get(this.comboPlan.getSelectedIndex()));
			this.vc.PlanManageView();
		}
	}
}