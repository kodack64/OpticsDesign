package Optics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Interface.Configable;
import Interface.Drawable;
import MyExtends.MyTextField;

abstract class Optics implements Drawable,Configable,ActionListener,DocumentListener{

	protected OpticsProperty name;
	protected OpticsProperty x;
	protected OpticsProperty y;

	protected ConfigList configList;
	protected ArrayList<ConfigObject> configObjectList;

	class ConfigObject{
		public String label;
		public MyTextField field;
		public OpticsProperty obj;
		public ConfigObject(OpticsProperty _obj,String _label,MyTextField _field){
			obj=_obj;
			label=_label;
			field=_field;
		}
		public void updateVariable(){
			obj.updateValue(field.getText());
		}
		public void updateField(){
			field.setText(obj.toString());
		}
	}

	protected void addObject(OpticsProperty obj,String label){
		MyTextField field = new MyTextField(20,label);
		field.getDocument().addDocumentListener(this);
		configObjectList.add(new ConfigObject(obj,label,field));
	}

	public Optics(String _name,Double _x,Double _y){
		configList = new ConfigList();
		configObjectList = new ArrayList<ConfigObject>();

		name=new OpticsProperty(_name);
		x	=new OpticsProperty(_x);
		y	=new OpticsProperty(_y);

		addObject(name,"Optics Label");
		addObject(x,"Position X");
		addObject(y,"Position Y");
	}

	@Override
	public ConfigList getConfigList() {
		configList.clear();
		for(int i=0;i<configObjectList.size();i++){
			ConfigObject config = configObjectList.get(i);
			config.updateField();
			configList.addConfig(config.field, config.label);
		}
		return configList;
	}

	public void textUpdate(DocumentEvent e){
		for(int i=0;i<configObjectList.size();i++){
			ConfigObject config = configObjectList.get(i);
			if(e.getDocument()==config.field.getDocument()){
				config.updateVariable();
			}
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {textUpdate(e);}
	@Override
	public void removeUpdate(DocumentEvent e) {textUpdate(e);}
	@Override
	public void changedUpdate(DocumentEvent e){textUpdate(e);}
	@Override
	public void actionPerformed(ActionEvent e) {}

}
