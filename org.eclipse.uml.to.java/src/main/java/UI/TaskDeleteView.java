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

import Core.Task;
import Core.TaskFacade;
import Core.User;

public class TaskDeleteView extends JPanel implements ActionListener {

	JButton dashboard = new JButton("Dashboard");
	JButton activityCategory = new JButton("Activity Category");
	JButton productCategory = new JButton("Product Category");
	JButton product = new JButton("Product");
	JButton account = new JButton("Account");
	JButton plan = new JButton("Plan");
	JButton task = new JButton("Task");
	   
	JButton profile = new JButton("Profile");
	JButton notifications = new JButton("Notifications");
	
	JButton delete = new JButton("Delete");
	
	/**
	 * Descriptions for the windows
	 */
	JLabel deleteTask = new JLabel("  Delete a Task :");
	
	/**
	 * Define the drop down menu with the task
	 */
	JComboBox<String> comboTask = new JComboBox<String>();
	
	/**
	 * Text to choose the activity category to delete
	 */
	JLabel chooseTask = new JLabel("Choose a Task to delete:");
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public TaskFacade taskFacades = new TaskFacade(this);

	/**
	 * Contain all the activity category of the database
	 */
	List<Task> allTask = new ArrayList<Task>();
	
	
	private User currentUser;
	private ViewController vc;
	
	public TaskDeleteView(User currentUser, ViewController vc) {
//		super("Task"); // Name of the frame
		this.currentUser = currentUser;
		this.vc = vc;
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
		
//        Container contentPane = getContentPane(); 
//        contentPane.setLayout(new BorderLayout());
//        setMinimumSize(new Dimension(1000,500));
//        setMaximumSize(new Dimension(1000,500));
        
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
		this.deleteTask.setFont(font);
		panelButton.add(this.deleteTask);
        
//        contentPane.add(panelButton,BorderLayout.NORTH);
		this.add(panelButton,BorderLayout.NORTH);
        
        /*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel(new GridLayout(2, 1));
		JPanel panelComboBoxTask = new JPanel(new GridLayout(2, 1));
		JPanel panelComboBoxAllTask = new JPanel();
		JPanel panelButtonDelete = new JPanel();
		
		//Recuperate the task and add to the combobox
		this.allTask = this.taskFacades.getAllTask();
		for (int i = 0; i< this.allTask.size(); i++) {
			this.comboTask.addItem(this.allTask.get(i).getName());
		}
		panelComboBoxTask.add(this.chooseTask);
		panelComboBoxTask.add(this.comboTask);
		panelComboBoxAllTask.add(panelComboBoxTask);
		
		panelButtonDelete.add(this.delete);
		this.delete.addActionListener(this);
		
		panelAll.add(panelComboBoxAllTask);
		panelAll.add(panelButtonDelete);
		
//		contentPane.add(panelAll, BorderLayout.WEST);
		this.add(panelAll, BorderLayout.WEST);
        
      //Display
//        setSize(400,120);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Delete") {
			System.out.println("BUTTON DELETE VIEW");
			this.taskFacades.deleteTask(this.allTask.get(this.comboTask.getSelectedIndex()));
		}
	}
}