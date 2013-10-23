package Optics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Interface.Configable;
import Interface.Drawable;
import MyExtends.MyTextField;

abstract class Optics implements Drawable,Configable,ActionListener,DocumentListener{
	protected String name;
	protected double x;
	protected double y;
	protected ConfigList configList;

	JTextField nameField;
	JTextField xField;
	JTextField yField;

	public Optics(){
		name="";
		x=0;
		y=0;
		nameField = new MyTextField(20);
		nameField.getDocument().addDocumentListener(this);
		xField = new MyTextField(20);
		xField.getDocument().addDocumentListener(this);
		yField = new MyTextField(20);
		yField.getDocument().addDocumentListener(this);
	}

	@Override
	public ConfigList getConfigList() {
		if(configList==null)configList = new ConfigList();
		configList.clear();
		nameField.setText(name);
		configList.addConfig(nameField,"Optics Name");
		xField.setText(String.valueOf(x));
		configList.addConfig(xField,"Optics Position X");
		yField.setText(String.valueOf(y));
		configList.addConfig(yField,"Optics Position Y");
		return configList;
	}

	@Override
	public void changedUpdate(DocumentEvent e){
		if(e.getDocument()==nameField.getDocument()){
			name = nameField.getText();
		}
		if(e.getDocument()==xField.getDocument()){
			try{
				x = Double.parseDouble(xField.getText());
			}catch(Exception exception){}
		}
		if(e.getDocument()==yField.getDocument()){
			try{
				x = Double.parseDouble(yField.getText());
			}catch(Exception exception){}
		}
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		this.changedUpdate(e);
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		this.changedUpdate(e);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
