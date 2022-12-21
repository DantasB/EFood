package com.xpto.efood.delegate;
import java.time.*;

import com.xpto.efood.service.dto.PedirDTO;
import com.xpto.efood.service.dto.PedirProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ThirdParty implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Boolean tarde = LocalTime.now().isAfter( LocalTime.parse( "23:59" ) );
        if(tarde){
            System.out.println("OrderService: ###########################################");
            System.out.println("OrderService: ###########################################");
            System.out.println("OrderService: ###########################################");
            System.out.println("OrderService:        Pedido " +  delegateExecution.getVariable("processInstance") + " Negado!");
            System.out.println("OrderService: ###########################################");
            System.out.println("OrderService: ###########################################");
            System.out.println("OrderService: ###########################################\n\n\n");
            delegateExecution.setVariable("DevePedir", false);
        }else{
            System.out.println("OrderService: ###########################################");
            System.out.println("OrderService: ###########################################");
            System.out.println("OrderService: ###########################################");
            System.out.println("OrderService:        Pedido " +  delegateExecution.getVariable("processInstance") + " aceito!");
            System.out.println("OrderService: ###########################################");
            System.out.println("OrderService: ###########################################");
            System.out.println("OrderService: ###########################################\n\n\n");
            delegateExecution.setVariable("DevePedir", true);
        }
    }
}
