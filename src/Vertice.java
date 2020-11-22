public class Vertice {
	private Ponto3D coord;
	private SemiAresta saida; 
	public int indice;
	
	public Vertice(Ponto3D Ponto3D, SemiAresta incidente){
		this.coord = Ponto3D;
		this.saida = incidente;
	}
	
	public Vertice(int i, Ponto3D p){
		indice = i;
		coord = p;
		saida = null;
	}
	
	public Vertice(){
		this(null, null);
	}

	public Ponto3D getCoord() {
		return coord;
	}

	public void setCoord(Ponto3D coord) {
		this.coord = coord;
	}

	public SemiAresta getSaida() {
		return saida;
	}

	public void setSaida(SemiAresta incidente) {
		this.saida = incidente;
	}

	@Override
	public String toString() {
		return coord+" ";
	}
}
