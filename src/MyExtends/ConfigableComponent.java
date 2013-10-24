package MyExtends;

import javax.swing.JLabel;

import Optics.OpticsProperty;

public class ConfigableComponent implements LabeledComponent{
	public String label;
	public JLabel labelField;
	public MyTextField field;
	public OpticsProperty obj;
	public ConfigableComponent(OpticsProperty _obj,String _label,MyTextField _field){
		obj=_obj;
		label=_label;
		field=_field;
		labelField = new JLabel(label);
	}
	public void updateVariable(){
		obj.updateValue(field.getText());
	}
	public void updateField(){
		field.setText(obj.toString());
	}
	@Override
	public MyTextField getFieldComponent(){
		return field;
	}
	@Override
	public JLabel getLabelComponent(){
		return labelField;
	}
}
