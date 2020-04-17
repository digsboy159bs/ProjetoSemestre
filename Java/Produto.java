public class Produto{
   //atributos
   private int idProduto;
   private String nomeProduto;
   private double valor;
   private int quantidade;
   private double peso;
   private String validade;
   
   //metodo construtor
   public Produto (int id, String n, double v, int q, double p, String val){
      idProduto = id;
      nomeProduto = n;
      valor = v;
      quantidade = q;
      peso = p;
      validade = val;   
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
}