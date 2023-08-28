package application;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class ProgramDiretorio {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//criar um diretorio em
						
		System.out.println("Insira a Unidade onde vc quer criar a pasta: ");
		String diretorioCriacao = sc.nextLine();
		System.out.println("Insira o nome do diretorio que você quer criar: ");
		String nomeDiretorio = sc.nextLine();
		
		boolean diretorio = new File(diretorioCriacao + nomeDiretorio).mkdir();
		if (diretorio == true){
			System.out.println("Diretório foi criado com sucesso.");
			
		}
		else
			System.out.println("O diretorio não foi criado ou já existe");
				

		sc.close();

	}
}