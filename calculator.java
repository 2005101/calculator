import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener{ //make it interactive 

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10]; // numbers
	JButton[] functionButtons = new JButton[7];// buttons 
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, clrButton;
	JPanel panel;
    Font myFont=new Font("Serif",Font.PLAIN,30);
    
	double num1=0,num2=0,result=0;
	char operator;
	
	calculator(){ //Constructor 
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		textfield.setBackground(Color.white);
        textfield.setForeground(Color.BLACK);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		clrButton = new JButton("Clr");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton; 
		functionButtons[6] = clrButton;
		//loop
		for(int i =0;i<7 ;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBackground(new Color(0, 120, 215)); // Set background color
            functionButtons[i].setForeground(Color.WHITE); // Set text color
        }
		//loop for numbers 
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBackground(new Color(173,  216, 230)); // Light gray background
            numberButtons[i].setForeground(Color.BLACK); 
		}
		//buttom place 
		clrButton.setBounds(250,430,100,50);
		
		//layout to add numbers 
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,3,10,10));

		//order 
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(divButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(mulButton);
		panel.add(equButton);
		panel.add(clrButton);

		
		frame.add(panel);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			//conditional switch
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
	
	}
}