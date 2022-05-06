package edu.apigestor.entity.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * A classe {@link IED} representa a tabela <b>ied</b> no Banco de Dados, contendo diferentes
 * informações sobre o Indicador de Esforço Docente. Essa classe funcionado como uma
 * entidade do JPA (Java Persistence API) e pode ser utilizada pelos repositórios para fazer leitura
 * no Bando de Dados, instâncias representam o indicador para o EF.
 *
 * @author LuizMFL
 * @version 1.0
 */
@Entity
@IdClass(IED.IEDKey.class)
@Table(name = "ied")
public class IED {

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
    private int tipo;
    @Column(name = "IEDFundamentalTotalNivel1")
    private double percentageN1;
    @Column(name = "IEDFundamentalTotalNivel2")
    private double percentageN2;
    @Column(name = "IEDFundamentalTotalNivel3")
    private double percentageN3;
    @Column(name = "IEDFundamentalTotalNivel4")
    private double percentageN4;
    @Column(name = "IEDFundamentalTotalNivel5")
    private double percentageN5;
    @Column(name = "IEDFundamentalTotalNivel6")
    private double percentageN6;

    /**
     * Retorna o ano dessa entidade.
     *
     * @return inteiro que representa o ano (e.g., 2019).
     */
    public int getAno() {
        return this.ano;
    }

    /**
     * Retorna o código INEP da escola associada (se possuir, 0 caso contrário) com esse IED.
     *
     * @return int representando o código INEP.
     */
    public int getCodINEP() {
        return codINEP;
    }

    /**
     * Retorna o código do estado associado com esse IED.
     *
     * @return int representando o estado.
     */
    public int getCodEstado() {
        return codEstado;
    }

    /**
     * Retorna o código da região associada com esse IED.
     *
     * @return int representando o estado.
     */
    public int getCodRegiao() {
        return codRegiao;
    }

    /**
     * Retorna o código do município associada com esse IED.
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
    public int getTipo() {
        return tipo;
    }

    /**
     * Retorna a porcentagem de professores que se encaixam na categoria 1.
     *
     * @return double representando essa porcentagem.
     */
    public double getPercentageN1() {
        return percentageN1;
    }

    /**
     * Retorna a porcentagem de professores que se encaixam na categoria 2.
     *
     * @return double representando essa porcentagem.
     */
    public double getPercentageN2() {
        return percentageN2;
    }

    /**
     * Retorna a porcentagem de professores que se encaixam na categoria 3.
     *
     * @return double representando essa porcentagem.
     */
    public double getPercentageN3() {
        return percentageN3;
    }

    /**
     * Retorna a porcentagem de professores que se encaixam na categoria 4.
     *
     * @return double representando essa porcentagem.
     */
    public double getPercentageN4() {
        return percentageN4;
    }

    /**
     * Retorna a porcentagem de professores que se encaixam na categoria 5.
     *
     * @return double representando essa porcentagem.
     */
    public double getPercentageN5() {
        return percentageN5;
    }

    /**
     * Retorna a porcentagem de professores que se encaixam na categoria 6.
     *
     * @return double representando essa porcentagem.
     */
    public double getPercentageN6() {
        return percentageN6;
    }

    public static class IEDKey implements Serializable {

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
            IEDKey key = (IEDKey) o;
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
