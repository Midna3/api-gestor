package edu.apigestor.control.mappers;

import edu.apigestor.entity.domain.Censo;
import edu.apigestor.control.mappers.StateMapper;


public final class AddressMapper {
    private AddressMapper() {
    }

    /**
     * Dado uma classe Censo, retorna uma String informando o endereço completo da escola.
     * Esse formato é dado por endereco,numero - bairro,municipio - Sigla, cep
     */
    public static String getAddress(Censo censo) {
        StringBuilder sb = new StringBuilder();
        sb.append(censo.getEndereco()).append(", ").append(censo.getNumero()).append(" - ");
        sb.append(censo.getNomeBairro()).append(", ").append(censo.getNomeMunicipio()).append(" - ");
        sb.append(censo.getSigla()).append(" - ").append(Math.round(censo.getCep()));
        return sb.toString();
    }
}
