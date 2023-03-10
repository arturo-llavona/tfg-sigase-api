package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.api.enums.TipoUsuarioEnum;
import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.IncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.IncidentePersonaAfectadaEntity;
import com.allavona.tfg.business.bbdd.entity.ObservacionEntity;
import com.allavona.tfg.business.bbdd.repository.*;
import com.allavona.tfg.business.converter.ClasificacionIncidenteEntityConverter;
import com.allavona.tfg.business.converter.IncidentePersonaAfectadaEntityConverter;
import com.allavona.tfg.business.dto.*;
import com.allavona.tfg.business.service.IncidentesService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentesServiceImpl implements IncidentesService {
    private final IncidenteRepository incidenteRepository;
    private final ObservacionRepository observacionRepository;
    private final IncidentePersonaAfectadaRepository incidentePersonaAfectadaRepository;
    private final IncidenteRecursoRepository incidenteRecursoRepository;
    private final RecursoRepository recursoRepository;
    private final IncidenteRecursoEstadoRepository incidenteRecursoEstadoRepository;
    private final RecursoEstadoRepository recursoEstadoRepository;
    private final PlantillaClasificacionIncidenteRepository plantillaClasificacionIncidenteRepository;
    private final TipoRecursoRepository tipoRecursoRepository;
    private final ClasificacionIncidenteRepository clasificacionIncidenteRepository;
    private final UsuarioRepository usuarioRepository;
    private ClasificacionIncidenteEntityConverter clasificacionIncidenteEntityConverter = new ClasificacionIncidenteEntityConverter();
    private IncidentePersonaAfectadaEntityConverter incidentePersonaAfectadaEntityConverter = new IncidentePersonaAfectadaEntityConverter();
    public IncidentesServiceImpl(IncidenteRecursoRepository incidenteRecursoRepository, IncidenteRepository incidenteRepository, ObservacionRepository observacionRepository, IncidentePersonaAfectadaRepository incidentePersonaAfectadaRepository, RecursoRepository recursoRepository, IncidenteRecursoEstadoRepository incidenteRecursoEstadoRepository, RecursoEstadoRepository recursoEstadoRepository, PlantillaClasificacionIncidenteRepository plantillaClasificacionIncidenteRepository, TipoRecursoRepository tipoRecursoRepository, ClasificacionIncidenteRepository clasificacionIncidenteRepository, UsuarioRepository usuarioRepository) {
        this.incidenteRecursoRepository = incidenteRecursoRepository;
        this.incidenteRepository = incidenteRepository;
        this.observacionRepository = observacionRepository;
        this.incidentePersonaAfectadaRepository = incidentePersonaAfectadaRepository;
        this.recursoRepository = recursoRepository;
        this.incidenteRecursoEstadoRepository = incidenteRecursoEstadoRepository;
        this.recursoEstadoRepository = recursoEstadoRepository;
        this.plantillaClasificacionIncidenteRepository = plantillaClasificacionIncidenteRepository;
        this.tipoRecursoRepository = tipoRecursoRepository;
        this.clasificacionIncidenteRepository = clasificacionIncidenteRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public List<ClasificacionIncidenteDTO> findClasificacionIncidenteByCodigo(final String codigo) {
        // Realizamos la consulta a base de datos para obtener el listado de clasificaciones de incidentes,
        // dependiendo de si nos llega un c??digo o no, buscamos todos o ??nicamente los que empiecen con la cadena
        // recibida.
        List<ClasificacionIncidenteEntity> source =  codigo != null ? clasificacionIncidenteRepository.findByCodigoStartingWith(codigo) : clasificacionIncidenteRepository.findAll();
        // Despu??s, realizamos la transformaci??n del listado de Entity a DTO utilizando su converter.
        List<ClasificacionIncidenteDTO> target = source.stream().map(recurso -> clasificacionIncidenteEntityConverter.convert(recurso)).toList();
        return target;
    }
    @Override
    public List<IncidenteDTO> findIncidentesEnCurso() {
        // Realizamos la consulta en base de datos de los incidentes cuya fecha de finalizaci??n sea nula,
        // rellenamos la informaci??n de cada incidente convirti??ndolo a su vez de Entity a DTO.
        return incidenteRepository.findByFechaFinalizacionIsNull().stream().map(i -> rellenarDatosIncidenteDTO(i, false, false, false)).toList();
    }
    @Override
    public List<IncidenteDTO> findIncidentesFinalizados() {
        // Realizamos la consulta en base de datos de los incidentes cuya fecha de finalizaci??n no sea nula,
        // rellenamos la informaci??n de cada incidente convirti??ndolo a su vez de Entity a DTO.
        return incidenteRepository.findByFechaFinalizacionIsNotNull().stream().map(i -> rellenarDatosIncidenteDTO(i, false, false, false)).toList();
    }
    @Override
    public IncidenteDTO findIncidenteById(final Integer idIncidente) {
        // Realizamos la consulta en base de datos de un incidente a partir de su identificador.
        // Posteriormente rellenamos la informaci??n del incidente, convirti??ndolo a su vez de Entity a DTO.
        // En este caso, se carga toda la informaci??n del incidente, ya que nos interesa todo su detalle.
        return incidenteRepository.findById(idIncidente).map(i -> rellenarDatosIncidenteDTO(i, true, true, true)).get();
    }
    @Override
    public IncidenteDTO crearIncidente(final UsuarioDTO usuario, final IncidenteDTO incidente) {
        // Inicializamos el incidente que vamos a querer crear, y le copiamos los datos a partir del DTO
        // que llega como par??metro.
        IncidenteEntity nuevoIncidente = new IncidenteEntity();
        nuevoIncidente.setAlertante(incidente.getAlertante());
        nuevoIncidente.setAlias(incidente.getAlias());
        nuevoIncidente.setLocalizacionDescripcion(incidente.getLocalizacionDescripcion());
        nuevoIncidente.setLocalizacionLongitud(incidente.getLocalizacionLongitud());
        nuevoIncidente.setLocalizacionLatitud(incidente.getLocalizacionLatitud());
        nuevoIncidente.setFechaCreacion(new Date());
        // La clasificaci??n del incidente, al ser un tipo complejo, la seteamos realizando una conversi??n de DTO a
        // tipo Entity.
        nuevoIncidente.setClasificacionIncidente(clasificacionIncidenteEntityConverter.convert(incidente.getClasificacionIncidente()));
        // Guardamos en base de datos el incidente.
        nuevoIncidente = incidenteRepository.save(nuevoIncidente);

        // Comprobamos si el incidente que se est?? intentando crear, ten??a datos de persona afectada
        IncidentePersonaAfectadaDTO personaAfectadaDTO = incidente.getPersonaAfectada();
        if ( personaAfectadaDTO != null ) {
            // En caso de existir datos de la persona afectada, realizamos una conversi??n del dato de tipo DTO a Entity.
            IncidentePersonaAfectadaEntity personaAfectadaEntity = incidentePersonaAfectadaEntityConverter.convert(personaAfectadaDTO);
            // Le establecemos el identificador del incidente que acabamos de crear.
            personaAfectadaEntity.setIdIncidente(nuevoIncidente.getIdIncidente());
            // Guardamos la informaci??n de la persona afectada en el incidente, en base de datos.
            incidentePersonaAfectadaRepository.save(personaAfectadaEntity);
        }

        // Comprobamos si existen observaciones que haya que insertar en base de datos.
        List<ObservacionDTO> observaciones = incidente.getObservaciones();
        if ( observaciones != null && observaciones.size() > 0 ) {
            // Si nos llegan observaciones para insertar, iteramos el listado.
            for (int i = 0; i < observaciones.size(); i++) {
                // Para cada observaci??n de tipo DTO que nos llega en la incidencia que se est?? creando, debemos
                // convertirla a tipo Entity.
                ObservacionDTO observacion = observaciones.get(i);
                ObservacionEntity nuevaObservacion = new ObservacionEntity();
                // Se introduce en la observaci??n el identificador del incidente que se ha creado.
                nuevaObservacion.setIdIncidente(nuevoIncidente.getIdIncidente());
                nuevaObservacion.setTexto(observacion.getTexto());
                // Si el usuario que est?? llamando a la funcionalidad es de tipo M??dico, y la observaci??n viene marcada
                // como que contiene datos m??dicos, establecemos dicho flag en la observaci??n que se va a insertar.
                // En caso de que el usuario no sea de tipo m??dico, se obvia el valor original, marcando el comentario
                // como que no tiene datos m??dicos, como medida de seguridad para controlar intentos de uso del software
                // malintencionado.
                if (TipoUsuarioEnum.MEDICO.getId().equals(usuario.getTipoUsuario()) && observacion.isDatosMedicos() ) {
                    nuevaObservacion.setDatosMedicos(true);
                } else {
                    nuevaObservacion.setDatosMedicos(false);
                }
                // Se establece en la observaci??n el identificador del usuario que ha llamado a la funcionalidad.
                nuevaObservacion.setIdUsuario(usuario.getIdUsuario());
                // Se establece la fecha actual como fecha de la observaci??n.
                nuevaObservacion.setFecha(new Date());
                // Se almacena la observaci??n en base de datos.
                observacionRepository.save(nuevaObservacion);
            }
        }
        // Devolvemos la informaci??n del incidente que acabamos de crear. Para que la informaci??n devuelta contenga
        // todos los identificadores y toda la informaci??n completa, llamamos a la funci??n creada para obtener toda la
        // informaci??n de un incidente, indic??ndole que queremos que cargue todos los datos que existan.
        return rellenarDatosIncidenteDTO(nuevoIncidente, true, true, true);
    }
    // Esta funci??n devuelve un Incidente de tipo DTO rellenando toda la informaci??n base del Incidente, y completando
    // su informaci??n dependiendo de los flags que se especifiquen:
    // cargarObservaciones: Carga de todas las observaciones que tenga el incidente.
    // cargarPersonaAfectada: Carga de la informaci??n de la persona afectada relacionada con el incidente.
    // cargarPlantillaRecursos: Carga de la plantilla de recursos recomendados para el incidente, a partir
    //          de su clasificaci??n.
    public IncidenteDTO rellenarDatosIncidenteDTO(IncidenteEntity i, boolean cargarObservaciones, boolean cargarPersonaAfectada, boolean cargarPlantillaRecursos) {
        // Crea un nuevo incidente de tipo DTO, y rellena sus datos b??sicos.
        // Para rellenar la clasificaci??n del incidente, se hace uso del converter implementado.
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

        // En caso de que haya que cargar las observaciones, se realiza una b??squeda de todas las observaciones existentes
        // para el incidente. Adem??s, se rellena la informaci??n del usuario que ha escrito el comentario a partir del
        // identificador del usuario que ha escrito la observaci??n.
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
        // Si se ha especificado que deben cargarse los datos de la persona afectada, se realiza una b??squeda mediante el
        // identificador del incidente, y si se encuentran datos, se establece la informaci??n de la persona afectada
        // dentro del Incidente en formato DTO que se est?? construyendo.
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
        // Si se ha especificado que debe cargarse la plantilla de recursos, se realiza una consulta de los tipos de recursos
        // establecidos para la clasificaci??n del incidente con el que estamos trabajando. Para cada tipo de recurso, se realiza
        // una consulta para obtener sus datos b??sicos.
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
        // Se realiza una carga de todos los recursos que est??n movilizados para el incidente. Para cada uno de los recursos
        // movilizados, se obtiene su informaci??n, y el estado en el que se encuentra actualmente.
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
