package com.xpto.efood.process.pedirProcess;

import com.xpto.efood.service.dto.PedirProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class EntregaPedidoUserTaskFormContextDTO {

    private PedirProcessDTO pedirProcess;
    private TaskInstanceDTO taskInstance;

    public PedirProcessDTO getPedirProcess() {
        return pedirProcess;
    }

    public void setPedirProcess(PedirProcessDTO pedirProcess) {
        this.pedirProcess = pedirProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
