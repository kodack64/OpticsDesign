package Interface;

import java.util.ArrayList;

import MyExtends.LabeledComponent;

public interface Configable {
	/**
	 * コンフィグのリストを取得する
	 * @return コンフィグのリスト
	 */
	public ArrayList<LabeledComponent> getComponentList();
}
