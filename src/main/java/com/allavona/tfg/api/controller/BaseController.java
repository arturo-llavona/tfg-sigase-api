package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.enums.TipoUsuarioEnum;

public class BaseController {
    public static boolean isUsuarioConPerfilConsulta(String tipoUsuario) {
        TipoUsuarioEnum tipoUsuarioEnum = TipoUsuarioEnum.valueOf(tipoUsuario);
        if ( tipoUsuarioEnum != null && (tipoUsuarioEnum.equals(TipoUsuarioEnum.AGENTE) ||
                tipoUsuarioEnum.equals(TipoUsuarioEnum.MEDICO)) ) {
            return true;
        }
        return false;
    }
}
