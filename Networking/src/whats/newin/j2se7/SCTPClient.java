package whats.newin.j2se7;

import java.io.IOException; 
import java.net.InetAddress; 
import java.net.InetSocketAddress; 
import java.net.SocketAddress; 
import java.nio.ByteBuffer;
/*
import com.sun.nio.sctp.MessageInfo; 
import com.sun.nio.sctp.SctpChannel;
*/
public class SCTPClient {

	private static final int SERVER_PORT = 0;
	private static final int CLIENT_PORT = 0;
	private static final int BUF_SIZE = 0;
	
	public static void main(String[] args) throws IOException {
		  try { 
	       /*     SocketAddress servAddr = new InetSocketAddress(SERVER_PORT); 
	            SctpChannel sctpChan = SctpChannel.open();
	            sctpChan.bind(new InetSocketAddress(CLIENT_PORT)); 
	            sctpChan.connect(servAddr, 1 ,1);

	            MessageInfo msgInfo = MessageInfo.createOutGoing(null,   // use peer primary address
	            		                                         0);     // stream #
				String hi = "Hello from the Client!  I want an association!";
				ByteBuffer buf = ByteBuffer.allocate(BUF_SIZE); 
				buf.put(hi.getBytes());
	            byteBuffer.flip();
	            try { 
	                sctpChannel.send(buf, msgInfo); 
	            } catch (Exception e) { 
	                e.printStackTrace(); 
	            } 
	            sctpChannel.close();           // close connection
*/
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	}

}

