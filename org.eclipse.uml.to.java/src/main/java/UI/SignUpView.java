package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Core.User;
import Core.UserFacade;
import Excpetion.AlreadyExistException;
import Persist.DateLabelFormatter;

/**
 * The Class SignUpView.
 * @author HelpingHand
 */
public class SignUpView extends JFrame implements ActionListener {

	/** Permit to validate the sign up. */
	JButton validate = new JButton("Validate");

	/** Permit to cancel the sign up. */
	JButton cancel = new JButton("Cancel");

	/** Description for the firstname information. */
	JLabel firstName = new JLabel("Enter a first name :*");

	/** The first name type. */
	JTextField firstNameEntre = new JTextField("", 10);

	/** Description for the surname information. */
	JLabel surName = new JLabel("Enter a sur name :*");

	/** The surname type. */
	JTextField surNameEntre = new JTextField("", 10);

	/** Description for the mobile information. */
	JLabel mobile = new JLabel("Enter a mobile :*");

	/** The mobile type. */
	JTextField mobileEntre = new JTextField("", 10);

	/** Description for the mail address information. */
	JLabel mail = new JLabel("Enter an mail :*");

	/** The mail type. */
	JTextField mailEntre = new JTextField("", 10);

	/** Description for date of birth. */
	JLabel dateOfBirth = new JLabel("Enter a date of birth :*");

	/** The model. */
	UtilDateModel model = new UtilDateModel();

	/** The date panel. */
	JDatePanelImpl datePanel;

	/** The date picker. */
	JDatePickerImpl datePicker;

	/** Description for the password information. */
	JLabel password = new JLabel("Password:*");

	/** The password type. */
	JPasswordField passwordEntre = new JPasswordField("", 15);

	/** Description for the address information. */
	JLabel address = new JLabel("Enter an address :*");

	/** The address type. */
	JTextField addressEntre = new JTextField("", 10);

	/** Description for the siret number information. */
	JLabel siret = new JLabel("Enter SIRET number :");

	/** The siret type. */
	JTextField siretEntre = new JTextField("", 10);

	/** Description for the websiteURL information. */
	JLabel websiteURL = new JLabel("Enter a website URL :");

	/** The website url type. */
	JTextField websiteURLEntre = new JTextField("", 10);

	/** Describe error message. */
	JLabel errorMessage = new JLabel("");

	/**
	 * Description of the property userFacades.
	 */
	public UserFacade userFacades = new UserFacade(this);


	/**
	 * The constructor who create the window.
	 */
	public SignUpView() {
		super("Sign Up");
		this.validate.addActionListener(this);
		this.cancel.addActionListener(this);
		Container contentPane = getContentPane(); 
		contentPane.setLayout(new BorderLayout()); 
		setMinimumSize(new Dimension(1000,500));
		setMaximumSize(new Dimension(1000,500));

		JPanel panelSignUp = new JPanel();
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextField = new JPanel(new GridLayout(0,1));
		JPanel panelButtonEnd = new JPanel();

		//FirstName
		this.firstName.setPreferredSize(this.firstNameEntre.getPreferredSize());
		this.firstName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.firstName);
		panelTextField.add(this.firstNameEntre);
		//Surname
		this.surName.setPreferredSize(this.surNameEntre.getPreferredSize());
		this.surName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.surName);
		panelTextField.add(this.surNameEntre);
		//Mobile number
		this.mobile.setPreferredSize(this.mobileEntre.getPreferredSize());
		this.mobile.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.mobile);
		panelTextField.add(this.mobileEntre);
		//Mail address
		this.mail.setPreferredSize(this.mailEntre.getPreferredSize());
		this.mail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.mail);
		panelTextField.add(this.mailEntre);
		//DateOfBirth
		this.dateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.dateOfBirth);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		this.datePanel = new JDatePanelImpl(model, p);
		this.datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panelTextField.add(datePicker);
		//Password
		this.password.setPreferredSize(this.passwordEntre.getPreferredSize());
		this.password.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.password);
		panelTextField.add(this.passwordEntre);
		//Address
		this.address.setPreferredSize(this.addressEntre.getPreferredSize());
		this.address.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.address);
		panelTextField.add(this.addressEntre);
		//SIRET number
		this.siret.setPreferredSize(this.siretEntre.getPreferredSize());
		this.siret.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.siret);
		panelTextField.add(this.siretEntre);
		//WebSite URL
		this.websiteURL.setPreferredSize(this.websiteURLEntre.getPreferredSize());
		this.websiteURL.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.websiteURL);
		panelTextField.add(this.websiteURLEntre);

		this.errorMessage.setHorizontalAlignment(JLabel.CENTER);
		this.errorMessage.setVisible(false);

		panelButtonEnd.add(this.errorMessage);
		panelButtonEnd.add(this.validate);
		panelButtonEnd.add(this.cancel);

		panelSignUp.add(panelLabels);
		panelSignUp.add(panelTextField);

		contentPane.add(panelSignUp, BorderLayout.CENTER);
		contentPane.add(panelButtonEnd,BorderLayout.SOUTH);

		// Display
		setSize(400,120);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Check if the mobile number is correct or not (10 int is a valid format).
	 *
	 * @param enteredMobile the entered mobile
	 * @return true, if is valid mobile
	 */
	public static boolean isValidMobile(String enteredMobile){
		String EMAIL_REGIX = "(0)[1-9][0-9]{8}";
		Pattern pattern = Pattern.compile(EMAIL_REGIX);
		Matcher matcher = pattern.matcher(enteredMobile);
		return ((!enteredMobile.isEmpty()) && (enteredMobile!=null) && (matcher.matches()));
	}


	/**
	 * Check if the mail address is valid or not ("xx@xx.xx" is a valid format) 
	 * @param enteredEmail Mail address enter by the user
	 * @return Boolean if the email address is valid, or not
	 */
	public static boolean isValidEmail(String enteredEmail){
		String EMAIL_REGIX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_REGIX);
		Matcher matcher = pattern.matcher(enteredEmail);
		return ((!enteredEmail.isEmpty()) && (enteredEmail!=null) && (matcher.matches()));
	}

	/**
	 * Encrypt in md5 format the password enter by the user.
	 *
	 * @param mdp the mdp
	 * @return the string encrypted in md5 format
	 */
	public String encrypt(String mdp) {
		String passwordToEncript = mdp;

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(passwordToEncript.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}

		return sb.toString();
	}


	/**
	 * Action when the user click on the button validate.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Validate") {
			/* Get the date in a String*/
			int day = this.datePicker.getModel().getDay();
			int month = this.datePicker.getModel().getMonth() + 1;
			int year = this.datePicker.getModel().getYear();
			String date = day + "-" + month + "-" + year;

			/* Clean error message */
			this.errorMessage.setVisible(false);
			this.firstName.setForeground(Color.black);
			this.surName.setForeground(Color.black);
			this.mobile.setForeground(Color.black);
			this.mail.setForeground(Color.black);
			this.dateOfBirth.setForeground(Color.black);
			this.password.setForeground(Color.black);
			this.address.setForeground(Color.black);

			/* Test if the user fill alls field */
			int count = 0;
			if(this.firstNameEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a first name please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.firstName.setForeground(Color.red);
				count++;
			}
			if (this.surNameEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a sur name please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.surName.setForeground(Color.red);
				count++;
			}
			if (this.mobileEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a mobile please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.mobile.setForeground(Color.red);
				count++;
			}
			if (!isValidMobile(this.mobileEntre.getText())) {
				this.errorMessage.setText("Mobile number invalid");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.mobile.setForeground(Color.red);
				count++;
			}
			if (this.mailEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a mail address please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.mail.setForeground(Color.red);
				count++;
			}
			if (!isValidEmail(this.mailEntre.getText())) {
				this.errorMessage.setText("Enter a valide mail address please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.mail.setForeground(Color.red);
				count++;
			}

			if (date.isEmpty()) {
				this.errorMessage.setText("Enter a date please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.dateOfBirth.setForeground(Color.red);
				count++;
			}
			if (String.valueOf((this.passwordEntre.getPassword())).isEmpty()) {
				this.errorMessage.setText("Enter a password please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.password.setForeground(Color.red);
				count++;
			}
			if (this.addressEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter an address please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.address.setForeground(Color.red);
				count++;
			}
			if(count > 2) {
				this.errorMessage.setText("Please complete all fields");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
			}

			/* If all the fiels are fills, we save*/
			if(!this.firstNameEntre.getText().isEmpty() && !this.surNameEntre.getText().isEmpty() && !this.mobileEntre.getText().isEmpty()
					&& isValidMobile(this.mobileEntre.getText()) && !this.mailEntre.getText().isEmpty() && isValidEmail((this.mailEntre.getText())) && !date.isEmpty() && !String.valueOf((this.passwordEntre.getPassword())).isEmpty() 
					&& !this.addressEntre.getText().isEmpty()) {
				String passwordEncrypted = encrypt(String.valueOf((this.passwordEntre.getPassword())));

				/* Cast date to a valid format for postgresql database*/
				java.util.Date dateOfUser = (Date) datePicker.getModel().getValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				final String stringDate= dateFormat.format(dateOfUser);
				final java.sql.Date valideDateUser =  java.sql.Date.valueOf(stringDate);

				/* Insert the user in the database */
				try {
					User newUser = this.userFacades.signUp(this.firstNameEntre.getText(), this.surNameEntre.getText(), this.mobileEntre.getText(), 
							this.mailEntre.getText(), passwordEncrypted, valideDateUser, this.websiteURLEntre.getText(),
							this.siretEntre.getText(), this.addressEntre.getText());
					LoginView loginV = new LoginView();
					this.dispose();
				}
				catch (AlreadyExistException errorSignUp) {
					this.errorMessage.setText(errorSignUp.getNameError());
					this.errorMessage.setForeground(Color.red);
					this.mail.setForeground(Color.red);
					this.errorMessage.setVisible(true);
				}
			}
			else {
				System.out.println("Pas tout remplit");
			}
		}
		else if (source == "Cancel") {
			LoginView loginV = new LoginView();
			this.dispose();
		}

	}

}
