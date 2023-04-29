package organizacao;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa {
	private BigDecimal salario;
	private String funcao;
	
	public Funcionario(String nome, String dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.setSalario(salario);
		this.setFuncao(funcao);
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	  }
	
	public void setFuncao(String funcao) {
		  if (!funcao.isEmpty()) {
			  this.funcao = funcao;  
		  }
	  }
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	
	@Override
	public String toString() {
		@SuppressWarnings("deprecation")
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return "\nNome: " + this.getNome() +
					"\nData de nascimento: " +
					formatador.format(this.getDataNascimento())
					+ "\nSalário: " + nf.format(this.getSalario())
					+ "\nFunção: " + this.getFuncao();
	}
	
}
