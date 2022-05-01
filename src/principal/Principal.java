package principal;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import clases.Jugador;
import clases.Partida;
import clases.Pregunta;
import clases.Respuesta;
import clases.ResumenPartida;
import clases.Ronda_Partida;
import dao.CategoriaDAO;
import dao.JugadorDAO;
import dao.PartidaDAO;
import dao.PreguntaDAO;
import dao.RespuestaDAO;
import dao.ResumenPartidaDAO;
import dao.Ronda_PartidaDAO;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcion1, opcion2;
		int contadorCategoria;
		int respuestaAleatoria;
		String continuarJugando;
		boolean finalizar;
		int seleccionarRespuesta;
		int puntajePartida = 0;
		Random r = new Random();
		ArrayList<ResumenPartida>  miResumen;
		
		Pregunta objPregunta = new Pregunta();
		PreguntaDAO objPreguntaDao = new PreguntaDAO();

		Respuesta objRespuesta = new Respuesta();
		RespuestaDAO objRespuestaDAO = new RespuestaDAO();

		CategoriaDAO objCategoriaDAO = new CategoriaDAO();

		Jugador obJugador = new Jugador();
		JugadorDAO obJugadorDAO = obJugadorDAO = new JugadorDAO();

		Partida objPartida = new Partida();
		PartidaDAO objPartidaDAO = new PartidaDAO();

		Ronda_Partida objRonda_Partida = new Ronda_Partida();
		Ronda_PartidaDAO objRonda_PartidaDAO = new Ronda_PartidaDAO();
		
		ResumenPartida objResumenPartida = new ResumenPartida();
		ResumenPartidaDAO  objResumenPartidaDAO = new ResumenPartidaDAO();
		
		miResumen = objResumenPartidaDAO.resumen();

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
				contadorCategoria = 1;
				finalizar = false;
				puntajePartida =0;
				// creamos el jugador 
				System.out.print("Ingresa tu Nickname: ");
				obJugador.setJugador_nom(entrada.next());
				obJugadorDAO.crearJugador(obJugador);

				// listar pregunta por categoria

				do {
					Pregunta PreguntaAleatoria[];
					Respuesta MisRespuestas[];
					respuestaAleatoria = (int) (Math.random() * 5 + 0);
					PreguntaAleatoria = objPreguntaDao.listarPreguntaAletoriaCategoria(contadorCategoria);
					System.out.println();
					System.out.println("Pregunta " + contadorCategoria + " categoria " + contadorCategoria + " \n");
					System.out.println(PreguntaAleatoria[respuestaAleatoria].getInterrogante());

					MisRespuestas = objRespuestaDAO
							.ObtenerRespuestaPorID(PreguntaAleatoria[respuestaAleatoria].getPre_id());
					// revolver respuestas
					for (int i = 0; i < MisRespuestas.length; i++) {
						int posAleatoria = r.nextInt(MisRespuestas.length);
						Respuesta temp = MisRespuestas[i];
						MisRespuestas[i] = MisRespuestas[posAleatoria];
						MisRespuestas[posAleatoria] = temp;
					}
					// mostrar respuestas
					for (int i = 0; i < MisRespuestas.length; i++) {
						System.out.println(i + ".) " + MisRespuestas[i].getSolucion());
					}
					// Seleccionar respuesta correcta

					System.out.print("Escribe el numero de la respuesta: ");
					seleccionarRespuesta = entrada.nextInt();
					entrada.nextLine();
					// System.out.println(MisRespuestas[seleccionarRespuesta].getRespuesta_correcta());
					if (MisRespuestas[seleccionarRespuesta].getRespuesta_correcta() == 1) {
						System.out.println("Respuesta Correcta!");
						puntajePartida += objCategoriaDAO.obtenerPuntaje(contadorCategoria);
						System.out.println(puntajePartida);
					} else {
						System.out.println("Incorrecta");
						puntajePartida = 0;
						finalizar = true;
					}

					if (contadorCategoria != 5 && finalizar == false) {
						System.out.println("¿Deseas Continuar Jugando? Y/N: ");
						continuarJugando = entrada.nextLine();
						if (continuarJugando.equalsIgnoreCase("Y")) {
							contadorCategoria++;
						} else {
							finalizar = true;
						}
					} else {
						finalizar = true;
					}

				} while (finalizar != true);

				objPartida.setJugador_id(obJugadorDAO.obtenerUltimoJugador());
				objPartida.setAcumulado_partida(puntajePartida);
				objPartidaDAO.crearPartida(objPartida);

				objRonda_Partida.setId_partida(objPartidaDAO.obtenerPartida());
				objRonda_Partida.setId_ronda(contadorCategoria);
				objRonda_PartidaDAO.crearRondaPartida(objRonda_Partida);

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
					System.out.println("* 7.)LISTAR RESUMEN DE PARTIDAS****");
					System.out.println("* 8.)ATRAS***************************");
					System.out.println("*************************************");
					System.out.print("Escribe la opcion deseada: ");
					opcion2 = entrada.nextInt();

					switch (opcion2) {
					case 1:
						objPreguntaDao.listarPregunta();
						break;
					case 2:

						System.out.print("Establezca la categoria de la pregunta: ");
						objPregunta.setPre_id_cate(entrada.nextInt());
						entrada.nextLine();
						System.out.print("Establezca la pregunta: ");
						objPregunta.setInterrogante(entrada.nextLine());

						objPreguntaDao.crearPregunta(objPregunta);

						for (int i = 0; i < 4; i++) { // Crear 4 respuestas para cada pregunta

							objRespuesta.setId_pregunta(objPreguntaDao.obtenerultimaPregunta());

							System.out.print("Escriba la " + (i + 1) + " Posible Solucion: ");
							objRespuesta.setSolucion(entrada.nextLine());
							System.out.print(
									"Escriba un 1 para saber si la respuesta enterior es la correcta de lo contrario escriba 0: ");
							objRespuesta.setRespuesta_correcta(entrada.nextInt());
							entrada.nextLine();

							objRespuestaDAO.crearRespuesta(objRespuesta);
						}
						break;
					case 3:
						System.out.print("Escribe el numero de la pregunta que deseas modificar: ");
						objPregunta.setPre_id(entrada.nextInt());
						entrada.nextLine();
						System.out.print("Reescribe la pregunta: ");
						objPregunta.setInterrogante(entrada.nextLine());
						objPreguntaDao.modificarPregunta(objPregunta);
						break;

					case 4:

						System.out.print("¿A que pregunta deseas modificar una de sus respuestas?: ");
						int id_pregunta = entrada.nextInt();
						entrada.nextLine();
						objRespuestaDAO.listarRespuestaPorID(id_pregunta);
						objRespuesta.setId_pregunta(id_pregunta);

						System.out.print("Establezca el numero de la respuesta que desea modificar: ");
						objRespuesta.setRespuesta_id(entrada.nextInt());
						entrada.nextLine();
						System.out.print("Escribe el nuevo contenido para la respuesta: ");
						objRespuesta.setSolucion(entrada.nextLine());
						objRespuestaDAO.modificarRespuesta(objRespuesta);

						break;

					case 5:
						System.out.print("Que pregunta deseas ver: ");
						objRespuestaDAO.listarRespuestaPorID(entrada.nextInt());
						entrada.hasNextLine();
						break;
					case 6:
						objCategoriaDAO.listarCategoria();
						break;
					case 7:
						
						
						System.out.println("id_partida \t" +"nom_jugador \t" + "ronda_maxima \t" + "    acumulado \t" );
						System.out.println("_________________________________________________________________________");
						for(ResumenPartida e: miResumen) {
							//System.out.println(e.getId_partida() + " " + e.getNom_jugador() + " " +  e.getRonda_maxima() + " " + e.getCumulado_final());
							System.out.print(e.getId_partida() + "\t\t ");
							System.out.print(e.getNom_jugador()  + "\t\t ");
							System.out.print(e.getRonda_maxima()  + "\t\t ");
							System.out.print(e.getCumulado_final()  + "\t\t ");
							System.out.println();
						}
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
