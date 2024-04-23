package rosol.roleservice.dto.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rosol.roleservice.dto.RoleDto;
import rosol.roleservice.model.AppRole;

/**
 * Data Transfer Object converter class to convert an AppRole object to a RoleDto instance when needed. These type of
 * classes are used to perform conversion between objects exchanged between Client and Server sides
 */
@Component
@RequiredArgsConstructor
public class RoleDTOConverter {

    private final ModelMapper modelMapper;

    public RoleDto convertToDto(AppRole role){
        return modelMapper.map(role, RoleDto.class);
    }
}
