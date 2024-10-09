package com.arthurrocha.demo.backend.api.api;

import com.arthurrocha.demo.backend.api.dto.PagamentoDTO;
import com.arthurrocha.demo.backend.api.facade.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoFacade pagamentoFacade;

    @PostMapping
    public String processar (@RequestBody PagamentoDTO request) {
        return pagamentoFacade.solicitarPagamento(request);
    }
}
