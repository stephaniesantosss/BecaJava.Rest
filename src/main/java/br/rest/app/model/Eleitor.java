package br.rest.app.model;

public class Eleitor {
	
	    private Long Id;
	    private String Nome;
	    private int Idade;

	    public int getIdade() {
			return Idade;
		}
		public void setIdade(int idade) {
			Idade = idade;
		}
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

}
