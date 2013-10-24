package MyExtends;

import javax.swing.JLabel;

import Optics.OpticsProperty;

public class ConfigableComponent implements LabeledComponent{
	public String label;
	public JLabel labelField;
	public MyTextField field;
	public OpticsProperty obj;

	/**
	 * コンストラクタ
	 * @param _obj 対象のオブジェクト
	 * @param _label オブジェクトのラベル
	 * @param _field オブジェクトに関連付けるフィールド
	 */
	public ConfigableComponent(OpticsProperty _obj,String _label,MyTextField _field){
		obj=_obj;
		label=_label;
		field=_field;
		labelField = new JLabel(label);
	}
	/**
	 * フィールドの文字列から対象のオブジェクトを更新
	 */
	public void updateVariable(){
		obj.updateValue(field.getText());
	}
	/**
	 * 対象のオブジェクトの値からフィールドの文字列を更新
	 */
	public void updateField(){
		field.setText(obj.toString());
	}
	/**
	 * フィールドのコンポーネントを取得
	 */
	@Override
	public MyTextField getFieldComponent(){
		return field;
	}
	/**
	 * ラベルのコンポーネントを取得
	 */
	@Override
	public JLabel getLabelComponent(){
		return labelField;
	}
}
