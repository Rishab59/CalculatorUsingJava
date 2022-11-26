/*
 * Developer's Name : Rishab.H
 * Title : CalculatorUsingJava
 * Description : This is a fully functional Calculator developed using Java JFrame
 */

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class Calculator implements ActionListener
{
	
	JFrame frame ;
	JTextField textField ;
	JButton [] numberButtons = new JButton[10] ;
	JButton [] functionButtons = new JButton[9] ;
	JButton addButton, subButton, mulButton, divButton ;
	JButton decButton, equButton, delButton, clrButton, negButton ;
	JPanel panel ;
	
	Font myFont = new Font("Consolas", Font.BOLD, 30) ;
	
	double num1 = 0, num2 = 0, result = 0 ;
	char operator ;
	
	Calculator() // Constructor
	{
		
		frame = new JFrame("CalculatorByRishab") ; // Creating a new Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		frame.setSize(420, 550) ;
		frame.setLayout(null) ;
		
		textField  = new JTextField() ; 
		// Creating a new textField which acts as a display to the Calculator
		textField.setBounds(50, 25, 300, 50) ;
		textField.setFont(myFont) ;
		textField.setEditable(false) ;
		// Users should not edit the display directly without clicking buttons
		
		addButton = new JButton("+") ;
		subButton = new JButton("-") ;
		mulButton = new JButton("*") ;
		divButton = new JButton("/") ;
		decButton = new JButton(".") ;
		equButton = new JButton("=") ;
		delButton = new JButton("Del") ;
		clrButton = new JButton("Clr") ;
		negButton = new JButton("(-)") ;
		
		functionButtons [0] = addButton ;
		functionButtons [1] = subButton ;
		functionButtons [2] = mulButton ;
		functionButtons [3] = divButton ;
		functionButtons [4] = decButton ;
		functionButtons [5] = equButton ;
		functionButtons [6] = delButton ;
		functionButtons [7] = clrButton ;
		functionButtons [8] = negButton ;
		
		for(int i = 0 ; i < 9 ; i++)
		{
			functionButtons [i].addActionListener(this) ;
			functionButtons [i].setFont(myFont) ;
		}
		
		for(int i = 0 ; i < 10 ; i++)
		{
			numberButtons [i] = new JButton(String.valueOf(i)) ;
			numberButtons [i].addActionListener(this) ;
			numberButtons [i].setFont(myFont) ;
		}
		
		delButton.setBounds(150, 430, 100, 50) ;
		clrButton.setBounds(250, 430, 100, 50) ;
		negButton.setBounds(50, 430, 100, 50) ;
		
		panel = new JPanel() ;
		panel.setBounds(50, 100, 300, 300) ;
		panel.setLayout(new GridLayout(4, 4, 10, 10)) ;
		//panel.setBackground(Color.GRAY) ; // Used for testing
		
		// row1
		panel.add(numberButtons [1]) ;
		panel.add(numberButtons [2]) ;
		panel.add(numberButtons [3]) ;
		panel.add(addButton) ;
		
		//row2
		panel.add(numberButtons [4]) ;
		panel.add(numberButtons [5]) ;
		panel.add(numberButtons [6]) ;
		panel.add(subButton) ;
		
		//row3
		panel.add(numberButtons [7]) ;
		panel.add(numberButtons [8]) ;
		panel.add(numberButtons [9]) ;
		panel.add(mulButton) ;
		
		//row4
		panel.add(decButton) ;
		panel.add(numberButtons [0]) ;
		panel.add(equButton) ;
		panel.add(divButton) ;
		
		frame.add(panel) ;
		frame.add(delButton) ;
		frame.add(clrButton) ;
		frame.add(negButton) ;
		frame.add(textField) ;
		
		frame.setVisible(true) ;
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		for(int i = 0 ; i < 10 ; i++)
		{
			if(e.getSource() == numberButtons[i])
			{
				textField.setText(textField.getText().concat(String.valueOf(i))) ;
			}
		}
		
		if(e.getSource() == decButton)
		{
			textField.setText(textField.getText().concat(".")) ;
		}
		
		if(e.getSource() == addButton)
		{
			num1 = Double.parseDouble(textField.getText()) ;
			operator = '+' ;
			textField.setText("") ;
		}
		
		if(e.getSource() == subButton)
		{
			num1 = Double.parseDouble(textField.getText()) ;
			operator = '-' ;
			textField.setText("") ;
		}
		
		if(e.getSource() == mulButton)
		{
			num1 = Double.parseDouble(textField.getText()) ;
			operator = '*' ;
			textField.setText("") ;
		}
		
		if(e.getSource() == divButton)
		{
			num1 = Double.parseDouble(textField.getText()) ;
			operator = '/' ;
			textField.setText("") ;
		}
		
		if(e.getSource() == equButton)
		{
			num2 = Double.parseDouble(textField.getText()) ;
			
			switch(operator)
			{
				case '+' :
					result = num1 + num2 ;
					break ;
				case '-' :
					result = num1 - num2 ;
					break ;
				case '*' :
					result = num1 * num2 ;
					break ;
				case '/' :
					result = num1 / num2 ;
					break ;
			}
			
			textField.setText(String.valueOf(result)) ;
			num1 = result ;
		}
		
		if(e.getSource() == clrButton)
		{
			textField.setText("");
			num1 = 0 ;
		}
		
		if(e.getSource() == delButton)
		{
			String string = textField.getText() ;
			textField.setText("") ;
			for(int i = 0 ; i < string.length() - 1 ; i++ )
			{
				textField.setText(textField.getText() + string.charAt(i)) ;
			}
		}
		
		if(e.getSource() == negButton)
		{
			double temp = Double.parseDouble(textField.getText()) ;
			temp *= -1 ;
			textField.setText(String.valueOf(temp)) ;
		}
		
	}
	
	public static void main(String [] array) 
	{
		new Calculator() ;
	}

}