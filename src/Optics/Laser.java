package Optics;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

import MyExtends.MyTextField;


public class Laser extends Optics implements ActionListener{

	double angle;
	double beamWaist;
	double beamWaistPosition;

	JTextField angleField;

	public Laser(String _name,double _x,double _y,double _angle,double _beamWaist,double _beamWaistPosition){
		name = _name;
		x = _x;
		y = _y;
		angle = _angle;
		beamWaist = _beamWaist;
		beamWaistPosition = _beamWaistPosition;

		angleField = new MyTextField(20);
		angleField.getDocument().addDocumentListener(this);
	}

	@Override
	public void paint(Graphics g) {
		int radius=10;
		g.drawOval((int)x-radius/2,(int)y-radius/2,radius,radius);
		g.drawString(name, (int)x, (int)y+10);
	}

	@Override
	public ConfigList getConfigList() {
		super.getConfigList();
		angleField.setText(String.valueOf(angle));
		configList.addConfig(angleField,"Angle");
		return configList;
	}

	@Override
	public void changedUpdate(DocumentEvent e){
		super.changedUpdate(e);
		if(e.getDocument()==angleField.getDocument()){
			try{
				angle = Double.parseDouble(angleField.getText());
			}catch(Exception exception){}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
	}
}
