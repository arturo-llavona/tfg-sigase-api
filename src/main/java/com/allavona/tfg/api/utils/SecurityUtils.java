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
    // Este método es utilizado para comprobar que un usuario determinado es de tipo consulta (no es administrador) y
    // además está habilitado. En caso contrario, se lanza una excepción.
    public static void checkIsUsuarioConPerfilConsulta(Usuario usuario) {
        if ( usuario == null || usuario.getTipoUsuario() == null || TipoUsuarioEnum.ADMINISTRADOR.getId().equals(usuario.getTipoUsuario()) || !usuario.getHabilitado()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
    // Este método es utilizado para reemplazar el texto de una observación que está marcada como que contiene datos médicos,
    // en caso de que el usuario que está accediendo a la observación, no sea de tipo Médico.
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
    // Este método itera por todos los incidentes, para llamar al método que reemplaza los textos de las observaciones
    // de cada uno de los incidentes.
    public static List<Incidente> filtrarObservacionesConDatosMedicos(List<Incidente> incidentes, Usuario usuario) {
        if ( incidentes != null && incidentes.size() > 0 ) {
            incidentes.forEach(i -> filtrarObservacionesConDatosMedicos(i, usuario));
        }
        return incidentes;
    }
}
