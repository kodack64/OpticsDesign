package Optics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import BeamSimulator.BeamSimulator;
import Interface.Drawable;

public class OpticsDrawer implements Drawable{

	ArrayList<Optics> optics;
	ArrayList<Laser> lasers;
	Optics currentTarget;

	BeamSimulator beamSimulator;

	public OpticsDrawer(ArrayList<Optics> opt){
		optics = opt;
		currentTarget=null;
		lasers = new ArrayList<Laser>();
		beamSimulator = new BeamSimulator();
	}
	public void setCurrentTarget(Optics opt){currentTarget=opt;}
	@Override
	public void paint(Graphics g) {
		for(Optics opt : optics){
			if(opt==currentTarget){
				g.setColor(Color.red);
				opt.paint(g);
			}else{
				g.setColor(Color.black);
				opt.paint(g);
			}
		}
		for(Optics opt : optics){
			if(opt instanceof Laser){
				lasers.add((Laser)opt);
			}
		}
		beamSimulator.simulate();
	}
}
