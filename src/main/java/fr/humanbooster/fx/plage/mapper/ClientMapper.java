package fr.humanbooster.fx.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import fr.humanbooster.fx.plage.business.Client;
import fr.humanbooster.fx.plage.dto.ClientDto;

@Mapper(componentModel = "spring", uses = { PaysMapper.class, LienDeParenteMapper.class })
public interface ClientMapper {

	ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

	@Mapping(source = "paysDto", target = "pays")
	@Mapping(source = "lienDeParenteDto", target = "lienDeParente")
	Client toEntity(ClientDto clientDto);

	@Mapping(source = "pays", target = "paysDto")
	@Mapping(source = "lienDeParente", target = "lienDeParenteDto")
	ClientDto toDto(Client client);

}