package com.arthurrocha.demo.backend.api.facade;

import com.arthurrocha.demo.backend.api.dto.PagamentoDTO;
import com.arthurrocha.demo.backend.api.producer.PagamentoRequestProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoFacade {

    @Autowired
    private PagamentoRequestProducer producer;

    public String solicitarPagamento(PagamentoDTO request) {
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro algo solicitar pagamento..."+e.getMessage();
        }
        return "Pagamento aguardando confirmnação...";
    }

    public void erroPagamento(String payload) {
        System.err.println("======== RESPOSTA DE ERRO =========="+payload);
    }

    public void sucessoPagamento(String payload) {
        System.out.println("======== RESPOSTA DE SUCESSO ======="+payload);
    }
}
