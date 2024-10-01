package com.example.demoapp.business.mapper;

import com.example.demoapp.domain.dtos.DomicilioDto;
import com.example.demoapp.domain.dtos.PersonaFullDto;
import com.example.demoapp.domain.dtos.PersonaShortDto;
import com.example.demoapp.domain.entities.Domicilio;
import com.example.demoapp.domain.entities.Persona;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-01T17:57:04-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public PersonaFullDto personaToPersonaFullDto(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaFullDto personaFullDto = new PersonaFullDto();

        personaFullDto.setId( persona.getId() );
        personaFullDto.setNombre( persona.getNombre() );
        personaFullDto.setApellido( persona.getApellido() );
        personaFullDto.setEdad( persona.getEdad() );
        personaFullDto.setFechaNacimiento( persona.getFechaNacimiento() );
        personaFullDto.setDomicilio( domicilioToDomicilioDto( persona.getDomicilio() ) );

        return personaFullDto;
    }

    @Override
    public Persona personaFullDtoToPersona(PersonaFullDto personaFullDto) {
        if ( personaFullDto == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setId( personaFullDto.getId() );
        persona.setDomicilio( domicilioDtoToDomicilio( personaFullDto.getDomicilio() ) );
        persona.setNombre( personaFullDto.getNombre() );
        persona.setApellido( personaFullDto.getApellido() );
        persona.setEdad( personaFullDto.getEdad() );
        persona.setFechaNacimiento( personaFullDto.getFechaNacimiento() );

        return persona;
    }

    @Override
    public PersonaShortDto personaToPersonaShortDto(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaShortDto personaShortDto = new PersonaShortDto();

        personaShortDto.setProvincia( personaDomicilioProvincia( persona ) );
        personaShortDto.setNombre( persona.getNombre() );
        personaShortDto.setApellido( persona.getApellido() );

        return personaShortDto;
    }

    protected DomicilioDto domicilioToDomicilioDto(Domicilio domicilio) {
        if ( domicilio == null ) {
            return null;
        }

        DomicilioDto domicilioDto = new DomicilioDto();

        domicilioDto.setId( domicilio.getId() );
        domicilioDto.setCalle( domicilio.getCalle() );
        domicilioDto.setNumero( domicilio.getNumero() );
        domicilioDto.setProvincia( domicilio.getProvincia() );

        return domicilioDto;
    }

    protected Domicilio domicilioDtoToDomicilio(DomicilioDto domicilioDto) {
        if ( domicilioDto == null ) {
            return null;
        }

        Domicilio domicilio = new Domicilio();

        domicilio.setId( domicilioDto.getId() );
        domicilio.setCalle( domicilioDto.getCalle() );
        domicilio.setNumero( domicilioDto.getNumero() );
        domicilio.setProvincia( domicilioDto.getProvincia() );

        return domicilio;
    }

    private String personaDomicilioProvincia(Persona persona) {
        if ( persona == null ) {
            return null;
        }
        Domicilio domicilio = persona.getDomicilio();
        if ( domicilio == null ) {
            return null;
        }
        String provincia = domicilio.getProvincia();
        if ( provincia == null ) {
            return null;
        }
        return provincia;
    }
}
