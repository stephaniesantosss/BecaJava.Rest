package br.rest.app.model;

public class Municipio {
    private Long Id;
    private String Nome;
    private int Populacao;

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public int getPopulacao() {
        return Populacao;
    }
    public void setPopulacao(int populacao) {
        Populacao = populacao;
    }


}
