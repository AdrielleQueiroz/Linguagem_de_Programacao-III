package exRobo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int opcao;

        Sala s = new Sala();
        Robo r1 = new Robo();
        r1.setSala(s);
        s.setRobo(r1);

        do{
            System.out.println(" Opções ");
            System.out.println(" (1) Inicializar sala e robô (padrão) ");
            System.out.println(" (2) Inicializar sala e robô (usuário) ");
            System.out.println(" (3) Mover esquerda ");
            System.out.println(" (4) Mover direita ");
            System.out.println(" (5) Mover cima ");
            System.out.println(" (6) Mover baixo ");
            System.out.println(" (7) Imprimir ");
            System.out.println(" (9) Sair ");
            System.out.println(" Digite a opção : ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1 -> {
                    r1.setX(1);
                    r1.setY(1);


                    s.inserirObstaculoRandom();
                    s.inserirObstaculoRandom();
                    s.inserirObstaculoRandom();
                    s.inserirObstaculoRandom();

                    s.Imprimir();
                }
                case 2 -> {
                    System.out.println("Digite a largura da sala (terá a mesma altura): ");
                    int largura = teclado.nextInt();

                    System.out.println("Digite a posição inicial X do robô: ");
                    int posX = teclado.nextInt();

                    System.out.println("Digite a posição inicial Y do robô: ");
                    int posY = teclado.nextInt();

                    // Configurar a sala com as dimensões fornecidas
                    s = new Sala(largura, largura);
                    r1 = new Robo(posX, posY, s);
                    r1.setSala(s);
                    s.setRobo(r1);

                    s.inserirObstaculoRandom();
                    s.inserirObstaculoRandom();
                    s.inserirObstaculoRandom();
                    s.inserirObstaculoRandom();

                    s.Imprimir();
                }
                case 3 -> {
                    r1.MoverEsquerda();
                    s.Imprimir();
                }
                case 4 -> {
                    r1.MoverDireita();
                    s.Imprimir();
                }
                case 5 -> {
                    r1.MoverCima();
                    s.Imprimir();
                }
                case 6 -> {
                    r1.MoverBaixo();
                    s.Imprimir();
                }
                case 7 -> s.Imprimir();
            }
        }while(opcao != 9);

    }
}
