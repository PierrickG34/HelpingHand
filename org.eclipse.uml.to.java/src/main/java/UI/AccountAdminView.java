package UI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Core.User;

/**
 * The Class AccountAdminView.
 * 
 * @author HelpingHand
 */
public class AccountAdminView extends JPanel implements ActionListener {
		
		/** The update. */
		JButton update = new JButton("Update an Account");
		
		/** The delete. */
		JButton delete = new JButton("Delete an Account");
		
		
		/** The current user. */
		private User currentUser;
		
		/** The vc. */
		private ViewController vc;
		
		/** The menu admin view. */
		private MenuAdminView menuAdminView;
		
		/**
		 * Instantiates a new account admin view.
		 *
		 * @param currentUser the current user
		 * @param vc the vc
		 */
		public AccountAdminView(User currentUser, ViewController vc) {
			this.currentUser = currentUser;
			this.vc = vc;
			this.menuAdminView = new MenuAdminView(this.vc);
			this.add(menuAdminView);
			
	        /*-------------- Veritable view --------------------*/
	        JPanel manageButton = new JPanel();
	        JPanel updateButton = new JPanel();
	        JPanel deleteButton = new JPanel();
	        
	        this.update.addActionListener(this);
	        this.delete.addActionListener(this);
	        
	        updateButton.add(this.update);
	        deleteButton.add(this.delete);
	        
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
			if(source == "Update an Account") {
				this.vc.UpdateAccountAdminView();
			}
			else if(source == "Delete an Account") {
				this.vc.DeleteAccountAdminView();
			}
		}
}
