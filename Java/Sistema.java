import javax.swing.JOptionPane;

public class Sistema{
   public static void main(String [] args){
   ProdutosArray produtosArray = new ProdutosArray();
   
   String menu = "1-Adicionar Produto\n2-Remover Produto\n3-Lista\n0-sair";
   int opcao;
   
    do{
      opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
      
      if (opcao == 1){
        int idProduto =Integer.parseInt(JOptionPane.showInputDialog("Qual a Identificação desse Produto?"));
        String nomeProduto  = JOptionPane.showInputDialog("Que Produto Deseja Inserir?");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Qual o Valor do Produto?"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Qual a Quantidade desse Produto?"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Qual o Peso do Produto?"));
        String validade = JOptionPane.showInputDialog("Qual a Validade do Produto?");
        Produto produto = new Produto (idProduto, nomeProduto, valor, quantidade, peso, validade);
        produtosArray.inserir(produto);
      } else if (opcao == 2){
       String nomeProduto = JOptionPane.showInputDialog("Digite o nome do Produto: "); 				
         produtosArray.remover(nomeProduto); 		
         }else if (opcao == 3){
            produtosArray.listarProdutos();
         }
      
      }while (opcao != 0);
    }
}