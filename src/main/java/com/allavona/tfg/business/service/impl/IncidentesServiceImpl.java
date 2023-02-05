package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.api.enums.TipoUsuarioEnum;
import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.api.vo.Observacion;
import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.IncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.IncidentePersonaAfectadaEntity;
import com.allavona.tfg.business.bbdd.entity.ObservacionEntity;
import com.allavona.tfg.business.bbdd.repository.*;
import com.allavona.tfg.business.converter.ClasificacionIncidenteEntityConverter;
import com.allavona.tfg.business.converter.IncidenteEntityConverter;
import com.allavona.tfg.business.dto.*;
import com.allavona.tfg.business.service.IncidentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentesServiceImpl implements IncidentesService {
    @Autowired
    private IncidenteRepository incidenteRepository;
    @Autowired
    private ObservacionRepository observacionRepository;
    @Autowired
    private IncidentePersonaAfectadaRepository incidentePersonaAfectadaRepository;
    @Autowired
    private IncidenteRecursoRepository incidenteRecursoRepository;
    @Autowired
    private RecursoRepository recursoRepository;
    @Autowired
    private IncidenteRecursoEstadoRepository incidenteRecursoEstadoRepository;
    @Autowired
    private RecursoEstadoRepository recursoEstadoRepository;
    @Autowired
    private PlantillaClasificacionIncidenteRepository plantillaClasificacionIncidenteRepository;
    @Autowired
    private TipoRecursoRepository tipoRecursoRepository;
    @Autowired
    private ClasificacionIncidenteRepository clasificacionIncidenteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    private ClasificacionIncidenteEntityConverter clasificacionIncidenteEntityConverter = new ClasificacionIncidenteEntityConverter();

    private IncidenteEntityConverter incidenteEntityConverter = new IncidenteEntityConverter();

    @Override
    public List<ClasificacionIncidenteDTO> findClasificacionIncidenteByCodigo(final String codigo) {
        List<ClasificacionIncidenteEntity> source =  clasificacionIncidenteRepository.findByCodigoStartingWith(codigo);
        List<ClasificacionIncidenteDTO> target = source.stream().map(recurso -> clasificacionIncidenteEntityConverter.convert(recurso)).toList();
        return target;
    }

    @Override
    public List<IncidenteDTO> findIncidentesEnCurso() {
        return incidenteRepository.findByFechaFinalizacionIsNull().stream().map(i -> rellenarDatosIncidenteDTO(i, false, false, false)).toList();
    }
    @Override
    public List<IncidenteDTO> findIncidentesFinalizados() {
        return incidenteRepository.findByFechaFinalizacionIsNotNull().stream().map(i -> rellenarDatosIncidenteDTO(i, false, false, false)).toList();
    }

    @Override
    public IncidenteDTO findIncidenteById(final Integer idIncidente) {
        return incidenteRepository.findById(idIncidente).map(i -> rellenarDatosIncidenteDTO(i, true, true, true)).get();
    }
    @Override
    public IncidenteDTO crearIncidente(final UsuarioDTO usuario, final IncidenteDTO incidente) {
        IncidenteEntity nuevoIncidente = new IncidenteEntity();
        nuevoIncidente.setAlertante(incidente.getAlertante());
        nuevoIncidente.setAlias(incidente.getAlias());
        nuevoIncidente.setLocalizacionDescripcion(incidente.getLocalizacionDescripcion());
        nuevoIncidente.setLocalizacionLongitud(incidente.getLocalizacionLongitud());
        nuevoIncidente.setLocalizacionLatitud(incidente.getLocalizacionLatitud());
        nuevoIncidente.setFechaCreacion(new Date());
        nuevoIncidente.setClasificacionIncidente(clasificacionIncidenteEntityConverter.convert(incidente.getClasificacionIncidente()));
        nuevoIncidente = incidenteRepository.save(nuevoIncidente);

        List<ObservacionDTO> observaciones = incidente.getObservaciones();
        if ( observaciones != null && observaciones.size() > 0 ) {
            for (int i = 0; i < observaciones.size(); i++) {
                ObservacionDTO observacion = observaciones.get(i);
                ObservacionEntity nuevaObservacion = new ObservacionEntity();
                nuevaObservacion.setIdIncidente(nuevoIncidente.getIdIncidente());
                nuevaObservacion.setTexto(observacion.getTexto());
                if (TipoUsuarioEnum.MEDICO.getId().equals(usuario.getTipoUsuario()) && observacion.isDatosMedicos() ) {
                    nuevaObservacion.setDatosMedicos(true);
                } else {
                    nuevaObservacion.setDatosMedicos(false);
                }
                nuevaObservacion.setIdUsuario(usuario.getIdUsuario());
                nuevaObservacion.setFecha(new Date());
                observacionRepository.save(nuevaObservacion);
            }
        }

        return rellenarDatosIncidenteDTO(nuevoIncidente, true, true, true);
    }
    public IncidenteDTO rellenarDatosIncidenteDTO(IncidenteEntity i, boolean cargarObservaciones, boolean cargarPersonaAfectada, boolean cargarPlantillaRecursos) {
        IncidenteDTO incidenteDTO = IncidenteDTO.builder()
                .idIncidente(i.getIdIncidente())
                .fechaCreacion(i.getFechaCreacion())
                .fechaFinalizacion(i.getFechaFinalizacion())
                .alertante(i.getAlertante())
                .alias(i.getAlias())
                .localizacionDescripcion(i.getLocalizacionDescripcion())
                .localizacionLatitud(i.getLocalizacionLatitud())
                .localizacionLongitud(i.getLocalizacionLongitud())
                .clasificacionIncidente(clasificacionIncidenteEntityConverter.convert(i.getClasificacionIncidente()))
                .build();

        if ( cargarObservaciones ) {
            incidenteDTO.setObservaciones(observacionRepository.findAllByIdIncidente(i.getIdIncidente()).stream().map(o -> {
                    return ObservacionDTO.builder()
                            .idObservacion(o.getIdObservacion())
                            .texto(o.getTexto())
                            .fecha(o.getFecha())
                            .datosMedicos(o.isDatosMedicos())
                            .usuario(usuarioRepository.findById(o.getIdUsuario()).map( u -> UsuarioDTO.builder()
                                    .idUsuario(u.getIdUsuario())
                                    .nombre(u.getNombre())
                                    .apellido1(u.getApellido1())
                                    .apellido2(u.getApellido2())
                                    .username(u.getUsername())
                                    .build()).get())
                            .build();
            }).toList());
        }
        if ( cargarPersonaAfectada ) {
            IncidentePersonaAfectadaEntity incidentePersonaAfectadaEntity = incidentePersonaAfectadaRepository.findByIdIncidente(i.getIdIncidente());
            if ( incidentePersonaAfectadaEntity != null ) {
                incidenteDTO.setPersonaAfectada(IncidentePersonaAfectadaDTO.builder()
                        .idIncidentePersonaAfectada(incidentePersonaAfectadaEntity.getIdIncidentePersonaAfectada())
                        .nombre(incidentePersonaAfectadaEntity.getNombre())
                        .apellidos(incidentePersonaAfectadaEntity.getApellidos())
                        .edad(incidentePersonaAfectadaEntity.getEdad())
                        .tipoEdad(incidentePersonaAfectadaEntity.getTipoEdad())
                        .sexo(incidentePersonaAfectadaEntity.getSexo())
                        .dni(incidentePersonaAfectadaEntity.getDni())
                        .telefono(incidentePersonaAfectadaEntity.getTelefono())
                        .centroSalud(incidentePersonaAfectadaEntity.getCentroSalud())
                        .tarjetaSanitaria(incidentePersonaAfectadaEntity.getTarjetaSanitaria())
                        .build());
            }
        }
        if ( cargarPlantillaRecursos ) {
            incidenteDTO.setPlantillaRecursos(plantillaClasificacionIncidenteRepository
                    .findAllByIdClasificacionIncidente(i.getClasificacionIncidente().getIdClasificacionIncidente()).stream().map(
                            t -> tipoRecursoRepository.findById(t.getIdTipoRecurso()).map(tr -> TipoRecursoDTO.builder()
                                    .idTipoRecurso(tr.getIdTipoRecurso())
                                    .habilitado(tr.isHabilitado())
                                    .nombre(tr.getNombre())
                                    .build()).get()
                    ).toList());
        }
        incidenteDTO.setRecursos(
                incidenteRecursoRepository.findAllByIdIncidente(i.getIdIncidente()).stream().map(
                        ir -> recursoRepository.findById(ir.getIdRecurso()).map(r-> Optional.ofNullable(incidenteRecursoEstadoRepository
                                        .findByIdRecursoAndIdIncidente(r.getIdRecurso(), i.getIdIncidente()))
                                .map(ire -> RecursoDTO.builder()
                                        .idRecurso(r.getIdRecurso())
                                        .nombre(r.getNombre())
                                        .habilitado(r.isHabilitado())
                                        .tipoRecurso(tipoRecursoRepository.findById(r.getTipoRecurso().getIdTipoRecurso()).map(tr -> TipoRecursoDTO.builder()
                                                .idTipoRecurso(tr.getIdTipoRecurso())
                                                .habilitado(tr.isHabilitado())
                                                .nombre(tr.getNombre())
                                                .build()).get())
                                        .estado(
                                                recursoEstadoRepository.findById(ire.getIdRecursoEstado())
                                                        .map(re -> EstadoRecursoDTO.builder()
                                                                .idRecursoEstado(re.getIdRecursoEstado())
                                                                .nombreEstado(re.getNombreEstado())
                                                                .fechaEstado(ire.getFecha())
                                                                .build()).get())
                                        .build()).get()).get()
                ).toList());
        return incidenteDTO;
    }

}
