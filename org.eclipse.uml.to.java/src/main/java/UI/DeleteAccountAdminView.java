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

import Core.User;
import Core.UserFacade;
import Persist.UserJDBC;

/**
	 * The Class DeleteAccountAdminView.
	 * 
	 * @author HelpingHand
	 */
	public class DeleteAccountAdminView extends JPanel implements ActionListener {
		
		
		/** Descriptions for the windows. */
		JLabel updateProduct = new JLabel(" Update an Account :");

		/** Description for the button validate. */
		JButton submit = new JButton("Submit");


		/** The combo. */
		JComboBox<String> combo = new JComboBox<String>();

		/** Text to choose the activity category to delete. */
		JLabel chooseProduct = new JLabel("Choose an Account :");

		/** Button who permit to validate the activity category choosen. */
		JButton chooseProductButton = new JButton("Delete");

		/** This panel permit to display information. */
		JPanel panelEditAll = new JPanel(new GridLayout(2,0));
		
		/** Define the current activit category that the admin choose. */
		UserJDBC userJDBC;
		
		/** The current user. */
		private User currentUser;
		
		/** The menu admin view. */
		private MenuAdminView menuAdminView;

		/**
		 * Description of the property ActivityCategoryFacades.
		 */
		public UserFacade userFacade;
		
		/** Contain all the activity category of the database. */
		List<User> allUsers = new ArrayList<User>();

		/** The View Controller. */
		private ViewController vc;

	/**
	 * Instantiates a new delete account admin view.
	 *
	 * @param currentUser the current user
	 * @param vc the ViewController
	 */
	public DeleteAccountAdminView(User currentUser, ViewController vc) {
//			super("DashBoard"); // Name of the frame
			/* Defined actions on the different buttons */
			this.currentUser = currentUser;
			this.vc = vc;
			this.userFacade = new UserFacade(this.currentUser);
			this.menuAdminView = new MenuAdminView(this.vc);
			this.add(menuAdminView);
			
			/*-------------- Veritable view --------------------*/
			JPanel panelAll = new JPanel(new GridLayout(1, 2));
			JPanel panelSemiAll = new JPanel();
			JPanel panelEdit = new JPanel();
			JPanel panelButtonValidate = new JPanel();
			JPanel panelComboBox = new JPanel(new GridLayout(3, 1));
			JPanel panelLabels = new JPanel(new GridLayout(0,1));
			JPanel panelTextFiel = new JPanel(new GridLayout(0,1));

			this.submit.addActionListener(this);
			this.chooseProductButton.addActionListener(this);

			//Recuperate the product and add to the combobox
			this.allUsers = this.userFacade.getAllUsers();
			for (int i = 0; i< this.allUsers.size(); i++) {
				this.combo.addItem(this.allUsers.get(i).getFirstName());
			}
			panelComboBox.add(this.chooseProduct);
			panelComboBox.add(this.combo);
			panelComboBox.add(this.chooseProductButton);
	        
			panelButtonValidate.add(submit, BorderLayout.CENTER);
	        panelSemiAll.add(panelComboBox);
	        panelAll.add(panelSemiAll);
			panelEdit.add(panelLabels);
			panelEdit.add(panelTextFiel);
			this.panelEditAll.setVisible(false);
			this.panelEditAll.add(panelEdit);
			this.panelEditAll.add(panelButtonValidate);
			panelAll.add(this.panelEditAll);

			this.add(panelAll);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();
			if(source == "Delete") {
				
				System.out.println(this.combo.getSelectedItem());
				System.out.println("1 : "+this.combo.getSelectedIndex());
				System.out.println(this.allUsers.get(0));
				System.out.println(this.allUsers.get(0).getFirstName());
				this.panelEditAll.setVisible(true);
			}
			if(source == "Submit") {
				this.userFacade.deleteAccount(this.allUsers.get(this.combo.getSelectedIndex()));
				this.vc.DeleteAccountAdminView();
			}
		}
}