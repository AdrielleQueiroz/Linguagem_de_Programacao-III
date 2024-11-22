package exRobo;

import java.util.Random;

import static java.lang.System.exit;

public class Sala {
    private int limDir, limInf;
    private char[][] mat;
    private Robo robo;

    public void setRobo(Robo r){
        this.robo = r;
    }

    Sala(){
        this.limDir = 5;
        this.limInf = 5;
        System.out.printf("Criando sala padrão %dx%d\n", this.limDir, this.limInf);
        mat = new char[limDir][limInf];

        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++) {
                this.mat[i][j] = '.';
            }

    }

    Sala(int d, int b){
        this.limDir = d;
        this.limInf = b;
        if (d != b){
            System.out.println("A sala precisa ser uma matriz quadrada");
            exit(-1);
        }
        System.out.printf("Criando sala com parâmetro %dx%d\n", this.limDir, this.limInf);
        mat = new char[limDir][limInf];

        for(int i = 0; i < limInf; i++)
            for(int j = 0; j < limDir; j++) {
                this.mat[i][j] = '.';
            }

    }

    public void inserirObstaculo(int i, int j){
        this.mat[i][j] = 'O';
    }

    public void inserirObstaculoRandom(){
        Random random = new Random();
        int i = random.nextInt(this.limDir);
        int j = random.nextInt(this.limInf);
        this.mat[i][j] = 'O';
    }

    public void excluirObstaculo(int i, int j)
    {
        this.mat[i][j] = '.';
    }

    public Boolean ehObstaculo(int i, int j)
    {
        if (this.mat[i][j] == 'O')
            return true;
        else
            return false;
    }
    public int getLimDir() {
        return limDir;
    }

    public int getLimInf() {
        return limInf;
    }

    public void setLimDir(int limDir) {
        this.limDir = limDir;
    }

    public void setLimInf(int limInf) {
        this.limInf = limInf;
    }

    public void Imprimir() {
        System.out.println();
        System.out.println();

        // imprime os num da primeira linha
        System.out.print("   "); //espaço antes do 0 da primeira linha
        for (int i = 0; i < this.limDir; i++) {
            System.out.print(i + "  "); //num e espaço entre os numeros
        }
        System.out.println();

        for (int i = 0; i < this.limInf; i++) { //imprime os num da coluna
            System.out.print(i + " "); //imprime os numeros e dá um espaço
            for (int j = 0; j < this.limDir; j++) { //imprime os pontos
                if (robo.getX() == i && robo.getY() == j) {
                    System.out.print(" R "); // posição do robô
                } else {
                    System.out.print(" " + this.mat[i][j] + " "); // a sala (os pontos)
                }
            }
            System.out.println();
        }
    }

}
