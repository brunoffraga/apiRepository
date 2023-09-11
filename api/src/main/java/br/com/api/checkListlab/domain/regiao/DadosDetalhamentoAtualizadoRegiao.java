package br.com.api.checkListlab.domain.regiao;

public record DadosDetalhamentoAtualizadoRegiao(String nome, String responsavel) {

    public DadosDetalhamentoAtualizadoRegiao(Regiao regiao){
        this(regiao.getNome(), regiao.getResponsavel());
    }

}
