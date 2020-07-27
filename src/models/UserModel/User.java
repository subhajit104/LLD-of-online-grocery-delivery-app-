package models.UserModel;


public class User extends Person {

    private Long cartId;
    private Long OrderHistoryId;
    private Long wishListId;

    public User(String name, String password, String mail) {
        super(name, password, mail);
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getOrderHistoryId() {
        return OrderHistoryId;
    }

    public void setOrderHistoryId(Long orderHistoryId) {
        OrderHistoryId = orderHistoryId;
    }

    public Long getWishListId() {
        return wishListId;
    }

    public void setWishListId(Long wishListId) {
        this.wishListId = wishListId;
    }
}
