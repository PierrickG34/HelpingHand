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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Core.User;
import Core.UserFacade;
import Persist.UserJDBC;

/**
 * The Class UpdateAccountAdminView.
 * @author HelpingHand
 */
public class UpdateAccountAdminView extends JPanel implements ActionListener {

	/** Descriptions for the update Product. */
	JLabel updateProduct = new JLabel(" Update an Account :");

	/** Description for the button submit. */
	JButton submit = new JButton("Submit");

	/** The combo. */
	JComboBox<String> combo = new JComboBox<String>();

	/** Text to choose the account to delete. */
	JLabel chooseProduct = new JLabel("Choose an Account :");

	/** Button who permit to validate the account choosen. */
	JButton chooseProductButton = new JButton("Choose");

	/** Descriptions for the first name of an account. */
	JLabel firstname = new JLabel("Firstname :");

	/** The firstname type. */
	JTextField firstnameEntre = new JTextField("", 15);

	/** Descriptions for the last name of an account. */
	JLabel lastname = new JLabel("Lastname :");

	/** The lastname type. */
	JTextField lastnameEntre = new JTextField("", 15);

	/** Descriptions for the mobile of an accout. */
	JLabel mobile = new JLabel("Mobile :");

	/** The mobile type. */
	JTextField mobileEntre = new JTextField("", 15);

	/** Descriptions for the fate of birth of an account. */
	JLabel dateofbirth = new JLabel("Date of birth :");

	/** The dateofbirth type. */
	JTextField dateofbirthEntre = new JTextField("", 15);

	/** Descriptions for the address of an account. */
	JLabel address = new JLabel("Address :");

	/** The address type. */
	JTextField addressEntre = new JTextField("", 15);

	/** Descriptions for the siret number of an account. */
	JLabel siretnumber = new JLabel("Siret number :");

	/** The siretnumber type. */
	JTextField siretnumberEntre = new JTextField("", 15);

	/** Descriptions for the web site URL of an account. */
	JLabel websiteurl = new JLabel("Website URL :");

	/** The websiteurl type. */
	JTextField websiteurlEntre = new JTextField("", 15);

	/** Descriptions for the pass word of an account. */
	JLabel password = new JLabel("Password :");

	/** The password type. */
	JTextField passwordEntre = new JTextField("", 15);

	/** This panel permit to display information. */
	JPanel panelEditAll = new JPanel(new GridLayout(2,0));

	/** Define the userJDBC. */
	UserJDBC userJDBC;

	/** The current user. */
	private User currentUser;

	/** The ViewController. */
	private ViewController vc;

	/** The menu admin view. */
	private MenuAdminView menuAdminView;

	/**
	 * Description of the property UserFacade.
	 */
	public UserFacade userFacade;

	/** Contain all the account of the database. */
	List<User> allUsers = new ArrayList<User>();


	/**
	 * Instantiates a new update account admin view.
	 *
	 * @param currentUser the current user
	 * @param vc the ViewController
	 */
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

		//Recuperate the user and add to the combobox
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

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
