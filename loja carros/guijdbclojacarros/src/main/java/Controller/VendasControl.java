package Controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Vendas;

public class VendasControl {

    // Atributos
    private DefaultTableModel tableModel; // Modelo da tabela Swing para exibição dos dados
    private JTable table; // Tabela Swing onde os dados são exibidos

    // Construtor
    public VendasControl(DefaultTableModel tableModel, JTable table) {
        this.tableModel = tableModel; // Inicializa o modelo da tabela
        this.table = table; // Inicializa a tabela Swing
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        List<Vendas> vendas = new VendasDAO().listarTodos(); // Obtém as vendas atualizadas do banco de dados
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada venda como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getData(), venda.getCliente(), venda.getValor(), venda.getTipoCarro() });
        }
    }

    // Método para cadastrar uma nova venda no banco de dados
    public void cadastrar(String data, String cliente, String valor, String carro) {
        new VendasDAO().cadastrar(data, cliente, valor, carro);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de uma venda no banco de dados
    public void atualizar(String data, String cliente, String valor, String carro) {
        new VendasDAO().atualizar(data, cliente, valor, carro);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar uma venda do banco de dados
    public void apagar(String carro) {
        new VendasDAO().apagar(carro);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}
