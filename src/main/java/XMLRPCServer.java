import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class XMLRPCServer {
    private static final int DEFAULT_PORT = 8282;
    public static void main(String[] args) {
        try{
            WebServer webServer = new WebServer(DEFAULT_PORT);
            XmlRpcServer xmlrpcserver = webServer.getXmlRpcServer();
            PropertyHandlerMapping phm = new PropertyHandlerMapping();

            phm.addHandler("XmlRpcService", XmlRpcService.class);

            xmlrpcserver.setHandlerMapping(phm);

            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlrpcserver.getConfig();
            serverConfig.setEnabledForExceptions(true);
            serverConfig.setContentLengthOptional(false);
            webServer.start();

            System.out.println("Server Started at Port http://127.0.0.1:" + DEFAULT_PORT + "/xmlrpc");
        }
        catch (Exception e){

        }
    }
}
