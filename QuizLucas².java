package FinalizadoPI;

import java.util.Scanner;

public class Quiz {

	static Scanner scan = new Scanner(System.in);

	// portugues
	// metodo main é o execultavel
	public static void main(String[] args) {
		System.out.println(
				"==========Bem vindo ao jogo do milhão!============\n==================================================\n==========Tecle 1 e Enter para Começar============");
		int num = scan.nextInt();

		while (num != 1) {
			System.out.println("Informe um dado válido!\nTecle 1 e Enter para começar");
			num = scan.nextInt();
		}

		System.out.println("Selecione a Categoria digitando de acordo com número correspondente: \n1- Entretenimento"
				+ "\n2- História e Geografia"
				+ "\n3- Ciências\n4- Matemática\n5- ingles\n=============\n6- *Como Jogar?\n7- *Creditos");
		num = scan.nextInt();
		while (num > 7 || num < 1) {
			System.out.println("Informe um dado válido!1 a 7");
			num = scan.nextInt();
		}
		if (num == 1) {
			perg(entreterimento());

		} else if (num == 2) {
			perg(HisGe());
		} else if (num == 3) {
			perg(ciencias());
		} else if (num == 4) {
			perg(mat());
		} else if (num == 5) {
			pergIngles(ingles());
		} else if (num == 6) {
			System.out.println(
					"O jogo Do Milhão é um game de perguntas e respostas, o objetivo é acertar todas as perguntas para VENCER\n"
							+ "\n1* Ao começar escolha a CATEGORIA digitando com o número correspondente e pressione ENTER\n"
							+ "\n"
							+ "1 para Entretenimento\n2 para História e Geografia\n3 para Ciências\n4 para Matemática\n5 para ingles\n"
							+ "\n2* Após escolher a categoria, escolha a dificuldade desejada digitando o numero correspondente e pressione ENTER(a categoria ingles tem apenas a dificuldade intermediaria)\n\n"
							+ "3* Agora começa vim as perguntas, terá 4 resposta e só uma delas esta certa, para escolher a resposta digite a letra correspondente e pressione ENTER\n\n"
							+ "4* o jogo conta com o sistema de pular a pergunta e ajuda da plateia, para pedir um desses beneficio que o jogador conta é so digitar \"PULAR\" ou \"AJUDA\" e pressione ENTER\nlembresse que só há uma tentativa dos beneficios, use com sabedoria \n\n"
							+ "5* O jogador perde ao errar e o jogo acaba, para recomeçar pressione F11");
			System.out.println();
			main(args);
		} else if (num == 7) {
			System.out.println("DESENVOLVIMENTO E PROGRAMAÇÃO POR:");
			System.out.println("*LUCAS VASCONCELOS DE OLIVEIRA NUNES BENTO");
			System.out.println("*LUCAS PASSARELLI CALDARA");
			System.out.println();
			System.out.println("IDE - eclipse IDE=---------=language*JAVA.SE-17*");
			System.out.println();
			System.out.println();
			main(args);
		}
	}

	// o metodo fim é responsavel caso o jogador erre ele termina o jogo
	public static void fim() {
		System.out.println("Resposta incorreta! Fim de jogo!");
		System.exit(0);
	}

	/*
	 * o metodo resp ele fica responsavel pela leitura da resposta do usuario e
	 * determina se esta certo ou nao
	 */
	public static void resp(String resp, String enter) {
		while (!enter.equalsIgnoreCase("A") && !enter.equalsIgnoreCase("B") && !enter.equalsIgnoreCase("C")
				&& !enter.equalsIgnoreCase("D") && !enter.equalsIgnoreCase("pular")
				&& !enter.equalsIgnoreCase("ajuda")) {
			System.out.println("Informe um dado válido! A, B, C ou D.");
			enter = scan.next();
		}
		if (enter.equalsIgnoreCase(resp)) {
			System.out.println("Resposta correta! Proxima pergunta:\n ");
		} else if (enter.equalsIgnoreCase("pular")) {
			System.out.println("Pergunta pulada!\nProxima pergunta:\n");
		} else if (enter.equalsIgnoreCase("ajuda")) {
			ajuda(resp);
		} else {
			fim();
		}

	}

	/*
	 * o metodo ajuda é responsavel pelo beneficos que o jogador tem durante o jogo
	 */
	public static void ajuda(String resp) {
		System.out.printf("A plateia acha que é %s! Qual sua resposta?", resp);
		String enter = scan.next();
		while (!enter.equalsIgnoreCase("A") && !enter.equalsIgnoreCase("B") && !enter.equalsIgnoreCase("C")
				&& !enter.equalsIgnoreCase("D")) {
			System.out.println("Informe um dado válido! A, B, C ou D.");
			enter = scan.next();
		}
		if (enter.equalsIgnoreCase(resp)) {
			System.out.println("Resposta correta! Proxima pergunta:\n ");
		} else {
			fim();
		}

	}

	/*
	 * o metodo perg ele verifica se o jogadoe ja usou os beneficios e recebe a
	 * categoria com as perguntas
	 */
	public static void perg(String[][] per) {
		String[] per2 = new String[1];
		String[] per3 = new String[1];
		boolean pular = false;
		boolean ajuda = false;
		String enter = "";
		for (int i = 0; i < 10; i++) {
			per2[0] = per[i][0];
			per3[0] = per[i][1];
			for (String item : per2) {
				System.out.println(item);
				enter = scan.next();
				while (enter.equalsIgnoreCase("pular") && pular == true) {
					System.out.println("Pular já usado! Informe outro dado!");
					enter = scan.next();
				}
				while (enter.equalsIgnoreCase("ajuda") && ajuda == true) {
					System.out.println("Ajuda já usada! Informe outro dado!");
					enter = scan.next();
				}
				if (enter.equalsIgnoreCase("pular")) {
					pular = true;
				}
				if (enter.equalsIgnoreCase("ajuda")) {
					ajuda = true;
				}
			}
			for (String item2 : per3) {
				resp(item2, enter);
			}
			System.out.print(
					i == 9 ? "\n============VENCEDOR============\nVocê acertou todas a perguntas e ganhou um milhão!"
							: "");
		}

	}

	// metodos para as perguntas de ingles
//ingles
	public static void pergIngles(String[][] per) {
		String[] per2 = new String[1];
		String[] per3 = new String[1];
		boolean pular = false;
		boolean ajuda = false;
		String enter = "";
		for (int i = 0; i < 10; i++) {
			per2[0] = per[i][0];
			per3[0] = per[i][1];
			for (String item : per2) {
				System.out.println(item);
				enter = scan.next();
				while (enter.equalsIgnoreCase("Skip") && pular == true) {
					System.out.println("Skip already used! Provide other information!");
					enter = scan.next();
				}
				while (enter.equalsIgnoreCase("Help") && ajuda == true) {
					System.out.println("Help already used! Provide other information!!");
					enter = scan.next();
				}
				if (enter.equalsIgnoreCase("Skip")) {
					pular = true;
				}
				if (enter.equalsIgnoreCase("Help")) {
					ajuda = true;
				}
			}
			for (String item2 : per3) {
				respIngles(item2, enter);
			}
			System.out.print(
					i == 9 ? "\n============WINNER============\nYou got all the questions right and won a million!!!"
							: "");
		}

	}

	public static void respIngles(String resp, String enter) {
		while (!enter.equalsIgnoreCase("A") && !enter.equalsIgnoreCase("B") && !enter.equalsIgnoreCase("C")
				&& !enter.equalsIgnoreCase("D") && !enter.equalsIgnoreCase("skip") && !enter.equalsIgnoreCase("help")) {
			System.out.println("Enter valid data! A, B, C or D.");
			enter = scan.next();
		}
		if (enter.equalsIgnoreCase(resp)) {
			System.out.println("Right answer! Next question:\n ");
		} else if (enter.equalsIgnoreCase("skip")) {
			System.out.println("Question skipped!\nNext question:\n");
		} else if (enter.equalsIgnoreCase("Help")) {
			ajudaIngles(resp);
		} else {
			fimIngles();
		}

	}

	public static void ajudaIngles(String resp) {
		System.out.printf("The audience thinks it's %s! What's your answer?", resp);
		String enter = scan.next();
		while (!enter.equalsIgnoreCase("A") && !enter.equalsIgnoreCase("B") && !enter.equalsIgnoreCase("C")
				&& !enter.equalsIgnoreCase("D")) {
			System.out.println("Enter valid data! A, B, C or D.");
			enter = scan.next();
		}
		if (enter.equalsIgnoreCase(resp)) {
			System.out.println("Right answer! Next question:\n ");
		} else {
			fim();
		}

	}

	public static void fimIngles() {
		System.out.println("Incorrect answer! Game over!");
		System.exit(0);
	}

	// os metodos a seguir sao aonde estao as perguntas e resposta do quiz, foi
	// utilizado vetor bidimensional
	//
	public static String[][] HisGe() {
		String[][] per = new String[10][2];
		System.out
				.println("História e Geografia Selecionado!\n\nSelecione o Grau de Dificuldade:\n1-Fácil\n2-Difícil\n");
		int num = scan.nextInt();
		if (num == 1) {
			System.out.println("Dificuldade fácil selecionada!\n");
			per[0][0] = " Quem foi o primeiro presidente dos Estados Unidos?\n "
					+ "A)George Washington          B)Thomas Jefferson\n C)Abraham Lincoln          D)Martin Luther King\n "
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[0][1] = "A";
			per[1][0] = " Qual evento historico marcou o inicio da Primeira Guerra Mundial?\n"
					+ "A)Regime de Napoleao Bonaparte           B)Assasinato de Francisco Ferdinando\nC)Titanic Naufragar          D)Assadinato deAbraham Lincoln \n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[1][1] = "B";
			per[2][0] = " Quem liderou a Revoluçao Cubana em 1959 e se tornou o lider de Cuba?\n"
					+ "A)Luis inacio lula da silva        B)Cheguevara\nC)Fidel Castro         D)Kim jong-un\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[2][1] = "C";
			per[3][0] = "3.  Qual foi o nome dado ao movimento cultural, artistico e intelectual que floresceu na Europa durante o século XIV?\n"
					+ "A)Renascimento         B)Teocencrismo\nC)Antropocentrismo          D)Homem Vitruviano\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[3][1] = "A";
			per[4][0] = "4.  Qual imperio governou grande parte da india durante o século XVI ate meados do século XIX?\n"
					+ "A)Império Romano          B)Império Mongol\nC)Império Britânico          D)Império Espanhol\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[4][1] = "C";
			per[5][0] = " Qual é o rio mais longo do mundo\n"
					+ "A)Rio Yenisei          B)Rio Tiete\nC)Rio Amazonas          D)Rio Nilo\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[5][1] = "C";
			per[6][0] = " Qual é a capital da austria?\n"
					+ "A)Amsterdan          B)Budapeste\nC)Rio de Janeiro          D)Viena\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[6][1] = "D";
			per[7][0] = " Qual é o maior deserto do mundo em área\n?"
					+ "A)Deserto do Saara          B)Deserto da Antártica\nC)Deserto do Atacama          D)Deserto da Arábia\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[7][1] = "B";
			per[8][0] = " Qual pais é conhecido como \"A Terra do Sol Nascente\"?\n"
					+ "A)Japão         B)China\nC)Russia         D)Brasil\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[8][1] = "A";
			per[9][0] = " Qual é o ponto mais alto da Terra, medido a partir do nivel do mar?\n"
					+ "A)Monte Everest          B)Cordilheira Karakoram\nC)Monte Gongga          D)Pico do Jaraguá\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[9][1] = "A";
		} else {
			System.out.println("Dificuldade difícil selecionada!\n");
			per[0][0] = "1. Qual foi o nome da famosa serie de revoltas e guerras ocorridas na Europa entre 1618 e 1648, que resultou na Paz de Westfalia?\n"
					+ "A)Guerra dos 30 anos          B)Guerra dos 10 anos\nC)Guerra dos 60 anos         D)Guerra dos 100 anos\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[0][1] = "A";
			// 1
			per[1][0] = "2. Qual foi o faraó responsavel pela contruçao das piramides de gizé?\n"
					+ "A)Faraó Quéops          B)Faraó Tutancâmon\nC)Faraó Ramsés II          D)Faraó Seti I\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[1][1] = "A";
			// 2
			per[2][0] = "3. Qual governante romano conhecido por ter implementado reformas significativas no Império Romano no século III d.C., incluindo a divisão do imperio em duas partes?\n"
					+ "A)Imperador Julio César         B)Imperador Diocleciano\nC)Imperador Trajano         D)Imperador Marco Aurélio\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[2][1] = "B";
			// 3
			per[3][0] = "4. Qual foi o nome da primeira pessoa a viajar ao espaço em uma missão espacial tripulada?\n"
					+ "A)Buzz Aldrin          B)Marcos Ponte\nC)Neil Armstrong         D)Iuri Gagarin\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[3][1] = "D";
			// 4
			per[4][0] = "5. Quantas dinastias que governou a China durante a construção da Grande Muralha?\n"
					+ "A)2 dinastias        B)3 dinastias\nC)4 dinastias         D)5 dinastias\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[4][1] = "C";
			// 5
			per[5][0] = "6. Qual é o ponto mais alto da América do Sul?\n"
					+ "A)Pedra da Mina          B)Pico da Neblina\nC)Pico Bolívar        D)Monte Aconcágua\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[5][1] = "D";
			// 6
			per[6][0] = "7. Qual é a capital do Butão, localizada nos Himalaias?\n"
					+ "A)Timbu          B)Taj Mahal\nC)Nepal         D)Abu Dhabi\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[6][1] = "A";
			// 7
			per[7][0] = "8. Qual é o rio que forma a fronteira entre o México e os Estados Unidos na maior parte de seu percurso?\n"
					+ "A)Rio Mississipi         B)Rio Ohio\nC)Rio Missouri          D)Rio Nilo\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[7][1] = "A";
			// 8
			per[8][0] = "9. Qual é o maior lago de água doce do mundo em termos de volume?\n"
					+ "A)Interlagos          B)Lago Baikal\nC)Lago Ness          D)Mar Caspio\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[8][1] = "B";
			// 9
			per[9][0] = "Qual é o maior pais insular do mundo em area terrestre?\n"
					+ "A)Sri Lanka         B)Reino Unido\nC)Indonésia         D)Japão\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[9][1] = "C";
			// 10
		}

		return per;
	}

	public static String[][] mat() {
		String[][] per = new String[10][2];
		System.out.println("Matemática Selecionado !\n\nSelecione o Grau de Dificuldade:\n1-fácil\n2-Difícil\n");
		int num = scan.nextInt();
		if (num == 1) {
			System.out.println("Dificuldade fácil selecionada!\n");
			per[0][0] = "1. Quantos segundos há em duas horas?\n" + "A)2800        B)3600\nC)1200         D)5500\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[0][1] = "B";
			// 1
			per[1][0] = "2. Você tem 36 laranjas e joga um terço fora, com quantas você fica?\n"
					+ "A)24         B)6\nC)12         D)18\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[1][1] = "C";
			// 2
			per[2][0] = "3. Um quilometro equivale a quantos metros?\n"
					+ "A)100m         B)1000m\nC)10m         D)500m\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[2][1] = "B";
			// 3
			per[3][0] = "4. 51x51?\n" + "A)5201           B)2602\nC)2601         D)5202\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[3][1] = "C";
			// 4
			per[4][0] = "5. Se 2a+b=10 e 2a−b=6, qual é o valor de a?\n"

					+ "A) 2           B)3\nC)4          D)5\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[4][1] = "C";
			// 5
			per[5][0] = "6. Cite o único número primo par?\n" + "A)3           B)5\nC)1          D)2\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[5][1] = "D";
			// 6
			per[6][0] = "7. Quantos milílitros há em um litro?\n"
					+ "A)10000ml          B)1000000ml\nC)100ml          D)1000ml\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[6][1] = "D";
			// 7
			per[7][0] = "8. 9*N é igual a 108. O que é N?\n" + "A)14            B)12\nC)15          D)22\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[7][1] = "B";
			// 8
			per[8][0] = "9. O que vem antes do Quatrilhão?\n"
					+ "A)Trilhão           B)Bilhao\nC)Milhao          D)Quinquilhoes\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[8][1] = "A";
			// 9
			per[9][0] = "10. Quem é o Pai da Matemática?\n"
					+ "A)Albert Heisnten           B)Aristoteles\nC)Tales de Mileto         D)Isaac Newlton\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[9][1] = "C";
			// 10
		} else {
			System.out.println("Dificuldade difícil selecionada!\n");
			per[0][0] = "1. Se c é a hipotenusa de um triângulo retângulo com catetos a=3 e b=4 qual é o valor de c?\n"
					+ "A) 5         B) 6\nC)7          D) 8\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[0][1] = "A";
			// 1
			per[1][0] = "2. Qual é a área de um triângulo com base b=6 e altura h=8?\n"
					+ "A) 20              B)18\nC)24           D)36\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[1][1] = "C";
			// 2
			per[2][0] = "3. Qual é a raiz quadrada de 121?\n" + "A)10         B)11\nC)12        D)13\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[2][1] = "B";
			// 3
			per[3][0] = "4. Qual é o resultado da fraçao 3/4 X 2/5?\n"
					+ "A)3/10          B)3/5\nC)6/20           D)5/8\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[3][1] = "A";
			// 4
			per[4][0] = "5.  Qual é o valor de 4 X (3+5)?\n" + "A)20           B)22\nC)30         D)32\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[4][1] = "D";
			// 5
			per[5][0] = "6. Se X=7, qual o valor de 2x + 3?\n" + "A)21          B)27\nC)18          D)17\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[5][1] = "D";
			// 6
			per[6][0] = "7. Qual é a solução para a equação 2y - 5=11?\n"
					+ "A)y=3            B)y=6\nC)y=8         D)y=9\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[6][1] = "C";
			// 7
			per[7][0] = "8. Se x é um número real, qual é a solução da inequação -2x+3>7?\n"
					+ "A)X<2          B)X<-2\nC)X=2          D)X<-5\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[7][1] = "B";
			// 8
			per[8][0] = "9. Qual é a área de um retângulo com comprimento L=8 e largura W=5?\n"
					+ "A)40           B)30\nC)13          D)56\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[8][1] = "A";
			// 9
			per[9][0] = "Se x é um número real, qual é a solução da inequação 3x-4>5?\n"
					+ "A)X>2          B)X=2\nC)X>3          D)X=3\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[9][1] = "C";
		}

		return per;

	}

	public static String[][] ciencias() {
		String[][] per = new String[10][2];
		System.out.println("Ciências Selecionado!\n\nSelecione o Grau de Dificuldade:\n1-Fácil\n2-Difícil\n");
		int num = scan.nextInt();
		if (num == 1) {
			System.out.println("Dificuldade fácil selecionada!\n");
			per[0][0] = "1. Como é o nome da energia gerada pelo vento?\n"
					+ "A) Hídrica          B) Térmica\nC) Eólica          D) Química\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[0][1] = "C";
			// 1
			per[1][0] = "2. O que as abelhas fabricam?\n" + "A) Seda           B) Mel\nC) Pólen          D) Algodão\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[1][1] = "B";
			// 2
			per[2][0] = "3. Qual é a fórmula da água\n" + "A) H2O         B)CO2\nC) NaCl         D)C6H12O6\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[2][1] = "A";
			// 3
			per[3][0] = "4. Caso um adulto não perca nenhum dos dentes, quantos ele possui?\n"
					+ "A)32              B)28\nC)30           D)36\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[3][1] = "A";
			// 4
			per[4][0] = "5. Como é chamado o maior osso do corpo humano?\n"
					+ "A)Esterno              B)Costela\nC)Femor           D)Patela\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[4][1] = "C";
			// 5
			per[5][0] = "6. Atualmente, quantos elementos químicos a tabela periódica possui?\n"
					+ "A)109              B)108\nC)118           D)120\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[5][1] = "C";
			// 6
			per[6][0] = "7. Qual o nome do cientista que descobriu o processo de pasteurização e a vacina contra a raiva?\n"
					+ "A)Luis inacio lula da silva(nine fingers)            B)Alber Heisten\nC)Charles Darwin           D)Louis Pasteur\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[6][1] = "D";
			// 7
			per[7][0] = "8. Quais são os cromossomos que determinam o sexo masculino?\n"
					+ "A)XY             B)XX\nC)XE           D)XZ\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[7][1] = "A";
			// 8
			per[8][0] = "9. Como se chamam os vasos que transportam sangue do coração para a periferia do corpo?\n"
					+ "A)Arterias           B)Veias\nC)Horta         D)Pumao\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[8][1] = "A";
			// 9
			per[9][0] = "10. Que substância é absorvida pelas plantas e expirada por todos os seres vivos?\n"
					+ "A)Oxigenio       B)Nitrogenio\nC)Dióxido de Carbono         D)Grafeno\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[9][1] = "C";
			// 10
		} else {
			System.out.println("Dificuldade difícil selecionada!\n");
			per[0][0] = "1. Qual é a teoria que propõe a existência de universos paralelos?\n"
					+ "A)Teoria do Big Bang         B)Teoria das Cordas 8\nC)Teoria da Relatividade Geral          D)Teoria da Inflação Cósmica\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[0][1] = "B";
			// 1
			per[1][0] = "2.  O que é a entropia em termos da segunda lei da termodinâmica?\n"
					+ "A)Medida da energia cinética            B) Medida da desordem\nC)Taxa de transferência de calor        D)Grau de pressão atmosférica\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[1][1] = "B";
			// 2
			per[2][0] = "3. Qual é a principal fonte de energia no núcleo do Sol?\n"
					+ "A)Fusão de hélio         B)Fusão de hidrogênio\nC)Fissão nuclear        D)Decaimento radioativo\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[2][1] = "B";
			// 3
			per[3][0] = "4. Quem desenvolveu a teoria da seleção natural simultaneamente com Charles Darwin\n"
					+ "A)Jean-Baptiste Lamarck           B)Thomas Malthus\nC) Gregor Mendel          D)Alfred Russel Wallace\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[3][1] = "D";
			// 4
			per[4][0] = "5. O que é a superposição quântica, conforme descrito pelo princípio da superposição?\n"
					+ "A)Existência simultânea de partículas em diferentes estados            B)interferência de ondas luminosas\nC)Propagação de elétrons em diferentes órbitas          D)Colapso do vetor de estado em mecânica quântica\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[4][1] = "A";
			// 5
			per[5][0] = "6. Qual é o processo pelo qual uma célula se divide para formar duas células filhas geneticamente idênticas?\n"
					+ "A)Transcrição              B)Tradução\\nC)Mitose           D)Meiose\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[5][1] = "C";
			// 6
			per[6][0] = "7. Qual ciência estuda a origem e evolução do universo?\n"
					+ "A)Biologia             B)Filosofia\nC)Quimica           D)Astronomia\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[6][1] = "D";
			// 7
			per[7][0] = "8. O que é a ressonância magnética funcional (fMRI) e qual é o seu principal uso na pesquisa científica?\n"
					+ "A)Técnica de imagem para estudar atividade cerebral           B)Método para investigar partículas subatômicas\nC)Ferramenta para analisar composição química de substâncias          D)Técnica de observação de planetas distantes\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[7][1] = "A";
			// 8
			per[8][0] = "9. Qual é o processo pelo qual os elementos mais pesados são formados a partir da fusão nuclear em estrelas?\n"
					+ "A)Fotossíntese           B)Fissão nuclear\nC)Nebulização          D)Nucleossíntese estelar\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[8][1] = "D";
			// 9
			per[9][0] = "Qual é a partícula subatômica responsável pela transmissão da força eletromagnética?\n"
					+ "A)Próton           B)Nêutron\nC)Fóton         D)Quark\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[9][1] = "C";
		}

		return per;

	}

	public static String[][] entreterimento() {

		String[][] per = new String[10][2];
		System.out.println("Entretenimento  Selecionado!\n\nSelecione o Grau de Dificuldade:\n1-Fácil\n2-Difícil");
		int num = scan.nextInt();
		if (num == 1) {
			System.out.println("Dificuldade fácil selecionada!");
			System.out.println();
			per[0][0] = "1. Quantos planetas tem o Sistema Solar?\n" + "A) 7         B) 8\nC) 9          D) 10\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[0][1] = "A";
			// 1
			per[1][0] = "2. De qual banda de rock que o cantor Freddie Mercury foi vocalista?\n"
					+ "A) The Beatles           B)Rolling Stones\nC)AC/DC           D)Queen\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[1][1] = "D";
			// 2
			per[2][0] = "3. Onde são disputadas as lutas de judô?\n"
					+ "A)Arena         B)Ringue\nC)Estádio        D)Tatame\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[2][1] = "D";
			// 3
			per[3][0] = "4. Na mitologia grega, Zeus era filho de quem?\n"
					+ "A)Apolo            B)Urano\nC)Cronos          D)Poseidon\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[3][1] = "C";
			// 4
			per[4][0] = "5. Na animação de Toy Story, qual o nome do personagem que é dono dos brinquedos?\n"
					+ "A)Sid          B)Jessie\nC)Andy          D)Woody\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[4][1] = "C";
			// 5
			per[5][0] = "6. Em que século o continente Europeu foi devastado pela peste bubônica?\n"
					+ "A)X          B)XI\nC)XII          D)XIV\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[5][1] = "D";
			// 6
			per[6][0] = "7. Qual ciência estuda a origem e evolução do universo?\n"
					+ "A)Astronomia         B)Economia\nC)Sinestezia         D)Biologia\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[6][1] = "A";
			// 7
			per[7][0] = "8. No exterior de que famoso edifício francês foi construída uma enorme pirâmide de vidro em 1989?\n"
					+ "A)coliseu        B)Torre Eiffel\nC)Piremides de Gizé          D)Muralha da China\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[7][1] = "B";
			// 8
			per[8][0] = "9. Qual lei que acabou definitivamente com a escravidão no Brasil?\n"
					+ "A)Lei Áurea          B)Lei Rouanet\nC)Lei Maria da Penha         D)Artigo 124\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[8][1] = "A";
			// 9
			per[9][0] = "Uma refeição vespertina acontece em qual período do dia?\n"
					+ "A)Amanha         B)Tarde\nC)Noite          D)Madrugada\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[9][1] = "C";
			// 10
		} else {
			System.out.println("Dificuldade difícil selecionada!\n");
			per[0][0] = "1. Qual é o nome do primeiro filme da trilogia \"O Senhor dos Anéis\"?\n"
					+ "A) A Sociedade do Anel         B)As Duas Torres\nC)O Retorno do Rei          D)A Busca pelo Anel\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[0][1] = "A";
			// 1
			per[1][0] = "2. Em que ano foi lançado o primeiro iPhone pela Apple?\n"
					+ "A)2005          B)2006\nC)2009         D)2007\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[1][1] = "D";
			// 2
			per[2][0] = "3. Qual é o nome do cientista que propôs a teoria da relatividade restrita?\n"
					+ "A)Isaac Newton         B)Max Planck\nC)Niels Bohr       D)Albert Einstein\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[2][1] = "D";
			// 3
			per[3][0] = "4. Qual é o nome do primeiro satélite artificial lançado pela União Soviética em 1957?\n"
					+ "A) Sputnik 1          B)Luna 1\nC)Vostok 1           D)Explorer 1\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[3][1] = "A";
			// 4
			per[4][0] = "5. Quem é o diretor do filme \"A Origem\" (Inception), lançado em 2010?\n"
					+ "A)Steven Spielberg          B)Christopher Nolan\nC)Quentin Tarantino        D)Ridley Scott\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[4][1] = "B";
			// 5
			per[5][0] = "6. Qual é o título da primeira obra literária de Machado de Assis?\n"
					+ "A)Memórias Póstumas de Brás Cubas          B)Dom Casmurro\nC)Quincas Borba         D)Ressurreição\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[5][1] = "D";
			// 6
			per[6][0] = "7. Qual ciência estuda a origem e evolução do universo?\n"
					+ "A)Astronomia        B)Economia\nC)Sinestezia          D)Biologia\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[6][1] = "A";
			// 7
			per[7][0] = "8. Qual é o nome do maior planeta do nosso sistema solar?\n"
					+ "A)Júpiter          B)Saturno\nC)Marte         D) Vênus\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[7][1] = "A";
			// 8
			per[8][0] = "9. Quem foi o líder dos Beatles?\n"
					+ "A)Paul McCartney         B)John Lennon\nC)George Harrison        D)Ringo Starr\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[8][1] = "A";
			// 9
			per[9][0] = "Qual é o nome da nave espacial em \"Star Trek\" comandada pelo Capitão James T. Kirk?\r\n"
					+ "A)Millennium Falcon          B)Discovery\nC)Enterprise           D)Voyager\n"
					+ "Digite \"PULAR\" para passar a pergunta ou \"AJUDA\" para ter ajuda!!!\n";
			per[9][1] = "C";
		}

		return per;

	}

	public static String[][] ingles() {
		String[][] per = new String[10][2];
		System.out.println("selected English!\n\nSelect the degree of difficulty:\n1-intermediary\n");
		int num = scan.nextInt();
		if (num == 1) {
			System.out.println("Selected intermediate difficulty!\n");
			per[0][0] = "She _____________ the windows because it was too hot in here. (to open - affirmative form)\n"
					+ "A) open        B) stayed \nC) opened          D) curios\n"
					+ "Type \"SKIP\" to skip the question or \"HELP\" to get help!!!\n";
			per[0][1] = "C";
			// 1
			per[1][0] = "2. He _____________ to be a doctor when he was a kid. (to want - affirmative form)\n"
					+ "A) opened             B) wanted\nC) wasted          D) stayed\n"
					+ "Type \"SKIP\" to skip the question or \"HELP\" to get help!!!\n";
			per[1][1] = "B";
			// 2
			per[2][0] = "3. Which of these Brazilian architectural works is one of the Seven Wonders of the Modern World?\n"
					+ "A)Elevator Lacerda         B)Light Station\nC)Palacea Alvorada         D)Christ the Redeemer\n"
					+ "Type \"SKIP\" to skip the question or \"HELP\" to get help!!!\n";
			per[2][1] = "D";
			// 3
			per[3][0] = "4. Complete the proverb “On a given horse…?\n"
					+ "A)it's expensive         B)don't look at your teeth\nC)don't look at the ass         D)afraid of cold water\n"
					+ "Type \"SKIP\" to skip the question or \"HELP\" to get help!!!\n";
			per[3][1] = "B";
			// 4
			per[4][0] = "5. In the Toy Story animation, what is the name of the character who owns the toys?\n"
					+ "A)Sid           B)Jessie\nC)Andy         D)Woody\n"
					+ "Type \"SKIP\" to skip the question or \"HELP\" to get help!!!\n";
			per[4][1] = "C";
			// 5
			per[5][0] = "6. Two of the statements below are wrong:\r\n"
					+ "(1) Religious intolerance is a hate crime.\r\n"
					+ "(2) Religious intolerance is not a crime in Brazil.\r\n"
					+ "(3) The penalty for the crime of religious intolerance ranges from 1 to 3 years in prison.\r\n"
					+ "(4) Religious intolerance is committing acts of vandalism against the temples of other religions.\r\n"
					+ "(5) Freedom of expression guarantees the right to say what we want about beliefs or religions other than our own.?\n"
					+ "A) 2 and 5           B)2 and 3\nC)2 and 4         D)2\n"
					+ "Type \"SKIP\" to skip the question or \"HELP\" to get help!!!\n";
			per[5][1] = "A";
			// 6
			per[6][0] = "7. Which country has carried out nuclear tests and, in 2017, mainly threatened the United States of America?\n"
					+ "A)Israel           B)Siria\nC)China          D)North Korea\n"
					+ "Type \"SKIP\" to skip the question or \"HELP\" to get help!!!\n";
			per[6][1] = "D";
			// 7
			per[7][0] = "8. Outside of which famous French building was a huge glass pyramid built in 1989?\n"
					+ "A)Christ the Redeemer           B)Coliseum\nC)Taj Mahal          D)Eiffel Tower\n"
					+ "Type \"SKIP\" to skip the question or \"HELP\" to get help!!!\n";
			per[7][1] = "D";
			// 8
			per[8][0] = "9. What is the role of the UNO?\n"
					+ "A)Protect culture in all nations       B)Manage trade agreements between countries"
					+ "\nC)Finance developing countries           D)Unite nations with the aim of maintaining world peace and security\n"
					+ "Type \"SKIP\" to skip the question or \"HELP\" to get help!!!\n";
			per[8][1] = "D";
			// 9
			per[9][0] = "Chernobyl and Cesium-137 are part of the biggest nuclear accidents in history. In which countries did they happen?\n"
					+ "A)Russia and Spain           B)Ukraine and Brazil\nC)United States and Ukraine           D)Taiwan and Germany\n"
					+ "Type \"SKIP\" to skip the question or \"HELP\" to get help!!!\n";
			per[9][1] = "B";

		} else {
			System.out.println("invalid, try again");
			pergIngles(ingles());
		}

		return per;

	}
	//
}
