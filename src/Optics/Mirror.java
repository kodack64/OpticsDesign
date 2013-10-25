package Optics;

import java.awt.Graphics;

public class Mirror extends Optics{
	OpticsProperty angle;
	OpticsProperty size;

	/**
	 * コンストラクタ
	 * @param _name 名前
	 * @param _x 配置するX座標
	 * @param _y 配置するY座標
	 * @param _angle 出射角
	 * @param _size ミラーのサイズ
	 */
	public Mirror(String _name,double _x,double _y,double _angle,double _size){
		super(_name,_x,_y);
		angle = new OpticsProperty(_angle);
		size= new OpticsProperty(_size);
		this.addObject(angle, "Angle");
		this.addObject(size, "Size");
	}

	/**
	 * 描画
	 */
	@Override
	public void paint(Graphics g) {
		int radius=5;
		int ix = x.toInt();
		int iy = y.toInt();
		double dangle = angle.toDouble();
		double dsize = size.toDouble();
		String sname = name.toString();

		g.drawOval(ix-radius/2,iy-radius/2,radius,radius);
		g.drawLine(
				ix-(int)(dsize/2*Math.cos(dangle*Math.PI/180)),
				iy+(int)(dsize/2*Math.sin(dangle*Math.PI/180)),
				ix+(int)(dsize/2*Math.cos(dangle*Math.PI/180)),
				iy-(int)(dsize/2*Math.sin(dangle*Math.PI/180))
				);
		g.drawString(sname, ix-15, iy+30);
	}
}
