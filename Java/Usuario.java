import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import com.mysql.cj.api.mysqla.result.Resultset;

public class Usuario{
   //Atributos
   public int idUsuario;
   private String nomeUsuario;
   private String email;
   private String senha;
   private String cpf;
   private String endereco;
   private int idTipo;
   private TipoUsuario tipoUsuario;
   
   //metodo construtor
   public Usuario(){}
   public Usuario (int idU, String no, String e, String s, String c, String end, int idT){
      idUsuario = idU;
      nomeUsuario = no;
      email = e;
      senha = s;
      cpf = c;
      endereco = end;
      idTipo = idT;
   }
   
   //metodo de acesso
   public int getIdUsuario(){
      return idUsuario;
   }
   public String getNomeUsuario(){
      return nomeUsuario;
   }
   public String getEmail(){
      return email;
   }
   public String getSenha(){
      return senha;
   }
   public String getCpf(){
      return cpf;
   }
   public String getEndereco(){
      return endereco;
   }
   public int getIdTipo(){
      return idTipo;
   }
   
   
   //metodos modificadores
   public void setIdUsuario(int idU){
      idUsuario = idU;
   }
   public void setNomeUsuario(String no){
      nomeUsuario = no;
   }
   public void setEmail(String e){
      email = e;
   }
   public void setSenha(String s){
      senha = s;
   }
   public void setCpf(String c){
      cpf = c;
   }
   public void setEndereco(String end){
      endereco = end;
   }
   public void setIdTipo(int idT){
      idTipo = idT;
   }
   
   public void imprimirDados() { 
   	System.out.println("Id Usuario: "+idUsuario+"\nNome: "+nomeUsuario+"\nEmail: "+email+"\nCpf: "+cpf+"\nEndereço: "+endereco+"\nTipo de Usuário: "+idTipo); 	
            }
     
  public void inserir(Usuario usuarioNovo){

    	   try {
         Connection conn = ConexaoBD.obtemConexao().getConnection();
         String sqlInsert = "insert into Usuario (idUsuario, nomeUsuario, email, senha, cpf, endereco, idTipo)"
				+ "values(?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement stm = conn.prepareStatement(sqlInsert);
         stm.setInt(1, usuarioNovo.getIdUsuario());
         stm.setString(2, usuarioNovo.getNomeUsuario());
			stm.setString(3, usuarioNovo.getEmail());
			stm.setString(4, usuarioNovo.getSenha());
         stm.setString(5, usuarioNovo.getCpf());
         stm.setString(6, usuarioNovo.getEndereco());
         stm.setInt(7, usuarioNovo.getIdTipo());
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
 public void excluir(int idUsuario){
		String sqlDelete = "delete from Usuario where IdUsuario = ?";
		   try {
            Connection conn = ConexaoBD.obtemConexao().getConnection();

            PreparedStatement stm = conn.prepareStatement(sqlDelete);
			   stm.setInt(1, getIdUsuario());
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

	public void atualizar(Connection conn)
	{
		String sqlUpdate = "update Usuario set nomeUsuario = ?, email = ?, senha = ?, cpf = ?, endereco = ? where idUsuario = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate)){
		   stm.setString(1, getNomeUsuario());
			stm.setString(2, getEmail());
			stm.setString(3, getSenha());
         stm.setString(4, getCpf());
         stm.setString(5, getEndereco());
			stm.setInt(6, getIdUsuario());
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
				conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}
	public void carregar(Connection conn)
	{
		String sqlSelect = "select * from Usuario where idUsuario = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			stm.setInt(1, getIdUsuario());
			try(ResultSet rs = stm.executeQuery(); ){
				if(rs.next()) {
					setNomeUsuario(rs.getString(2));
					setEmail(rs.getString(3));
					setSenha(rs.getString(4));
               setCpf(rs.getString(5));
               setEndereco(rs.getString(6));
				}	
			}
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
				conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}
   
   public void listarUsuarios(){
      try{
         Connection conn = ConexaoBD.obtemConexao().getConnection();
         //1 especificar o comando sql
         String sql = "SELECT * FROM Usuario";

                 //2 pré compilar o comando SQL
         PreparedStatement ps = conn.prepareStatement(sql); 
         //3 configurar os valores que estão faltando (placeholders)
         
         //4 executar o comando
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
            idUsuario = rs.getInt("IdUsuario");
            nomeUsuario = rs.getString ("NomeUsuario");
            email = rs.getString("Email");
            senha = rs.getString ("Senha");
            cpf = rs.getString("CPF");
            endereco = rs.getString ("Endereco");
            idTipo = rs.getInt ("IdTipo");

            String aux = "idUsuario: " + idUsuario;
            aux += "\nNomeUsuario: " + nomeUsuario;
            aux += "\nEmail " +  email ;
            aux += "\nSenha: "+senha ;
            aux += "\nCpf: " +  cpf  ;
            aux += "\nEndereco: " +  endereco;
            aux += "\nTipo de Usuário: " +  idTipo;
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