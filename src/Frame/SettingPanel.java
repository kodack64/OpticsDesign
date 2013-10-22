package Frame;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Interface.Configable;
import Interface.Updatable;
import Optics.ConfigList;

public class SettingPanel extends JPanel implements Updatable{
	Configable configable = null;
	public SettingPanel(){
		this.setMaximumSize(new Dimension(200,1000));
		this.setMinimumSize(new Dimension(200,0));
		this.setPreferredSize(new Dimension(200, 640));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
	public void setConfigable(Configable conf){
		configable = conf;
	}

	@Override
	public void updateInfo(){
		if(configable!=null){
			this.removeAll();
			ConfigList configList = configable.getConfigList();
			for(int i=0;i<configList.size();i++){
				this.add(configList.getConfig(i));
			}
		}
		this.validate();
	}
}
