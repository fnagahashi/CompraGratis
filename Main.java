//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Produtos arroz = new Produtos("Arroz", 5.0, 2);
        Produtos feijao = new Produtos("Feijão", 7.0, 3);
        Produtos macarrao = new Produtos("Macarrão", 3.0, 1);
        Produtos leite = new Produtos("Leite", 3.5, 2);
        Produtos carne = new Produtos("Carne", 20.0, 1);

        Compra compra = new Compra(1, 10, 30);
        compra.adicionarProduto(arroz);
        compra.adicionarProduto(feijao);
        compra.adicionarProduto(macarrao);
        compra.adicionarProduto(leite);
        compra.adicionarProduto(carne);
        compra.calcularDesconto(50.0, compra.calcularTotalProduto());
        compra.imprimirNotaFiscal();
    }
}