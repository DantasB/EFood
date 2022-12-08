package com.xpto.efood.delegate;

import com.xpto.efood.service.OrderService;
import com.xpto.efood.service.dto.PedirProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThirdParty implements JavaDelegate {

    @Autowired
    PedirService pedirService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        PedirProcessDTO orderProcess = (PedirProcessDTO) delegateExecution.getVariable("pi");
        //Confirming the flight
        pedirService.validateOrder(orderProcess.getPedir().getIdPedido());
    }
}
