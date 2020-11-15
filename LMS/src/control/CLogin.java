package control;

import model.MLogin;

public class CLogin {
   
   private MLogin eLogin;

   public boolean validateUser(String id, String password) {
      this.eLogin = new MLogin();
      return this.eLogin.validateUser(id, password);
      
   }

}