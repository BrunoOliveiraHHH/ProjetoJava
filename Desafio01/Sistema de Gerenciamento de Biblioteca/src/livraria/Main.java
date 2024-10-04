
package livraria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Menu Livraria Aurora");
        System.out.println("1-Usuario");
        // to Do: aplicar listagem numerada de menus;
        
        System.out.println("Escolha sua opção(numero):");
        String escolha = sc.nextLine();
        
        boolean formatoValido = false;
        while(!formatoValido) {
        	try {
        		formatoValido = true;
        		switch(Integer.parseInt(escolha)) {
        		case 1:
        			System.out.println("Menu Usuario");
        		}
        		
        	}catch(NumberFormatException e) {
        		formatoValido = false;
        		System.out.println("Formato digitado incorreto, favor digitar o numero da opção");
        		escolha = sc.nextLine();
        	}
        }

        sc.close();
    }
}
