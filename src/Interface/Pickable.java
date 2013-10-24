package Interface;

public interface Pickable {
	/**
	 * 座標に応じてオプティクスにフォーカスする。
	 * @param x 指定するX座標
	 * @param y 指定するY座標
	 */
	public void pick(int x,int y);
}
