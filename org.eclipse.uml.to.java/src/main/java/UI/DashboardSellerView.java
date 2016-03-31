package UI;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Core.Plan;
import Core.PlanFacade;
import Core.User;
import Core.UserFacade;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardSellerView.
 */
public class DashboardSellerView extends JPanel implements ActionListener, MouseListener {

	   
	   /** The current user. */
   	private User currentUser;
	   
	   /** The vc. */
   	private ViewController vc;
	   
   	/** The menu seller view. */
   	private MenuSellerView menuSellerView;
	   
	   /**
		 * Description of the property ActivityCategoryFacades.
		 */
		public PlanFacade planFacades = new PlanFacade(this);
		
		/** The random plan. */
		List<Plan> randomPlan = new ArrayList<Plan>();
		
		/** The name1. */
		JLabel name1 = new JLabel();
		
		/** The name2. */
		JLabel name2 = new JLabel();
		
		/** The obs1. */
		JTextArea obs1 = new JTextArea();
		
		/** The obs2. */
		JTextArea obs2 = new JTextArea();
	
	// Start of user code (user defined attributes for LoginView)

	// End of user code

	/**
	 * The constructor who create the window.
	 *
	 * @param currentUser the current user
	 * @param vc the vc
	 */
	public DashboardSellerView(User currentUser, ViewController vc) {
		/* Defined actions on the different buttons */
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuSellerView = new MenuSellerView(this.vc);
		this.add(menuSellerView);
		
		/*-------------- Veritable view --------------------*/
        JPanel panelAll = new JPanel();
        JPanel panelSemiAll = new JPanel(new GridLayout(2, 1));
        JPanel panelPlan1 = new JPanel(new GridLayout(3, 1));
        JPanel panelPlan2 = new JPanel(new GridLayout(3, 1));
        
        /*Recuperate 2 random plan from the database to display*/
        this.getRandomPlan();

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
        this.add(panelAll, BorderLayout.CENTER);
	}
	
	/**
	 * Gets the random plan.
	 *
	 * @return the random plan
	 */
	public void getRandomPlan() {
		this.randomPlan = this.planFacades.getRandomPlan();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		String source = e.getComponent().getName();
		if(source.equals("Plan1")) {
			this.vc.PlanViewSeller(this.randomPlan.get(0));
		}
		else if(source.equals("Plan2")) {
			this.vc.PlanViewSeller(this.randomPlan.get(1));
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}