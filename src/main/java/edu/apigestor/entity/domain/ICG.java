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
  @Column(name = "tipo")
  private int tipo;
  @Id
  @Column(name = "dependencia")
  private String dependencia; // Não precisamos de get/set, apenas serve para chave primária.
  @Id
  @Column(name = "localizacao")
  private String localizacao; // Não precisamos de get/set, apenas serve para chave primária.
  @Column(name = "ICGNivelMedio")
  private double valorMedio;

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
  public int tipo() {
    return this.tipo;
  }

  /**
   * Retorna o valor médio de ICG.
   *
   * @return double representando esse valor.
   */
  public double valorMedio(){
    return this.valorMedio;
  }   

  public static class ICGKey implements Serializable {

    private int codINEP;
    private int codEstado;
    private int codPais;
    private int codRegiao;
    private int codMunicipio;
    private String dependencia;
    private String localizacao;
    private int tipo;
    
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      ICGKey key = (ICGKey) o;
      return (this.codINEP == key.codINEP) &&
          (this.codEstado == key.codEstado) &&
          (this.codPais == key.codPais) &&
          (this.codRegiao == key.codRegiao) &&
          (this.codMunicipio == key.codMunicipio) &&
          this.dependencia.equals(key.dependencia) &&
          this.localizacao.equals(key.localizacao) &&
          (this.tipo == key.tipo);
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(this.codINEP, this.codEstado, this.codPais, this.codRegiao,
          this.codMunicipio, this.dependencia, this.localizacao, this.tipo);
    }
  }
}