package TrabalhoFinal_Lojavirtual;

import java.sql.Statement;
import java.sql.SQLException;

public class Main {
    public static void main(String args[])throws Exception{
        Conexao conexao = new Conexao();
        conexao.abrirConexao();
        Produto produto = new Produto(conexao.getConnection());
        
        //crud.consultaEstoqueId(4);
        
        Cliente cliente = new Cliente(conexao.getConnection());
        
        cliente.adicionarNovoCliente("Vanderlei", 377, "Rua da consolaçao", "Boleto", 889996633);
        
        Vendedor vendedor = new Vendedor (conexao.getConnection());
        
        vendedor.adicionarNovoVendedor("Chagas", 752, "chagas@gmail.com");
        
    }
}

