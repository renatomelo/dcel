import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class poliedro {
	List<Vertice> vertices;
	List<Face> faces;
	List<SemiAresta> arestas;
	int numSemiArestas = 0;


	public poliedro(int n, int f) {
		this.vertices = new ArrayList<>(n);
		this.arestas = new ArrayList<>();
		this.faces = new ArrayList<>(f);
	}

	public poliedro(Ponto3D[] pontos) {
		this.vertices = new ArrayList<>();
		this.arestas = new ArrayList<>();
		this.faces = new ArrayList<>();
		inicializar(pontos);
	}
	
	private void inicializar(Ponto3D[] pontos) {
		for (int i = 0; i < pontos.length; i++) {
			vertices.add(new Vertice(i+1,pontos[i]));
		}
	}

//	private void inicializar(Ponto3D[] pontos) {
//		int nsemiarestas=1;
//		Face f = new Face();
//		faces.add(f);
//
//		SemiAresta arestaEsqAnt = null;
//		SemiAresta arestaDirAnt = null;
//
//		// Percorre os pontos para criar os vertices e semi arestas para a
//		// estrutura
//		for (int i = 0; i < pontos.length; i++) {
//			Ponto3D p = pontos[i];
//
//			Vertice v = new Vertice(i+1,p);
//			SemiAresta esquerda = new SemiAresta(nsemiarestas++);
//			SemiAresta direita = new SemiAresta(nsemiarestas++);
//
//			// Determina as arestas esquerdas e direitas
//			esquerda.setFaceIncidente(f);
//			esquerda.setProx(null);
//			esquerda.setOrigem(v);
//			esquerda.setSimetrica(direita);
//
//			direita.setFaceIncidente(null);
//			direita.setProx(arestaDirAnt);
//			direita.setOrigem(null);
//			direita.setSimetrica(esquerda);
//
//			// insere na lista de arestas
//			arestas.add(esquerda);
//			arestas.add(direita);
//
//			v.setSaida(esquerda);
//
//			vertices.add(v);
//
//			// configura as arestas anteriores e proximas à esquerda
//			if (arestaEsqAnt != null)
//				arestaEsqAnt.setProx(esquerda);
//
//			// configura a origem da aresta a direita
//			if (arestaDirAnt != null)
//				arestaDirAnt.setOrigem(v);
//
//			arestaEsqAnt = esquerda;
//			arestaDirAnt = direita;
//		}
//
//		SemiAresta arestaEsquerda1 = arestas.get(0);
//		arestaEsqAnt.setProx(arestaEsquerda1);
//
//		// define a primeira aresta do proximo ponto para a ultima aresta
//		// direita criada. As arestas direitas estão nos indicies impares
//		SemiAresta arestaDireita1 = arestas.get(1);
//		arestaDireita1.setProx(arestaDirAnt);
//		// define a ultima aresta direita da origem para o primeiro vertice na
//		// lista
//		arestaDirAnt.setOrigem(vertices.get(0));
//
//		// define a aresta da face para a primeira aresta esquerda
//		f.setAresta(arestaEsquerda1);
//	}

	public void adicionaFace(int[] indices) {
		Face f = new Face(numFaces()+1);
		
		SemiAresta ant = null;
		
		for (int i = 0; i < indices.length; i++) {
			
			SemiAresta atual;
						
			atual = new SemiAresta(vertices.get(indices[i]-1), f);
			
			if(vertices.get(indices[i]-1).getSaida() == null)
				vertices.get(indices[i]-1).setSaida(atual);
			
			atual.indice = ++numSemiArestas;
			arestas.add(atual);
			
			if (ant != null) {
				atual.setAnt(ant);
				atual.setSimetrica(ant);
				
				ant.setProx(atual);
				ant.setSimetrica(atual);
			} else {
				f.setAresta(atual);
			}
			ant = atual;
		}
		f.getAresta().setAnt(ant);
		ant.setProx(f.getAresta());
		
		f.setPonto3D(f.getAresta().getOrigem().getCoord());
		
		faces.add(f);
	}

	int numVertices() {
		return vertices.size();
	}

	int numArestas() {
		return arestas.size()/2;
	}

	int numFaces() {
		return faces.size();
	}

	int grauVertice(Vertice v) {
		int grau = 0;

		SemiAresta e = v.getSaida();
		SemiAresta prox = e.getProx().getSimetrica();

		while (prox != e) {
			prox = prox.getProx().getSimetrica();
			grau++;
		}

		return grau + 1;
	}

	boolean ehFechado() {
		for (SemiAresta e : arestas)
			if (e.getFaceIncidente() == null)
				return false;
		return true;
	}

	public static void main(String[] args) {
		Ponto3D[] pontos;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f = sc.nextInt();
		sc.nextLine();
		pontos = new Ponto3D[n];
		
		int x, y, z;
		for (int i = 0; i < n; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			z = sc.nextInt();
			pontos[i]= new Ponto3D(x, y, z);
			sc.nextLine();
		}
		
		poliedro poliedro = new poliedro(pontos);
		
		while (sc.hasNextLine()) {
			int indices[] = new int[4];
			int j=0;
			while(j < 4){
				indices[j] = sc.nextInt();
				j++;
			}
			poliedro.adicionaFace( indices);
			sc.nextLine();
		}

		

		List<Vertice> vert = poliedro.vertices;
		List<SemiAresta> are = poliedro.arestas;
		List<Face> fac = poliedro.faces;

		System.out.println(poliedro.numVertices() + " " + poliedro.numArestas() + " " + poliedro.numFaces());

//		System.out.println("Vertices");
		for (Vertice v : vert) {
			System.out.println(v+" "+v.getSaida().indice);
		}

//		System.out.println("Faces");
		for (Face fa : fac) {
			System.out.println(fa);
		}

//		System.out.println("Semi arestas");
		for (SemiAresta sa : are) {
			System.out.println(sa);
		}

	}
}
