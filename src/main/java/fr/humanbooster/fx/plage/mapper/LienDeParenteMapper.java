package fr.humanbooster.fx.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.humanbooster.fx.plage.business.LienDeParente;
import fr.humanbooster.fx.plage.dto.LienDeParenteDto;

@Mapper(componentModel = "spring")
public interface LienDeParenteMapper {

	LienDeParenteMapper INSTANCE = Mappers.getMapper(LienDeParenteMapper.class);

	LienDeParenteDto toDto(LienDeParente lienDeParente);

	LienDeParente toEntity(LienDeParenteDto lienDeParenteDto);

}