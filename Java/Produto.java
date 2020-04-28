import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import com.mysql.cj.api.mysqla.result.Resultset;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;


public class Produto{


   //atributos
   public int idProduto;
   private String nomeProduto;
   private double valor;
   private int quantidade;
   private double peso;
   private String validade;
   
   //metodo construtor
   public Produto() {}
   
   public Produto (int id, String n, double v, int q, double p, String val){
      idProduto = id;
      nomeProduto = n;
      valor = v;
      quantidade = q;
      peso = p;
      validade = val;   
   }
   
   public Produto(int id){
      idProduto = id;
   }
   
   //metodo de acesso
   public int getIdProduto(){
      return idProduto;
   }
   public String getNomeProduto(){
      return nomeProduto;
   }
   public double getValor(){
      return valor;
   }
   public int getQuantidade(){
      return quantidade;
   }
   public double getPeso(){
      return peso;
   }
   public String getValidade(){
      return validade;
   }
   
   //metodo modificador
   public void setIdProduto(int id){
      idProduto = id;
   }
   public void setNomeProduto(String n){
      nomeProduto = n;
   }
   public void setValor(double v){
      valor = v;
   }
   public void setQuantidade(int q){
      quantidade = q;
   }
   public void setPeso(double p){
      peso = p;
   }
   public void setValidade(String val){
      validade = val;
   }
   public void imprimirDados() { 
   	System.out.println("Id: "+idProduto+"\nNome: "+nomeProduto+"\nValor: "+valor+"\nQuantidade: "+quantidade+"\nPeso: "+peso+
                "\nValidade: "+validade); 	}
                
      public void inserir(Produto produtoNovo){

    	   try {
         
         
         Connection conn = ConexaoBD.obtemConexao().getConnection();
         conn.setAutoCommit(true);
         
         String sqlInsert = "insert into Produto (idProduto, nomeProduto, valor, quantidade, peso, validade)"
				+ "values(?, ?, ?, ?, ?, ?)";

      
         PreparedStatement stm = conn.prepareStatement(sqlInsert);
		   stm.setInt(1, produtoNovo.getIdProduto());
         stm.setString(2, produtoNovo.getNomeProduto());
			stm.setDouble(3, produtoNovo.getValor());
			stm.setInt(4, produtoNovo.getQuantidade());
         stm.setDouble(5, produtoNovo.getPeso());
         stm.setString(6, produtoNovo.getValidade());
			stm.execute();
        
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
         Connection conn = ConexaoBD.obtemConexao().getConnection();

			conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
      }
  }

   
   	public void excluir(int idProduto)
	{
		String sqlDelete = "delete from Produto where idProduto = ?";
		try {
        
 Connection conn = ConexaoBD.obtemConexao().getConnection();

         PreparedStatement stm = conn.prepareStatement(sqlDelete);
			stm.setInt(1, getIdProduto());
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
          Connection conn = ConexaoBD.obtemConexao().getConnection();

				conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}
	public void atualizar(Produto produtoAtualizado)
	{
		String sqlUpdate = "update Produto set NomeProduto = ?, Valor = ?, Quantidade = ?, Peso = ?, Validade = ? where IdProduto = ?";
		try {
         Connection conn = ConexaoBD.obtemConexao().getConnection();

         PreparedStatement stm = conn.prepareStatement(sqlUpdate);
         stm.setInt(1, getIdProduto());

		   stm.setString(2, produtoAtualizado.getNomeProduto());
			stm.setDouble(3, produtoAtualizado.getValor());
			stm.setInt(4, produtoAtualizado.getQuantidade());
         stm.setDouble(5, produtoAtualizado.getPeso());
         stm.setString(6, produtoAtualizado.getValidade());
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
            Connection conn = ConexaoBD.obtemConexao().getConnection();

				conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}
	   
   public void listarProdutos (){
      try{
         Connection conn = ConexaoBD.obtemConexao().getConnection();
         //1 especificar o comando sql
         String sql = "SELECT * FROM Produto";
         //2 pré compilar o comando SQL
         PreparedStatement ps = conn.prepareStatement(sql); 
         //3 configurar os valores que estão faltando (placeholders)
         
         //4 executar o comando
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
            idProduto = rs.getInt("IdProduto");
            nomeProduto = rs.getString ("NomeProduto");
            valor = rs.getDouble("Valor");
            quantidade = rs.getInt ("Quantidade");
            peso = rs.getDouble("Peso");
            validade = rs.getString ("Validade");

            String aux = "idProduto: " + idProduto;
            aux += "\nNomeProduto: " + nomeProduto;
            aux += "\nvalor: " +  valor + "R$";
            aux += "\nquantidade: " +  quantidade;
            aux += "\npeso: " +  peso + "kg" ;
            aux += "\nvalidade: " +  validade;
            JOptionPane.showMessageDialog (null, aux);
            //System.out.println (aux);
         }
      }
      catch (Exception e){
         System.out.println (e.getMessage());
         e.printStackTrace();
      }
       }

       

  }