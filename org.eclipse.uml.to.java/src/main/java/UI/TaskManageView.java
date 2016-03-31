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

// TODO: Auto-generated Javadoc
/**
 * The Class TaskManageView.
 */
public class TaskManageView extends JPanel implements ActionListener {
	
	/** The create. */
	JButton create = new JButton("Create a Task");
	
	/** The update. */
	JButton update = new JButton("Update a Task");
	
	/** The delete. */
	JButton delete = new JButton("Delete a Task");
	
	
	/** The current user. */
	private User currentUser;
	
	/** The vc. */
	private ViewController vc;
	
	/** The menu admin view. */
	private MenuAdminView menuAdminView;
	
	/**
	 * Instantiates a new task manage view.
	 *
	 * @param currentUser the current user
	 * @param vc the vc
	 */
	public TaskManageView(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(vc);
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
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Create a Task") {
			this.vc.TaskCreateView();
		}
		else if(source == "Update a Task") {
			this.vc.TaskUpdateView();
		}
		else if(source == "Delete a Task") {
			this.vc.TaskDeleteView();
		}
	}
}
