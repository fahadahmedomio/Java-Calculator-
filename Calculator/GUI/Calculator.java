package GUI;
import javax.swing.*; //JFrame, JLabel, JTextField, JButton ....
import java.awt.*;//Color, Font...
import java.awt.event.*;//Color, Font...

public class Calculator extends JFrame implements ActionListener{
	
	JLabel title;
	JTextField screen;
	
	JButton []buttons = new JButton[17];
	String []numbers = new String[]{"0","1","2","3",
									"4","5","6","7",
									"8","9",".","/","x",
									"-","+","=","AC"};
	
	//For different size font
	Font font12 = new Font("Cambria",Font.BOLD,12);
	Font font14 = new Font("Cambria",Font.BOLD,14);
	Font font16 = new Font("Cambria",Font.BOLD,16);
	Font font18 = new Font("Cambria",Font.BOLD,18);
	Font font20 = new Font("Cambria",Font.BOLD,20);
	
	//For calculation
	double op1,op2;
	char operator;
	
	public Calculator(){
		super("My Calculator");
		System.out.println("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,500);//(w,h) sets the size of frame/window
		this.setLocation(300,100);//(x,y)sets the location of frame/window
		//Change Frame Color
		this.getContentPane().setBackground(new Color(116,108,247));
		
		this.setLayout(null);
		
		//Title
		title = new JLabel("100 MS (OOP1-A)");
		title.setFont(font16);
		title.setBounds(10,10,200,20);//x,y,w,h
		this.add(title);
			
		//Screen
		screen = new JTextField();
		screen.setFont(font20);
		screen.setBounds(20,40,340,60);
		screen.setBackground(new Color(0,0,0));
		screen.setForeground(Color.WHITE);
		this.add(screen);
	
		//initializing buttons with loop
		for(int i=0;i<buttons.length;i++){
			buttons[i] = new JButton(numbers[i]);
			buttons[i].setFont(font20);
			buttons[i].setBackground(Color.BLACK);
			buttons[i].setForeground(Color.WHITE);
			buttons[i].addActionListener(this);
			this.add(buttons[i]);
		}
		
		//Manual Customization of Button =
		buttons[15].setBounds(260,110,100,30);
		
		
		int btnSize = 60;
		int gap = btnSize+20;
		int x=50;
		int y=150;
		
		buttons[7].setBounds(x,y,btnSize,btnSize);
		buttons[8].setBounds(x+=gap,y,btnSize,btnSize);
		buttons[9].setBounds(x+=gap,y,btnSize,btnSize);
		buttons[11].setBounds(x+=gap,y,btnSize,btnSize);
		
		x=50;
		y+=gap;
		buttons[4].setBounds(x,y,btnSize,btnSize);
		buttons[5].setBounds(x+=gap,y,btnSize,btnSize);
		buttons[6].setBounds(x+=gap,y,btnSize,btnSize);
		buttons[12].setBounds(x+=gap,y,btnSize,btnSize);
		
		x=50;
		y+=gap;
		buttons[1].setBounds(x,y,btnSize,btnSize);
		buttons[2].setBounds(x+=gap,y,btnSize,btnSize);
		buttons[3].setBounds(x+=gap,y,btnSize,btnSize);
		buttons[13].setBounds(x+=gap,y,btnSize,btnSize);
		
		x=50;
		y+=gap;
		buttons[16].setBounds(x,y,btnSize,btnSize);
		buttons[0].setBounds(x+=gap,y,btnSize,btnSize);
		buttons[10].setBounds(x+=gap,y,btnSize,btnSize);
		buttons[14].setBounds(x+=gap,y,btnSize,btnSize);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("BTN CLICKED");
		String num = "0123456789.";
		if( num.indexOf(e.getActionCommand())>=0 ){
			screen.setText(screen.getText()+e.getActionCommand());
		}
		else if(e.getSource() == buttons[11] || 
				e.getSource() == buttons[12] ||
				e.getSource() == buttons[13] ||
				e.getSource() == buttons[14] ){
					
					op1 = Double.parseDouble(screen.getText());
					operator = e.getActionCommand().charAt(0);
					screen.setText("");
				}
		else if(e.getSource() == buttons[15]){
			op2 = Double.parseDouble(screen.getText());
			double result = 0.0;
			if(operator == '/'){
				result = op1/op2;
			}
			else if(operator == 'x'){
				result = op1*op2;
			}
			else if(operator == '-'){
				result = op1-op2;
			}
			else if(operator == '+'){
				result = op1+op2;
			}
			screen.setText(String.valueOf(result));
		}
		else if(e.getSource() == buttons[16]){
			op1 = 0.0;
			op2 = 0.0;
			operator = ' ';
			screen.setText("");
		}
	}
}