
public class Face {
	private SemiAresta aresta;
	private Ponto3D p;
	int indice;

	public Face(SemiAresta aresta, Ponto3D p) {
		this.aresta = aresta;
		this.p = p;
	}

	public Face(Ponto3D p) {
		this(null, p);
	}

	public Face() {
		this(null, null);
	}

	public Face(int i) {
		this.indice = i;
		this.aresta = null;
		this.p = null;
	}

	public SemiAresta getAresta() {
		return aresta;
	}

	public void setAresta(SemiAresta aresta) {
		this.aresta = aresta;
	}

	public Ponto3D getPonto3D() {
		return p;
	}

	public void setPonto3D(Ponto3D p) {
		this.p = p;
	}

	public String toString() {
		String s = ""+ aresta.indice;
		return s;
	}

	/**
	 * Devolve o numero de arestas desta face
	 * 
	 * @return int
	 */
	public int numeroArestas() {
		int cont = 0;
		SemiAresta aresta = this.aresta;

		if (aresta != null) {
			cont++;
			while (aresta.getProx() != this.aresta) {
				cont++;
				aresta = aresta.getProx();
			}
		}

		return cont;
	}
}
