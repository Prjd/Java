import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		double escolha;
		Scanner a = new Scanner(System.in);
		a.useLocale(Locale.ENGLISH);
		System.out.println("Programa simples para gerenciar pastas, você pode criar ou deletar pasta ou arquivos."
						+ "\nPode listar todas as pastas ou arquivos digitando o caminho, "
						+ "mostrando tambem arquivos ocultos do sistema."
						+ "\nEscolha a opção que você quer abaixo e siga as instruções."
						+ "\nDigitando 0 você fecha o programa nos outros programas você volta para o inicio."
						+ "\n "
						+ "\n0º Fechar o programa " 
						+ "\n1º Criar uma pasta " 
						+ "\n2º Deletar uma pasta "
						+ "\n3º Criar um arquivo " 
						+ "\n4º Deletar um arquivo " 
						+ "\n5º Criar uma pasta com um arquivo dentro"
						+ "\n6º Listar todos os arquivos" 
						+ "\n7º Verificar se o arquivo existe"
						+ "\n8º Lista todas as pastas");
		escolha = a.nextDouble();
		if (escolha == 1) {
			v1();
		} else if (escolha == 2) {
			v1Del();
		} else if (escolha == 3) {
			v2();
		} else if (escolha == 4) {
			v2Del();
		} else if (escolha == 5) {
			v3();
		} else if (escolha == 6) {
			v4();
		} else if (escolha == 7) {
			v5();
		} else if (escolha == 8){
			v6();
		}
		  else if (escolha == 0) {
			System.out.println("Obrigado por usar o programa!");
			return;
		} else {
			main(null);
		}
	}

	public static void continuar() {
		Scanner a = new Scanner(System.in);
		String continuar = a.next();
		if (continuar.equalsIgnoreCase("sim")) {
			main(null);
		} else {
			if (continuar.equalsIgnoreCase("nao")) {
				System.out.println("Obrigado por usar o programa!");
				return;
			}
			System.out.println("Desculpe-me mais não entendi sua resposta. Tente novamente!");
			continuar();
			return;
		}
	}

	public static void v1() {
		String pasta;
		Scanner a = new Scanner(System.in);
		System.out.println("Digite o nome da pasta:\n");
		pasta = a.next();
		if (new File(pasta).mkdir()) {
			System.out.println("Pasta criada com sucesso! \nContinuar usando o programa: \nSim \nNao");
			continuar();
		} else {
			System.out.println("Essa pasta já existe tente outro nome.");
			v1();
		}
	}

	public static void v1Del() {
		String pasta;
		Scanner a = new Scanner(System.in);
		System.out.println("Digite o nome da pasta:\n");
		pasta = a.next();
		testPasta("", pasta);
		// test("directory", File.separator + "docs" + File.separator);
	}

	public static boolean delPasta(String filename) {
		boolean exists = new File(filename).delete();
		return exists;
	}

	public static void testPasta(String type, String filename) {
		// ?: Operador condicional. Exemplo: i=0; (i>2?i=0:i --);
		if (delPasta(filename)) {
			System.out.println("Pasta deletada! \nContinuar usando o programa: \nSim \nNao");
			continuar();
		} else {
			System.out.println("|" + filename + "|" + " Essa pasta não existe, tente novamente.");
			v1Del();
		}
		// System.out.println(filename+(delPasta(filename)?", pasta deleta."
		// : ", essa pasta não existe."+(" ")));
	}

	public static void v2() {
		String arquivo;
		Scanner a = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo:\n");
		arquivo = a.next();
		try {
			if (new File(arquivo).createNewFile()) {
				System.out.println("Arquivo criado com sucesso! \nContinuar usando o programa: \nSim \nNao");
				continuar();
			} else {
				System.out.println("Esse arquivo já existe tente outro nome.");
				v2();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void v2Del() {
		String arquivo;
		Scanner a = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo:\n");
		arquivo = a.next();
		testArquivo("", arquivo);
	}

	public static boolean delArquivo(String filename) {
		boolean exists = new File(filename).delete();
		return exists;
	}

	public static void testArquivo(String type, String filename) {
		if (delArquivo(filename)) {
			System.out.println("Arquivo deletado! \nContinuar usando o programa: \nSim \nNao");
			continuar();
		} else {
			System.out.println("|" + filename + "|" + " Esse arquivo não existe, tente novamente.");
			v2Del();
		}
	}

	public static void v3() {
		String pasta;
		String arquivo;
		Scanner a = new Scanner(System.in);
		System.out.println("Digite o nome da pasta:\n");
		pasta = a.next();
		System.out.println("Digite o nome do arquivo:\n");
		arquivo = a.next();
		if (new File(pasta).mkdir()) {
			try {
				if (new File(pasta + "/" + arquivo).createNewFile()) {
					System.out
							.println("Pasta e arquivo criados com sucesso! \nContinuar usando o programa: \nSim \nNao");
					continuar();
				} else {
					System.out.println("Esse arquivo já existe tente outro nome.");
					v3();
				}
			} catch (IOException e) {
				System.out.print(e.getMessage());
			}
		} else {
			System.out.println("Essa pasta já existe tente outro nome.");
			v3();
		}
	}
	public static void v4() {
		String v4;
		Scanner a= new Scanner(System.in);
		System.out.println("Digite o caminho da pasta:   (ex: C:/Users/Binario/Desktop)");
		v4 = a.next();
		if (v4.equalsIgnoreCase("0")){
			main(null);
		} else {
			File dir = new File(v4);
			String[] children = dir.list();
			if (children == null){
				System.out.println("Essa pasta não existe.");
			}else {
				for (int i=0; i< children.length; i++){
					String filename = children[i];
					System.out.println(filename);
				}
			}v4();	
		}	
	}
	public static void v5(){
		String v5;
		Scanner a = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo:\n");
		v5 = a.next();
		File file = new File(v5);
		if (file.exists()){
			System.out.print("| " + v5 + " |" + "Esse arquivo existe.\n");
			main(null);			
		}else {
			System.out.print("| " + v5 + " |" + "Esse arquivo não existe tente novamente\n");
			v5();
		}
	}
	public static void v6(){
		String v6;
		Scanner a = new Scanner(System.in);
		System.out.println("Digite o caminho da pasta:   (ex: C:/Users/Binario/Desktop)");
		v6 = a.next();
		File dir = new File(v6);
	    File[] files = dir.listFiles();
	    FileFilter fileFilter = new FileFilter() {
	         public boolean accept(File file) {
	            return file.isDirectory();
	         }
	      };
	      files = dir.listFiles(fileFilter);
	      System.out.println(files.length);
	      if (files.length == 0) {
	         System.out.println("Essa pasta não existe.\n");
	         v6();
	      }
	      else {
	         for (int i=0; i< files.length; i++) {
	            File filename = files[i];
	            System.out.println(filename.toString());
	            main(null);
	         }
	      }
	}
	public static void v7(){
		String v7;
	}
}

/**
v2
		if (escolha1 == 1){
			String pasta;
			System.out.println("Digite o nome da pasta:\n");
			pasta=a.next();			
			if (new File(pasta).mkdir()){
				System.out.println("Pasta criada com sucesso!");
				resposta();
			}else{
				System.out.println("Essa pasta já existe");
			}
		}else if (escolha1 == 2){
			try{
				String arquivo;
				System.out.println("Digite o nome do arquivo:\n");
				arquivo=a.next();
				if(new File(arquivo).createNewFile())
					System.out.println("Arquivo criado com sucesso!");
				else
					System.out.println("Essa arquivo já existe");
			}catch(IOException e){
				System.out.println(e.getMessage());
			}	
		}else if (escolha1 == 3){
			String pasta;
			String arquivo;
			System.out.println("Digite o nome da pasta:\n");
			pasta=a.next();
			System.out.println("Digite o nome do arquivo:\n");
			arquivo=a.next();
			
			if (new File(pasta).mkdir()){
				try{
					if(new File(pasta+"/"+arquivo).createNewFile()){
						System.out.println("Pasta e arquivo criados com sucesso.");
					}else{
						System.out.println("Falha na criação da pasta e arquivo.");
					}
					}
					catch(IOException e){
						System.out.print("");
					}
				}
			}else {
				System.out.println("Essa pasta já existe.");
			}	
v1
public class main {
	public static void main(String[] args){
		String pasta = "Combo PasteBin";
		String arquivo = "01.txt";
		
		if(new File(pasta).mkdir()){
			try{
				if(new File(pasta+"/"+arquivo).createNewFile()){
					System.out.println("Pasta e arquivo criado com sucesso!");
				}else{
					System.out.println("Falha na criação da pasta e arquivo!");
				}
			}
			catch(IOException e){				
			}
			System.out.println("Programa funcionou com sucesso!");
		}
		else{
			System.out.println("Falha,algo está errado.");
		}
			
	}

}
Cria o arquivo
		try{
			if(new File("Teste/01.txt").createNewFile())
				System.out.println("Criado com sucesso");
			else
				System.out.println("Falhou");
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
Criar a pasta
		if(new File("Teste").mkdir())
			System.out.println("");
		else
			System.out.println("");		
*/
