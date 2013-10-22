package Optics;

public class OpticsFactory {
	static Optics CreateOptics(OpticsEnum opt,double x,double y){
		if(opt == OpticsEnum.Laser){
			return CreateLaser(x,y);
		}
		return null;
	}
	static Optics CreateLaser(double x,double y){
		return new Laser("Laser", x,y,0,0,0);
	}
}
