package com.rubo.productos;

import java.util.Date;

public class Productos {
    private String codArt;
    private String seccion;
    private String nombreArt;
    private double precio;
    private Date fecha;
    private String importado;
    private String paisOrigen;

    public Productos(String codArt, String seccion, String nombreArt, double precio, Date fecha, String importado,
            String paisOrigen) {
        this.codArt = codArt;
        this.seccion = seccion;
        this.nombreArt = nombreArt;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.paisOrigen = paisOrigen;
    }

    public Productos(String seccion, String nombreArt, double precio, Date fecha, String importado, String paisOrigen) {
        this.seccion = seccion;
        this.nombreArt = nombreArt;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return "Productos [codArt=" + codArt + ", fecha=" + fecha + ", importado=" + importado + ", nombreArt="
                + nombreArt + ", paisOrigen=" + paisOrigen + ", precio=" + precio + ", seccion=" + seccion + "]";
    }

    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
