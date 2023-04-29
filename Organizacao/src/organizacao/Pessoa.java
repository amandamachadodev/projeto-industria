package organizacao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
	private String nome;
	private LocalDate dataNascimento;
	
	public Pessoa(String nome, String dataNascimento) {
		super();
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
	}
	
	public void setNome(String nome) {
		  this.nome = nome;
}

	public void setDataNascimento(String nascimento) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		  dataNascimento = LocalDate.parse(nascimento, formato);  
}
	
	public String getNome() {
		return nome;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
}
