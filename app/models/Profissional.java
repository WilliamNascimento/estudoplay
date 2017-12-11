package models;

import javax.persistence.*;
import io.ebean.*;

import play.data.validation.Constraints.Required;

@Entity
public class Profissional extends Model{

    @Id
    public Long id;
    @Required(message = "O nome do produto é obrigatório")
    public String nome;
    public String profissao;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setProfissao(String profissao){
        this.profissao = profissao;
    }

    public String getProfissao(){
        return profissao;
    }
    
    public static Finder<Long,Profissional> find = 
        new Finder<>(Profissional.class);
}