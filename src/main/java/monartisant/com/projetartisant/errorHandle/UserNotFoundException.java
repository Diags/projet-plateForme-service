package monartisant.com.projetartisant.errorHandle;

import monartisant.com.projetartisant.model.User;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find customer id =  " + id);
    }

    public UserNotFoundException(User customer) {
        super("Could not find customer " + customer);
    }
    public UserNotFoundException(String user){
        super("Could not find user id {user} =  "+ user );
    }

}