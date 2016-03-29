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

	public class DeleteAccountAdminView extends JPanel implements ActionListener {
		
		
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
		JButton chooseProductButton = new JButton("Delete");

		/**
		 * This panel permit to display information 
		 */
		JPanel panelEditAll = new JPanel(new GridLayout(2,0));
		
		/**
		 * Define the current activit category that the admin choose
		 */
		UserJDBC userJDBC;
		
		private User currentUser;
		private MenuAdminView menuAdminView;

		/**
		 * Description of the property ActivityCategoryFacades.
		 */
		public UserFacade userFacade;
		
		/**
		 * Contain all the activity category of the database
		 */
		List<User> allUsers = new ArrayList<User>();

		private ViewController vc;

	public DeleteAccountAdminView(User currentUser, ViewController vc) {
//			super("DashBoard"); // Name of the frame
			/* Defined actions on the different buttons */
			this.currentUser = currentUser;
			this.vc = vc;
			this.userFacade = new UserFacade(this.currentUser);
			this.menuAdminView = new MenuAdminView(this.vc);
			this.add(menuAdminView);
			
			/*-------------- Veritable view --------------------*/
			JPanel panelAll = new JPanel();
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
			panelAll.add(panelComboBox);
			panelEdit.add(panelLabels);
			panelEdit.add(panelTextFiel);
			this.panelEditAll.setVisible(false);
			this.panelEditAll.add(panelEdit);
			this.panelEditAll.add(panelButtonValidate);
			panelAll.add(this.panelEditAll);

//			contentPane.add(panelAll, BorderLayout.WEST);
			this.add(panelAll, BorderLayout.WEST);

			//Display
//			setSize(400,120);
//			setVisible(true);
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();
			if(source == "Delete") {
				
				System.out.println(this.combo.getSelectedItem());
				System.out.println("1 : "+this.combo.getSelectedIndex());
				System.out.println(this.allUsers.get(0));
				System.out.println(this.allUsers.get(0).getFirstName());
				this.panelEditAll.setVisible(true);
				
				
				/* Aller dans la base de données avec l'id de la category*/
//				this.currentActivityCategory = new ActivityCategoryJDBC("1", "2", "3", "4");
//				this.nameActivityCategoryEntre.setToolTipText(this.currentActivityCategory.getName());
//				this.shortDetailActivityCategoryEntre.setToolTipText(this.currentActivityCategory.getShortDetail());
//				this.longDetailActivityCategoryEntre.setToolTipText(this.currentActivityCategory.getLongDetail());
			}
			if(source == "Submit") {
				this.userFacade.deleteAccount(this.allUsers.get(this.combo.getSelectedIndex()));
			}
		}
}