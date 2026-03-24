import br.berkeley.model.Clock;
import br.berkeley.model.Node;
import br.berkeley.service.MasterServer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node mestre = new Node("Mestre", new Clock(10, 10, 0));
        Node nodeA = new Node("A", new Clock(10, 30, 0));
        Node nodeB = new Node("B", new Clock(9, 45, 0));
        Node nodeC = new Node("C", new Clock(9, 30, 0));
        Node nodeD = new Node("D", new Clock(10, 25, 0));
        
        List<Node> clientes = new ArrayList<>();
        clientes.add(nodeA);
        clientes.add(nodeB);
        clientes.add(nodeC);
        clientes.add(nodeD);
        
        System.out.println("Antes da sincronizacao:");
        System.out.println(mestre.getId() + ": " + mestre.getRelogio());
        System.out.println(nodeA.getId() + ": " + nodeA.getRelogio());
        System.out.println(nodeB.getId() + ": " + nodeB.getRelogio());
        System.out.println(nodeC.getId() + ": " + nodeC.getRelogio());
        System.out.println(nodeD.getId() + ": " + nodeD.getRelogio());
        System.out.println();
        
        System.out.println("Calculando media...");
        int tempoMestre = mestre.getRelogio().getTotalSegundos();
        int tempoA = nodeA.getRelogio().getTotalSegundos();
        int tempoB = nodeB.getRelogio().getTotalSegundos();
        int tempoC = nodeC.getRelogio().getTotalSegundos();
        int tempoD = nodeD.getRelogio().getTotalSegundos();
        
        System.out.println(mestre.getId() + ": " + tempoMestre + "s");
        System.out.println(nodeA.getId() + ": " + tempoA + "s");
        System.out.println(nodeB.getId() + ": " + tempoB + "s");
        System.out.println(nodeC.getId() + ": " + tempoC + "s");
        System.out.println(nodeD.getId() + ": " + tempoD + "s");
        
        int soma = tempoMestre + tempoA + tempoB + tempoC + tempoD;
        int numeroNos = 5;
        
        System.out.println("Soma total: " + soma + "s");
        System.out.println("Numero de nos: " + numeroNos);
        System.out.println("Media: " + soma + " / " + numeroNos + " = " + (soma / numeroNos) + "s");
        System.out.println();
        
        int media = soma / numeroNos;
        Clock relogioMedia = new Clock(0, 0, media);
        System.out.println("Media calculada: " + relogioMedia);
        System.out.println();
        
        System.out.println("Ajustes necessarios:");
        System.out.println(mestre.getId() + ": " + media + " - " + tempoMestre + " = " + (media - tempoMestre) + "s");
        System.out.println(nodeA.getId() + ": " + media + " - " + tempoA + " = " + (media - tempoA) + "s");
        System.out.println(nodeB.getId() + ": " + media + " - " + tempoB + " = " + (media - tempoB) + "s");
        System.out.println(nodeC.getId() + ": " + media + " - " + tempoC + " = " + (media - tempoC) + "s");
        System.out.println(nodeD.getId() + ": " + media + " - " + tempoD + " = " + (media - tempoD) + "s");
        System.out.println();
        
        MasterServer servidor = new MasterServer(mestre, clientes);
        servidor.sincronizar();
        
        System.out.println("Depois da sincronizacao:");
        System.out.println(mestre.getId() + ": " + mestre.getRelogio());
        System.out.println(nodeA.getId() + ": " + nodeA.getRelogio());
        System.out.println(nodeB.getId() + ": " + nodeB.getRelogio());
        System.out.println(nodeC.getId() + ": " + nodeC.getRelogio());
        System.out.println(nodeD.getId() + ": " + nodeD.getRelogio());
    }
}
