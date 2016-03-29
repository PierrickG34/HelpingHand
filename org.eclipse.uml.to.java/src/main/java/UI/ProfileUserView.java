package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Core.User;

public class ProfileUserView extends JPanel implements ActionListener {
	
	/**
	 * Description for the firstname information
	 */
	JLabel informations = new JLabel(" Informations: ");


	/**
	 * Description for the firstname information
	 */
	JLabel firstName = new JLabel("");

	/**
	 * Description for the surname information
	 */
	JLabel surName = new JLabel("");

	/**
	 * Description for the mobile information
	 */
	JLabel mobile = new JLabel("");

	/**
	 * Description for the mail information
	 */
	JLabel mail = new JLabel("");

	/**
	 * Description for the dateOfBirth information
	 */
	JLabel dateOfBirth = new JLabel("");

	/**
	 * Description for the password information
	 */
	JLabel password = new JLabel("");

	/**
	 * Description for the address information
	 */
	JLabel address = new JLabel("");

	/**
	 * Description for the button permits to modify this informations
	 */
	JButton modify = new JButton("Modify informations");

	/**
	 * 
	 */
	private User currentUser;
	private ViewController vc;
	private MenuUserView menuUserView;


	// Start of user code (user defined attributes for LoginView)

	// End of user code

	/**
	 * The constructor who create the window
	 */
	public ProfileUserView(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuUserView = new MenuUserView(this.vc);
		this.add(menuUserView);

		/*##### Display the information of the user #####*/
		this.firstName.setText("Name: " + this.currentUser.getFirstName());
		this.firstName.setHorizontalAlignment(JLabel.CENTER);
		this.surName.setText("First name: " + this.currentUser.getSurName());
		this.surName.setHorizontalAlignment(JLabel.CENTER);
		this.mobile.setText("Mobile: " + this.currentUser.getMobile());
		this.mobile.setHorizontalAlignment(JLabel.CENTER);
		this.mail.setText("Mail: " + this.currentUser.getMailAddress());
		this.mail.setHorizontalAlignment(JLabel.CENTER);
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// Get the date today using Calendar object.
		Date dateOfBirthToParse = this.currentUser.getDateOfBirth();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(dateOfBirthToParse);
		this.dateOfBirth.setText("Date of birth: " + reportDate);
		this.dateOfBirth.setHorizontalAlignment(JLabel.CENTER);
		this.password.setText("Password: " + this.currentUser.getPassword());
		this.password.setHorizontalAlignment(JLabel.CENTER);
		this.address.setText("Address: " + this.currentUser.getAddress());
		this.address.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel panelAll = new JPanel();
		JPanel panelInformations = new JPanel(new GridLayout(7,1));
		JPanel panelButtonValidate = new JPanel();
		panelInformations.add(this.firstName);
		panelInformations.add(this.surName);
		panelInformations.add(this.mobile);
		panelInformations.add(this.mail);
		panelInformations.add(this.dateOfBirth);
		panelInformations.add(this.password);
		panelInformations.add(this.address);
		panelButtonValidate.add(this.modify);
		this.modify.addActionListener(this);

		
		panelAll.add(panelInformations, BorderLayout.WEST);
		panelAll.add(panelButtonValidate,  BorderLayout.SOUTH);
		this.add(panelAll);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Modify informations") {
			this.vc.ProfileUserModifyView();
		}

	}

}
