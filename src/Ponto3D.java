
/**
 * Representa um ponto no espaço 3D
 * @author renato
 *
 */
public class Ponto3D {
	double x, y, z;
	
	public Ponto3D(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String toString(){
		int x = (int)this.x;
		int y = (int) this.y;
		int z = (int) this.z;
		return ( x+" "+y+" "+z);
	}
}
