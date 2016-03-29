package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Core.User;

public class PlanManageView extends JPanel implements ActionListener {

	/**
	 * Button for create an activity category
	 */
	JButton create = new JButton("Create a Plan");
	
	/**
	 * Button for update an activity category
	 */
	JButton update = new JButton("Update a Plan");
	
	JButton delete = new JButton("Delete a Plan");
	
	/**
	 * The current user
	 */
	private User currentUser;
	private ViewController vc;
	private MenuAdminView menuAdminView;

	
	/**
	 * Constructor for the class
	 * @param currentUser
	 */
	public PlanManageView(User currentUser, ViewController vc) {
//		super("Plan"); // Name of the frame
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(this.vc);
		this.add(menuAdminView);
  
        /*-------------- Veritable view --------------------*/
        JPanel manageButton = new JPanel(new GridLayout(3, 1));
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
        
//        contentPane.add(manageButton, BorderLayout.WEST);
        this.add(manageButton, BorderLayout.WEST);

        //Display
//        setSize(400,120);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Action when the user click on a button
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Create a Plan") {
			this.vc.CreatePlanView();
		}
		else if(source == "Update a Plan") {
		//UPDATE
		}
		else if(source == "Delete a Plan") {
			this.vc.PlanDeleteView();
		}
	}
}
