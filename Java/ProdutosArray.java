import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ProdutosArray{
  private ArrayList <Produto> produtosArray;
  
  //Objeto Criado
  public ProdutosArray(){
   produtosArray = new ArrayList<>();
  }
  
  //Inserir
  public void inserir(Produto produtos){
   produtosArray.add(produtos);
  }
  
  //Remover
  public void remover(String nomeProduto){
   int posicao = buscarProdutos (nomeProduto);
   if(posicao >= 0){
      produtosArray.remove(posicao);
   }
  }
  
  //Busca
  public int buscarProdutos(String nomeProduto){
   for(int i = 0; i < produtosArray.size(); i++){
      Produto produtos = produtosArray.get(i);
      String nomeProdutos = produtos.getNomeProduto();
      if(nomeProduto.equalsIgnoreCase(nomeProdutos)){
         return i;   
      }   
   } return -1;
  }
  
  /*//Atualizar
  public void atualizar(String nomeProduto, String produtoAtualizado){
   int posicao = buscarProdutos (nomeProduto);
   if(posicao >= 0){
      Produto produtos;
      produtos.setNomeProduto (produtoAtualizado);
      produtosArray.set(posicao, produtos.setNomeProduto(produtoAtualizado));
   }*/
   
   //Listar Produtos
   public void listarProdutos(){
      for(int i = 0; i <produtosArray.size(); i++){
      Produto produtos = produtosArray.get(i); 
      JOptionPane.showMessageDialog(null, "Nome: "+produtos.getNomeProduto()+"\nValor=R$ "+produtos.getValor()+"\nQuantidade em Estoque: "+produtos.getQuantidade()+
      "\nPeso: "+produtos.getPeso()+"\nValidade: "+produtos.getValidade());
      } 	
   }
}