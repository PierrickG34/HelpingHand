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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import Core.Plan;
import Core.PlanFacade;
import Core.Task;
import Core.User;

public class PlanView extends JPanel implements ActionListener {
	
	JLabel informationsPlan = new JLabel ("Plan informations");
	JLabel namePlan = new JLabel ("");
	JLabel ACPlan = new JLabel ("");
	JTextArea obsPlan = new JTextArea ("");
	public PlanFacade planFacades = new PlanFacade(this);
	List<Task> allTask = new ArrayList<Task>();
	JLabel nameTask = new JLabel ("");
	JLabel descTask = new JLabel ("");
	JLabel deadLinePlan = new JLabel("");
	JButton copyPlan = new JButton("Copy to my Plans");
	JButton addFavorite = new JButton("Add to my Favorites");
	
	
	private User currentUser;
	private Plan currentPlan;
	private ViewController vc;
	private MenuAdminView menuAdminView;
	
	
	
	public PlanView(User currentUser, Plan currentPlan, ViewController vc) {
//		super("DashBoard"); // Name of the frame
		this.currentUser = currentUser;
		this.currentPlan = currentPlan;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(this.vc);
		this.add(menuAdminView);
        
        /*-------------- Veritable view --------------------*/
        getTaskForPlan(this.currentPlan.getIdPlan());
        int nbTask = this.allTask.size();
        
        JPanel panelAll = new JPanel(new GridLayout(1, 2));
        JPanel panelLeft = new JPanel(new GridLayout(4, 1));
        JPanel panelRight = new JPanel(new GridLayout(3, 1));
        JPanel panelName = new JPanel();
        JPanel panelAC = new JPanel();
        JPanel panelObservation = new JPanel();
        JPanel panelAllTask = new JPanel(new GridLayout(nbTask, 1));
        JPanel panelTask = new JPanel(new GridLayout(2, 1));
        JPanel panelTask1 = new JPanel(new GridLayout(2, 1));
        JPanel panelDeadLine = new JPanel();
        JPanel panelCopy = new JPanel();
        JPanel panelFavorite = new JPanel();
        
        // Name
        this.namePlan.setText(this.currentPlan.getNamePlan());
        panelName.add(this.namePlan);
        // AC
        this.ACPlan.setText(this.currentPlan.getActivityCategory());
        panelAC.add(this.ACPlan);
        // Observation
        this.obsPlan.setText(this.currentPlan.getObservationPlan());
    	this.obsPlan.setLineWrap(true);
    	JScrollPane zoneScrolable = new JScrollPane(this.obsPlan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	zoneScrolable.setPreferredSize(new Dimension(300, 80));
        panelObservation.add(zoneScrolable);
       
        //Task
        for(int i = 0; i < this.allTask.size(); i++) {
        	this.nameTask.setText("Task " + i + ": " + this.allTask.get(i).getName());
        	this.descTask.setText(this.allTask.get(i).getDescription());
        	panelTask.add(this.nameTask);
        	panelTask.add(this.descTask);
        	panelAllTask.add(panelTask);
		}
        
    	// DeadLine
        this.deadLinePlan.setText(this.currentPlan.getDeadline().toString());
        panelDeadLine.add(this.deadLinePlan);
        
        // Copy 
        panelCopy.add(this.copyPlan);
        this.copyPlan.addActionListener(this);
        
        // Favorite
        panelFavorite.add(this.addFavorite);
        this.addFavorite.addActionListener(this);
        
        
        panelLeft.add(panelName);
        panelLeft.add(panelAC);
        panelLeft.add(panelObservation);
        panelLeft.add(panelAllTask);
        panelAll.add(panelLeft);
        panelRight.add(panelDeadLine);
        panelRight.add(panelCopy);
        panelRight.add(panelFavorite);
        panelAll.add(panelRight);

        this.add(panelAll,BorderLayout.WEST);
	}



	private void getTaskForPlan(Integer idPlan) {
		this.allTask = this.planFacades.getTaskForPlan(idPlan);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Copy to my Plans") {
			System.out.println("Action pas faite");
		}
		else if (source == "Add to my Favorites") {
			System.out.println("Action pas faite");
		}
	}
}
