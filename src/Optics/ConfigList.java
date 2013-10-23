
package Optics;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class ConfigList extends ArrayList<JComponent>{
	public ConfigList(){
		super();
	}
	public void addConfig(JComponent comp , String name){
		this.add(new JLabel(name));
		this.add(comp);
	}
	public JComponent getConfig(int index){
		return this.get(index);
	}
}
