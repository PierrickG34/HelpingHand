package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Core.User;

/**
 * The Class PlanManageView.
 * 
 * @author HelpingHand
 */
public class PlanManageView extends JPanel implements ActionListener {

	/** Button for create an activity category. */
	JButton create = new JButton("Create a Plan");

	/** Button for update an activity category. */
	JButton update = new JButton("Update a Plan");

	/** The delete. */
	JButton delete = new JButton("Delete a Plan");

	/** The current user. */
	private User currentUser;

	/** The ViewController. */
	private ViewController vc;

	/** The menu admin view. */
	private MenuAdminView menuAdminView;


	/**
	 * Constructor for the class.
	 *
	 * @param currentUser the current user
	 * @param vc the ViewController
	 */
	public PlanManageView(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(this.vc);
		this.add(menuAdminView);

		/*-------------- Veritable view --------------------*/
		JPanel manageButton = new JPanel();
		JPanel createButton = new JPanel();
		JPanel updateButton = new JPanel();
		JPanel deleteButton = new JPanel();

		this.create.addActionListener(this);
		this.update.addActionListener(this);
		this.delete.addActionListener(this);

		createButton.add(this.create);
		updateButton.add(this.update);
		deleteButton.add(this.delete);

		manageButton.add(createButton);
		manageButton.add(updateButton);
		manageButton.add(deleteButton);

		this.add(manageButton, BorderLayout.WEST);
	}

	/**
	 * Action when the user click on a button.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Create a Plan") {
			this.vc.CreatePlanView();
		}
		else if(source == "Update a Plan") {
			System.out.println("Action pas faite");
		}
		else if(source == "Delete a Plan") {
			this.vc.PlanDeleteView();
		}
	}
}
