//importing Required Libraries

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.*;

//Creating the Client Class
public class JavaClient {
    public static void main (String [] args) {

        try {
            //Initializing the Client Configuration
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            //Setting the Host, port and URL of Server to Access
            config.setServerURL(new URL("http://localhost:8080/xmlrpc"));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);

            //Using Objects to Send via the Client to Server
            Object[] sum = new Object[]{2, 3};
            //Executing the method
            int result = (int) client.execute("add", sum);
            System.out.println("The sum is: "+ result);

            Object[] mul = new Object[]{2, 3};
            int res = (int) client.execute("mul", mul);
            System.out.println("The Multiplication is: "+ res);

        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception);
        }
    }
}