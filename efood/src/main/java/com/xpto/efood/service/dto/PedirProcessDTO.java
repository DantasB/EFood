package com.xpto.efood.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.xpto.efood.domain.PedirProcess} entity.
 */
public class PedirProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private PedirDTO pedir;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public PedirDTO getPedir() {
        return pedir;
    }

    public void setPedir(PedirDTO pedir) {
        this.pedir = pedir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedirProcessDTO)) {
            return false;
        }

        PedirProcessDTO pedirProcessDTO = (PedirProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pedirProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PedirProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", pedir=" + getPedir() +
            "}";
    }
}
