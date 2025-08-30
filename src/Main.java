import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Produto p1 = new Produto("Mouse teste", 80.0, 10);
        Produto p2 = new Produto("Teclado", 120.0, 0);
        Produto p3 = new Produto("Cadeira", 500.0, 5);
        Produto p4 = new Produto("Fone", 40.0, 20);

        List<Produto> produtos = Arrays.asList(p1, p2, p3, p4);

        Predicate<Produto> precoMaiorQue50 = p -> p.preco > 50;
        Predicate<Produto> disponivel = p -> p.quantidade > 0;

        Function<Produto, String>  formatarProduto = p -> {
            double precoComDesconto = p.preco * 0.9;
            return String.format(
                    "Produto: %s - Preço com desconto: R$%.2f",
                    p.nome, precoComDesconto);
        } ;

        produtos.stream()
                .filter(precoMaiorQue50)
                .filter(disponivel)
                .map(formatarProduto)
                .forEach(System.out::println);
    }
}
