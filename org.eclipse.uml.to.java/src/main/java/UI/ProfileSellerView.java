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

public class ProfileSellerView extends JPanel implements ActionListener {
	
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
	 * Description for the siretNumber information
	 */
	JLabel siretNumber = new JLabel("");
	
	/**
	 * Description for the website URL information
	 */
	JLabel websiteURL = new JLabel("");

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
	private MenuSellerView menuSellerView;


	// Start of user code (user defined attributes for LoginView)

	// End of user code

	/**
	 * The constructor who create the window
	 */
	public ProfileSellerView(User currentUser, ViewController vc) {
//		super("Profile"); // Name of the frame
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuSellerView = new MenuSellerView(this.vc);
		this.add(menuSellerView);


		/*##### Display the information of the user #####*/
		this.firstName.setText(this.currentUser.getFirstName());
		this.firstName.setHorizontalAlignment(JLabel.CENTER);
		this.surName.setText(this.currentUser.getSurName());
		this.surName.setHorizontalAlignment(JLabel.CENTER);
		this.mobile.setText(this.currentUser.getMobile());
		this.mobile.setHorizontalAlignment(JLabel.CENTER);
		this.mail.setText(this.currentUser.getMailAddress());
		this.mail.setHorizontalAlignment(JLabel.CENTER);
		this.websiteURL.setText(this.currentUser.getWebsiteURL());
		this.websiteURL.setHorizontalAlignment(JLabel.CENTER);
		this.siretNumber.setText(this.currentUser.getSiretNumber());
		this.siretNumber.setHorizontalAlignment(JLabel.CENTER);
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// Get the date today using Calendar object.
		Date dateOfBirthToParse = this.currentUser.getDateOfBirth();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(dateOfBirthToParse);
		this.dateOfBirth.setText(reportDate);
		this.dateOfBirth.setHorizontalAlignment(JLabel.CENTER);
		this.password.setText(this.currentUser.getPassword());
		this.password.setHorizontalAlignment(JLabel.CENTER);
		this.address.setText(this.currentUser.getAddress());
		this.address.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel panelAll = new JPanel();
		JPanel panelInformations = new JPanel(new GridLayout(9,1));
		JPanel panelButtonValidate = new JPanel();
		panelInformations.add(this.firstName);
		panelInformations.add(this.surName);
		panelInformations.add(this.mobile);
		panelInformations.add(this.mail);
		panelInformations.add(this.dateOfBirth);
		panelInformations.add(this.password);
		panelInformations.add(this.address);
		panelInformations.add(this.siretNumber);
		panelInformations.add(this.websiteURL);
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
			this.vc.ProfileSellerModifyView();
		}

	}

}
