package rw.lois.ne.binarysupermarket.utils;

import org.modelmapper.ModelMapper;
import rw.lois.ne.binarysupermarket.models.User;

public class Mapper {

    public static ModelMapper modelMapper = new ModelMapper();

    public static User getUserFromDTO(Object object) {
        return modelMapper.map(object, User.class);
    }


}
