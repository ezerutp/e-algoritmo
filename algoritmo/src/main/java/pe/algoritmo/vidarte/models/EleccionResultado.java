package pe.algoritmo.vidarte.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EleccionResultado {
    private int electores;
    private int abstenciones;
    private int votantes;
    private int blancos;
    private int validos;
    private int nulos;
    private int psoe;
    private int fo;
    private int pp;
    private int pacma;
    private int pcte;
    private int pumJ;
    private int vox;
    private int puede;
    private int aeev;
    private int rc;
    private int sumar;

    public EleccionResultado() {
    }

    public EleccionResultado(String[] data) {
        try {
            this.electores = Integer.parseInt(data[3]);
            this.abstenciones = Integer.parseInt(data[4]);
            this.votantes = Integer.parseInt(data[5]);
            this.blancos = Integer.parseInt(data[6]);
            this.validos = Integer.parseInt(data[7]);
            this.nulos = Integer.parseInt(data[8]);
            this.psoe = Integer.parseInt(data[9]);
            this.fo = Integer.parseInt(data[10]);
            this.pp = Integer.parseInt(data[11]);
            this.pacma = Integer.parseInt(data[12]);
            this.pcte = Integer.parseInt(data[13]);
            this.pumJ = Integer.parseInt(data[14]);
            this.vox = Integer.parseInt(data[15]);
            this.puede = Integer.parseInt(data[16]);
            this.aeev = Integer.parseInt(data[17]);
            this.rc = Integer.parseInt(data[18]);
            this.sumar = Integer.parseInt(data[19]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters and Setters
    public int getElectores() {
        return electores;
    }

    public void setElectores(int electores) {
        this.electores = electores;
    }

    public int getAbstenciones() {
        return abstenciones;
    }

    public void setAbstenciones(int abstenciones) {
        this.abstenciones = abstenciones;
    }

    public int getVotantes() {
        return votantes;
    }

    public void setVotantes(int votantes) {
        this.votantes = votantes;
    }

    public int getBlancos() {
        return blancos;
    }

    public void setBlancos(int blancos) {
        this.blancos = blancos;
    }

    public int getValidos() {
        return validos;
    }

    public void setValidos(int validos) {
        this.validos = validos;
    }

    public int getNulos() {
        return nulos;
    }

    public void setNulos(int nulos) {
        this.nulos = nulos;
    }

    public int getPsoe() {
        return psoe;
    }

    public void setPsoe(int psoe) {
        this.psoe = psoe;
    }

    public int getFo() {
        return fo;
    }

    public void setFo(int fo) {
        this.fo = fo;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPacma() {
        return pacma;
    }

    public void setPacma(int pacma) {
        this.pacma = pacma;
    }

    public int getPcte() {
        return pcte;
    }

    public void setPcte(int pcte) {
        this.pcte = pcte;
    }

    public int getPumJ() {
        return pumJ;
    }

    public void setPumJ(int pumJ) {
        this.pumJ = pumJ;
    }

    public int getVox() {
        return vox;
    }

    public void setVox(int vox) {
        this.vox = vox;
    }

    public int getPuede() {
        return puede;
    }

    public void setPuede(int puede) {
        this.puede = puede;
    }

    public int getAeev() {
        return aeev;
    }

    public void setAeev(int aeev) {
        this.aeev = aeev;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public int getSumar() {
        return sumar;
    }

    public void setSumar(int sumar) {
        this.sumar = sumar;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("electores", electores)
            .append("abstenciones", abstenciones)
            .append("votantes", votantes)
            .append("blancos", blancos)
            .append("validos", validos)
            .append("nulos", nulos)
            .append("psoe", psoe)
            .append("fo", fo)
            .append("pp", pp)
            .append("pacma", pacma)
            .append("pcte", pcte)
            .append("pumJ", pumJ)
            .append("vox", vox)
            .append("puede", puede)
            .append("aeev", aeev)
            .append("rc", rc)
            .append("sumar", sumar)
            .toString();
    }
}