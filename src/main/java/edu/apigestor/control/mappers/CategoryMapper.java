package edu.apigestor.control.mappers;

public final class CategoryMapper {

  private CategoryMapper() {

  }

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

}
