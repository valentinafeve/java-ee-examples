import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class Main {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		InitialContext ctx = null;
		QueueConnectionFactory connectionFactory;
		QueueConnection connection = null;
		QueueSession session;
		Queue queue;
		QueueReceiver receiver;
		Message msg;
		TextMessage tmsg;
		try {
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,  
			    "com.sun.enterprise.naming.SerialInitContextFactory");
			ctx = new InitialContext();
			connectionFactory = (QueueConnectionFactory) ctx.lookup("jms/exampleConnectionFactory");
			connection = connectionFactory.createQueueConnection();
			connection.start();
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			queue = (Queue) ctx.lookup("jms/exampleQueue");
			receiver = session.createReceiver(queue);
			msg = receiver.receive(10);
			while (msg != null) {
				if (msg instanceof TextMessage) {
				tmsg = (TextMessage) msg;
				System.out.println("Mensaje : " + tmsg.getText());
				}
				msg = receiver.receive(10);
			}
			receiver.close();
			session.close();
			} 
		catch (NamingException | JMSException e) {
			e.printStackTrace();
		} 
		finally {
			if (connection != null) {
				try {
				connection.close();
				} 
				catch (JMSException jmse) {
					System.out.println("error: " + jmse.toString());
				}
			}
		}
	}
}