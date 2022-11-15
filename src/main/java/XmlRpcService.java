public class XmlRpcService {
    public synchronized int getSUM(int num1, int num2){
        return SUM(num1, num2);
    }

    public synchronized String getMessage (String msg){
        return MESSAGE(msg);
    }

    private static synchronized int SUM(int n1, int n2){
        return n1+n2;
    }

    private static synchronized String MESSAGE(String msg){
        return "Welcome " + msg;
    }
}
