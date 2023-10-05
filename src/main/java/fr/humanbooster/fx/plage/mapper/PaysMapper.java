package fr.humanbooster.fx.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.humanbooster.fx.plage.business.Pays;
import fr.humanbooster.fx.plage.dto.PaysDto;

@Mapper(componentModel = "spring")
public interface PaysMapper {

	PaysMapper INSTANCE = Mappers.getMapper(PaysMapper.class);

	/**
	 * Méthode qui convertit un métier en Dto
	 * 
	 * @param pays
	 * @return un objet Dto
	 */
	PaysDto toDto(Pays pays);

	/**
	 * Méthode qui convertit un Dto en métier
	 * 
	 * @param paysDto
	 * @return un objet métier
	 */
	Pays toEntity(PaysDto paysDto);

}