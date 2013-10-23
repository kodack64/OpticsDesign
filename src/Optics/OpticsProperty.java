package Optics;

public class OpticsProperty {
	private Object obj;

	public OpticsProperty(Object _obj){
		if(_obj instanceof String || _obj instanceof Double){
			obj=_obj;
		}else{
			//throw new UnsupportedType();
		}
	}

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

	@Override
	public String toString(){
		return obj.toString();
	}

	public double toDouble(){
		if(obj instanceof Double){
			return (Double)obj;
		}else{
			return 0.;
		}
	}
	public int toInt(){
		if(obj instanceof Double){
			return ((Double)obj).intValue();
		}else{
			return 0;
		}
	}

}
