package com.allavona.tfg.api.enums;

public enum TipoUsuarioEnum {
    AGENTE(1), MEDICO(2), ADMINISTRADOR(3);
    public final Integer id;
    private TipoUsuarioEnum(final Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }
    public static TipoUsuarioEnum valueOf(Integer id) {
        for (TipoUsuarioEnum e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return null;
    }
}
