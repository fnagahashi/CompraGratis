import java.util.Objects;
public class Produtos {
    String nomeProduto;
    double precoUnidade;
    int quantidadeProduto;

    public int getQuantidade() {
        return quantidadeProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public double getPrecoUnidade() {
        return precoUnidade;
    }
    public void setPrecoUnidade(double precoUnidade) {
        if(precoUnidade <= 0) {
            throw new IllegalArgumentException("O preço da unidade do produto deve ser maior que zero");
        }
        Objects.requireNonNull(precoUnidade, "O preço do produto é obrigatório");
        this.precoUnidade = precoUnidade;
    }
    public void setNomeProduto(String nomeProduto) {
        Objects.requireNonNull(nomeProduto);
        nomeProduto = nomeProduto.trim();
        if(nomeProduto.isEmpty()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório");
        }
        this.nomeProduto = nomeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        if(quantidadeProduto <= 0) {
            throw new IllegalArgumentException("A quantidade do produto deve ser maior que zero");
        }
        Objects.requireNonNull(quantidadeProduto, "A quantidade do produto é obrigatória");
        this.quantidadeProduto = quantidadeProduto;
    }



    public Produtos (String nomeProduto, double precoUnidade, int quantidadeProduto){
        this.nomeProduto = nomeProduto;
        this.precoUnidade = precoUnidade;
        this.quantidadeProduto = quantidadeProduto;
    }
    public double calcularPrecoTotal() {
        return precoUnidade * quantidadeProduto;
    }

}
