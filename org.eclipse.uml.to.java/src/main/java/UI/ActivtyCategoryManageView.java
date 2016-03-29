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

public class ActivtyCategoryManageView extends JPanel implements ActionListener {

	/**
	 * Button for create an activity category
	 */
	JButton create = new JButton("Create an Activity Category");
	
	/**
	 * Button for update an activity category
	 */
	JButton update = new JButton("Update an Activity Category");
	
	/**
	 * The current user
	 */
	private User currentUser;
	
	private ViewController vc;
	
	/**
	 * Constructor for the class
	 * @param currentUser
	 */
	public ActivtyCategoryManageView(User currentUser, ViewController vc) {
//		super("Activity Category"); // Name of the frame
		this.currentUser = currentUser;
		this.vc = vc;
  
        /*-------------- Veritable view --------------------*/
        JPanel manageButton = new JPanel(new GridLayout(2, 1));
        JPanel createButton = new JPanel();
        JPanel updateButton = new JPanel();
        
        this.create.addActionListener(this);
        this.update.addActionListener(this);
        
        createButton.add(this.create);
        updateButton.add(this.update);
        
        manageButton.add(createButton);
        manageButton.add(updateButton);
        
//        contentPane.add(manageButton, BorderLayout.WEST);
        this.add(manageButton, BorderLayout.WEST);

	}
	
	/**
	 * Action when the user click on a button
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Create an Activity Category") {
			this.vc.CreateActivityCategoryView();
		}
		else if(source == "Update an Activity Category") {
			this.vc.UpdateActivityCategoryView();
		}
	}
}
