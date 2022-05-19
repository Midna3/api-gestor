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
 * informações sobre o Censo Escolar. Essa classe funcionado como uma entidade do JPA (Java
 * Persistence API) e pode ser utilizada pelos repositórios para fazer leitura no Bando de Dados,
 * instâncias representam o indicador para o EF.
 *
 * @author ArthurFS
 * @version 1.0
 */
@Entity
@IdClass(Censo.CensoKey.class)
@Table(name = "censo")
public class Censo {

  @Id
  @Column(name = "ano")
  private long ano;
  @Id
  @Column(name = "codEscola")
  private long codINEP;
  @Id
  @Column(name = "codEstado")
  private long codEstado;
  @Id
  @Column(name = "codMunicipio")
  private long codMunicipio;
  @Id
  @Column(name = "codRegiao")
  private long codRegiao;
  @Id
  @Column(name = "dependencia")
  private String dependencia;

  @Column(name = "nomeRegiao")
  private String nomeRegiao;
  @Column(name = "nomeUF")
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
  private Double cep;
  @Column(name = "DDD")
  private String DDD;
  @Column(name = "telefone")
  private String telefone;
  @Column(name = "existeFundamental")
  private Double existeFundamental;
  @Column(name = "matriculadosFundamental")
  private Double matriculadosFundamental;
  @Column(name = "docentesFundamental")
  private Double docentesFundamental;
  @Column(name = "turmasFundamental")
  private Double turmasFundamental;

  public Censo(long ano, long codINEP, long codEstado, long codMunicipio, long codRegiao,
      String dependencia, String nomeRegiao, String nomeEstado, String nomeMunicipio,
      String nomeBairro, String nomeEscola, String endereco, String numero, String complemento,
      double cep, String DDD, String telefone, Double existeFundamental,
      Double matriculadosFundamental,
      Double docentesFundamental, Double turmasFundamental) {
    this.ano = ano;
    this.codINEP = codINEP;
    this.codEstado = codEstado;
    this.codMunicipio = codMunicipio;
    this.codRegiao = codRegiao;
    this.dependencia = dependencia;
    this.nomeRegiao = nomeRegiao;
    this.nomeEstado = nomeEstado;
    this.nomeMunicipio = nomeMunicipio;
    this.nomeBairro = nomeBairro;
    this.nomeEscola = nomeEscola;
    this.endereco = endereco;
    this.numero = numero;
    this.complemento = complemento;
    this.cep = cep;
    this.DDD = DDD;
    this.telefone = telefone;
    this.existeFundamental = existeFundamental;
    this.matriculadosFundamental = matriculadosFundamental;
    this.docentesFundamental = docentesFundamental;
    this.turmasFundamental = turmasFundamental;
  }

  public Censo() {

  }

  /**
   * Retorna o ano dessa entidade.
   *
   * @return inteiro que representa o ano (e.g., 2019).
   */
  public long getAno() {
    return ano;
  }

  /**
   * Retorna o código INEP da escola associada (se possuir, 0 caso contrário) com essa escola.
   *
   * @return int representando o código INEP.
   */
  public long getCodINEP() {
    return codINEP;
  }

  /**
   * Retorna o código do estado associado a essa escola.
   *
   * @return int representando o estado.
   */
  public long getCodEstado() {
    return codEstado;
  }

  /**
   * Retorna o código do município associada a essa escola.
   *
   * @return int representando o estado.
   */
  public long getCodMunicipio() {
    return codMunicipio;
  }

  /**
   * Retorna o código da região associada a essa escola.
   *
   * @return int representando o estado.
   */
  public long getCodRegiao() {
    return codRegiao;
  }

  /**
   * Retorna o nome da região associada a essa escola.
   *
   * @return String representando a Região.
   */
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
  public double getCep() {
    return cep;
  }

  /**
   * Retorna o DDD do telefone da escola associada a essa escola.
   *
   * @return Double representando o Telefone.
   */
  public String getDDD() {
    return DDD;
  }

  /**
   * Retorna o telefone da escola associada a essa escola.
   *
   * @return Double representando o Telefone.
   */
  public String getTelefone() {
    return telefone;
  }

  /**
   * Verifica a dependencia administrativa da escola.
   *
   * @return String representando a dependencia administrativa.
   * */
  public String getDependencia() {
    return dependencia;
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
   */
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

  /**
   * Pega a sigla do Estado.
   *
   * @return String representando a Sigla do Estado.
   */
  public String getSigla() {
    return switch (this.nomeEstado) {
      case "Acre" -> "AC";
      case "Alagoas" -> "AL";
      case "Amapá" -> "AP";
      case "Amazonas" -> "AM";
      case "Bahia" -> "BA";
      case "Ceará" -> "CE";
      case "Distrito Federal" -> "DF";
      case "Espírito Santo" -> "ES";
      case "Goiás" -> "GO";
      case "Maranhão" -> "MA";
      case "Mato Grosso" -> "MT";
      case "Mato Grosso do Sul" -> "MS";
      case "Minas Gerais" -> "MG";
      case "Pará" -> "PA";
      case "Paraíba" -> "PB";
      case "Paraná" -> "PR";
      case "Pernambuco" -> "PE";
      case "Piauí" -> "PI";
      case "Rio de Janeiro" -> "RJ";
      case "Rio Grande do Norte" -> "RN";
      case "Rio Grande do Sul" -> "RS";
      case "Rondônia" -> "RO";
      case "Roraima" -> "RR";
      case "Santa Catarina" -> "SC";
      case "São Paulo" -> "SP";
      case "Sergipe" -> "SE";
      case "Tocantins" -> "TO";
      default -> null;
    };

  }



  public static class CensoKey implements Serializable {

    private long codINEP;
    private long codEstado;
    private long codRegiao;
    private long codMunicipio;
    private String dependencia;
    private long ano;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Censo.CensoKey key = (Censo.CensoKey) o;
      return (this.codINEP == key.codINEP) &&
          (this.codEstado == key.codEstado) &&
          (this.codRegiao == key.codRegiao) &&
          (this.codMunicipio == key.codMunicipio) &&
          this.dependencia.equals(key.dependencia) &&
          (this.ano == key.ano);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.codINEP, this.codEstado, this.codRegiao,
          this.codMunicipio, this.dependencia, this.ano);
    }
  }
}
