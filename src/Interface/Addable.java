package Interface;

import Optics.OpticsEnum;

public interface Addable {
	/**
	 * オプティクスを追加する
	 * @param id 追加するオプティクスの種類
	 * @param x 追加するX座標
	 * @param y 追加するY座標
	 */
	public void addOptics(OpticsEnum id,double x,double y);
}
