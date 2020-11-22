
public class SemiAresta {
	public int indice = 0;
	public Vertice origem;
	private SemiAresta simetrica, ant, prox;
	private Face faceIncidente;

	public SemiAresta(Vertice origem, SemiAresta simetrica, SemiAresta ant, SemiAresta prox, Face faceIncidente) {
		this.origem = origem;
		this.simetrica = simetrica;
		this.ant = ant;
		this.prox = prox;
		this.faceIncidente = faceIncidente;
	}

	public SemiAresta(int i) {
		indice = i;
		this.origem = null;
		this.simetrica = null;
		this.ant = null;
		this.prox = null;
		this.faceIncidente = null;
	}

	public SemiAresta(Vertice v, Face face) {
		this.origem = v;
		this.simetrica = null;
		this.ant = null;
		this.prox = null;
		this.faceIncidente = face;
		
	}

	public String toString(){
		return ""+origem.indice+" "+simetrica.indice+" "+
				faceIncidente.indice+" "+prox.indice +" "+ant.indice;
	}

	public Vertice getOrigem() {
		return origem;
	}

	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}

	public SemiAresta getSimetrica() {
		return simetrica;
	}

	public void setSimetrica(SemiAresta simetrica) {
		this.simetrica = simetrica;
	}

	public SemiAresta getAnt() {
		return ant;
	}

	public void setAnt(SemiAresta ant) {
		this.ant = ant;
	}

	public SemiAresta getProx() {
		return prox;
	}

	public void setProx(SemiAresta prox) {
		this.prox = prox;
	}

	public Face getFaceIncidente() {
		return faceIncidente;
	}

	public void setFaceIncidente(Face faceIncidente) {
		this.faceIncidente = faceIncidente;
	}
}
