package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class FramePrincipal extends JFrame {

    public FramePrincipal() {
        super("Loja de Carros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Use a constante JFrame.EXIT_ON_CLOSE para definir o encerramento padrão
        JTabbedPane abas = new JTabbedPane();
        abas.add("Carros", new CarrosPainel());
        abas.add("Clientes", new ClientesPainel());
        abas.add("Vendas", new VendasPainel());
        this.add(abas);
        setBounds(150, 0, 1000, 1000);
    }

    public void run() {
        setVisible(true);
    }
}
