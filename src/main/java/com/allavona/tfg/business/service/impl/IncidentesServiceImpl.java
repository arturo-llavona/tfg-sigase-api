package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.IncidenteEntity;
import com.allavona.tfg.business.bbdd.repository.*;
import com.allavona.tfg.business.converter.ClasificacionIncidenteEntityConverter;
import com.allavona.tfg.business.dto.*;
import com.allavona.tfg.business.service.IncidentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            incidenteDTO.setPersonaAfectada(Optional.ofNullable(incidentePersonaAfectadaRepository.findByIdIncidente(i.getIdIncidente())).map(p ->
                    IncidentePersonaAfectadaDTO.builder()
                            .idIncidentePersonaAfectada(p.getIdIncidentePersonaAfectada())
                            .nombre(p.getNombre())
                            .apellidos(p.getApellidos())
                            .edad(p.getEdad())
                            .tipoEdad(p.getTipoEdad())
                            .sexo(p.getSexo())
                            .dni(p.getDni())
                            .telefono(p.getTelefono())
                            .centroSalud(p.getCentroSalud())
                            .tarjetaSanitaria(p.getTarjetaSanitaria())
                            .build()
            ).get());
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
