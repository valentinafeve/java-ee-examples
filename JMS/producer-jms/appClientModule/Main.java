import java.util.Hashtable;
import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {
	
	public Main() {
		super();
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		InitialContext ctx = null;
		QueueConnectionFactory connectionFactory;
		QueueConnection connection = null;
		QueueSession session;
		Queue queue;
		QueueSender sender;
		TextMessage msg;
		try {
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,  
			    "com.sun.enterprise.naming.SerialInitContextFactory");

			ctx = new InitialContext(env);
			
			connectionFactory = (QueueConnectionFactory) ctx.lookup("jms/exampleConnectionFactory");
			connection = connectionFactory.createQueueConnection();
			connection.start();
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			queue = (Queue) ctx.lookup("jms/exampleQueue");
			sender = session.createSender(queue);
			msg = session.createTextMessage();
				for (int i = 0; i < 10; i++) {
					msg.setText("Mensaje No." + (i + 1));
					sender.send(msg);
				}
			sender.close();
			session.close();
			} 
		catch (NamingException | JMSException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException jmse) {
					System.out.println("error: " + jmse.toString());
				}
			}
		}
	}
}