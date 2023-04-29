package organizacao;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Organizacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		lista.add(new Funcionario("Maria", "18/10/2000", new BigDecimal(2009.44), "Operador"));
		lista.add(new Funcionario("João", "12/05/1990", new BigDecimal(2284.38), "Operador"));
		lista.add(new Funcionario("Caio", "02/05/1961", new BigDecimal(9836.14), "Coordenador"));
		lista.add(new Funcionario("Miguel", "14/10/1988", new BigDecimal(19119.88), "Diretor"));
		lista.add(new Funcionario("Alice", "05/01/1995", new BigDecimal(2234.68), "Recepcionista"));
		lista.add(new Funcionario("Heitor", "19/11/1999", new BigDecimal(1582.72), "Operador"));
		lista.add(new Funcionario("Arthur", "31/03/1993", new BigDecimal(4071.84), "Contador"));
		lista.add(new Funcionario("Laura", "08/07/1994", new BigDecimal(3017.45), "Gerente"));
		lista.add(new Funcionario("Heloisa", "24/05/2003", new BigDecimal(1606.85), "Eletricista"));
		lista.add(new Funcionario("Helena", "02/09/1996", new BigDecimal(2799.93), "Gerente"));
		
		
		//Imprime funcionários
		for (Funcionario f: lista) {
			System.out.println(f);
		}

		//Remove João da lista de funcionários
		lista.removeIf(i -> i.getNome().contains("João"));
		System.out.println("\n-Remove João-");
		for (Funcionario f: lista) {
			System.out.println(f);
		}
		
		
		//Aumento de salário de 10% para todos os funcionários
		System.out.println("\n-Atualiza salário-");
		for (Funcionario f: lista) {
			BigDecimal percentualAumento = new BigDecimal(10);
			BigDecimal percentual = f.getSalario().divide(percentualAumento);
			f.setSalario(f.getSalario().add(percentual));
			System.out.println(f);
		}
		
		//Agrupa funcionários for função
		System.out.println("\n-Agrupa por função-\n");
		Map<String, List<Funcionario>> map = lista.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
		System.out.println(map);
		
		System.out.println("\n-Aniversariantes do mês 10 e 12-");
		for (Funcionario f: lista) {
			String mes = f.getDataNascimento().getMonth().toString();
			if (mes == "OCTOBER" || mes == "DECEMBER") {
				System.out.println(f);
			}
		}
		
		
		//Imprime funcionário mais velho
		LocalDate anoAtual = LocalDate.now();
		String nome = "";
		int idade = 0;
		System.out.println("\n-Funcionário mais velho-\n");
		for (Funcionario f: lista) {
			Period periodo = Period.between(anoAtual, f.getDataNascimento());
			if (periodo.getYears() < idade) {
				nome = f.getNome();
				idade = periodo.getYears();
			}
		}
		System.out.println("\nNome: " + nome + "\nIdade: " + idade);
		
		
		//Funcionários em ordem alfabética
		System.out.println("\n-Lista ordenada em ordem alfabética- ");
		Collections.sort(lista, new OrdemAlfabetica());
		for (Funcionario f: lista) {
			System.out.println(f);
		}
		
		//Soma dos salários
		@SuppressWarnings("deprecation")
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		System.out.println("\n-Total do salário dos funcionários-\n");
		 BigDecimal valorTotal = lista.stream()
			    .map(Funcionario::getSalario)
			    .reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(nf.format(valorTotal));

		
		//Quantidade de salários mínimos por funcionário
		DecimalFormat df = new DecimalFormat("0");
		System.out.println("\n-Quantidade de salários mínimos por cada funcionário- ");
		int salarioMinimo = 1212;
		for (Funcionario f: lista) {
			Integer salario = Integer.parseInt(df.format(f.getSalario()));
			int quantidade = salario / salarioMinimo;
			
			System.out.println("\nNome: " + f.getNome() + "\nQuantidade: " + quantidade);
		}

	}
	
	
}
