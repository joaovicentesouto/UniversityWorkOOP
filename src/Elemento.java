import java.util.Arrays;

public class Elemento {

	// Declarando as variaveis principais
	private String tipo, id;
	private Pessoa[] pessoas;
	
	// Construtor sem parametros
	public Elemento() {
		super();
		pessoas = new Pessoa[5];
		tipo = null;
		id = null;
	}
	
	// Construtor com parametros
	public Elemento(int tamanhoArray, String tipo, String id) {
		pessoas = new Pessoa[tamanhoArray];
		this.tipo = tipo;
		this.id = id;
	}
	
	// Getters e Setters
	public Pessoa[] getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(Pessoa[] pessoas) {
		this.pessoas = pessoas;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	// Metodo complementar do completaCidade(), criando array pessoas aleatórias.
	public void criandoPessoas(boolean naoCasa) {
		Inicializacao in = new Inicializacao();
		
		if(naoCasa) { // Caso não for uma casa
			
			for(int i = 0; i < pessoas.length; i++) {
				
				// Inplementando um numero aleatório de 0 a 15 para pegar um nome e sobrenome
				// aleatório dos arrys criados para está finalidade.
				String nome = in.getNomeAleatorio(((7 * in.quantPessoas + 3) % 16 )) + " ";
				nome += in.getSobrenomeAleatorio(((5 * in.quantPessoas + 1) % 24));
				
				// Criando a pessoa com o nome e uma idade aleatória entre 1 e 60
				pessoas[i] = new Pessoa(nome, ((11 * in.quantPessoas + 1) % 60));
				
				//Incrementado o contador pessoas
				in.quantPessoas++;
			}
		} else { // Caso for uma casa
			
			for(int i = 0; i < pessoas.length; i++) {
				
				// Inplementando um numero aleatório de 0 a 15 para pegar um nome apenas.
				// dos arrys criados para está finalidade.
				String nome = in.getNomeAleatorio(((7 * in.quantPessoas + 3) % 16 )) + " ";
				nome += in.getSobrenomeAleatorio(in.quantElementos % 24);
				
				// Criando a pessoa com o nome e uma idade aleatória entre 1 e 60
				pessoas[i] = new Pessoa(nome, ((11 * in.quantPessoas + 1) % 60));
				
				//Incrementado o contador pessoas
				in.quantPessoas++;
			}
		}
	}

	// Método complementar do procuraPessoa(), para comparar nomes.
	public boolean comparaNomes(String nome) {
		
		boolean compara = false;
		
		for(int i = 0; i < pessoas.length; i++) {
			if(compara == false) {
				compara = nome.equals(pessoas[i].getNome());
			}
		}
		return compara;
	}

	// Método complementar do procuraIdadeMaiorIgual30(), para comparar idades.
	public int comparaIdade(int idade) {
		int contador = 0;
		for(int i = 0; i < pessoas.length; i++) {
			Pessoa pe = pessoas[i];
			if(pe.getIdade() >= idade){
				contador++;
			}
		}
		return contador;
	}
	
	// Método complementar do contaQuantPessoas(), para retornar a quantidade de pessoas no array Pessoas.
	public int quantPessoasArray() {
		return pessoas.length;
	}
	
	// Método que pega todos os nomes das pessoas.
	public String todosNomes() {
		String nomesConcatenados = "As pessoas no elemento " + getId() + "\n";
		
		// FOR usando uma outra sintaxe para a repetição onde não preciso criar no escopo o objeto pessoa, porque já está no for.
		for(Pessoa pe : pessoas) {
			nomesConcatenados += pe.getNome() + " / Idade: " + pe.getIdade() + "\n";
		}
		return nomesConcatenados;
	}
	
	// Método complementar do modificaElemento()
	public void modificaPessoas() {
		InteracaoUsuario iu = new InteracaoUsuario();
		for(int i = 0; i < pessoas.length; i++) {
			pessoas[i].setNome(iu.informeString("Informe o nome completo da pessoa:"));
			pessoas[i].setIdade(iu.informeInt("Informe a idade da pessoa:"));
		}
	}

	// Método toString() do Elemento.
	@Override
	public String toString() {
		return "Elemento [tipo=" + tipo + ", id=" + id + ", pessoas=" + Arrays.toString(pessoas) + "]";
	}
	
	// Método para pegar toString() de uma pessoa.
	public String getToStringPessoaX(String nomePessoa) {
		
		for(int i = 0; i < pessoas.length; i++) {
			if(nomePessoa.equals(pessoas[i].getNome())) {
				return pessoas[i].toString();
			}
		}
		return "Pessoa não encontrada.";
	}

	// Método equals no elemento. USADO NO CONTROLE
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elemento other = (Elemento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(pessoas, other.pessoas))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
}
