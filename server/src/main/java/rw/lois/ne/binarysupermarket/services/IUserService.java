package rw.lois.ne.binarysupermarket.services;

import rw.lois.ne.binarysupermarket.models.User;


public interface IUserService {

    User create(User user);

    boolean isNotUnique(User user);

    void validateNewRegistration(User user);

    User getLoggedInUser();

}