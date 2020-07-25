package models.UserModel;


public class User extends Person {

    private Long cartId;
    public User(String name, String password, String mail) {
        super(name, password, mail);
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
