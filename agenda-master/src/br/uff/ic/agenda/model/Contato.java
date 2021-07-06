package br.uff.ic.agenda.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Contato implements Serializable {
    private String nome;
    private String endereco;
    private String endereco1;
    private String telefone;
    private String telefone1;
    private String detalhes;

    public Contato() {
     


        nome = "Novo Contato";
        endereco = "";
        endereco1 = "";
        telefone = "";
        telefone1 = "";
        detalhes = "";
    }
    public String getendereco1(){
        return endereco1;
    }
    public void setendereco1(String endereco1){
        this.endereco1 = endereco1;
    }

    public String getendereco() {
        return endereco;
    }
    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    @Override
    public String toString() {
        return nome;
    }    

    
}