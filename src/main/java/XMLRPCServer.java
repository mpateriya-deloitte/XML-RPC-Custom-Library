
//Importing Required Libraries
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

//Creating a Class for Handling Server
public class XMLRPCServer {

    private static final int DEFAULT_PORT = 8282; //Setup Default Port for Opening the Server
    public static void main(String[] args) {
        try{
            WebServer webServer = new WebServer(DEFAULT_PORT); // Create WebServer Class using the Specified Port
            XmlRpcServer xmlrpcserver = webServer.getXmlRpcServer();  // Get the XMLRPC Server Instance
            PropertyHandlerMapping phm = new PropertyHandlerMapping(); // Create Property Handler to Handle the Specifications of Server

            phm.addHandler("XmlRpcService", XmlRpcService.class); // Connecting the Class and Handler

            xmlrpcserver.setHandlerMapping(phm);

            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlrpcserver.getConfig(); // Getting the Configurations of the Server
            serverConfig.setEnabledForExceptions(true);
            serverConfig.setContentLengthOptional(false);
            webServer.start(); // Starting the Server

            System.out.println("Server Started at Port http://127.0.0.1:" + DEFAULT_PORT + "/xmlrpc");
        }
        catch (Exception e){

        }
    }
}
