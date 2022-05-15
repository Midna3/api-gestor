package edu.apigestor.entity.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * A classe {@link IDEB} representa a tabela <b>ideb</b> no Banco de Dados, contendo diferentes
 * informações sobre o Índice de Desenvolvimento da Educação Básica. Essa classe funcionado como uma
 * entidade do JPA (Java Persistence API) e pode ser utilizada pelos repositórios para fazer leitura
 * no Bando de Dados, instâncias representam o indicador para o EF.
 *
 * @author ArthurFS
 * @version 1.0
 */
@Entity
@IdClass(IDEB.IDEBKey.class)
@Table(name = "ideb")
public class IDEB {

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
  @Column(name = "rede")
  private String dependencia;
  @Column(name = "tipo")
  private int tipo;
  @Column(name = "anosIniciais")
  private Double anosIniciais;
  @Column(name = "anosFinais")
  private Double anosFinais;
  @Column(name = "projecaoAI")
  private Double projecaoAI;
  @Column(name = "projecaoAF")
  private Double projecaoAF;

  public IDEB(int ano, int codINEP, int codEstado, int codMunicipio, int codPais, int codRegiao,
      String dependencia, int tipo, double anosIniciais, double anosFinais, double projecaoAI,
      double projecaoAF) {
    this.ano = ano;
    this.codINEP = codINEP;
    this.codEstado = codEstado;
    this.codMunicipio = codMunicipio;
    this.codPais = codPais;
    this.codRegiao = codRegiao;
    this.dependencia = dependencia;
    this.tipo = tipo;
    this.anosIniciais = anosIniciais;
    this.anosFinais = anosFinais;
    this.projecaoAI = projecaoAI;
    this.projecaoAF = projecaoAF;
  }

  public IDEB() {

  }

  /**
   * Retorna o ano dessa entidade.
   *
   * @return inteiro que representa o ano (e.g., 2019).
   */
  public int getAno() {
    return this.ano;
  }

  /**
   * Retorna o código INEP da escola associada (se possuir, 0 caso contrário) com esse IDEB.
   *
   * @return int representando o código INEP.
   */
  public int getCodINEP() {
    return codINEP;
  }

  /**
   * Retorna o código do estado associado com esse IDEB.
   *
   * @return int representando o estado.
   */
  public int getCodEstado() {
    return codEstado;
  }

  /**
   * Retorna o código da região associada com esse IDEB.
   *
   * @return int representando o estado.
   */
  public int getCodRegiao() {
    return codRegiao;
  }

  /**
   * Retorna o código do município associada com esse IDEB.
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
   * Retorna a nota do IDEB nos anos Iniciais dessa entidade.
   *
   * @return double que representa a nota.
   */
  public Double getAnosIniciais() {
    return anosIniciais;
  }

  /**
   * Retorna a nota do IDEB nos anos Finais dessa entidade.
   *
   * @return double que representa a nota.
   */
  public Double getAnosFinais() {
    return anosFinais;
  }

  /**
   * Retorna a projeção do IDEB nos anos Iniciais dessa entidade.
   *
   * @return double que representa a projeção.
   */
  public Double getProjecaoAI() {
    return projecaoAI;
  }

  /**
   * Retorna a projeção do IDEB nos anos Finais dessa entidade.
   *
   * @return double que representa a projeção.
   */
  public Double getProjecaoAF() {
    return projecaoAF;
  }


  public static class IDEBKey implements Serializable {

    private int ano;
    private int codINEP;
    private int codEstado;
    private int codPais;
    private int codRegiao;
    private int codMunicipio;
    private String dependencia;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      IDEB.IDEBKey key = (IDEB.IDEBKey) o;
      return (this.ano == key.ano) &&
          (this.codINEP == key.codINEP) &&
          (this.codEstado == key.codEstado) &&
          (this.codPais == key.codPais) &&
          (this.codRegiao == key.codRegiao) &&
          (this.codMunicipio == key.codMunicipio) &&
          this.dependencia.equals(key.dependencia);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.ano, this.codINEP, this.codEstado, this.codPais, this.codRegiao,
          this.codMunicipio, this.dependencia);
    }
  }

}
