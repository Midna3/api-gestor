package edu.apigestor.entity.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * A classe {@link TDI} representa a tabela <b>tdi</b> no Banco de Dados, contendo diferentes
 * informações sobre a Distorção idade Serie. Essa classe funcionado como uma
 * entidade do JPA (Java Persistence API) e pode ser utilizada pelos repositórios para fazer leitura
 * no Bando de Dados, instâncias representam o indicador para o EF.
 *
 * @author LuizMFL
 * @version 1.0
 */
@Entity
@IdClass(TDI.TDIKey.class)
@Table(name = "tdi")
public class TDI {

    @Id
    @Column(name = "ano")
    private int ano;
    @Id
    @Column(name = "codEscola")
    private int codINEP;
    @Id
    @Column(name = "codEstado")
    private int codEstado;
    @Id
    @Column(name = "codMunicipio")
    private int codMunicipio;
    @Id
    @Column(name = "codPais") // Não precisamos de get/set, apenas serve para chave primária.
    private int codPais;
    @Id
    @Column(name = "codRegiao")
    private int codRegiao;
    @Id
    @Column(name = "dependencia") // Não precisamos de get/set, apenas serve para chave primária.
    private String dependencia;
    @Id
    @Column(name = "localizacao") // Não precisamos de get/set, apenas serve para chave primária.
    private String localizacao;
    @Column(name = "tipo")
    private Integer tipo;
    @Column(name = "TDIFundamentalTotal")
    private Double percentageFundamentalTotal;

    /**
     * Retorna o ano dessa entidade.
     *
     * @return inteiro que representa o ano (e.g., 2019).
     */
    public int getAno() {
        return this.ano;
    }

    /**
     * Retorna o código INEP da escola associada (se possuir, 0 caso contrário) com esse TDI.
     *
     * @return int representando o código INEP.
     */
    public int getCodINEP() {
        return codINEP;
    }

    /**
     * Retorna o código do estado associado com esse TDI.
     *
     * @return int representando o estado.
     */
    public int getCodEstado() {
        return codEstado;
    }

    /**
     * Retorna o código da região associada com esse TDI.
     *
     * @return int representando o estado.
     */
    public int getCodRegiao() {
        return codRegiao;
    }

    /**
     * Retorna o código do município associada com esse TDI.
     *
     * @return int representando o estado.
     */
    public int getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * Retorna o tipo dessa entidade (o tipo identifica se essa entidade se refere ao nível nacional,
     * regional, estadual ou escolar).
     *
     * @return inteiro que representa o tipo.
     */
    public Integer getTipo() {
        return tipo;
    }

    /**
     * Retorna a porcentagem de Distorção idade Serie total do Fundamental.
     *
     * @return double representando essa porcentagem.
     */
    public Double getPercentageFundamentalTotal() {
        return percentageFundamentalTotal;
    }

    public static class TDIKey implements Serializable {

        private int ano;
        private int codINEP;
        private int codEstado;
        private int codPais;
        private int codRegiao;
        private int codMunicipio;
        private String dependencia;
        private String localizacao;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TDIKey key = (TDIKey) o;
            return  (this.ano == key.ano) &&
                    (this.codINEP == key.codINEP) &&
                    (this.codEstado == key.codEstado) &&
                    (this.codPais == key.codPais) &&
                    (this.codRegiao == key.codRegiao) &&
                    (this.codMunicipio == key.codMunicipio) &&
                    this.dependencia.equals(key.dependencia) &&
                    this.localizacao.equals(key.localizacao);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.ano, this.codINEP, this.codEstado, this.codPais, this.codRegiao,
                    this.codMunicipio, this.dependencia, this.localizacao);
        }
    }

}