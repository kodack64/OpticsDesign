package Frame;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Interface.Configable;
import Interface.Updatable;
import MyExtends.LabeledComponent;

public class SettingPanel extends JPanel implements Updatable{

	Configable configable = null;

	/**
	 * コンストラクタ
	 */
	public SettingPanel(){
		this.setMaximumSize(new Dimension(200,1000));
		this.setMinimumSize(new Dimension(200,0));
		this.setPreferredSize(new Dimension(200, 640));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}

	/**
	 * コンポーネントの値やフォーカス先を更新
	 */
	@Override
	public void updateInfo(){
		if(configable!=null){
			this.removeAll();
			ArrayList<LabeledComponent> configList = configable.getComponentList();
			if(configList!=null){
				for(int i=0;i<configList.size();i++){
					this.add(configList.get(i).getLabelComponent());
					this.add(configList.get(i).getFieldComponent());
				}
			}
		}
		this.validate();
	}

	public void setConfigable(Configable conf){configable = conf;}
}
