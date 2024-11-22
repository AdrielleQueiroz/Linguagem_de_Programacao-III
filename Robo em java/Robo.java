package exRobo;

import static java.lang.System.exit;

public class Robo {
    private int x, y;
    private Sala sala;
    Robo(){
        System.out.println("Criando robô (padrão)");
        this.x = 0;
        this.y = 0;
    }

    Robo(int x, int y, Sala s){
        sala = s;
        System.out.println("Criando robô (parâmentros)");
        if (x > sala.getLimInf()) {
            System.out.println("ERRO!");
            exit(-1);
        }
        this.x = x;
        this.y = y;

    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x >= 0)
            this.x = x;
        else
            System.out.println("ERRO! Valor inválido");
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y >= 0)
            this.y = y;
        else
            System.out.println("ERRO! Valor inválido");
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void imprimir(){
        System.out.printf("Robo: (%d, %d)", this.x, this.y);
    }
    public void MoverCima(){
        if (this.x > 0) {
            System.out.println("Movendo para cima");
            this.x--;
        }
        else{
            System.out.printf("Erro! O robô não pode se mover pois está na posição (%d, %d)\n", this.x, this.y);
        }
    }

    public void MoverBaixo(){
        if ((this.x < sala.getLimInf() - 1) && (!(this.sala.ehObstaculo(this.x+1, this.y)))) {
            System.out.println("Movendo para baixo");
            this.x++;
        }
        else{
            System.out.printf("Erro! O robô não pode se mover pois está na posição (%d, %d)\n", sala.getLimInf(), this.y);
        }
    }

    public void MoverEsquerda(){
        if (this.y > 0) {
            System.out.println("Movendo para esquerda");
            this.y--;
        }
        else{
            System.out.printf("Erro! O robô não pode se mover pois está na posição (%d, %d)\n", this.x, this.y);
        }
    }
    public void MoverDireita(){
        if ((this.y < sala.getLimDir() - 1) && (!(this.sala.ehObstaculo(this.x, this.y+1)))) {
            System.out.println("Movendo para direita");
            this.y++;
        }
        else{
            System.out.printf("Erro! O robô não pode se mover pois está na posição (%d, %d)\n", this.x, this.y);
        }
    }
}
