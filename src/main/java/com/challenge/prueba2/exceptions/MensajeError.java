package com.challenge.prueba2.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensajeError {

    private String mensaje;

    private String path;

    public MensajeError(String mensaje, String path) {

        this.mensaje = mensaje;
        this.path = path;
    }
    
}
