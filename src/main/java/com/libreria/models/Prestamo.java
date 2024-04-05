package com.libreria.models;

import com.libreria.models.bases.EstadosLibros;
import com.libreria.models.bases.Recurso;

public class Prestamo {
    private Recurso recurso;
    private Usuario usuario;
    private int cantDiasPrestamo = 30;
    private int contadorDias = 1;
    private boolean tieneMulta = false;
    private double valorMulta = 0;

    public Prestamo(Recurso recurso, Usuario usuario){
        this.recurso = recurso;
        this.usuario = usuario;
    }
    public void validarRetraso(){
        if (contadorDias>cantDiasPrestamo && contadorDias<120){
            this.tieneMulta = true;
            this.valorMulta = 100*(contadorDias-cantDiasPrestamo);
            this.recurso.setEstadoLibro(EstadosLibros.RETRASADO);
            this.usuario.setEstadoCuenta(false);
        }else if (contadorDias>120){
            this.valorMulta = this.recurso.getPrecio();
            this.recurso.setEstadoLibro(EstadosLibros.RETRASADO);
            this.usuario.setEstadoCuenta(false);
        }else{
            System.out.println("El recurso se encuentra dentro de los plazos establecidos para el prestamo");
        }
    }

    public int getContadorDias() {
        return contadorDias;
    }

    public void setContadorDias(int contadorDias) {
        this.contadorDias = contadorDias;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCantDiasPrestamo() {
        return cantDiasPrestamo;
    }

    public void setCantDiasPrestamo(int cantDiasPrestamo) {
        this.cantDiasPrestamo = cantDiasPrestamo;
    }

    public boolean isTieneMulta() {
        return tieneMulta;
    }

    public void setTieneMulta(boolean tieneMulta) {
        this.tieneMulta = tieneMulta;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prestamo{");
        sb.append(recurso.getTipoRecurso()).append(": ").append(recurso.getTitulo());
        sb.append(", ISBN ").append(recurso.getTipoRecurso()).append(": ").append(recurso.getIsbn());
        sb.append(", ID Usuario: ").append(usuario.getId());
        sb.append(", Días en prestamo: ").append(contadorDias);
        sb.append(", Estado: ").append(tieneMulta? "Tiene Multa":"Aun no tiene multa");
        if (tieneMulta){
            sb.append(", valorMulta=").append(valorMulta);
        }
        sb.append('}');
        return sb.toString();
    }
}
