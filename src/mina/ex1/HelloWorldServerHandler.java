package mina.ex1;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class HelloWorldServerHandler extends IoHandlerAdapter{

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		
		if(message == null) {
			System.out.println("message不能为空");
			return;
		}
		
		String msg = (String)message;
		
		if("quit".equals(msg)) {
			session.close(true);
			System.out.println("session.close(true)");
			return;
		}
		
		System.out.println("接收到信息：" + msg);
		
		session.write("hello," + msg);
		
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("sessionClosed");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		 System.out.println( "IDLE " + session.getIdleCount( status ));  
	}

}
