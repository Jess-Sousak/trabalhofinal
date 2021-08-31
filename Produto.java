package TrabalhoFinal_Lojavirtual;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Produto {
    private Connection conexao;
    public Produto(Connection conexao){
        this.conexao = conexao;

    }
    //Criar produto
    public boolean adicionarNovoProduto(String nome, int cod, double preço, String setor, int quantidade){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Produto VALUES("+cod+", '"+nome+"', '"+setor+"', "+preço+", "+quantidade+")");
            
            System.out.println(nome+" - "+cod+ "adicionado(a)");
            return true;
            
        }catch(SQLException e){
            return false;
        }
    }
    public boolean consultaEstoqueId(int id){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Produto WHERE idproduto = "+id);

            while (rs.next()) {
                Integer codigo = rs.getInt("idproduto");
                String nome = rs.getString("nmproduto");
                Integer estoque = rs.getInt("Qnt.Estoque");
                Integer preco = rs.getInt("pcproduto");
                
                System.out.println( "O id "+codigo +" pertence ao produto "+nome+"| R$"+preco+"| Estoque: "+estoque);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean pesquisarProduto(String produto){
        try {
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Produto WHERE nmproduto LIKE '%"+produto+"%'");

            while (rs.next()) {
                String nome = rs.getString("nmproduto");
                String preco = rs.getString("pcproduto");

                
                System.out.println(nome+"| R$"+preco);
                
                    
            }
            return true;
            
        }catch (SQLException e) {
            //throw new RuntimeException(e);
            return false;
        }
        
}
}