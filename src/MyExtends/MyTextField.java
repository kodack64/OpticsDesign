package MyExtends;

import javax.swing.JTextField;

/**
 * Box Layoutの時にフィールドが勝手に広がらないように修正
 */
public class MyTextField extends JTextField{
	public String label;

	/**
	 * コンストラクタ
	 * @param size フィールドのサイズ
	 * @param _label フィールドのラベル
	 */
	public MyTextField(int size,String _label){
		super(size);
		label=_label;
		this.setMaximumSize(this.getPreferredSize());
	}
}
