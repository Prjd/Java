import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class teste {
	//
	static int tentativasUsu = 0;	
	static int tentativasSen = 0;
	// colocar na db
	static String usuario = "matheus";
	static String senha = "matheus";
	public static void main(String args[]){
		JFrame frame = new JFrame("Demo");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		Components(panel);
		
		frame.setVisible(true);
		
		System.out.println("Bem vindo ao sistema de gerenciamento \n");
		
		verificarUsuario();
	}
	public static void verificarUsuario() {
		Scanner a = new Scanner(System.in);
		System.out.println("Digite o seu usuario: ");
		String continuar = a.nextLine();
		//
		if (tentativasUsu <= 2){
			if (continuar.equalsIgnoreCase(usuario)){
				verificarSenha();
			}else{
				if (tentativasUsu == 2){
					System.out.println("Você errou muitas vezes seguidas.");
					return;
				}else{
					tentativasUsu++;
					System.out.println(tentativasUsu+" |Usuario invalido tente novamente. \n");
					verificarUsuario();
				}
			}	
		}else {
			System.out.println("Você errou muitas vezes seguidas.");
			return;
		}
	}
	public static void verificarSenha(){
		Scanner a = new Scanner(System.in);
		System.out.println("Digite a senha:");
		String continuar = a.nextLine();		// Salvar senha na db futuramente		

		if (tentativasSen <= 2){
			if (continuar.equalsIgnoreCase(senha)) {
				conta();
			}else{
				if (tentativasSen == 2) {
					System.out.println("Você errou muitas vezes seguidas.");
					return;
				}else {
					tentativasSen++;
					System.out.println(tentativasSen+" |Senha invalida tente novamente. \n");
					verificarSenha();
				}
			}				
		}else {
			System.out.println("Você errou muitas vezes seguidas.");
			return;
		}
		
	}
	public static void codigoSeg(){
		/*
			import java.util.Random;
			 
			public final class RandomGaussian {
			  
			  public static void main(String... aArgs){
			    RandomGaussian gaussian = new RandomGaussian();
			    double MEAN = 100.0f; 
			    double VARIANCE = 5.0f;
			    for (int idx = 1; idx <= 10; ++idx){
			      log("Generated : " + gaussian.getGaussian(MEAN, VARIANCE));
			    }
			  }
			    
			  private Random fRandom = new Random();
			  
			  private double getGaussian(double aMean, double aVariance){
			    return aMean + fRandom.nextGaussian() * aVariance;
			  }
			
			  private static void log(Object aMsg){
			    System.out.println(String.valueOf(aMsg));
			  }
			}
		 */

		
	}
	public static void conta(){
		System.out.println("Bem vindo a sua conta!");
	}
	private static void Components(JPanel panel){
		panel.setLayout(null);
		
		JLabel userLabel = new JLabel("Usuario");
		userLabel.setBounds(10,10,80,25);
		panel.add(userLabel);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100,10,160,25);
		panel.add(userText);
		
		JLabel passwordLabel = new JLabel("senha");
		passwordLabel.setBounds(10,40,80,25);
		panel.add(passwordLabel);
		
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100,40,160,25);
		panel.add(passwordText);
		
		JButton loginButton = new JButton("login");
		loginButton.setBounds(10,80,80,25);
		panel.add(loginButton);
		
		JButton resgisterButton = new JButton("Registrar");
		resgisterButton.setBounds(180,80,100,25);
		panel.add(resgisterButton);		
	}
}


/**

			
		
		if (continuar.equalsIgnoreCase("Matheus\n12")) {
			conta();
		} else {
			System.out.println("Senha invalida tente novamente. \n");
			verificarSenha();
			return;
		}

Como exibir todos os diretórios em um diretório?
import java.io.*;

class Main {
   public static void main(String[] args) {
      File dir = new File("F:");
      File[] files = dir.listFiles();
      FileFilter fileFilter = new FileFilter() {
         public boolean accept(File file) {
            return file.isDirectory();
         }
      };
      files = dir.listFiles(fileFilter);
      System.out.println(files.length);
      if (files.length == 0) {
         System.out.println("Either dir does not exist
         or is not a directory");
      }
      else {
         for (int i=0; i< files.length; i++) {
            File filename = files[i];
            System.out.println(filename.toString());
         }
      }
   }
}
Como exibir todos os arquivos em um diretório?
import java.io.*;

class Main {
   public static void main(String[] args) {
      File dir = new File("C:");
      String[] children = dir.list();
      if (children == null) {
         System.out.println( "Either dir does 
         not exist or is not a directory");
      }
	  else {
         for (int i=0; i< children.length; i++) {
            String filename = children[i];
            System.out.println(filename);
         }
      }
   }
}
Como procurar um arquivo em um diretório?
import java.io.*;

class Main {
   public static void main(String[] args) {
      File dir = new File("C:");
      FilenameFilter filter = new FilenameFilter() {
         public boolean accept
         (File dir, String name) {
            return name.startsWith("b");
        }
      };
      String[] children = dir.list(filter);
      if (children == null) {
         System.out.println("Either dir does not 
         exist or is not a directory");
      } 
      else {
         for (int i=0; i7lt; children.length; i++) {
            String filename = children[i];
            System.out.println(filename);
         }
      } 
   }
}
Como pesquisar todos os arquivos dentro de um diretório?
import java.io.File;

public class Main {
   public static void main(String[] argv) 
   throws Exception {
      File dir = new File("directoryName");
      String[] children = dir.list();
      if (children == null) {
         System.out.println("does not exist or 
         is not a directory");
      }
      else {
         for (int i = 0; i < children.length; i++) {
            String filename = children[i];
            System.out.println(filename);
         }
      }
   }
}
Como verificar um arquivo existe ou não?
import java.io.File;

public class Main {
   public static void main(String[] args) {
      File file = new File("C:/java.txt");
      System.out.println(file.exists());
   }
}
*/
