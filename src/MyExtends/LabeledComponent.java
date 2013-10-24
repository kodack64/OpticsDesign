package MyExtends;

import javax.swing.JLabel;

public interface LabeledComponent{
	/**
	 * コンポーネントのラベルを取得
	 * @return ラベルのコンポーネント
	 */
	public JLabel getLabelComponent();
	/**
	 * コンポーネント本体を取得
	 * @return コンポーネント本体
	 */
	public MyTextField getFieldComponent();
}

