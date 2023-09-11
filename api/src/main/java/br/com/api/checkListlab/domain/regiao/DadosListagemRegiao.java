package br.com.api.checkListlab.domain.regiao;

public record DadosListagemRegiao(Long id, String nome, String responsavel) {

    public DadosListagemRegiao(Regiao regiao){
        this(regiao.getId(),  regiao.getNome(), regiao.getResponsavel());
    }
}
