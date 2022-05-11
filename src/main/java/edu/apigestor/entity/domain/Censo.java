package edu.apigestor.entity.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * A classe {@link Censo} representa a tabela <b>censo</b> no Banco de Dados, contendo diferentes
 * informações sobre o Censo Escolar. Essa classe funcionado como uma
 * entidade do JPA (Java Persistence API) e pode ser utilizada pelos repositórios para fazer leitura
 * no Bando de Dados, instâncias representam o indicador para o EF.
 *
 * @author ArthurFS
 * @version 1.0
 */
@Entity
@Table(name = "censo")
public class Censo {

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
    @Column(name = "codRegiao")
    private int codRegiao;
    @Id
    @Column(name = "dependencia")
    private String dependencia;

    @Column(name = "nomeRegiao")
    private String nomeRegiao;
    @Column(name = "nomeEstado")
    private String nomeEstado;
    @Column(name = "nomeMunicipio")
    private String nomeMunicipio;
    @Column(name = "nomeBairro")
    private String nomeBairro;
    @Column(name = "nomeEscola")
    private String nomeEscola;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "cep")
    private int cep;
    @Column(name = "DDD")
    private Double DDD;
    @Column(name = "telefone")
    private Double telefone;
    @Column(name = "existeFundamental")
    private Double existeFundamental;
    @Column(name = "matriculadosFundamental")
    private Double matriculadosFundamental;
    @Column(name = "docentesFundamental")
    private Double docentesFundamental;
    @Column(name = "turmasFundamental")
    private Double turmasFundamental;

    /**
     * Retorna o ano dessa entidade.
     *
     * @return inteiro que representa o ano (e.g., 2019).
     */
    public int getAno() {
        return ano;
    }

    /**
     * Retorna o código INEP da escola associada (se possuir, 0 caso contrário) com essa escola.
     *
     * @return int representando o código INEP.
     */
    public int getCodINEP() {
        return codINEP;
    }

    /**
     * Retorna o código do estado associado a essa escola.
     *
     * @return int representando o estado.
     */
    public int getCodEstado() {
        return codEstado;
    }

    /**
     * Retorna o código do município associada a essa escola.
     *
     * @return int representando o estado.
     */
    public int getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * Retorna o código da região associada a essa escola.
     *
     * @return int representando o estado.
     */
    public int getCodRegiao() {
        return codRegiao;
    }

    /**
     * Retorna o nome da região associada a essa escola.
     *
     * @return String representando a Região.
     * */
    public String getNomeRegiao() {
        return nomeRegiao;
    }

    /**
     * Retorna o nome do estado associado a essa escola.
     *
     * @return String representando o Estado.
     */
    public String getNomeEstado() {
        return nomeEstado;
    }

    /**
     * Retorna o nome do município associado a essa escola.
     *
     * @return String representando o Município.
     */
    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    /**
     * Retorna o nome do bairro associado a essa escola.
     *
     * @return String representando o Bairro.
     */
    public String getNomeBairro() {
        return nomeBairro;
    }

    /**
     * Retorna o nome da escola associada a essa escola.
     *
     * @return String representando o Nome da Escola.
     */
    public String getNomeEscola() {
        return nomeEscola;
    }

    /**
     * Retorna o endereço da escola associada a essa escola.
     *
     * @return String representando o Endereço.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Retorna o número da escola associada a essa escola.
     *
     * @return String representando o Número.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Retorna o complemento do endereço da escola associada a essa escola.
     *
     * @return String representando o Complemento.
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Retorna o CEP associada a essa escola.
     *
     * @return int representando o CEP.
     */
    public int getCep() {
        return cep;
    }

    /**
     * Retorna o DDD do telefone da escola associada a essa escola.
     *
     * @return Double representando o Telefone.
     */
    public Double getDDD() {
        return DDD;
    }

    /**
     * Retorna o telefone da escola associada a essa escola.
     *
     * @return Double representando o Telefone.
     */
    public Double getTelefone() {
        return telefone;
    }

    /**
     * Verifica se a escola tem ensino fundamental.
     *
     * @return Double representando se a escola tem ensino fundamental.
     */
    public Double getExisteFundamental() {
        return existeFundamental;
    }

    /**
     * Retorna o numero de matriculados da escola associada a essa escola.
     *
     * @return Double representando o numero de Matriculados.
     */
    public Double getMatriculadosFundamental() {
        return matriculadosFundamental;
    }

    /**
    * Retorna o numero de docentes da escola associada a essa escola.
     *
     * @return Double representando o numero de Docentes.
    * */
    public Double getDocentesFundamental() {
        return docentesFundamental;
    }

    /**
     * Retorna o numero de turmas da escola associada a essa escola.
     *
     * @return Double representando o numero de Turmas.
     */
    public Double getTurmasFundamental() {
        return turmasFundamental;
    }
}
