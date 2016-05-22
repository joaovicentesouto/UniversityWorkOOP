
public class Controle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// OBSERVAÇÃO : Existe um arquivo .txt na pasta src com algumas observações
		// para ficar mais claro alguns pontos do meu trabalho. Obrigado
		// Desculpe todos esses comentários.
		
		
		// Variáveis principáis.
		boolean continua = true;
		int tamanhoCidade = 0;
		
		// Instancilizões principais.
		InteracaoUsuario iu = new InteracaoUsuario();
		Cidade cidadeX;
		
		// Instanciando a cidade com tamanho N.
		tamanhoCidade = iu.informeInt("Informe um número par para o\ntamanho da matriz Cidade:");
		cidadeX = new Cidade(tamanhoCidade);
		
		// Completando a matriz com objetos.
		cidadeX.completaCidade();
		
		// DO_WHILE para realizar todas as ações e métodos. Só para quando o usuário quiser sair do programa.
		do {
			
			// Variáveis auxiliares.
			int seletorDeOpcao = 0;
			
			// Interação com o usuário para ele escolher o método que quer executar.
			seletorDeOpcao = iu.informeInt("Informe o número da ação que deseja fazer primeiro:\n"
									 	 + "1 : Descobrir a quantidade de um tipo de elemento na matriz/quadrante.\n"
									 	 + "2 : Procurar uma pessoa pelo nome.\n"
									 	 + "3 : Procurar a quantidade de pessoas com idade > ou = a 30(ou outra idade).\n"
									 	 + "4 : Informar a quantidade de pessoas na cidade.\n"
									 	 + "5 : Mostrar o nome de todas as pessoas, elemento por elemento.\n"
									 	 + "6 : Mostrar uma representação gráfica da cidade e seus elementos.\n"
									 	 + "7 : Alterar os dados de um elemento.\n"
									 	 + "8 : Método toString() das classes (Opção de escolher qual classe).\n"
									 	 + "9 : Método equals() : Compara um elemento com outro (Informado pelo usuário).\n"
									 	 + "10: Sair do programa.");
			
			// IF para realizar a contagem da quantidade de um tipo de elemento na matriz ou em um quadrante.
			if(seletorDeOpcao == 1){
				String tipo = iu.informeString("Informe o tipo de objeto que você deseja procurar.\n"
												+ "Casa, Escola ou Hospital:");
				int procurarNoLocal = iu.informeInt("Informe o número onde deseja procurar:\n"
													+ "0 : Na cidade inteira.\n"
													+ "1 : No primeiro quadrante / Q1.\n"
													+ "2 : No segundo quadrante  / Q2.\n"
													+ "3 : No terceiro quadrante / Q3.\n"
													+ "4 : No quarto quadrante   / Q4.\n");
				
				// Na matriz inteira
				if(procurarNoLocal == 0){
					iu.mostraMensagem("A quantidade de elementos do tipo " + tipo + " na matriz inteira é: " + 
										cidadeX.procuraQuantElemento(tipo, 0, tamanhoCidade, 0, tamanhoCidade));
				}
				
				// No quadrante Q1
				if(procurarNoLocal == 1){
					iu.mostraMensagem("A quantidade de elementos do tipo " + tipo + " no 1º quadrante é: " + 
										cidadeX.procuraQuantElemento(tipo, 0, tamanhoCidade/2, 0, tamanhoCidade/2));
				}
				
				// No quadrante Q2
				if(procurarNoLocal == 2){
					iu.mostraMensagem("A quantidade de elementos do tipo " + tipo + " no 2º quadrante é: " + 
										cidadeX.procuraQuantElemento(tipo, 0, tamanhoCidade/2, tamanhoCidade/2, tamanhoCidade));
				}
				
				// No quadrante Q3
				if(procurarNoLocal == 3){
					iu.mostraMensagem("A quantidade de elementos do tipo " + tipo + " no 3º quadrante é: " + 
										cidadeX.procuraQuantElemento(tipo, tamanhoCidade/2, tamanhoCidade, 0, tamanhoCidade/2));
				}
				
				// No quadrante Q4
				if(procurarNoLocal == 4){
					iu.mostraMensagem("A quantidade de elementos do tipo " + tipo + " no 4º quadrante é: " + 
										cidadeX.procuraQuantElemento(tipo, tamanhoCidade/2, tamanhoCidade, tamanhoCidade/2, tamanhoCidade));
				}
				
				// Caso o usuario insira um número fora das opções disponiveis.
				if(procurarNoLocal < 0 || procurarNoLocal > 4){
					iu.mostraMensagem("Lamento mas você escolheu uma opção inválida.");
				}
				
			}
			
			// IF para procurar uma pessoa pelo nome na matriz e retornar onde ela está.
			if(seletorDeOpcao == 2) {
				String procurarPeloNome = iu.informeString("Informe o nome da pessoa que deseja encontrar:");
				iu.mostraMensagem(cidadeX.procuraPessoa(procurarPeloNome));
			}
			
			// IF para procurar a quantidade de pessoas com idade maior ou igual a determinada idade (informada pelo usuário).
			if(seletorDeOpcao == 3) {
				int idade = iu.informeInt("Informe a idade para ser comparada (> ou =):");
				iu.mostraMensagem("A quantidade de pessoas com idade maior ou igual a " + idade + " é: " +
									cidadeX.procuraIdadeMaiorIgualQueX(idade));
			}
			
			// IF para informar a quantidade de objetos do tipo pessoas na matriz.
			if(seletorDeOpcao == 4) {
				iu.mostraMensagem("A quantidade de pessoas na cidade é: " + cidadeX.contaQuantPessoas());
			}
			
			// IF para mostrar o nome de todas as pessoas e em quais quadrantes estão.
			if(seletorDeOpcao == 5) {
				cidadeX.todasPessoas();
			}
			
			// IF para mostrar uma representação gráfica da matriz.
			if(seletorDeOpcao == 6) {
				iu.mostraMensagem(cidadeX.desenhoCidade());
			}
			
			// IF para modificar um elemento.
			if(seletorDeOpcao == 7) {
				int posicaoLinha = 0, posicaoColuna = 0;
				posicaoLinha = iu.informeInt("Por favor, escolha o primeiro número da coordenada que quer alterar ( ?, y):\n"
											+ cidadeX.matrizComCoordenadas());
				posicaoColuna = iu.informeInt("Por favor, escolha o segundo número da coordenada que quer alterar ( x, ?):\n"
											+ cidadeX.matrizComCoordenadas());
				cidadeX.modificaElemento(posicaoLinha, posicaoColuna);
				iu.mostraMensagem("O elemento foi alterado com sucesso!");
			}
			
			// IF para métodos toString().
			if(seletorDeOpcao == 8) {
				int qualToString = iu.informeInt("Informe qual toString você deseja ver:\n"
												+ "1 : toString() da classe Cidade.\n"
												+ "2 : toString() da classe Elemento.\n"
												+ "3 : toString() da classe Pessoa.");
				
				// toString da cidade.
				if(qualToString == 1)
					
					//iu.mostraMensagem(cidadeX.toString()); // Mostra o toString() da cidade porém aparece apenas o endereço da memória dos elementos.
					// FOR para mostrar os toString() de todos os elementos.
					for(int i = 0; i < cidadeX.getCidade().length; i++) {
						for(int j = 0; j < cidadeX.getCidade()[0].length; j++) {
							iu.mostraMensagem(cidadeX.getCidade()[i][j].toString());
						}
					}
				
				
				// toString() apenas de um elemento.
				if(qualToString == 2)
					iu.mostraMensagem(cidadeX.getToStringElementoX(iu.informeString("Informe o identificador do elemento que deseja chamar o toString():")));
					
				// toString() apenas de uma pessoa.
				if(qualToString == 3)
					iu.mostraMensagem(cidadeX.getToStringPessoaX(iu.informeString("Informe o nome da pessoa que deseja chamar o toString():")));
				
				// Caso digitar o numero errado.
				if(qualToString < 1 || qualToString > 3)
					iu.mostraMensagem("Lamento mas não foi possível encontrar essa funcionalidade.");
					
			}
			
			// IF para usar o equals
			if(seletorDeOpcao == 9) {
				
				// Pegando as coordenadas de cada elemento que deseja comparar.
				int x1, y1, x2, y2;
				x1 = iu.informeInt("Informe a coordenada X do Primeiro objeto que deseja comparar");
				y1 = iu.informeInt("Informe a coordenada Y do Primeiro objeto que deseja comparar");
				x2 = iu.informeInt("Informe a coordenada X do Segundo objeto que deseja comparar");
				y2 = iu.informeInt("Informe a coordenada Y do Segundo objeto que deseja comparar");
				
				
				// equal() que compara um elemente a outro.
				if(cidadeX.getElemento(x1, y1).equals(cidadeX.getElemento(x2, y2))) {
					iu.mostraMensagem("Os dois objetos são iguais.");
				} else {
					iu.mostraMensagem("Os dois objetos NÃO são iguais.");
				}
			}
			
			// IF para terminar a aplicação.
			if(seletorDeOpcao == 10) {
				break;
			}
			
			if(seletorDeOpcao < 1 || seletorDeOpcao > 10) {
				iu.mostraMensagem("Lamento mas essa opção é inválida.");
			}
			
			// IF para continuar ou não com o programa.
			String querContinuar = iu.informeString("Deseja continuar?\n Digite Sim ou Não:");
			if(querContinuar.equals("Não") || querContinuar.equals("Nao") ||
			   querContinuar.equals("não") ||  querContinuar.equals("nao")) {
				continua = false;
			}
			
		} while(continua);
		
		// Testes.
		Inicializacao in = new Inicializacao();
		System.out.println("As quantidades para testes:");
		System.out.println("A quantidade de casas é: " + in.quantCasas);
		System.out.println("A quantidade de escolas é: " + in.quantEscolas);
		System.out.println("A quantidade de hospitais é: " + in.quantHospitais);
		System.out.println("A quantidade total de elementos é: " + in.quantElementos);
		System.out.println("A quantidade total de pessoas é: " + in.quantPessoas);

	}

}
