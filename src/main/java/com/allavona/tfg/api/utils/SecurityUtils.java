package com.allavona.tfg.api.utils;

import com.allavona.tfg.api.enums.TipoUsuarioEnum;
import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.api.vo.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class SecurityUtils {
    public static void checkIsUsuarioConPerfilConsulta(Usuario usuario) {
        if ( usuario == null || usuario.getTipoUsuario() == null || TipoUsuarioEnum.ADMINISTRADOR.getId().equals(usuario.getTipoUsuario()) || !usuario.getHabilitado()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
    public static Incidente filtrarObservacionesConDatosMedicos(Incidente incidente, Usuario usuario) {
        if ( usuario == null || usuario.getTipoUsuario() == null || !(TipoUsuarioEnum.MEDICO.getId().equals(usuario.getTipoUsuario()))) {
            if ( incidente.getObservaciones() != null ) {
                incidente.getObservaciones().forEach(o -> {
                    if (o.isDatosMedicos()) {
                        o.setTexto(Constants.MASCARA_COMENTARIOS_DATOS_MEDICOS);
                    }
                });
            }
        }
        return incidente;
    }
    public static List<Incidente> filtrarObservacionesConDatosMedicos(List<Incidente> incidentes, Usuario usuario) {
        if ( incidentes != null && incidentes.size() > 0 ) {
            incidentes.forEach(i -> filtrarObservacionesConDatosMedicos(i, usuario));
        }
        return incidentes;
    }
}
