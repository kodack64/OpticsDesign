package Frame;


import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import Optics.OpticsManager;

public class MainFrame extends JFrame{
	GraphicPanel graphicPanel;
	SettingPanel settingPanel;
	OpticsManager opticsManager;
	public MainFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graphicPanel = new GraphicPanel();
		settingPanel = new SettingPanel();
		opticsManager = new OpticsManager();

		graphicPanel.setAddable(opticsManager);
		graphicPanel.setPickable(opticsManager);
		graphicPanel.setDrawable(opticsManager);
		graphicPanel.setUpdatable(settingPanel);
		settingPanel.setConfigable(opticsManager);
		this.getContentPane().add(new JScrollPane(graphicPanel),BorderLayout.CENTER);
		this.getContentPane().add(new JScrollPane(settingPanel),BorderLayout.EAST);
		this.setVisible(true);
		this.pack();
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
	}
}
