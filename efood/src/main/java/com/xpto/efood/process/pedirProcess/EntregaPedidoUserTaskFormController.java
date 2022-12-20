package com.xpto.efood.process.pedirProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedir-process/entrega-pedido-user-task-form")
public class EntregaPedidoUserTaskFormController {

    private final Logger log = LoggerFactory.getLogger(EntregaPedidoUserTaskFormController.class);

    private final EntregaPedidoUserTaskFormService entregaPedidoUserTaskFormService;

    public EntregaPedidoUserTaskFormController(EntregaPedidoUserTaskFormService entregaPedidoUserTaskFormService) {
        this.entregaPedidoUserTaskFormService = entregaPedidoUserTaskFormService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaPedidoUserTaskFormContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        EntregaPedidoUserTaskFormContextDTO entregaPedidoUserTaskFormContext = entregaPedidoUserTaskFormService.loadContext(id);
        return ResponseEntity.ok(entregaPedidoUserTaskFormContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<EntregaPedidoUserTaskFormContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        EntregaPedidoUserTaskFormContextDTO entregaPedidoUserTaskFormContext = entregaPedidoUserTaskFormService.claim(id);
        return ResponseEntity.ok(entregaPedidoUserTaskFormContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody EntregaPedidoUserTaskFormContextDTO entregaPedidoUserTaskFormContext) {
        log.debug(
            "REST request to complete PedirProcess.EntregaPedidoUserTaskForm {}",
            entregaPedidoUserTaskFormContext.getTaskInstance().getId()
        );
        entregaPedidoUserTaskFormService.complete(entregaPedidoUserTaskFormContext);
        return ResponseEntity.noContent().build();
    }
}
