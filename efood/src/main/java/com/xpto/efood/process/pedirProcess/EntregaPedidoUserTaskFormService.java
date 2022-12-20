package com.xpto.efood.process.pedirProcess;

import com.xpto.efood.repository.PedirProcessRepository;
import com.xpto.efood.service.PedirService;
import com.xpto.efood.service.dto.PedirDTO;
import com.xpto.efood.service.dto.PedirProcessDTO;
import com.xpto.efood.service.mapper.PedirProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class EntregaPedidoUserTaskFormService {

    private final TaskInstanceService taskInstanceService;

    private final PedirService pedirService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final PedirProcessRepository pedirProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final EntregaPedidoUserTaskFormMapper entregaPedidoUserTaskFormMapper;

    private final PedirProcessMapper pedirProcessMapper;

    public EntregaPedidoUserTaskFormService(
        TaskInstanceService taskInstanceService,
        PedirService pedirService,
        TaskInstanceRepository taskInstanceRepository,
        PedirProcessRepository pedirProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        EntregaPedidoUserTaskFormMapper entregaPedidoUserTaskFormMapper,
        PedirProcessMapper pedirProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.pedirService = pedirService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.pedirProcessRepository = pedirProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.entregaPedidoUserTaskFormMapper = entregaPedidoUserTaskFormMapper;
        this.pedirProcessMapper = pedirProcessMapper;
    }

    public EntregaPedidoUserTaskFormContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        PedirProcessDTO pedirProcess = pedirProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(entregaPedidoUserTaskFormMapper::toPedirProcessDTO)
            .orElseThrow();

        EntregaPedidoUserTaskFormContextDTO entregaPedidoUserTaskFormContext = new EntregaPedidoUserTaskFormContextDTO();
        entregaPedidoUserTaskFormContext.setTaskInstance(taskInstanceDTO);
        entregaPedidoUserTaskFormContext.setPedirProcess(pedirProcess);

        return entregaPedidoUserTaskFormContext;
    }

    public EntregaPedidoUserTaskFormContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(EntregaPedidoUserTaskFormContextDTO entregaPedidoUserTaskFormContext) {
        PedirDTO pedirDTO = pedirService.findOne(entregaPedidoUserTaskFormContext.getPedirProcess().getPedir().getId()).orElseThrow();
        pedirDTO.setPedido(entregaPedidoUserTaskFormContext.getPedirProcess().getPedir().getPedido());
        pedirDTO.setPedido(entregaPedidoUserTaskFormContext.getPedirProcess().getPedir().getPedido());
        pedirService.save(pedirDTO);
    }

    public void complete(EntregaPedidoUserTaskFormContextDTO entregaPedidoUserTaskFormContext) {
        save(entregaPedidoUserTaskFormContext);
        PedirProcessDTO pedirProcess = pedirProcessRepository
            .findByProcessInstanceId(entregaPedidoUserTaskFormContext.getPedirProcess().getProcessInstance().getId())
            .map(pedirProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(entregaPedidoUserTaskFormContext.getTaskInstance(), pedirProcess);
    }
}
