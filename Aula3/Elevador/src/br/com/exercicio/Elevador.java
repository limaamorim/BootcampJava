package br.com.exercicio;

public class Elevador {

    private int andarAtual; // começa no térreo (0)
    private int totalDeAndares; // não conta o térreo
    private int capacidade;
    private int pessoasPresentes;

    public Elevador(int capacidade, int totalDeAndares) {
        this.capacidade = capacidade;
        this.totalDeAndares = totalDeAndares;
        this.andarAtual = 0;
        this.pessoasPresentes = 0;
    }

    // GETTERS E SETTERS
    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getTotalDeAndares() {
        return totalDeAndares;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getPessoasPresentes() {
        return pessoasPresentes;
    }

    public void setPessoasPresentes(int pessoasPresentes) {
        this.pessoasPresentes = pessoasPresentes;
    }
}
