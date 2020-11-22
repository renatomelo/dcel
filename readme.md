# Doubly-Connected Edge List (DCEL)
## Implementação
- O código está em Java e os fontes estão no diterório 'src/'. 
- O programa pode ser compilado usando o make. 
- O executável (poliedro) é gerado no diretório 'bin' junto com as suas dependências.

Compilação: `make`
Execução:	`cd bin/; java poliedro < arquivo_entrada > arquivo_saida`

## Descrição da estrutura
Uma DCEL é uma estruturas de dados utilizada para representar subdivisões planares. Baseada em listas de arestas que contém três tipos de objetos principais: vértice, aresta e face. Isso facilita a travessia das faces de uma subdivisão planar, visitando todas as arestas que saem de um dado vértice.

Para cada face, aresta e vértice, são armazenados dados como, informações geométricas, topológicas e de atributo. Uma estrutura de semi aresta cujas principais ideias são: as arestas são orientadas em sentido anti-horário dentro de cada face. Uma vez que uma aresta divide dua faces, esta aresta é substituída por duas semi arestas, uma para cada face. Esses campos armazenam as seguintes informações geométricas e topológicas:

- O registro que armazena um **vértice** $v$ contém as coordenadas de $v$ e um ponteiro para uma aresta arbitrária que tem $v$ como origem.
- O registro para uma **face** salva um ponteiro para alguma semi aresta na sua borda que pode ser usada como um ponto de início da travessia da face em sentido anti horário.	
- O registro de uma **semi-aresta** $e$ armazena um ponteiro para: origem de $e$, a semi-aresta **simétrica** de $e$, a face a sua esquerda, a **próxima** semi aresta na borda da face incidente a $e$, e a semi aresta **anterior**. Não precisamos armazenar o destino da semi aresta por que este é a origem da sua semi aresta simétrica.

O espaço necessário para uma DCEL é linear no número de vértices, arestas e faces.

### Operações

As informações armazenadas nesta lista duplamente encadeada é suficiente para realizar algumas operações básicas como, por exemplo, caminhar pela borda de uma dada face em sentido anti horário, usando os ponteiros das semi arestas. Podemos também acessar uma face a partir de uma face adjacente, ou ainda, visitar todas as arestas que saem de um determinado vértice.

Além disso podemos fazer algumas consultas interessantes, como: dada a descrição de uma DCEL, uma reta $L$ e uma semi aresta que é cortada por $L$, encontrar eficientemente todas as faces que são cortadas por $L$.

A seguinte rotina ilustra como seria possível atravessar uma face $f$: 
	**Entrada**: uma aresta de  $f$
		1. Determina a semi aresta $e$, incidente à $f$
		2. aresta_atual $\leftarrow e$
		3. **Enquanto** próxima($e$) $\neq$ aresta_atual **faça**
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;$e \leftarrow$ próxima($e$)

Atravessando todas as arestas incidentes a um vértice $v$:
	**Entrada**: uma semi aresta $e$ que tem origem em $v$
	**Saída**: Apenas as semi arestas que têm origem em $ v $
		1. aresta\_atual $\leftarrow e$
		2. **Enquanto** próxima(simétrica($e$)) $\neq$ aresta_atual **faça**
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;$e \leftarrow$ próxima(simétrica($ e $))

Apesar das várias vantagens que podem ser obtidas em usar uma estrutura DCEL, tais como, eficiência nas buscas, na travessia entre arestas e faces, flexibilidade no formato dos dados processados e a possibilidade de funcionar em diversos algoritmos. É preciso ser cuidadoso na hora de escolher usar uma DCEL, porque em alguns casos pode ser exagero usar uma estrutura tão robusta, se alguma aplicação pode ser feita com estruturas mais simples. Isso principalmente por causa da complexidade de implementação. 

