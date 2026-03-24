package br.berkeley.service;

import br.berkeley.model.Node;
import java.util.List;

public class MasterServer {
    private Node mestre;
    private List<Node> clientes;

    public MasterServer(Node mestre, List<Node> clientes) {
        this.mestre = mestre;
        this.clientes = clientes;
    }

    public int sincronizar() {
        int soma = mestre.getRelogio().getTotalSegundos();
        
        for (Node cliente : clientes) {
            soma += cliente.getRelogio().getTotalSegundos();
        }
        
        int numeroNos = 1 + clientes.size();
        int media = soma / numeroNos;
        
        int ajusteMestre = media - mestre.getRelogio().getTotalSegundos();
        mestre.ajustarRelogio(ajusteMestre);
        
        for (Node cliente : clientes) {
            int ajuste = media - cliente.getRelogio().getTotalSegundos();
            cliente.ajustarRelogio(ajuste);
        }
        
        return media;
    }
}
