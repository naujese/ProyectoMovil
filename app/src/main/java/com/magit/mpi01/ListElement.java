package com.magit.mpi01;

public class ListElement {
    public String image;
    public String texto;
    public String info;


    public ListElement(String image, String texto, String info) {
        this.image = image;
        this.texto = texto;
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
