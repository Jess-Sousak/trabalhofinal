package TrabalhoFinal_Lojavirtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente{ 
    private int id;
    private String nome;
    private int cpf;
    private String Endereco;
    private String Tp;
    private Connection conexao;
   
    public Cliente(){}
    
    public Cliente(String nome, int id, String endereco, String tp, int cpf) {
        this.id = id;
        this.nome = nome;
        //this.endereco = endereco;
        //this.tp = tp;
        this.cpf= cpf;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //public String getendereco() {
      // return endereco;
  // }
    
    //public void set(String endereco ) {
        //this.endereco = endereco;
   // }

   // public String get(String tp) {
     //   return tp;
  // }
    
    //public void set(String tp) {
    //    this.tp = tp;
   // }
    
    public int getcpf () {
        return cpf ;
    }
    public void set(int cpf ) {
        this.cpf = cpf ;
    }

    public Cliente(Connection conexao){
        this.conexao = conexao;

    }

public boolean adicionarNovoCliente(String nome, int id, String endereco, String tp, int cpf){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Cliente VALUES("+id+", '"+nome+"', "+cpf+", '"+endereco+"', '"+tp+"')");
            
            System.out.println("nome: "+nome+" - cpf:"+cpf+ "adicionado(a)");
            return true;
            
        }catch(SQLException e){
            return false;
        }
    }

public boolean consultaClienteId(int id){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Cliente WHERE idcliente = "+id);

            while (rs.next()) {
                Integer codigo = rs.getInt("idcliente");
                String nome = rs.getString("nmcliente");
                Integer cpf = rs.getInt("cpf");
                String endereco = rs.getString("endereco");
                
                System.out.println("O id "+codigo +" pertence ao cliente "+nome+"| "+cpf+"| Endereco: "+endereco);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
public boolean DeletarClienteId(int id){
            try{
                Statement statement = this.conexao.createStatement();
                statement.executeUpdate("DELETE FROM Cliente WHERE idvendedor ="+id+"");

                System.out.println("O cliente de id "+id+" foi  deletado ");
                return true;
            }catch(SQLException e){
                return false;
            }
        }

    public boolean RealizarVendaCliente (String produto,String cliente, int getid){
        try {
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  FROM Cliente WHERE nmcliente LIKE '%"+cliente+"%'and SELECT  FROM Produto WHERE nmproduto LIKE '%"+produto+"%'");
            while (rs.next()) { 
                
                //int id = rs.getid ("idproduto");
                String nome = rs.getString ("nmcliente");
                //String nome = rs.getString ("nmproduto");
                String preco = rs.getString("pcproduto");
                

                
                //System.out.println(nome+"| R$"+preco+"|"+id +"|"+nome);
                System.out.println(id+"|"+nome +"| R$"+nome+"|R$"+preco);
                    
            }
            return true;
            
        }catch (SQLException e) {
            //throw new RuntimeException(e);
            return false;
        }
 }
 
        public boolean Efetuarpagamento (String tp,String Cliente){
        try {
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Cliente WHERE nmcliente LIKE '%"+tp+"%'");
            while (rs.next()) {
                String nome = rs.getString ("nmcliente");
                //String tp = rs.getString("tipodepagamento");
                //int id = rs.getString ("idcliente");
                //

                
                System.out.println(nome+"| R$"+tp);
                //"|"+id 
                    
            }
            return true;
            
        }catch (SQLException e) {
            //throw new RuntimeException(e);
            return false;
        }
}
}