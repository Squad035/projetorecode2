package crud;

import java.util.Arrays;

import dao.AlunosDAO;

public class Principal {
	public static void main(String[] args) {
		
		AlunosDAO luno = new AlunosDAO();
		
		Alunos a1 = new Alunos(2, "Joice");
		
	
		
		for (Alunos a : alunoDAO.getAutores()) {
			System.out.println(a.getNome());
		}
	}