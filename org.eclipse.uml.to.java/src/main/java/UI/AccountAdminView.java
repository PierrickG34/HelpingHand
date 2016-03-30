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

public class AccountAdminView extends JPanel implements ActionListener {
		
		JButton update = new JButton("Update an Account");
		JButton delete = new JButton("Delete an Account");
		
		
		private User currentUser;
		
		private ViewController vc;
		private MenuAdminView menuAdminView;
		
		public AccountAdminView(User currentUser, ViewController vc) {
//			super("Product"); // Name of the frame
			/* Defined actions on the different buttons */
			
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
