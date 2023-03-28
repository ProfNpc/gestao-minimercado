package com.belval.gestaominimercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belval.gestaominimercado.model.ItemCarrinho;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {
    void adicionarItem(ItemCarrinho item);
    void removerItem(ItemCarrinho item);
    List<ItemCarrinho> listarItens();
}
