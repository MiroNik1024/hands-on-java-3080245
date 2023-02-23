package bank;

import javax.security.auth.login.LoginException;

public class Authenthicate {
  /**
   * @param username
   * @param password
   * @return
   * @throws LoginException
   */
  public static Customer login(String username, String password) throws LoginException {
    Customer customer = DataSource.getCustomer(username);
    if (customer == null) {
      throw new LoginException("Invalid username");
    }

    if (password.equals(customer.getPassword())) {
      customer.setAuthenticate(true);
    } else {
      throw new LoginException("Incorrect password");
    }

    return customer;
  }

  public static void logout(Customer customer) {
    customer.setAuthenticate(false);
  }
}
