
import java.io.IOException;

import jakarta.websocket.EndpointConfig;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websocket")
public class WebsocketServer {
	
	public String toString() {
		return null;
	}
	
	private String serverID = this.toString();
	private int msgCnt = 0;
	private EndpointConfig config;
	
	@OnMessage
	public String serverAnswer(String msg, Session session) {
		//ausgabe auf dem Server
		System.out.println(msg);
		try {
			for(Session client : session.getOpenSessions()) 
			{
				client.getBasicRemote().sendText(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
		
	}
}
