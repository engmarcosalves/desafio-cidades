package br.com.geekcode.marcos.desafio.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cidades")
public class Cidade implements Serializable {

    @Id
    @Column(name = "ibge_id")
    private Long ibgeId;

    @Column(name = "uf")
    private String uf;

    @Column(name = "nome")
    private String nome;

    private boolean capital;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name="sem_acentos")
    private String semAcentos;

    @Column(name = "nome_alternativo")
    private String nomeAlternativo;

    @Column(name = "micro_regiao")
    private String migroRegiao;

    @Column(name = "meso_regiao")
    private String mesoRegiao;

    public Long getIbgeId() {
        return ibgeId;
    }

    public void setIbgeId(Long ibgeId) {
        this.ibgeId = ibgeId;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getSemAcentos() {
        return semAcentos;
    }

    public void setSemAcentos(String semAcentos) {
        this.semAcentos = semAcentos;
    }

    public String getNomeAlternativo() {
        return nomeAlternativo;
    }

    public void setNomeAlternativo(String nomeAlternativo) {
        this.nomeAlternativo = nomeAlternativo;
    }

    public String getMigroRegiao() {
        return migroRegiao;
    }

    public void setMigroRegiao(String migroRegiao) {
        this.migroRegiao = migroRegiao;
    }

    public String getMesoRegiao() {
        return mesoRegiao;
    }

    public void setMesoRegiao(String mesoRegiao) {
        this.mesoRegiao = mesoRegiao;
    }
}
