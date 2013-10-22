package Optics;

import java.awt.Graphics;
import java.util.ArrayList;

import Interface.Drawable;

public class OpticsDrawer implements Drawable{

	ArrayList<Optics> optics;
	public OpticsDrawer(ArrayList<Optics> opt){
		optics = opt;
	}
	@Override
	public void paint(Graphics g) {
		for(Optics opt : optics){
			opt.paint(g);
		}
	}
}
