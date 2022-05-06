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
    @Column(name = "ICGNivel1")
    private double percentageN1;
    @Column(name = "ICGNivel2")
    private double percentageN2;
    @Column(name = "ICGNivel3")
    private double percentageN3;
    @Column(name = "ICGNivel4")
    private double percentageN4;
    @Column(name = "ICGNivel5")
    private double percentageN5;
    @Column(name = "ICGNivel6")
    private double percentageN6;

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
    public int tipo() {
        return this.tipo;
    }

    /**
     * Retorna a porcentagem de escolas que se encaixam no nível 1.
     *
     * @return double representando essa porcentagem.
     */
    public double percentageN1(){
        return this.percentageN1;
    }

    /**
     * Retorna a porcentagem de escolas que se encaixam no nível 2.
     *
     * @return double representando essa porcentagem.
     */
    public double percentageN2(){
        return this.percentageN2;
    }

    /**
     * Retorna a porcentagem de escolas que se encaixam no nível 3.
     *
     * @return double representando essa porcentagem.
     */
    public double percentageN3(){
        return this.percentageN3;
    }

    /**
     * Retorna a porcentagem de escolas que se encaixam no nível 4.
     *
     * @return double representando essa porcentagem.
     */
    public double percentageN4(){
        return this.percentageN4;
    }

    /**
     * Retorna a porcentagem de escolas que se encaixam no nível 5.
     *
     * @return double representando essa porcentagem.
     */
    public double percentageN5(){
        return this.percentageN5;
    }
    
    /**
     * Retorna a porcentagem de escolas que se encaixam no nível 6.
     *
     * @return double representando essa porcentagem.
     */
    public double percentageN6(){
        return this.percentageN6;
    }

    public static class AFDKey implements Serializable {

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
          AFDKey key = (AFDKey) o;
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