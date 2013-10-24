package Frame;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import Optics.OpticsManager;

public class MainFrame extends JFrame{

	/** 描画用のパネル */
	GraphicPanel graphicPanel;
	/** 設定用のパネル */
	SettingPanel settingPanel;
	/** 光学系の処理全般 */
	OpticsManager opticsManager;

	/**
	 * @description コンストラクタ
	 */
	public MainFrame(){
		this.setTitle("Optics Design");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graphicPanel = new GraphicPanel();
		settingPanel = new SettingPanel();
		opticsManager = new OpticsManager();

		/** 追加操作時の対象を指定 */
		graphicPanel.setAddable(opticsManager);
		/** パーツ選択時のフォーカス先の指定 */
		graphicPanel.setPickable(opticsManager);
		/** 描画先の指定 */
		graphicPanel.setDrawable(opticsManager);
		/** クリック時のフォーカス先のアップデートの指定 */
		graphicPanel.setUpdatable(settingPanel);
		/** パラメータ操作時の反映先の指定 */
		settingPanel.setConfigable(opticsManager);

		this.getContentPane().add(new JScrollPane(graphicPanel),BorderLayout.CENTER);
		this.getContentPane().add(new JScrollPane(settingPanel),BorderLayout.EAST);

		this.setVisible(true);
		this.pack();
	}
}
