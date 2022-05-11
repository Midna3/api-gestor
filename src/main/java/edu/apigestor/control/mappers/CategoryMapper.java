package edu.apigestor.control.mappers;

/**
 * Essa é uma classe utilitária que permite mapear valores de diferentes indicadores em Strings que
 * representam sua respectiva categoria.
 *
 * @version 1.0
 */
public final class CategoryMapper {

  private CategoryMapper() {

  }

  /**
   * O indicador de formação docente pode ser classificado em 5 categorias, esse método retorna a
   * categoria para um dado valor.
   *
   * @param value valor do indicador de adequação da formação docente.
   * @return uma String que determina a categoria.
   */
  public static String getAFDCategory(double value) {
    if (value <= 1.0) {
      return "Docentes com formação superior de licenciatura na mesma disciplina que lecionam, "
          + "ou bacharelado na mesma disciplina com curso de complementação pedagógica concluída.";
    } else if (value <= 2.0) {
      return "Docentes com formação superior de bacharelado na disciplina correspondente, "
          + "mas sem licenciatura ou complementação pedagógica.";
    } else if (value <= 3.0) {
      return "Docentes com licenciatura em área diferente daquela que leciona, ou com bacharelado "
          + "nas disciplinas da base curricular comum e complementação pedagógica concluída em "
          + "área diferente daquela que leciona.";
    } else if (value <= 4.0) {
      return "Docentes com outra formação superior não considerada nas categorias anteriores.";
    } else {
      return "Docentes que não possuem curso superior completo.";
    }
  }

  /**
   * O indicador de esforço docente pode ser classificado em 6 categorias, esse método retorna a
   * categoria para um dado valor.
   *
   * @param value valor do indicador de esforço docente.
   * @return uma String que determina a categoria.
   */
  public static String getIEDCategory(double value) {
    if (value <= 1.0) {
      return "Docente que tem até 25 alunos e atua em um único turno, escola e etapa.";
    } else if (value <= 2.0) {
      return "Docente que tem entre 25 e 150 alunos e atua em um único turno, escola e etapa.";
    } else if (value <= 3.0) {
      return "Docente que tem entre 25 e 300 alunos e atua em um ou dois turnos em uma única "
          + "escola e etapa.";
    } else if (value <= 4.0) {
      return "Docentes que tem entre 50 e 400 alunos e atua em dois turnos, em uma ou duas escolas "
          + "e em duas etapas.";
    } else if (value <= 5.0) {
      return "Docente que tem mais de 300 alunos e atua nos três turnos, em duas ou três escolas e "
          + "em duas etapas ou três etapas.";
    } else {
      return " Docente que tem mais de 400 alunos e atua nos três turnos, em duas ou três escolas "
          + "e em duas etapas ou três etapas.";
    }
  }


  /**
   * O indicador de regularidade docente pode ser classificado em 4 categorias, esse método retorna
   * a categoria para um dado valor.
   *
   * @param value valor do indicador de regularidade docente no intervalo [1.5, 4.5].
   * @return uma String que determina a categoria.
   */
  public static String getIRDCategory(double value) {
    if (value <= 2.0) {
      return "Baixa regularidade";
    } else if (value <= 3.0) {
      return "Média-baixa";
    } else if (value <= 4.0) {
      return "Média-alta";
    } else {
      return "Alta";
    }
  }

  /**
   * O indicador de complexidade de gestão pode ser classificado em 6 categorias, esse método
   * retorna a categoria para um dado valor.
   *
   * @param value valor do indicador de complexidade de gestão em [1.0, 6.0].
   * @return uma String que determina a categoria.
   */
  public static String getICGCategory(double value) {
    if (value < 2.0) {
      return "Porte inferior a 50 matrículas, operando em único turno e etapa e apresentando a "
          + "Educação Infantil ou Anos Iniciais como etapa mais elevada.";
    } else if (value < 3.0) {
      return "Porte entre 50 e 300 matrículas, operando em 2 turnos, com oferta de até 2 etapas e "
          + "apresentando a Educação Infantil ou Anos Iniciais como etapa mais elevada.";
    } else if (value < 4.0) {
      return "Porte entre 50 e 500 matrículas, operando em 2 turnos, com 2 ou 3 etapas e "
          + "apresentando os Anos Finais como etapa mais elevada.";
    } else if (value < 5.0) {
      return "Porte entre 150 e 1000 matrículas, operando em 2 ou 3 turnos, com 2 ou 3 etapas, "
          + "apresentando Ensino Médio/profissional ou a EJA como etapa mais elevada.";
    } else if (value < 6.0) {
      return "Porte entre 150 e 1000 matrículas, operando em 3 turnos, com 2 ou 3 etapas, "
          + "apresentando a EJA como etapa mais elevada.";
    } else {
      return "Porte superior à 500 matrículas, operando em 3 turnos, com 4 ou mais etapas, "
          + "apresentando a EJA como etapa mais elevada.";
    }
  }
}
