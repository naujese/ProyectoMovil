package com.magit.mpi01;

public class DatosVo {

    private String titulo;
    private String info;
    private int foto;

    public DatosVo() {

    }

    public DatosVo(String titulo, String info, int foto) {
        this.titulo = titulo;
        this.info = info;
        this.foto = foto;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
