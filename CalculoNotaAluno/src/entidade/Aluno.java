package entidade;

public class Aluno {
	public String nome;
	public double grade1, grade2, grade3;

	public double gradeFinal() {
		return grade1 + grade2 + grade3;
	}

	public double pontosFaltando() {
		if(gradeFinal() < 170.0) {
			return 170 - gradeFinal();
		}else {
			return 0.0;
		}
	}
}
