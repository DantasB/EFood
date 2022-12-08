package com.xpto.efood.delegate;

import com.xpto.efood.service.dto.PedirProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThirdParty implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        PedirProcessDTO orderProcess = (PedirProcessDTO) delegateExecution.getVariable("pi");
        
        //Confirming the flight
        System.out.println("OrderService: ###########################################");
        System.out.println("OrderService: ###########################################");
        System.out.println("OrderService: ###########################################");
        System.out.println("OrderService:        Pedido " +  orderProcess.getPedir().getIdPedido()) + " aceito!");
        System.out.println("OrderService: ###########################################");
        System.out.println("OrderService: ###########################################");
        System.out.println("OrderService: ###########################################\n\n\n");
    }
}
