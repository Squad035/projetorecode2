package crud;

import java.util.Scanner;

import dao.AlunosDAO;

public class AlunosCrud {

	public static void main(String[] args) {
		
		AlunosDAO alunoDAO = new AlunosDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";

		do {
			
			System.out.println("=== CRUD ALUNOS ===");
			System.out.println("1 - Cadastrar alunos");
			System.out.println("2 - Consultar alunos");
			System.out.println("3 - Atualizar alunos");
			System.out.println("4 - Deletar alunos");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				
				System.out.println("Digite o nome do aluno(a): ");
				nome = s.nextLine();
				
				Alunos a1 = new Alunos(id, nome);
				
				alunoDAO.save(a1);
				
				System.out.println("\n***  Cadastrou  ***\n");

				break;
			case 2:
				
				for (Alunos a : alunoDAO.getAlunos()) {
					System.out.println("Id: " + a.getId() + " Nome: " + a.getNome());
				}
				
				System.out.println("consultou");
				break;
			case 3:
				
				System.out.println("Digite o id do aluno: ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome do aluno: ");
				nome = s.nextLine();
				
				Alunos a2 = new Alunos(posicao, nome);
			
				alunoDAO.update(a2);
	
				System.out.println("atualizou");
				break;
			case 4:
				
				System.out.println("Digite o id do aluno: ");
				posicao = s.nextInt();
				
				alunoDAO.deleteById(posicao);
				
				break;
			case 5:
				
				System.out.println("Digite o id do autor: ");
				posicao = s.nextInt();
				
				Alunos a3 = alunorDAO.getAlunoById(posicao);
				
				System.out.println("Id: " + a3.getId() + " Nome: " + a3.getNome());
				
				break;
			default:
				System.out.println(opcao != 0 ? "opção invalida, digite novamente." : "");
				break;

			}

		} while (opcao != 0);

		System.out.println("Obrigado!");
		s.close();
	}

}
