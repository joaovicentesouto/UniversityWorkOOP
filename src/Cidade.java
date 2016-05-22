import java.util.Arrays;

public class Cidade {

	
	// Declaração das variáveis principais.
	private Elemento[][] cidade;
	
	// Construtor sem parâmetros.
	public Cidade() {
		super();
		cidade = new Elemento[4][4];
	}
	
	// Construtor com parâmetros.
	public Cidade(int tamanhoMatriz) {
		cidade = new Elemento[tamanhoMatriz][tamanhoMatriz];
	}
	
	// Getters e Setters.
	public Object[][] getCidade() {
		return cidade;
	}
	
	public void setCidade(Elemento[][] cidade) {
		this.cidade = cidade;
	}
	
	public Elemento getElemento(int i, int j) {
		return cidade[i][j];
	}
	
	// Metodo povoamento da cidade.
	public void completaCidade() {
		
		// FOR para percorrer a matriz
		for(int i = 0; i < cidade.length; i++) {
			
			// Instancialização do objeto IN para pegar os nomes aleatórios.
			Inicializacao in = new Inicializacao();
			
			for(int j = 0; j < cidade[0].length; j++) {
				
				// Primeiro IF compara a quantidade de elementos ja criada. Se == 0, cria uma casa com uma quantidade aleatória de pessoas (1 à 5).
				// e com o nome Casa dos "Sobrenome na posição 0".
				if(in.quantElementos == 0) {
					
					// Criando um elemento e já jogando ele em uma posicção.
					// Usando construtor com parâmetros(tamanho array, tipo, identificador).
					cidade[i][j] = new Elemento((((3 * in.quantElementos + 2) % 5) + 1),
										"Casa", ("Casa dos " + in.getSobrenomeAleatorio(0)));
					
					// Criando aleatóriamente as pessoas no array Pessoas.
					cidade[i][j].criandoPessoas(false);
					
					// Incremento no contador de elementos e o de casas.
					in.quantElementos++;
					in.quantCasas++;
					
				} else {	// Caso não seja igual a 0.
					
					// Segundo IF -> Caso um número aleatório(0 a "tamanho da cidade -1") seja divisível por 3
					// Será uma escola.
					if((((10 * in.quantElementos + 1) % 16) % 3) == 0 ) {
						
						// Idem ao outros construtor, porém o tamanho do array é aleatório.
						cidade[i][j] = new Elemento((((3 * in.quantElementos + 2) % 5) + 1), 
											"Escola", ("Escola " + (in.quantEscolas+1)));
						cidade[i][j].criandoPessoas(true);
						
						// Incremento no contador de elementos e o de escolas.
						in.quantElementos++;
						in.quantEscolas++;
						
					} else { // Caso não seja divisível por 3.
						
						// Terceiro IF -> Caso um número aleatório(0 a "tamanho da cidade -1") seja divisivel por 4
						// OU o segundo elemento criado, será um hospital.
						if((((((5 * in.quantElementos + 1) % 16) % 4) == 0) || (in.quantElementos == 1))) {
							
							// Idem aos outros construtores
							cidade[i][j] = new Elemento((((3 * in.quantElementos + 2) % 5) + 1), 
												"Hospital", ("Hospital " + (in.quantHospitais+1)));
							cidade[i][j].criandoPessoas(true);
							
							// Incremento no contador de elementos e o de hospitais.
							in.quantElementos++;
							in.quantHospitais++;
							
						} else { // E por fim, será um números qualquer.
							
							// Agora agorando um nome aleatório para a casa que será o mesmo nome aleatório das pessoas.
							cidade[i][j] = new Elemento((((3 * in.quantElementos + 2) % 5) + 1), 
												"Casa", ("Casa dos " + in.getSobrenomeAleatorio(in.quantElementos % 24)));
							cidade[i][j].criandoPessoas(false);
							
							// Incremento no contador de elementos e o de casas.
							in.quantElementos++;
							in.quantCasas++;
						}
					}
				}
			}
		}
	}
	
	// Metodo genérico para procurar um tipo de elemento na matriz.
	public int procuraQuantElemento(String tipo, int linhaInicial, int linha, int colunaInicial, int coluna) {
		
		// Contador de elementos.
		int quantidade = 0;
		
		// For para percorrer a matriz cidade nos quadrantes informados
		for(int i = linhaInicial; i < linha; i++) {
			for(int j = colunaInicial; j < coluna; j++) {
				
				// IF para comparar o tipo com o tipo do elemento.
				if(tipo.equals(cidade[i][j].getTipo())) {
					quantidade++;
				}
			}
		}
		// Retorna a quantidade de elementos daquele tipo.
		return quantidade;
	}
	
	// Método para pesquisar a existência de uma determinada Pessoa (pelo Nome) na matriz Cidade e retornar o objeto (identificador) que ela se encontra.
	public String procuraPessoa(String nome) {
		
		// Variável auxiliar.
		String identificador = nome + " não foi encontrado nenhuma pessoa com esse nome.";
		
		// FOR para percorrer a matriz, se ela achar uma pessoa em um dos elementos com o nome igual vai parar e retornar o identificador.
		for(int i = 0; i < cidade.length; i++) {
			for(int j = 0; j < cidade[0].length; j++) {

				// IF para comparar os nomes, caso forem iguais é TRUE, atribui o nome do identificadaor e para o FOR.
				if(cidade[i][j].comparaNomes(nome)) {
					
					// Susbistitui a frase original pelo nome do identificador.
					identificador = nome + " foi encontrado no elemento: " + cidade[i][j].getId();
					return identificador;
				}
			}
		}
		// Retorna o identificador.
		return identificador;
	}

	// Método para informar o número de objetos do tipo Pessoa com idade maior ou igual a uma idade qualquer (30 anos).
	public int procuraIdadeMaiorIgualQueX(int idade) {
		
		// Variável auxiliar.
		int quantidade = 0;
		
		// FOR para percorrer a matriz, se ela achar uma pessoa com idade > ou = a 30, incrementa a quantidade em +1.
		for(int i = 0; i < cidade.length; i++) {
			for(int j = 0; j < cidade[0].length; j++) {
				
				// Aqui ele manda a idade e compara com todas as pessoas e retorna a quantidade de pessoas com idade > ou = aquela informada.
				quantidade += cidade[i][j].comparaIdade(idade);
			}
		}
		// Retorna a quantidade.
		return quantidade;
	}

	// Método para informar o número total de objetos do tipo Pessoa na matriz Cidade.
	public int contaQuantPessoas() {
		
		// Variável auxiliar.
		int quantidade = 0;
		
		// FOR para percorrer a matriz.
		for(int i = 0; i < cidade.length; i++) {
			for(int j = 0; j < cidade[0].length; j++) {
				
				// Soma da quantidade de cada array Pessoas de cada elemento.
				quantidade += cidade[i][j].quantPessoasArray();
			}
		}
		return quantidade;
	}

	// Método para pegar todos os elementos e as pessoas que estão neles.
	public void todasPessoas() {
		
		InteracaoUsuario iu = new InteracaoUsuario();
		
		for(int i = 0; i < cidade.length; i++) {
			for(int j = 0; j < cidade[0].length; j++) {
				iu.mostraMensagem(cidade[i][j].todosNomes());
			}
		}
	}

	// Método para representar a matriz graficamente.
	public String desenhoCidade() {
		String desenho = "";
		String informacao = "";
		
		for(int i = 0; i < cidade.length; i++) {
			for(int j = 0; j < cidade[0].length; j++) {
				
				if(cidade[i][j].getTipo().equals("Casa")) {
					desenho += "|   Casa   |";
					informacao += "Posição (" + i + ", " + j + ") : " + cidade[i][j].getId() + "\n"; 
				} else {
					
					if(cidade[i][j].getTipo().equals("Escola")) {
						desenho += "|  Escola  |";
						informacao += "Posição (" + i + ", " + j + ") : " + cidade[i][j].getId() + "\n";
					} else {
						desenho += "| Hospital |";
						informacao += "Posição (" + i + ", " + j + ") : " + cidade[i][j].getId() + "\n";
					}
				}
			}
			desenho += "\n";
		}
		desenho += "\n" + informacao;
		return desenho;
	}
	
	// Desenho matriz para o seletor de modificador
	public String matrizComCoordenadas() {
		String comCoordenadas = "";
		
		for(int i = 0; i < cidade.length; i++) {
			for(int j = 0; j < cidade[0].length; j++) {
				comCoordenadas += "| " + i + ", " + j + " ";
			}
			comCoordenadas += "|\n";
		}
		
		return comCoordenadas;
	}
	
	// Método para modificar as informações de um elemento.
	public void modificaElemento(int posicaoLinha, int posicaoColuna) {
		InteracaoUsuario iu = new InteracaoUsuario();
		// Alterando os dados do elemento.
		cidade[posicaoLinha][posicaoColuna].setTipo(iu.informeString("Informe o tipo do elemento:"));
		cidade[posicaoLinha][posicaoColuna].setId(iu.informeString("Informe o identificador do elemento:"));
		cidade[posicaoLinha][posicaoColuna].modificaPessoas();
	}

	// Método toString() padrão para a matriz cidade.
	@Override
	public String toString() {
		return "Cidade [cidade=" + Arrays.toString(cidade) + "]";
	}	
	
	// Método para pegar toString de um elemento:
	public String getToStringElementoX(String idElemento){
		
		for(int i = 0; i < cidade.length; i++) {
			for(int j = 0; j < cidade[0].length; j++) {

				// IF para comparar os nomes, caso forem iguais é TRUE, atribui o nome do identificadaor e para o FOR.
				if(cidade[i][j].getId().equals(idElemento)) {
					return cidade[i][j].toString();
				}
			}
		}
		return "Elemento não encontrado.";
	}

	// Método pagar pegar o toString de uma pessoa.
	public String getToStringPessoaX(String nomePessoa) {
		
		// FOR para percorrer a matriz, se ela achar uma pessoa em um dos elementos com o nome igual vai parar e retornar o identificador.
		for(int i = 0; i < cidade.length; i++) {
			for(int j = 0; j < cidade[0].length; j++) {

				// IF para comparar os nomes, caso forem iguais é TRUE, atribui o nome do identificadaor e para o FOR.
				if(cidade[i][j].comparaNomes(nomePessoa)) {
					return cidade[i][j].getToStringPessoaX(nomePessoa);
				}
			}
		}
		// Retorna o identificador.
		return "Pessoa não encontrada";
	}

	
	// Método equals padrão do eclipse.
	// Mas acho que não se usa aqui porque é para comparar uma cidade com outra, por isso implementei um no elemento.
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
