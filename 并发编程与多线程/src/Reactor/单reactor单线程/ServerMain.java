package Reactor.单reactor单线程;

public class ServerMain {
    public static void main(String[] args) {
        Reactor reactor = new Reactor(8888);
        reactor.run();
    }
}
