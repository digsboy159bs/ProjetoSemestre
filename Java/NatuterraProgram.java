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
import java.sql.SQLException;

public class NatuterraProgram{
   public static void main (String [] args)throws SQLException{
      		
           
           try {
            Connection conn = ConexaoBD.obtemConexao().getConnection();

			conn.setAutoCommit(false);
		
					}catch (Exception e) {
			e.printStackTrace();
         
					}
      
       String menu = "1-Adicionar Produto\n2-Remover Produto\n3-Listar Produtos\n7- Atualizar produto\n4- inserir Usuario\n5- Listar usuarios\n6- Deletar Usuario\n0-sair";
   int opcao;
   
    do{
      opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
      
      if (opcao == 1){
      Produto produto = new Produto();
      produto.setNomeProduto(JOptionPane.showInputDialog("Qual Nome do Produto"));
      produto.setValor(Double.parseDouble(JOptionPane.showInputDialog("Qual o Valor do Produto em R$?")));
      produto.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Qual a Quantidade desse Produto?")));
      produto.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Qual o Peso do Produto em kg?")));
      produto.setValidade(JOptionPane.showInputDialog("Qual a validade do produto?"));

      produto.inserir(produto);

      } else if (opcao == 2){
      Produto produto = new Produto();

      produto.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog("Qual a Identificação desse Produto?")));
      produto.excluir(produto.idProduto);

       		
         }else if (opcao == 3){
         Produto produto = new Produto();
         
         produto.listarProdutos();
         
         }else if(opcao == 4){
            Usuario usuario = new Usuario();
            usuario.setNomeUsuario(JOptionPane.showInputDialog("Qual Nome do Usuario"));
            usuario.setEmail(JOptionPane.showInputDialog("Qual o Email do usuario"));
            usuario.setSenha(JOptionPane.showInputDialog("Qual a senha ?"));
            usuario.setCpf(JOptionPane.showInputDialog("Qual o CPF?"));
            usuario.setEndereco(JOptionPane.showInputDialog("Qual o Endereco?"));
            usuario.setIdTipo(Integer.parseInt(JOptionPane.showInputDialog("Qual o tipo de usuario\n 1 - ADM \n2-Funcionario \n3- Cliente ")));
            usuario.inserir(usuario);



         }else if(opcao == 5){
            Usuario usuario = new Usuario();
            usuario.listarUsuarios();
         }else if(opcao == 6){
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(Integer.parseInt(JOptionPane.showInputDialog("Qual a Identificação desse Usuario")));
            usuario.excluir(usuario.idUsuario);

         }else if(opcao == 7){
            Produto produto = new Produto();
            produto.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog("Qual a Identificação desse Produto?")));
            produto.setNomeProduto(JOptionPane.showInputDialog("Qual Nome do Produto"));
            produto.setValor(Double.parseDouble(JOptionPane.showInputDialog("Qual o Valor do Produto em R$?")));
            produto.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Qual a Quantidade desse Produto?")));
            produto.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Qual o Peso do Produto em kg?")));
            produto.setValidade(JOptionPane.showInputDialog("Qual a validade do produto?"));
      
            produto.atualizar(produto);
         }
         

   }while (opcao != 0);
}
}