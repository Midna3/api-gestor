package edu.apigestor.entity.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * A classe {@link AFD} representa a tabela <b>afd</b> no Banco de Dados, contendo diferentes
 * informações sobre o Indicador de Adequação da Formação Docente. Essa classe funcionado como uma
 * entidade do JPA (Java Persistence API) e pode ser utilizada pelos repositórios para fazer leitura
 * no Bando de Dados, instâncias representam o indicador para o EF.
 *
 * @author moesiof
 * @version 1.0
 */
@Entity
@IdClass(AFD.AFDKey.class)
@Table(name = "afd")
public class AFD {

  @Id
  @Column(name = "codEscola")
  private int codINEP;
  @Id
  @Column(name = "codEstado")
  private int codEstado;
  @Id
  @Column(name = "codPais")
  private int codPais; // Não precisamos de get/set, apenas serve para chave primária.
  @Id
  @Column(name = "codMunicipio")
  private int codMunicipio;
  @Id
  @Column(name = "codRegiao")
  private int codRegiao;
  @Id
  @Column(name = "ano")
  private int ano;
  @Id
  @Column(name = "dependencia")
  private String dependencia; // Não precisamos de get/set, apenas serve para chave primária.
  @Id
  @Column(name = "localizacao")
  private String localizacao; // Não precisamos de get/set, apenas serve para chave primária.
  @Column(name = "tipo")
  private Integer tipo;
  @Column(name = "AFDFundamentalTotalG1")
  private Double percentageG1;
  @Column(name = "AFDFundamentalTotalG2")
  private Double percentageG2;
  @Column(name = "AFDFundamentalTotalG3")
  private Double percentageG3;
  @Column(name = "AFDFundamentalTotalG4")
  private Double percentageG4;
  @Column(name = "AFDFundamentalTotalG5")
  private Double percentageG5;

  public AFD(int codINEP, int codEstado, int codPais, int codMunicipio, int codRegiao, int ano,
      String dependencia, String localizacao, Integer tipo, Double percentageG1,
      Double percentageG2,
      Double percentageG3, Double percentageG4, Double percentageG5) {
    this.codINEP = codINEP;
    this.codEstado = codEstado;
    this.codPais = codPais;
    this.codMunicipio = codMunicipio;
    this.codRegiao = codRegiao;
    this.ano = ano;
    this.dependencia = dependencia;
    this.localizacao = localizacao;
    this.tipo = tipo;
    this.percentageG1 = percentageG1;
    this.percentageG2 = percentageG2;
    this.percentageG3 = percentageG3;
    this.percentageG4 = percentageG4;
    this.percentageG5 = percentageG5;
  }

  public AFD() {

  }

  /**
   * Retorna o código INEP da escola associada (se possuir, 0 caso contrário) com esse AFD.
   *
   * @return int representando o código INEP.
   */
  public int codINEP() {
    return this.codINEP;
  }

  /**
   * Retorna o código do estado associado com esse AFD.
   *
   * @return int representando o estado.
   */
  public int codEstado() {
    return this.codEstado;
  }

  /**
   * Retorna o código do município associada com esse AFD.
   *
   * @return int representando o estado.
   */
  public int codMunicipio() {
    return this.codMunicipio;
  }

  /**
   * Retorna o código da região associada com esse AFD.
   *
   * @return int representando o estado.
   */
  public int codRegiao() {
    return this.codRegiao;
  }

  /**
   * Retorna o tipo dessa entidade (o tipo identifica se essa entidade se refere ao nível nacional,
   * regional, estadual ou escolar).
   *
   * @return inteiro que representa o tipo.
   */
  public Integer tipo() {
    return this.tipo;
  }

  /**
   * Retorna o ano dessa entidade.
   *
   * @return inteiro que representa o ano (e.g., 2019).
   */
  public int ano() {
    return this.ano;
  }

  /**
   * Retorna a porcentagem de professores que se encaixam na categoria 1.
   *
   * @return double representando essa porcentagem.
   */
  public Double percentageG1() {
    return this.percentageG1;
  }

  /**
   * Retorna a porcentagem de professores que se encaixam na categoria 2.
   *
   * @return double representando essa porcentagem.
   */
  public Double percentageG2() {
    return this.percentageG2;
  }

  /**
   * Retorna a porcentagem de professores que se encaixam na categoria 3.
   *
   * @return double representando essa porcentagem.
   */
  public Double percentageG3() {
    return this.percentageG3;
  }

  /**
   * Retorna a porcentagem de professores que se encaixam na categoria 4.
   *
   * @return double representando essa porcentagem.
   */
  public Double percentageG4() {
    return this.percentageG4;
  }

  /**
   * Retorna a porcentagem de professores que se encaixam na categoria 5.
   *
   * @return double representando essa porcentagem.
   */
  public Double percentageG5() {
    return this.percentageG5;
  }

  public static class AFDKey implements Serializable {

    private int codINEP;
    private int codEstado;
    private int codPais;
    private int codRegiao;
    private int codMunicipio;
    private String dependencia;
    private String localizacao;
    private int ano;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      AFDKey key = (AFDKey) o;
      return (this.codINEP == key.codINEP) &&
          (this.codEstado == key.codEstado) &&
          (this.codPais == key.codPais) &&
          (this.codRegiao == key.codRegiao) &&
          (this.codMunicipio == key.codMunicipio) &&
          this.dependencia.equals(key.dependencia) &&
          this.localizacao.equals(key.localizacao) &&
          (this.ano == key.ano);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.codINEP, this.codEstado, this.codPais, this.codRegiao,
          this.codMunicipio, this.dependencia, this.localizacao, this.ano);
    }
  }
}
