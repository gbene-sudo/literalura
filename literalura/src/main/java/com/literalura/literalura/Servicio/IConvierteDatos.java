package com.literalura.literalura.Servicio;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
