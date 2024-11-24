package com.finacaqui.Financaqui.service;

import com.finacaqui.Financaqui.model.Gasto;
import com.finacaqui.Financaqui.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoService {
    @Autowired
    private GastoRepository gastoRepository;

    public List<Gasto> listaTodos() {
        return (List<Gasto>) gastoRepository.findAll();
    }

    public Gasto salvar(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public Gasto alterar(Long id, Gasto dados) {
        Gasto gastoSalvo = buscarPorId(id);
        gastoSalvo.setCategoria(dados.getCategoria());
        gastoSalvo.setValor(dados.getValor());
        gastoSalvo.setData(dados.getData());
        gastoSalvo.setFormaPagamento(dados.getFormaPagamento());
        gastoSalvo.setQtdParcelas(dados.getQtdParcelas());
        return gastoRepository.save(gastoSalvo);
    }

    public Gasto buscarPorId(Long id) {
        return gastoRepository.findById(id).get();
    }

    public void remover(Long id) {
        gastoRepository.deleteById(id);
    }
}
