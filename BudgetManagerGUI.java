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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class e extends JFrame{
    GridBagConstraints gbc = new GridBagConstraints();
    
    Object [] expenseCategories ={"Groceries"};

    JComboBox jcbExpenses = new JComboBox(expenseCategories);
    JComboBox jcb = new JComboBox();
    
    JTextField jtf = new JTextField();
    JTextField jtfCost = new JTextField(10);
    JTextField jtfTotal = new JTextField(10);
    
    JButton jbtPlus = new JButton("+");
    
    JLabel instructionLabel0 = new JLabel("From the drop down, select the expense type that best represents your");
    JLabel instructionLabel1 = new JLabel("purchase and then input into the box to the right how much it cost.");
    JLabel instructionLabel2 = new JLabel("Press the '+' button to add another expense.");
    JLabel totalLabel = new JLabel("Based off your expenses, you have spent:  ");
    
    BudgetManagerGUI.ActionHandler actHandler = new BudgetManagerGUI.ActionHandler();
    
    
    JPanel entryPanel = new JPanel();
    JPanel resultPanel = new JPanel();
    
    public BudgetManagerGUI(){      
        jbtPlus.setToolTipText("Press this button to add another expenses.");
        
        entryPanel.setSize(new Dimension(600, 340)); //Set static dimensions
        entryPanel.setBorder(BorderFactory.createTitledBorder("Expenses")); //Set panel to have titled border
        
        resultPanel.setPreferredSize(new Dimension(600, 60)); //Set static dimensions
        
        entryPanel.setLayout(new GridBagLayout()); 
        resultPanel.setLayout(new GridBagLayout());
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        entryPanel.add(instructionLabel0, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 1;
        entryPanel.add(instructionLabel1, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 2;
        entryPanel.add(instructionLabel2, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 3;
        entryPanel.add(jbtPlus, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 5;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 4;
        entryPanel.add(jcbExpenses, gbc);

        gbc.weightx = 0.01;
        gbc.weighty = 5;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy = 4;
        entryPanel.add(jtfCost, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.gridx = 0;
        gbc.gridy = 0;
        resultPanel.add(totalLabel, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.gridx = 1;
        gbc.gridy = 0;
        resultPanel.add(jtfTotal, gbc);
        
        JScrollPane scroll = new JScrollPane(entryPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(600, 340));
        
        add(scroll, BorderLayout.NORTH);
        add(resultPanel);
        
        jbtPlus.addActionListener(actHandler);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public class ActionHandler implements ActionListener{
        int count = 1;
        @Override
        public void actionPerformed(ActionEvent e){
        jcb = new JComboBox(expenseCategories);
        jtf = new JTextField(10);
        String buttonClicked = e.getActionCommand();
        System.out.println(buttonClicked + " button clicked."); //Logs all button clicks
            if (e.getSource() == jbtPlus){ //If jbtPlus is pressed
                gbc.weightx = 0;
                gbc.weighty = 5;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridx = 0;
                gbc.gridy = 4 + count;
                entryPanel.add(jcb, gbc);
                
                gbc.weightx = 0;
                gbc.weighty = 5;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridx = 1;
                gbc.gridy = 4 + count;
                entryPanel.add(jtf, gbc);
        
                entryPanel.revalidate();
                entryPanel.repaint();
                ++count;
            }
        }    
    }
}
