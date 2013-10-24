package Optics;

public class OpticsProperty {
	private Object obj;

	/**
	 * コンストラクタ
	 * @param _obj 管理するオブジェクト
	 */
	public OpticsProperty(Object _obj){
		if(_obj instanceof String || _obj instanceof Double){
			obj=_obj;
		}else{
			//throw new UnsupportedType();
		}
	}

	/**
	 * 入力された文字列から管理するオブジェクトの値を更新
	 * @param val
	 */
	public void updateValue(String val){
		if(obj instanceof String){
			obj = val;
		}
		if(obj instanceof Double){
			try{
				obj = Double.parseDouble(val);
			}catch(Exception e){
				obj = 0.;
			}
		}
	}

	/**
	 * 文字列に変換
	 */
	@Override
	public String toString(){
		return obj.toString();
	}

	/**
	 * 実数に変換
	 * @return 管理オブジェクトを変換した数値。読み取れない場合は0。
	 */
	public double toDouble(){
		if(obj instanceof Double){
			return (Double)obj;
		}else{
			return 0.;
		}
	}
	/**
	 * 整数に変換
	 * @return 管理オブジェクトを変換した数値。読み取れない場合は0。
	 */
	public int toInt(){
		if(obj instanceof Double){
			return ((Double)obj).intValue();
		}else{
			return 0;
		}
	}

}
