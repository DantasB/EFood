package com.xpto.efood.delegate;

import com.xpto.efood.service.dto.PedirProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ThirdParty implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("OrderService: ###########################################");
        System.out.println("OrderService: ###########################################");
        System.out.println("OrderService: ###########################################");
        System.out.println("OrderService:        Pedido " +  delegateExecution.getVariable("processInstance") + " aceito!");
        System.out.println("OrderService: ###########################################");
        System.out.println("OrderService: ###########################################");
        System.out.println("OrderService: ###########################################\n\n\n");
    }
}
