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

  public Censo(int ano, int codINEP, int codEstado, int codMunicipio, int codRegiao,
      String dependencia, String nomeRegiao, String nomeEstado, String nomeMunicipio,
      String nomeBairro, String nomeEscola, String endereco, String numero, String complemento,
      int cep, Double DDD, Double telefone, Double existeFundamental,
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
    switch (this.nomeEstado) {
      case "Acre":
        return "AC";
      case "Alagoas":
        return "AL";
      case "Amapá":
        return "AP";
      case "Amazonas":
        return "AM";
      case "Bahia":
        return "BA";
      case "Ceará":
        return "CE";
      case "Distrito Federal":
        return "DF";
      case "Espírito Santo":
        return "ES";
      case "Goiás":
        return "GO";
      case "Maranhão":
        return "MA";
      case "Mato Grosso":
        return "MT";
      case "Mato Grosso do Sul":
        return "MS";
      case "Minas Gerais":
        return "MG";
      case "Pará":
        return "PA";
      case "Paraíba":
        return "PB";
      case "Paraná":
        return "PR";
      case "Pernambuco":
        return "PE";
      case "Piauí":
        return "PI";
      case "Rio de Janeiro":
        return "RJ";
      case "Rio Grande do Norte":
        return "RN";
      case "Rio Grande do Sul":
        return "RS";
      case "Rondônia":
        return "RO";
      case "Roraima":
        return "RR";
      case "Santa Catarina":
        return "SC";
      case "São Paulo":
        return "SP";
      case "Sergipe":
        return "SE";
      case "Tocantins":
        return "TO";
      default:
        return null;
    }

  }



  public static class CensoKey implements Serializable {

    private int codINEP;
    private int codEstado;
    private int codRegiao;
    private int codMunicipio;
    private String dependencia;
    private int ano;

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
