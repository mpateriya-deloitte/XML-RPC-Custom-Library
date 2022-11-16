import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.*;

public class JavaClient {
    public static void main (String [] args) {

        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8080/xmlrpc"));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);

            Object[] sum = new Object[]{2, 3};
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