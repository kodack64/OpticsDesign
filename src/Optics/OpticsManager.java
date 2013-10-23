package Optics;

import java.awt.Graphics;
import java.util.ArrayList;

import Interface.Addable;
import Interface.Configable;
import Interface.Drawable;
import Interface.Pickable;

public class OpticsManager implements Addable,Pickable,Configable,Drawable{
	ArrayList <Optics> optics;
	Optics currentTarget;
	OpticsDrawer drawer;
	public OpticsManager(){
		optics = new ArrayList<Optics>();
		currentTarget=null;
		drawer = new OpticsDrawer(optics);
	}
	@Override
	public void addOptics(OpticsEnum opticsEnum,double x,double y){
		Optics optic = OpticsFactory.CreateOptics(opticsEnum,x, y);
		optics.add(optic);
		currentTarget=optic;
	}
	@Override
	public void pick(int x,int y){
		double minDist=1000000;
		for(Optics opt : optics){
			double dist =Math.hypot(opt.x-x, opt.y-y);
			if(minDist>dist){
				currentTarget=opt;
				minDist=dist;
			}
		}
	}
	@Override
	public ConfigList getConfigList() {
		return currentTarget.getConfigList();
	}
	@Override
	public void paint(Graphics g) {
		drawer.paint(g);
	}
}
