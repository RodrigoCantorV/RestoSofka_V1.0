package principal;

import java.util.Scanner;

import clases.Pregunta;
import clases.Respuesta;
import clases.ResumenPartida;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcion1, opcion2;
		do {
			System.out.println();
			System.out.println("***********************************");
			System.out.println("********MENU DE INICIO*************");
			System.out.println("* 1.)JUGAR*************************");
			System.out.println("* 2.)OPCIONES**********************");
			System.out.println("* 3.)SALIR*************************");
			System.out.println("***********************************");
			System.out.print("Escribe la opcion deseada: ");
			opcion1 = entrada.nextInt();
			switch (opcion1) {
			case 1:
			


		break;
	case 2:
		do {
			System.out.println();
			System.out.println("*************************************");
			System.out.println("********MENU DE OPCIONES*************");
			System.out.println("* 1.)LISTAR PREGUNTAS****************");
			System.out.println("* 2.)CREAR PREGUNTA******************");
			System.out.println("* 3.)MODIFICAR PREGUNTA**************");
			System.out.println("* 4.)MODIFICAR RESPUESTA*************");
			System.out.println("* 5.)LISTAR PREGUNTA Y SU RESPUESTA**");
			System.out.println("* 6.)LISTAR CATEGORIAS EXISTENTES****");
			System.out.println("* 7.)LISTAR RESUMEN DE PARTIDAS******");
			System.out.println("* 8.)ATRAS***************************");
			System.out.println("*************************************");
			System.out.print("Escribe la opcion deseada: ");
			opcion2 = entrada.nextInt();

			switch (opcion2) {
			case 1:
				
				break;
			case 2:

				break;
			case 3:
		
				break;

			case 4:

			
				break;

			case 5:
			
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			default:
				System.out.println("Esta opcion no es valida Por favor intenta de nuevo!");
				break;

			}

		} while (opcion2 != 8);

		break;
	}

} while (opcion1 != 3);

System.out.println("Has salido del juego...Gracias");
	}

}
