import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Compra {
    private ArrayList<Produtos> produtos;
    private int numeroCaixa;
    private LocalTime horarioCompra;
    private double valorTotalCompra;
    private double palpiteValorCompra;

    public LocalTime getHorarioCompra() {

        return horarioCompra;
    }

    public double getvalorTotalCompra(){
        return valorTotalCompra;
    }
    public int getNumeroCaixa() {

        return numeroCaixa;
    }
    public double getPalpiteValorCompra() {

        return palpiteValorCompra;
    }

    public void setValorTotalCompra(double valorTotalCompra){
        if (valorTotalCompra <= 0){
            throw new IllegalArgumentException("O valor deve ser positivo");
        }
    }
    public void setNumeroCaixa(int numeroCaixa) {
        if (numeroCaixa <= 0) {
            throw new IllegalArgumentException("O número do caixa deve ser maior que zero");
        }
        Objects.requireNonNull(numeroCaixa, "O número do caixa é obrigatório");
        this.numeroCaixa = numeroCaixa;
    }
    public void setPalpiteValorCompra (double palpiteValorCompra) {
        if (palpiteValorCompra <= 0) {
            throw new IllegalArgumentException("O palpite do valor da compra deve ser maior que zero");
        }
        Objects.requireNonNull(palpiteValorCompra, "O palpite do valor da compra é obrigatório");
        this.palpiteValorCompra = palpiteValorCompra;
    }
    public Compra(int numeroCaixa, int horaCompra, int minutoCompra) {
        this.numeroCaixa = numeroCaixa;
        this.horarioCompra = LocalTime.of(horaCompra, minutoCompra);
        this.produtos = new ArrayList<>();
    }
   public void adicionarProduto(Produtos produto) {
        produtos.add(produto);
    }

    public double calcularTotalProduto() {
        double valorTotalCompra = 0;
        for (Produtos produto : produtos) {
            valorTotalCompra = valorTotalCompra + produto.calcularPrecoTotal();
        }
        return valorTotalCompra;
    }
    public int getHoraCompra() {
        return horarioCompra.getHour();
    }

    public int getMinutoCompra() {
        return horarioCompra.getMinute();
    }

    public void imprimirNotaFiscal() {
        System.out.println("Número do caixa: " + numeroCaixa);
        System.out.println("Horário da compra: " + horarioCompra);
        System.out.println("Produtos comprados: ");
        for (Produtos produto : produtos) {
            System.out.println(produto.getNomeProduto() + " - R$ " + produto.getPrecoUnidade() + " - " + produto.getQuantidade() + " unidade(s)");
        }
        System.out.println("Total da compra: R$ " + valorTotalCompra);
    }
    public double calcularDesconto(double palpiteValorCompra, double valorTotalCompra) {
        if (palpiteValorCompra == valorTotalCompra){
            return 0;
        } else if ((int) palpiteValorCompra == (int) valorTotalCompra) {
            return 0.3 * valorTotalCompra;
        } else {
            return valorTotalCompra;
        }
    }
}
