package com.ericsson.urm.util;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class JmsQueueSession {
	private final static Logger logger = Logger.getLogger(JmsQueueSession.class);
	
	private QueueConnection connection   = null;
	private QueueSession    session      = null;
	private Queue           commandQueue = null;
	private QueueSender     sender       = null;

	public static class SessionParameters {
		public boolean transacted = false;
		public int acknowledgeMode = Session.AUTO_ACKNOWLEDGE;
	};
	
	private JmsQueueSession(QueueConnection connection,
			QueueSession session, Queue commandQueue, QueueSender sender) {
		super();
		this.connection = connection;
		this.session = session;
		this.commandQueue = commandQueue;
		this.sender = sender;
	}
	
	public QueueConnection getConnection() {
		return connection;
	}

	public QueueSession getSession() {
		return session;
	}

	public Queue getCommandQueue() {
		return commandQueue;
	}

	public QueueSender getSender() {
		return sender;
	}
	
	public synchronized static JmsQueueSession  createSessionByJndi (
			String jndiQueueConnFactory,
			String jndiDestinationName
		) throws NamingException, JMSException {
		return createSession (jndiQueueConnFactory,jndiDestinationName,true,null,null);
	}
	
	public synchronized static JmsQueueSession  createSessionByJndi(
			String jndiQueueConnFactory,
			String jndiDestinationName,
			SessionParameters sessionParameters
		) throws NamingException, JMSException {
		return createSession (jndiQueueConnFactory,jndiDestinationName,true,sessionParameters,null);
	}
	
	public synchronized static JmsQueueSession  createSessionByJndi (
			String jndiQueueConnFactory,
			String jndiDestinationName,
			SessionParameters sessionParameters,
			Hashtable htInitialContext
		) throws NamingException, JMSException {
		return createSession (jndiQueueConnFactory,jndiDestinationName,true,sessionParameters,htInitialContext);
	}
	


	public synchronized static JmsQueueSession  createSession (
			String jndiQueueConnFactory,
			String destinationName
		) throws NamingException, JMSException {
		return createSession (jndiQueueConnFactory,destinationName,false,null,null);
	}
	
	public synchronized static JmsQueueSession  createSession(
			String jndiQueueConnFactory,
			String destinationName,
			SessionParameters sessionParameters
		) throws NamingException, JMSException {
		return createSession (jndiQueueConnFactory,destinationName,false,sessionParameters,null);
	}
	
	public synchronized static JmsQueueSession  createSession (
			String jndiQueueConnFactory,
			String destinationName,
			SessionParameters sessionParameters,
			Hashtable htInitialContext
		) throws NamingException, JMSException {
		return createSession (jndiQueueConnFactory,destinationName,false,sessionParameters,htInitialContext);
	}

	private synchronized static JmsQueueSession  createSession (
															String jndiQueueConnFactory,
															String destinationName,
															boolean jndiDestinationName,
															SessionParameters sessionParameters,
															Hashtable htInitialContext
														) throws NamingException, JMSException {
		ArgumentsCheckerUtil.checkString(jndiQueueConnFactory,"jndiQueueConnFactory");
		ArgumentsCheckerUtil.checkString(destinationName,"destinationName");
		
		if(sessionParameters==null) {
			sessionParameters = new SessionParameters();
		}
		
		InitialContext ctx = null;
		try {
			QueueConnection connection   = null;

			ctx = htInitialContext!= null ? new InitialContext(htInitialContext) : new InitialContext();
			QueueConnectionFactory factory      = (QueueConnectionFactory)ctx.lookup (jndiQueueConnFactory);
			connection   = factory.createQueueConnection();

			QueueSession    session      = connection.createQueueSession (sessionParameters.transacted, sessionParameters.acknowledgeMode);
			
			Queue           commandQueue = null;
			if(jndiDestinationName) {
			   commandQueue = (Queue) ctx.lookup (destinationName);
			} else {
			   commandQueue = session.createQueue(destinationName);
			}
			QueueSender     sender       = session.createSender (commandQueue);
			
			JmsQueueSession instance = new JmsQueueSession(connection,session, commandQueue, sender);
			
			return instance;
		} finally {
			if(ctx!=null) {
				try { ctx.close();
				} catch (Exception e) {
					logger.error("Close context failed; "+e.getMessage());
				}
			}
		}
	}
	
	public void close() {
		try {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					logger.error (
							"Can't close the JMS session; " +
									"Error cause: " + e.getMessage ()
							);
				}
			}
		} finally {
			this.connection = null;
			this.session = null;
			this.commandQueue = null;
			this.sender = null;
		}
	}

}
