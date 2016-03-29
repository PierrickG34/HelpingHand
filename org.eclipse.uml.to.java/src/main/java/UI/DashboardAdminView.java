package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Core.Plan;
import Core.PlanFacade;
import Core.User;

public class DashboardAdminView extends JPanel implements ActionListener, MouseListener {
	
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
	 * Description of the property ActivityCategoryFacades.
	 */
	public PlanFacade planFacades = new PlanFacade(this);
	
	List<Plan> randomPlan = new ArrayList<Plan>();
	
	JLabel name1 = new JLabel();
	JLabel name2 = new JLabel();
	
	JTextArea obs1 = new JTextArea();
	JTextArea obs2 = new JTextArea();
	
	
	
	private User currentUser;
	
	private ViewController vc;
	
	
	public DashboardAdminView(User currentUser, ViewController vc) {
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
        
//        contentPane.add(panelButton,BorderLayout.NORTH);
        this.add(panelButton,BorderLayout.NORTH);
        
        /*-------------- Veritable view --------------------*/
        JPanel panelAll = new JPanel();
        JPanel panelSemiAll = new JPanel(new GridLayout(2, 1));
        JPanel panelPlan1 = new JPanel(new GridLayout(3, 1));
        JPanel panelPlan2 = new JPanel(new GridLayout(3, 1));
        
        /*Recuperate 2 random plan from the database to display*/
        getRandomPlan();

    	this.name1.setText(this.randomPlan.get(0).getNamePlan());
    	this.name1.addMouseListener(this);
    	this.name1.setName("Plan1");
    	this.obs1.setText(this.randomPlan.get(0).getObservationPlan());
    	this.obs1.setLineWrap(true);
    	JScrollPane zoneScrolable1 = new JScrollPane(this.obs1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	zoneScrolable1.setPreferredSize(new Dimension(900, 65));
    	
    	this.name2.setText(this.randomPlan.get(1).getNamePlan());
    	this.name2.addMouseListener(this);
    	this.name2.setName("Plan2");
    	this.obs2.setText(this.randomPlan.get(1).getObservationPlan());
    	this.obs2.setLineWrap(true);
    	JScrollPane zoneScrolable2 = new JScrollPane(this.obs2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	zoneScrolable2.setPreferredSize(new Dimension(900, 65));
        
        panelPlan1.add(this.name1);
        panelPlan1.add(zoneScrolable1);
        panelPlan2.add(this.name2);
        panelPlan2.add(zoneScrolable2);
        
        panelSemiAll.add(panelPlan1);
        panelSemiAll.add(panelPlan2);
        panelAll.add(panelSemiAll);
//        contentPane.add(panelAll,BorderLayout.WEST);
        this.add(panelAll, BorderLayout.WEST);
        
//        //Display
//        setSize(400,120);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void getRandomPlan() {
		this.randomPlan = this.planFacades.getRandomPlan();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Dashboard") {
			this.vc.dashboardAdminView();
		}
		else if (source == "Activity Category" ){
			this.vc.ActivtyCategoryManageView();
		}
		else if (source == "Product"){
			this.vc.ProductManageView();
		}
		else if (source == "Account"){
			this.vc.dashboardAdminView();
		}
		else if (source == "Plan"){
			this.vc.PlanManageView();
		}
		else if (source == "Task"){
			this.vc.TaskManageView();
		}
		else if (source == "Profile"){
			this.vc.ProfileUserView();
		}
		else if (source == "Notifications"){
			System.out.println("Je suis Notifications");
			System.out.println("Action a définir ici...");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String source = e.getComponent().getName();
		if(source.equals("Plan1")) {
			System.out.println("DashboardAdmin --> PLAN1");
			this.vc.PlanView(this.randomPlan.get(0));
		}
		else if(source.equals("Plan2")) {
			System.out.println("DashboardAdmin --> PLAN2");
			this.vc.PlanView(this.randomPlan.get(1));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
