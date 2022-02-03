package br.com.clinica.app.adapters.presentation.mapper;

import br.com.clinica.app.adapters.database.entities.EnderecoData;
import br.com.clinica.app.adapters.database.entities.MedicoData;
import br.com.clinica.app.adapters.presentation.request.MedicoRequest;
import br.com.clinica.app.adapters.presentation.response.EnderecoResponse;
import br.com.clinica.app.adapters.presentation.response.MedicoResponse;
import br.com.clinica.app.domain.entities.Endereco;
import br.com.clinica.app.domain.entities.Medico;
import java.util.ArrayList;
import java.util.List;

public final class MedicoMapper {

    public static MedicoResponse map(MedicoData medicoData){
        return MedicoResponse.builder()
                .id(medicoData.getId())
                .nome(medicoData.getNome())
                .cpf(medicoData.getCpf())
                .rg(medicoData.getRg())
                .crm(medicoData.getRg())
                .endereco(EnderecoResponse.builder()
                        .rua(medicoData.getEndereco().getRua())
                        .bairro(medicoData.getEndereco().getBairro())
                        .cidade(medicoData.getEndereco().getCidade())
                        .complemento(medicoData.getEndereco().getComplemento())
                        .uf(medicoData.getEndereco().getUf())
                        .build())
                .build();
    }

    public static List<MedicoResponse> map(List<MedicoData> medicos){
        List<MedicoResponse> medicoResponses = new ArrayList<>();
        for(MedicoData m : medicos) {
            medicoResponses.add(MedicoResponse.builder()
                    .nome(m.getNome())
                    .cpf(m.getCpf())
                    .rg(m.getRg())
                    .crm(m.getRg())
                    .endereco(EnderecoResponse.builder()
                            .rua(m.getEndereco().getRua())
                            .bairro(m.getEndereco().getBairro())
                            .cidade(m.getEndereco().getCidade())
                            .complemento(m.getEndereco().getComplemento())
                            .uf(m.getEndereco().getUf())
                            .build())
                    .build());
        }
        return medicoResponses;
    }

    public static MedicoData map(MedicoRequest medicoRequest, Long id){
        return MedicoData.builder()
                .id(id)
                .nome(medicoRequest.getCpf())
                .cpf(medicoRequest.getCpf())
                .crm(medicoRequest.getCrm())
                .rg(medicoRequest.getRg())
                .endereco(EnderecoData.builder()
                        .rua(medicoRequest.getEndereco().getRua())
                        .bairro(medicoRequest.getEndereco().getBairro())
                        .cidade(medicoRequest.getEndereco().getCidade())
                        .complemento(medicoRequest.getEndereco().getComplemento())
                         .uf(medicoRequest.getEndereco().getUf())
                                      .build())
              .build();
          }

    public static Medico map(MedicoRequest medicoRequest){
        return Medico.builder()
                .nome(medicoRequest.getCpf())
                .cpf(medicoRequest.getCpf())
                .crm(medicoRequest.getCrm())
                .rg(medicoRequest.getRg())
                .endereco(Endereco.builder()
                        .rua(medicoRequest.getEndereco().getRua())
                        .bairro(medicoRequest.getEndereco().getBairro())
                        .cidade(medicoRequest.getEndereco().getCidade())
                        .complemento(medicoRequest.getEndereco().getComplemento())
                        .uf(medicoRequest.getEndereco().getUf())
                        .build())
                .build();
    }

    public static Medico from(MedicoRequest medicoRequest, Long id){
        return Medico.builder()
                .codigo(id)
                .nome(medicoRequest.getCpf())
                .cpf(medicoRequest.getCpf())
                .crm(medicoRequest.getCrm())
                .rg(medicoRequest.getRg())
                .endereco(Endereco.builder()
                        .rua(medicoRequest.getEndereco().getRua())
                        .bairro(medicoRequest.getEndereco().getBairro())
                        .cidade(medicoRequest.getEndereco().getCidade())
                        .complemento(medicoRequest.getEndereco().getComplemento())
                        .uf(medicoRequest.getEndereco().getUf())
                        .build())
                .build();
    }



    public static MedicoData map(Medico medico){
        return MedicoData.builder()
                .nome(medico.getCpf())
                .cpf(medico.getCpf())
                .crm(medico.getCrm())
                .rg(medico.getRg())
                .endereco(EnderecoData.builder()
                        .rua(medico.getEndereco().getRua())
                        .bairro(medico.getEndereco().getBairro())
                        .cidade(medico.getEndereco().getCidade())
                        .complemento(medico.getEndereco().getComplemento())
                        .uf(medico.getEndereco().getUf())
                        .build())
                .build();
    }

}
