package edu.apigestor.entity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "afd")
public class AFD {

  @Id
  @Column(name = "codEscola")
  private long codINEP;

  @Column(name = "tipo")
  private int tipo;

  @Column(name = "AFDFundamentalTotalG1")
  private double percentageG1;

  @Column(name = "AFDFundamentalTotalG2")
  private double percentageG2;

  @Column(name = "AFDFundamentalTotalG3")
  private double percentageG3;

  @Column(name = "AFDFundamentalTotalG4")
  private double percentageG4;

  @Column(name = "AFDFundamentalTotalG5")
  private double percentageG5;

  /**
   * Retorna o código INEP da escola associada com esse AFD (0 caso não seja aplicável para uma
   * escola).
   *
   * @return long representando o código INEP.
   * */
  public long codINEP() {
    return this.codINEP;
  }

  /**
   * Retorna o tipo.
   *
   * @return inteiro que representa o tipo.
   * */
  public int tipo() {
    return this.tipo;
  }

  /**
   * Retorna a porcentagem de professores que se encaixam na categoria 1.
   *
   * @return double representando essa porcentagem.
   * */
  public double percentageG1() {
    return this.percentageG1;
  }

  /**
   * Retorna a porcentagem de professores que se encaixam na categoria 1.
   *
   * @return double representando essa porcentagem.
   * */
  public double percentageG2() {
    return this.percentageG2;
  }

  /**
   * Retorna a porcentagem de professores que se encaixam na categoria 1.
   *
   * @return double representando essa porcentagem.
   * */
  public double percentageG3() {
    return this.percentageG3;
  }

  /**
   * Retorna a porcentagem de professores que se encaixam na categoria 1.
   *
   * @return double representando essa porcentagem.
   * */
  public double percentageG4() {
    return this.percentageG4;
  }

  /**
   * Retorna a porcentagem de professores que se encaixam na categoria 1.
   *
   * @return double representando essa porcentagem.
   * */
  public double percentageG5() {
    return this.percentageG5;
  }
}
