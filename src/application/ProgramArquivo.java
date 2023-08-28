package application;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ProgramArquivo {

	@SuppressWarnings("resource") // A anotação @SuppressWarnings é usada para suprimir warnings do compilador.
	public static void main(String[] args) throws IOException { // Declaração do método main, que lança uma IOException.

		Locale.setDefault(Locale.US); // Define o local padrão como US (Estados Unidos).

		try { // Início de um bloco try-catch para tratamento de exceções.

			Scanner sc = new Scanner(System.in); // Criação de um objeto Scanner para leitura de entrada do usuário.
			System.out.println("Insira o diretório onde você quer criar o arquivo: ");
			String diretorioCriacao = sc.nextLine(); // Leitura da entrada do usuário para o diretório.
			System.out.println("Insira o nome do arquivo com extensão: ");
			String nomeArquivo = sc.nextLine(); // Leitura da entrada do usuário para o nome do arquivo.

			// Valide se o diretório existe
			File diretorio = new File(diretorioCriacao); // Criação de um objeto File com o diretório fornecido.
			if (!diretorio.exists() || !diretorio.isDirectory()) { // Verifica se o diretório não existe ou não é um
				// diretório válido.
				System.out.println("O diretório inserido não é válido.");
				return; // Sai do programa em caso de diretório inválido.
			}

			// Valide se o nome do arquivo é válido (por exemplo, não contém caracteres
			// inválidos)
			if (!nomeArquivo.matches("[a-zA-Z0-9_\\.]+\\w*")) { // Verifica se o nome do arquivo contém apenas letras,
				// números e sublinhados.
				System.out.println("O nome do arquivo inserido não é válido.");
				return; // Sai do programa em caso de nome de arquivo inválido.
			}

			// Cria um arquivo no diretório especificado com o nome fornecido.
			boolean arquivo = new File(diretorioCriacao + "\\" + nomeArquivo).createNewFile();
			if (arquivo == true) { // Verifica se o arquivo foi criado com sucesso.
				System.out.println("Arquivo criado com sucesso.");
			} else {
				System.out.println("O arquivo não foi criado ou já existe.");
			}
			sc.close(); // Fecha o objeto Scanner.

		} catch (Exception e) { // Captura de exceções genéricas.
			System.out.println("Erro ao criar o arquivo: " + e.getMessage()); // Exibe mensagem de erro.
		}
	}
}
