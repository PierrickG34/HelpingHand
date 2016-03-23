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

import Core.ActivityCategory;
import Core.ActivityCategoryFacade;
import Core.Task;
import Core.TaskFacade;
import Core.User;
import Persist.ActivityCategoryJDBC;

public class TaskUpdateView extends JFrame implements ActionListener {

	JButton dashboard = new JButton("Dashboard");
	JButton activityCategory = new JButton("Activity Category");
	JButton productCategory = new JButton("Product Category");
	JButton product = new JButton("Product");
	JButton account = new JButton("Account");
	JButton plan = new JButton("Plan");
	JButton task = new JButton("Task");

	JButton profile = new JButton("Profile");
	JButton notifications = new JButton("Notifications");
	
	/**
	 * Descriptions for the windows
	 */
	JLabel updateTask = new JLabel("  Update a Task :");

	/**
	 * Description for the button validate
	 */
	JButton submit = new JButton("Submit");


	/**
	 * Define the drop down menu with the activity category
	 */
	JComboBox<String> combo = new JComboBox<String>();

	/**
	 * Text to choose the activity category to delete
	 */
	JLabel chooseTask = new JLabel("Choose a Task  :");

	/**
	 * Button who permit to validate the activity category choosen
	 */
	JButton chooseActivityCategoryButton = new JButton("Choose");
	
	/**
	 * Descriptions for the name of a task
	 */
	JLabel name = new JLabel("Name :");
	JTextField nameEntre = new JTextField("", 15);

	/**
	 * Descriptions for the description of a task
	 */
	JLabel description = new JLabel("Description :");
	JTextField descriptionEntre = new JTextField("", 15);
	
	/**
	 * This panel permit to display information 
	 */
	JPanel panelEditAll = new JPanel(new GridLayout(2,0));

	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public TaskFacade taskFacades = new TaskFacade(this);
	
	/**
	 * Contain all the activity category of the database
	 */
	List<Task> allTask = new ArrayList<Task>();

	private User currentUser;

	public TaskUpdateView(User currentUser) {
		super("Task"); // Name of the frame
		this.currentUser = currentUser;
		/* Defined actions on the different buttons */
		this.dashboard.addActionListener(this);
		this.activityCategory.addActionListener(this);
		this.productCategory.addActionListener(this);
		this.product.addActionListener(this);
		this.account.addActionListener(this);
		this.plan.addActionListener(this);
		this.task.addActionListener(this);
		this.profile.addActionListener(this);
		this.notifications.addActionListener(this);

		Container contentPane = getContentPane(); 
		contentPane.setLayout(new BorderLayout());
		setMinimumSize(new Dimension(1000,500));
		setMaximumSize(new Dimension(1000,500));

		JPanel panelButton = new JPanel(new GridLayout(3, 1)); // 2 rows x 1 column
		JPanel panelTopButton = new JPanel();
		JPanel panelBottomButton = new JPanel();

		panelTopButton.add(this.dashboard);
		panelTopButton.add(this.activityCategory);
		panelTopButton.add(this.productCategory);
		panelTopButton.add(this.product);
		panelTopButton.add(this.account);
		panelTopButton.add(this.plan);
		panelTopButton.add(this.task);

		panelBottomButton.add(this.profile);
		panelBottomButton.add(this.notifications);

		panelButton.add(panelTopButton);
		panelButton.add(panelBottomButton);
        Font font = new Font("bold", Font.BOLD,12);
        this.updateTask.setFont(font);
        panelButton.add(this.updateTask);

		contentPane.add(panelButton,BorderLayout.NORTH);

		/*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel();
		JPanel panelEdit = new JPanel();
		JPanel panelButtonValidate = new JPanel();
		JPanel panelComboBox = new JPanel(new GridLayout(3, 1));
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextFiel = new JPanel(new GridLayout(0,1));

		this.submit.addActionListener(this);
		this.chooseActivityCategoryButton.addActionListener(this);

		//Recuperate the activity Category and add to the combobox
		this.allTask = this.taskFacades.getAllTask();
		for (int i = 0; i< this.allTask.size(); i++) {
			this.combo.addItem(this.allTask.get(i).getName());
		}
		panelComboBox.add(this.chooseTask);
		panelComboBox.add(this.combo);
		panelComboBox.add(this.chooseActivityCategoryButton);
        
        // Name 
        this.name.setPreferredSize(this.nameEntre.getPreferredSize());
        this.name.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.name);
        panelTextFiel.add(this.nameEntre);

        // Description
        this.description.setPreferredSize(this.descriptionEntre.getPreferredSize());
        this.description.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.description);
        panelTextFiel.add(this.descriptionEntre);
        
		panelButtonValidate.add(submit, BorderLayout.CENTER);
		panelAll.add(panelComboBox);
		panelEdit.add(panelLabels);
		panelEdit.add(panelTextFiel);
		this.panelEditAll.setVisible(false);
		this.panelEditAll.add(panelEdit);
		this.panelEditAll.add(panelButtonValidate);
		panelAll.add(this.panelEditAll);

		contentPane.add(panelAll, BorderLayout.WEST);

		//Display
		setSize(400,120);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Choose") {
			this.panelEditAll.setVisible(true);
			
			/* Aller dans la base de données avec l'id de la category*/
			this.nameEntre.setToolTipText(this.allTask.get(this.combo.getSelectedIndex()).getName());
			this.descriptionEntre.setToolTipText(this.allTask.get(this.combo.getSelectedIndex()).getDescription());
		}
		if(source == "Submit") {
			System.out.println("BUTTON SUBMIT");
			//this.activityCategoryFacades.modifyActivityCategory(this.allActivityCategory.get(this.combo.getSelectedIndex()), this.shortDetailActivityCategoryEntre.getText(), this.longDetailActivityCategoryEntre.getText());
		}
	}
}
