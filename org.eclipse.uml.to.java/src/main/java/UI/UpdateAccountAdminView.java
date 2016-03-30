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
	import javax.swing.JTextField;
	import javax.swing.SwingConstants;


	import Core.User;
	import Core.UserFacade;
	import Persist.UserJDBC;

	public class UpdateAccountAdminView extends JPanel implements ActionListener {
		
		/**
		 * Descriptions for the windows
		 */
		JLabel updateProduct = new JLabel(" Update an Account :");

		/**
		 * Description for the button validate
		 */
		JButton submit = new JButton("Submit");


		JComboBox<String> combo = new JComboBox<String>();

		/**
		 * Text to choose the activity category to delete
		 */
		JLabel chooseProduct = new JLabel("Choose an Account :");

		/**
		 * Button who permit to validate the activity category choosen
		 */
		JButton chooseProductButton = new JButton("Choose");

		/**
		 * Descriptions for the name of an activity category
		 */
		JLabel firstname = new JLabel("Firstname :");
		JTextField firstnameEntre = new JTextField("", 15);

		/**
		 * Descriptions for the short detail of an activity category
		 */
		JLabel lastname = new JLabel("Lastname :");
		JTextField lastnameEntre = new JTextField("", 15);

		/**
		 * Descriptions for the short detail of an activity category
		 */
		JLabel mobile = new JLabel("Mobile :");
		JTextField mobileEntre = new JTextField("", 15);
		
		/**
		 * Descriptions for the short detail of an activity category
		 */
		JLabel dateofbirth = new JLabel("Date of birth :");
		JTextField dateofbirthEntre = new JTextField("", 15);
		
		/**
		 * Descriptions for the short detail of an activity category
		 */
		JLabel address = new JLabel("Address :");
		JTextField addressEntre = new JTextField("", 15);
		
		/**
		 * Descriptions for the short detail of an activity category
		 */
		JLabel siretnumber = new JLabel("Siret number :");
		JTextField siretnumberEntre = new JTextField("", 15);
		
		/**
		 * Descriptions for the short detail of an activity category
		 */
		JLabel websiteurl = new JLabel("Website URL :");
		JTextField websiteurlEntre = new JTextField("", 15);
		
		/**
		 * Descriptions for the short detail of an activity category
		 */
		JLabel password = new JLabel("Password :");
		JTextField passwordEntre = new JTextField("", 15);
		
		/**
		 * This panel permit to display information 
		 */
		JPanel panelEditAll = new JPanel(new GridLayout(2,0));
		
		/**
		 * Define the current activit category that the admin choose
		 */
		UserJDBC userJDBC;
		
		private User currentUser;
		private ViewController vc;
		private MenuAdminView menuAdminView;

		/**
		 * Description of the property ActivityCategoryFacades.
		 */
		public UserFacade userFacade;
		
		/**
		 * Contain all the activity category of the database
		 */
		List<User> allUsers = new ArrayList<User>();


	public UpdateAccountAdminView(User currentUser, ViewController vc) {
			/* Defined actions on the different buttons */
			this.currentUser = currentUser;
			this.vc = vc;
			this.userFacade = new UserFacade(this.currentUser);
			this.menuAdminView = new MenuAdminView(vc);
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
		 
			// Firstname
	        this.firstname.setPreferredSize(this.firstnameEntre.getPreferredSize());
	        this.firstname.setHorizontalAlignment(SwingConstants.RIGHT);
	        panelLabels.add(this.firstname);
	        panelTextFiel.add(this.firstnameEntre);
	        
	        // Lastname
	        this.lastname.setPreferredSize(this.lastnameEntre.getPreferredSize());
	        this.lastname.setHorizontalAlignment(SwingConstants.RIGHT);
	        panelLabels.add(this.lastname);
	        panelTextFiel.add(this.lastnameEntre);

	        // Mobile
	        this.mobile.setPreferredSize(this.mobileEntre.getPreferredSize());
	        this.mobile.setHorizontalAlignment(SwingConstants.RIGHT);
	        panelLabels.add(this.mobile);
	        panelTextFiel.add(this.mobileEntre);
	        
	        
	        // Date of birth
	        this.dateofbirth.setPreferredSize(this.dateofbirth.getPreferredSize());
	        this.dateofbirth.setHorizontalAlignment(SwingConstants.RIGHT);
	        panelLabels.add(this.dateofbirth);
	        panelTextFiel.add(this.dateofbirthEntre);
	        
	        // Address
	        this.address.setPreferredSize(this.address.getPreferredSize());
	        this.address.setHorizontalAlignment(SwingConstants.RIGHT);
	        panelLabels.add(this.address);
	        panelTextFiel.add(this.addressEntre);
	        
	        // Siret number
	        this.siretnumber.setPreferredSize(this.siretnumber.getPreferredSize());
	        this.siretnumber.setHorizontalAlignment(SwingConstants.RIGHT);
	        panelLabels.add(this.siretnumber);
	        panelTextFiel.add(this.siretnumberEntre);
	        
	        // Website URL
	        this.websiteurl.setPreferredSize(this.websiteurl.getPreferredSize());
	        this.websiteurl.setHorizontalAlignment(SwingConstants.RIGHT);
	        panelLabels.add(this.websiteurl);
	        panelTextFiel.add(this.websiteurlEntre);
	        
	        
	        // Password
	        this.password.setPreferredSize(this.password.getPreferredSize());
	        this.password.setHorizontalAlignment(SwingConstants.RIGHT);
	        panelLabels.add(this.password);
	        panelTextFiel.add(this.passwordEntre);
	        
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

		@Override
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();
			if(source == "Choose") {
				this.panelEditAll.setVisible(true);
			}
			if(source == "Submit") {
				this.userFacade.modifyAccount(this.allUsers.get(this.combo.getSelectedIndex()),this.firstnameEntre.getText(),this.lastnameEntre.getText(),this.mobileEntre.getText(),this.dateofbirthEntre.getText(),this.addressEntre.getText(),this.siretnumberEntre.getText(),this.websiteurlEntre.getText(),this.passwordEntre.getText());
				this.vc.AccountAdminView();
			}
		}
}
