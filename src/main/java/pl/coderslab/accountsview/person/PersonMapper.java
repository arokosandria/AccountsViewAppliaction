package pl.coderslab.accountsview.person;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    List<PersonDto> toDto(List<Person>personList);


    Person DtoTo(PersonDto person);
    PersonDto toDto(Person person);



}
