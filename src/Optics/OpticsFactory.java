package Optics;

public class OpticsFactory {
	/**
	 * 個々の光学系のパーツのファクトリ
	 * @param opt 作成するパーツの種類
	 * @param x 作成するX座標
	 * @param y 作成するY座標
	 * @return 作成したパーツのインスタンス
	 */
	static Optics CreateOptics(OpticsEnum opt,double x,double y){
		if(opt == OpticsEnum.Laser){
			return CreateLaser(x,y);
		}
		return null;
	}
	/**
	 * レーザーの作成
	 * @param x 作成するX座標
	 * @param y 作成するY座標
	 * @return 作成したレーザーのインスタンス
	 */
	static Optics CreateLaser(double x,double y){
		return new Laser("Laser", x,y,0,0,0);
	}
}
