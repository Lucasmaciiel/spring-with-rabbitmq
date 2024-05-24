package com.lmg.demo_backend_api.api;

import com.lmg.demo_backend_api.dto.PagamentoDTO;
import com.lmg.demo_backend_api.facade.PagamentoFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoFacade pagamentoFacade;

    public PagamentoController(PagamentoFacade pagamentoFacade) {
        this.pagamentoFacade = pagamentoFacade;
    }

    @PostMapping
    public String processar(@RequestBody PagamentoDTO request) {
        return pagamentoFacade.solicitarPagamento(request);
    }
}
