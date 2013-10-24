package Optics;

import java.awt.Graphics;


public class Laser extends Optics{

	OpticsProperty angle;
	OpticsProperty beamWaist;
	OpticsProperty beamWaistPosition;

	/**
	 * コンストラクタ
	 * @param _name 名前
	 * @param _x 配置するX座標
	 * @param _y 配置するY座標
	 * @param _angle 出射角
	 * @param _beamWaist ビームウェスト
	 * @param _beamWaistPosition ビームウェストとなる箇所の相対位置
	 */
	public Laser(String _name,double _x,double _y,double _angle,double _beamWaist,double _beamWaistPosition){
		super(_name,_x,_y);
		angle = new OpticsProperty(_angle);
		beamWaist = new OpticsProperty(_beamWaist);
		beamWaistPosition = new OpticsProperty(_beamWaistPosition);
		this.addObject(angle, "Angle");
		this.addObject(beamWaist, "Beam Waist");
		this.addObject(beamWaistPosition, "Beam Waist Position");
	}

	/**
	 * 描画
	 */
	@Override
	public void paint(Graphics g) {
		int radius=20;
		int ix = x.toInt();
		int iy = y.toInt();
		double dangle = angle.toDouble();
		String sname = name.toString();

		g.drawOval(ix-radius/2,iy-radius/2,radius,radius);
		g.drawLine(ix, iy, ix+(int)(radius/2*Math.cos(dangle*Math.PI/180)), iy-(int)(radius/2*Math.sin(dangle*Math.PI/180)));
		g.drawString(sname, ix-15, iy+30);
	}
}
