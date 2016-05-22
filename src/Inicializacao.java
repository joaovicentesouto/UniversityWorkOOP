import java.util.Arrays;

public class Inicializacao {

	// Nomes aleatórios para as Pessoas
	public String[] nomesAleatorios = {"João", "Sansa", "Bran", "Rob",
										"Ceasar", "Eddard", "Bruce", "Issac",
										"Clark", "Claudia", "Jean", "Camila",
										"Neil", "Edgar", "Felix", "Marta"};
	
	public String[] sobrenomesAleatorios = {"Souto", "Santos", "Batista", "Trunda",
											"Otoni", "Snow", "Pascal", "Newton",
											"Tesla", "Drogon", "Parker", "Wayne",
											"Lannister", "Folks", "Arryn", "Stark",
											"Borges", "Dontos", "Taurus", "Zetta",
											"Lewis", "Dracula", "Sultan", "Nike"};
	
	//Variáveis publicas e estáticas que são usadas parar gerar nomes aleatórios. OBS.: Eu uso um método para contar pessoa por pessoa e não essas variaveis.
	public static int quantElementos = 0;
	public static int quantPessoas = 0;
	public static int quantCasas = 0;
	public static int quantHospitais = 0;
	public static int quantEscolas = 0;
	
	public Inicializacao() {
		super();
	}
	
	public String getNomeAleatorio(int n) {
		return nomesAleatorios[n];
	}
	
	public String getSobrenomeAleatorio(int s) {
		return sobrenomesAleatorios[s];
	}

	@Override
	public String toString() {
		return "Inicializacao [nomesAleatorios=" + Arrays.toString(nomesAleatorios) + ", sobrenomesAleatorios="
				+ Arrays.toString(sobrenomesAleatorios) + "]";
	}
	
	
}
