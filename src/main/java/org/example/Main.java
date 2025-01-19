package org.example;

import org.example.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdInfoPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Criando um perfil
            Perfil perfil = new Perfil();
            perfil.setDescricao("Administrador");
            em.persist(perfil);

            // Criando um usuário
            Usuario usuario = new Usuario();
            usuario.setNome("Carlos Silva");
            usuario.setEmail("carlos@example.com");
            usuario.setSenha("senha123");
            usuario.setTelefone("65992630678");
            usuario.setDataCriacao(LocalDateTime.now());

            // Associando perfil ao usuário
            Set<Perfil> perfis = new HashSet<>();
            perfis.add(perfil);
            usuario.setPerfis(perfis);

            em.persist(usuario);

            // Criando produtos
            Produto produto1 = new Produto();
            produto1.setNome("Notebook Dell");
            produto1.setDescricao("Notebook Dell Inspiron 15");
            produto1.setPreco(new BigDecimal("4500.00"));
            produto1.setQuantidadeEstoque(10);
            produto1.setDataCadastro(LocalDateTime.now());

            Produto produto2 = new Produto();
            produto2.setNome("Smartphone Samsung");
            produto2.setDescricao("Galaxy S21 Ultra");
            produto2.setPreco(new BigDecimal("3500.00"));
            produto2.setQuantidadeEstoque(20);
            produto2.setDataCadastro(LocalDateTime.now());

            em.persist(produto1);
            em.persist(produto2);

            // Criando um pedido
            Pedido pedido = new Pedido();
            pedido.setUsuario(usuario);
            pedido.setDataPedido(LocalDateTime.now());
            pedido.setValorTotal(new BigDecimal("8000.00"));
            pedido.setStatus("CONFIRMADO");

            em.persist(pedido);

            // Criando itens do pedido
            ItemPedido item1 = new ItemPedido();
            item1.setPedido(pedido);
            item1.setProduto(produto1);
            item1.setQuantidade(1);
            item1.setPrecoUnitario(produto1.getPreco());

            ItemPedido item2 = new ItemPedido();
            item2.setPedido(pedido);
            item2.setProduto(produto2);
            item2.setQuantidade(2);
            item2.setPrecoUnitario(produto2.getPreco());

            List<ItemPedido> itens = new ArrayList<>();
            itens.add(item1);
            itens.add(item2);
            pedido.setItens(itens);

            em.persist(item1);
            em.persist(item2);

            // Criando um pagamento
            Pagamento pagamento = new Pagamento();
            pagamento.setPedido(pedido);
            pagamento.setValorPago(new BigDecimal("8000.00"));
            pagamento.setMetodoPagamento("Cartão de Crédito");
            pagamento.setDataPagamento(LocalDateTime.now());

            em.persist(pagamento);

            em.getTransaction().commit();
            System.out.println("Dados inseridos com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
