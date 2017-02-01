package j0kersecrets;

import java.security.*;
import java.util.Scanner;
import javax.crypto.*;
        
public class J0kerSecrets {
    
    public static void main(String[] args) {
        //initializing class and calling method to encrypt
        J0kerSecrets j0ker = new J0kerSecrets();
        j0ker.enc();
    }
    
    public static void enc() {
        //intializing 2 variables outwith try/catch block
        KeyGenerator keygen;
        Cipher cipher;
        
        try {
            //Determines the type of encryption to be used an assigns it to variable keygen with type KeyGenerator
            keygen = KeyGenerator.getInstance("Blowfish");
            //Generator of the secret key 
            SecretKey secret = keygen.generateKey();
            
            cipher = Cipher.getInstance("Blowfish");
            Scanner sc = new Scanner(System.in);
            String string2crypt = sc.nextLine();
            
            cipher.init(Cipher.ENCRYPT_MODE, secret);
            byte[] encrypted = cipher.doFinal(string2crypt.getBytes());
            
            System.out.println("Encrypted string : " + encrypted);
              
              
        }
        
        catch(NoSuchAlgorithmException e) {
            System.err.println("Blowfish is not a valid algorithm in this isntance");
        }
        
        catch(NoSuchPaddingException x) {
            System.err.println("Cannot get instance Blowfish");
        }
        
        catch(InvalidKeyException i) {
            System.err.println("Error");
        }
        
        catch(IllegalBlockSizeException | BadPaddingException q) {
            System.err.println("error in dofinal crypt");
        }
        
        

}
    
}
