package MyExtends;

import javax.swing.JTextField;

public class MyTextField extends JTextField{
	public MyTextField(int size){
		super(size);
		this.setMaximumSize(this.getPreferredSize());
	}
}
