import javax.swing.JOptionPane;

public class InteracaoUsuario {

	// Construtor sem parametros
	public InteracaoUsuario() {
		super();
	}
	
	// Metodo que retorna um numero inteiro
	public int informeInt(String texto) {
		return Integer.parseInt(JOptionPane.showInputDialog(texto));
	}
	
	// Metodo que retorna uma String
	public String informeString(String texto) {
		return JOptionPane.showInputDialog(texto);
	}
	
	// Metodo que apenas mostra uma mensagem, sem retorno
	public void mostraMensagem(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
	
	
	
}
