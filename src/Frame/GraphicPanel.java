package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Interface.Addable;
import Interface.Drawable;
import Interface.Pickable;
import Interface.Updatable;
import Optics.OpticsEnum;

public class GraphicPanel extends JPanel implements MouseListener,ActionListener{

	Drawable drawable;
	Addable addable;
	Updatable updatable;
	Pickable pickable;
	Timer timer;

	JPopupMenu popupMenu;
	double putX;
	double putY;
	HashMap<JMenuItem,OpticsEnum> itemMap;

	public GraphicPanel(){
		drawable=null;
		addable=null;
		updatable=null;
		putX=putY=0;

		this.setPreferredSize(new Dimension(640, 640));
		this.addMouseListener(this);
		itemMap = new HashMap<JMenuItem,OpticsEnum>();

		createPopupMenu();

		timer = new Timer(1000, this);
		timer.start();
	}

	private void createPopupMenu(){
		popupMenu = new JPopupMenu();
		for(OpticsEnum opt : OpticsEnum.values()){
			JMenuItem item = new JMenuItem(opt.name());
			item.addActionListener(this);
			popupMenu.add(item);
			itemMap.put(item, opt);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==timer){
			// only repaint
		}
		if(itemMap.containsKey(e.getSource())){
			addable.addOptics(itemMap.get(e.getSource()),putX,putY);
			if(updatable!=null)updatable.updateInfo();
		}
		this.repaint();
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.white);
		g.clearRect(0, 0, this.getSize().width,this.getSize().height);
		g.setColor(Color.black);
		if(drawable!=null)drawable.paint(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e)){
			putX=e.getX();
			putY=e.getY();
			popupMenu.show(e.getComponent(),e.getX(),e.getY());
		}
		if(SwingUtilities.isLeftMouseButton(e)){
			if(pickable!=null)pickable.pick(e.getX(), e.getY());
			if(updatable!=null)updatable.updateInfo();
		}
		this.repaint();
	}
	public void setDrawable(Drawable draw){drawable = draw;}
	public void setAddable(Addable add){addable = add;}
	public void setUpdatable(Updatable update){updatable = update;}
	public void setPickable(Pickable pick){pickable=pick;}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
