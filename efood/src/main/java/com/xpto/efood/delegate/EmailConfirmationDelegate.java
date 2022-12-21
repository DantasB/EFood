package com.xpto.efood.delegate;

import com.xpto.efood.service.MailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Locale;

@Component
public class EmailConfirmationDelegate implements JavaDelegate {

    @Autowired
    MailService mailService;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String subject = "Pedido Confirmado!";
        Context context = new Context(Locale.getDefault());
        String content = templateEngine.process("pedirProcess/PedirSummaryEmail", context);
        mailService.sendEmail("example@gmail.com", subject, content, false, true);
    }
}