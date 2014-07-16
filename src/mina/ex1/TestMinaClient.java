package mina.ex1;

import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class TestMinaClient {
	
	public static void main(String[] args) {
		
		IoConnector connector = new NioSocketConnector(1);
		connector.getSessionConfig().setUseReadOperation(true);
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
		ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 8888));
		future.awaitUninterruptibly();
		IoSession session = future.getSession();
		
		for(int i = 0;i<10;i++) {
		
			session.write("scott here." + i);
			Object message = session.read().awaitUninterruptibly().getMessage();
			System.out.println(message);
		}
		
		
		session.close(true);
	}

}
