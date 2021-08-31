package TrabalhoFinal_Lojavirtual;

import conexoes.ConexaoMySql;
import model.Pessoa;

/**
 *
 * @author Br
 */
public class CrtCliente {

    public int salvarDAO(Cliente Cliente) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {

            conexao.conectar();

            String sql
                    = "INSERT INTO pessoa (nome, peso) VALUES ("
                    + "'" + pPessoa.getNome() + "',"
                    + "'" + pPessoa.getPeso() + "'"
                    + ");";

            return conexao.insertSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            conexao.fecharConexao();
        }
    }

    public Pessoa getPessoaDAO(int pCodigoPessoa) {
        Pessoa pessoa = new Pessoa();
        ConexaoMySql conexao = new ConexaoMySql();

        try {

            conexao.conectar();

            String sql
                    = "SELECT nome, peso FROM pessoa WHERE codigo = '" + pCodigoPessoa + "'"
                    + ";";
            
            conexao.executarSQL(sql);

            while (conexao.getResultSet().next()) {
                pessoa.setNome(conexao.getResultSet().getString("nome"));
                pessoa.setPeso(conexao.getResultSet().getFloat("peso"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return pessoa;

    }
    
    public boolean excluirDAO(int pCodigoPessoa){
        
        ConexaoMySql conexao = new ConexaoMySql();
        
        try{
            
            conexao.conectar();
            
            String sql = 
                    "DELETE FROM pessoa WHERE codigo = '" + pCodigoPessoa + "';";
            
            conexao.executarUpdateDeleteSQL(sql);
            
            return true;
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            conexao.fecharConexao();
        }
        
    }
    
    public boolean updateDAO(Pessoa pPessoa){
        ConexaoMySql conexao = new ConexaoMySql();
        
        try{
            
            conexao.conectar();
            
            String sql = 
                    "UPDATE pessoa SET "
                    + " nome = '" + pPessoa.getNome() + "',"
                    + " peso = '" + pPessoa.getPeso() + "';";
            
            conexao.executarUpdateDeleteSQL(sql);
            
            return true;
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            conexao.fecharConexao();
        }
        
    }

}
