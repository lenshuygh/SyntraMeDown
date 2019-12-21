package handmedown.repository.helpers;

import handmedown.model.User;

public class UserHelper {
    public static final User createSimpleUser(){
        return new User("Lens","Huygh",null);
    }
}
