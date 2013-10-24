package Optics;

import java.awt.Graphics;
import java.util.ArrayList;

import Interface.Addable;
import Interface.Configable;
import Interface.Drawable;
import Interface.Pickable;
import MyExtends.LabeledComponent;

public class OpticsManager implements Addable,Pickable,Configable,Drawable{
	ArrayList <Optics> optics;
	Optics currentTarget;
	OpticsDrawer drawer;

	/**
	 * コンストラクタ
	 */
	public OpticsManager(){
		optics = new ArrayList<Optics>();
		currentTarget=null;
		drawer = new OpticsDrawer(optics);
	}
	/**
	 * パーツの追加
	 */
	@Override
	public void addOptics(OpticsEnum opticsEnum,double x,double y){
		Optics optic = OpticsFactory.CreateOptics(opticsEnum,x, y);
		optics.add(optic);
		currentTarget=optic;
	}
	/**
	 * クリックされた座標に応じてパーツにフォーカスする
	 */
	@Override
	public void pick(int x,int y){
		double minDist=1000000;
		for(Optics opt : optics){
			double dist =Math.hypot(opt.x.toDouble()-x, opt.y.toDouble()-y);
			if(minDist>dist){
				currentTarget=opt;
				minDist=dist;
			}
		}
	}
	/**
	 * コンポーネントのリストを取得
	 */
	@Override
	public ArrayList<LabeledComponent> getComponentList() {
		if(currentTarget!=null)return currentTarget.getComponentList();
		else return null;
	}
	/**
	 * 描画
	 */
	@Override
	public void paint(Graphics g) {
		drawer.setCurrentTarget(currentTarget);
		drawer.paint(g);
	}
}
