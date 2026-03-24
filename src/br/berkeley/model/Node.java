package br.berkeley.model;

public class Node {
    private String id;
    private Clock relogio;

    public Node(String id, Clock relogio) {
        this.id = id;
        this.relogio = relogio;
    }

    public String getId() {
        return id;
    }

    public Clock getRelogio() {
        return relogio;
    }

    public void ajustarRelogio(int offsetSegundos) {
        relogio.ajustar(offsetSegundos);
    }
}
