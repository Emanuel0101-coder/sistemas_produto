package com.mercado.komprinha.config;

import com.mercado.komprinha.model.Categoria;
import com.mercado.komprinha.model.Produto;
import com.mercado.komprinha.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(ProdutoRepository produtoRepository) {
        return args -> {
            if (produtoRepository.count() == 0) {

                // 🔹 Produto 1
                Produto p1 = new Produto();
                p1.setNome("Castelo de Vidro");
                p1.setDescricao("Capa dura, pintura tri-lateral e ótima história");
                p1.setPreco(15.90);
                p1.setEstoque(20);
                p1.setImagem("/images/castelo.png");
                p1.setCategoria(Categoria.LITERATURA);
                produtoRepository.save(p1);

                // 🔹 Produto 2
                Produto p2 = new Produto();
                p2.setNome("Corte de chamas prateadas");
                p2.setDescricao("Capa dura, pintura tri-lateral, edição de colecionador");
                p2.setPreco(22.50);
                p2.setEstoque(15);
                p2.setImagem("/images/chamas_prateadas.png");
                p2.setCategoria(Categoria.LITERATURA);
                produtoRepository.save(p2);

                // 🔹 Produto 3
                Produto p3 = new Produto();
                p3.setNome("Corte espinhos e rosas");
                p3.setDescricao("Capa dura, pintura tri-lateral, continuação do primeiro");
                p3.setPreco(35.00);
                p3.setEstoque(18);
                p3.setImagem("/images/corte_espinhos_rosas.png");
                p3.setCategoria(Categoria.LITERATURA);
                produtoRepository.save(p3);

                // 🔹 Produto 4
                Produto p4 = new Produto();
                p4.setNome("Five Night At Freddy");
                p4.setDescricao("5 noites no freddy, acompanha a história dos games");
                p4.setPreco(29.99);
                p4.setEstoque(25);
                p4.setImagem("/images/fnaf.png");
                p4.setCategoria(Categoria.ARTE);
                produtoRepository.save(p4);

                // 🔹 Produto 5
                Produto p5 = new Produto();
                p5.setNome("Harry Potter");
                p5.setDescricao("O menino que sobreviveu");
                p5.setPreco(42.90);
                p5.setEstoque(12);
                p5.setImagem("/images/harry_potter.png");
                p5.setCategoria(Categoria.LITERATURA);
                produtoRepository.save(p5);

                // 🔹 Produto 6
                Produto p6 = new Produto();
                p6.setNome("Kairos Mafia");
                p6.setDescricao("Capa dura, pintura tri-lateral e papel polén");
                p6.setPreco(55.00);
                p6.setEstoque(8);
                p6.setImagem("/images/kairos.png");
                p6.setCategoria(Categoria.LITERATURA);
                produtoRepository.save(p6);

                // 🔹 Produto 7
                Produto p7 = new Produto();
                p7.setNome("O maestro");
                p7.setDescricao("Capa dura, papel polén e uma excelente história");
                p7.setPreco(31.80);
                p7.setEstoque(22);
                p7.setImagem("/images/maestro.png");
                p7.setCategoria(Categoria.LITERATURA);
                produtoRepository.save(p7);

                // 🔹 Produto 8
                Produto p8 = new Produto();
                p8.setNome("Corte névoa e fúria");
                p8.setDescricao("Edição de colecionador volume 2");
                p8.setPreco(27.75);
                p8.setEstoque(16);
                p8.setImagem("/images/nevoa_furia.png");
                p8.setCategoria(Categoria.LITERATURA);
                produtoRepository.save(p8);

                // 🔹 Produto 9
                Produto p9 = new Produto();
                p9.setNome("Princípe Cruel");
                p9.setDescricao("O príncipe que nasceu do rei perverso");
                p9.setPreco(19.99);
                p9.setEstoque(30);
                p9.setImagem("/images/principe.png");
                p9.setCategoria(Categoria.LITERATURA);
                produtoRepository.save(p9);

                // 🔹 Produto 10
                Produto p10 = new Produto();
                p10.setNome("Rainha do nada");
                p10.setDescricao("Aquela que desejava governar, mas nunca conseguiu");
                p10.setPreco(60.00);
                p10.setEstoque(10);
                p10.setImagem("/images/rainha.png");
                p10.setCategoria(Categoria.LITERATURA);
                produtoRepository.save(p10);

                System.out.println("✅ Banco H2 populado automaticamente com 10 produtos iniciais!");
            } else {
                System.out.println("ℹ️ Produtos já existem — inicialização ignorada.");
            }
        };
    }
}
