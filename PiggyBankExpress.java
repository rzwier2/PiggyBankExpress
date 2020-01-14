/*
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * @Project PiggyBankExpress
 * @date 12/05/2019
 * @author Ryan Zwier
 +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ 
*/
package piggybankexpress;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.stage.Stage;

public class PiggyBankExpress{
    GridBagConstraints gbc = new GridBagConstraints();
    
    JButton jbtBudgetMenu = new JButton("Budget Manager");
    JButton jbtHistoryMenu = new JButton("Expense History");
    
    JLabel creditLabel = new JLabel("Software created by Technical Jeniuses.");
    JLabel instructionLabel = new JLabel("Please select the program best suited for your needs.");
    JLabel budgetLabel = new JLabel("The Budget Manager program helps you track and evaluate your financial needs.");
    JLabel historyLabel = new JLabel("The History program allows you to view your expenditure history.");
    
    ActionHandler actHandler = new ActionHandler();
    Stage startStage;
    JFrame frame;
    
    JPanel programPanel = new JPanel();
    JPanel creditPanel = new JPanel();
    
    public PiggyBankExpress(){
        frame = new JFrame("PiggyBankExpress Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        
        jbtHistoryMenu.setToolTipText("Press this button to open the Expense History program.");
        jbtBudgetMenu.setToolTipText("Press this button to open the Budget Manager program.");
        
        programPanel.setPreferredSize(new Dimension(500, 340)); //Set static dimensions
        programPanel.setBorder(BorderFactory.createTitledBorder("Programs")); //Set panel to have titled border
        
        creditPanel.setPreferredSize(new Dimension(500, 60)); //Set static dimensions
        
        programPanel.setLayout(new GridBagLayout());        
        creditPanel.setLayout(new GridBagLayout());
                 
        gbc.weightx = 0;
        gbc.weighty = 0.25;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        programPanel.add(instructionLabel, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 0.25;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        programPanel.add(jbtBudgetMenu, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 0.25;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        programPanel.add(budgetLabel, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 0.25;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        programPanel.add(jbtHistoryMenu, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 0.25;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        programPanel.add(historyLabel, gbc);
             
        gbc.weightx = 0;
        gbc.weighty = 5;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 5;
        creditPanel.add(creditLabel, gbc);
        
        frame.add(programPanel, BorderLayout.NORTH);
        frame.add(creditPanel);
        frame.setVisible(true);
        
        jbtBudgetMenu.addActionListener(actHandler);
        jbtHistoryMenu.addActionListener(actHandler);
    }
    public class ActionHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String buttonClicked = e.getActionCommand();
            System.out.println(buttonClicked + " button clicked."); //Logs all button clicks
            if (e.getSource() == jbtBudgetMenu){ //If jbtBudgetMenu is pressed
                BudgetManagerGUI bmGUI = new BudgetManagerGUI();  
            }
            if (e.getSource() == jbtHistoryMenu){ //If jbtBudgetMenu is pressed
				ExpenseHistoryGUI ehGUI = new ExpenseHistoryGUI();  
            }
        }      
    }   
}
