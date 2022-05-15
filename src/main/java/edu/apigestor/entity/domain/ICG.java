package edu.apigestor.entity.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * A classe {@link ICG} representa a tabela <b>icg</b> no Banco de Dados, contendo diferentes
 * informações sobre o Indicador de Complexidade de Gestão Escolar. Essa classe funcionado como uma
 * entidade do JPA (Java Persistence API) e pode ser utilizada pelos repositórios para fazer leitura
 * no Bando de Dados, instâncias representam o indicador para o EF.
 *
 * @author João Pedro Freire
 * @version 1.0
 */
@Entity
@IdClass(ICG.ICGKey.class)
@Table(name = "icg")
public class ICG {

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
  @Column(name = "codPais")
  private int codPais; // Não precisamos de get/set, apenas serve para chave primária.
  @Id
  @Column(name = "codMunicipio")
  private int codMunicipio;
  @Id
  @Column(name = "codRegiao")
  private int codRegiao;
  @Id
  @Column(name = "dependencia")
  private String dependencia; // Não precisamos de get/set, apenas serve para chave primária.
  @Id
  @Column(name = "localizacao")
  private String localizacao; // Não precisamos de get/set, apenas serve para chave primária.
  @Column(name = "ICGNivelMedio")
  private Double valorMedio;
  @Column(name = "tipo")
  private Integer tipo;

  public ICG(int ano, int codINEP, int codEstado, int codPais, int codMunicipio, int codRegiao,
      String dependencia, String localizacao, Double valorMedio, Integer tipo) {
    this.ano = ano;
    this.codINEP = codINEP;
    this.codEstado = codEstado;
    this.codPais = codPais;
    this.codMunicipio = codMunicipio;
    this.codRegiao = codRegiao;
    this.dependencia = dependencia;
    this.localizacao = localizacao;
    this.valorMedio = valorMedio;
    this.tipo = tipo;
  }

  public ICG() {

  }

  /**
   * Retorna o código INEP da escola associada (se possuir, 0 caso contrário) com esse ICG.
   *
   * @return int representando o código INEP.
   */
  public int codINEP() {
    return this.codINEP;
  }

  /**
   * Retorna o código do estado associado com esse ICG.
   *
   * @return int representando o estado.
   */
  public int codEstado() {
    return this.codEstado;
  }

  /**
   * Retorna o código do município associada com esse ICG.
   *
   * @return int representando o estado.
   */
  public int codMunicipio() {
    return this.codMunicipio;
  }

  /**
   * Retorna o código da região associada com esse ICG.
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
   * Retorna o valor médio de ICG.
   *
   * @return double representando esse valor.
   */
  public Double valorMedio() {
    return this.valorMedio;
  }

  public static class ICGKey implements Serializable {

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
      ICGKey key = (ICGKey) o;
      return (this.ano == key.ano) &&
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
