package whats.newin.j2se7;

import java.io.IOException; 
import java.net.InetSocketAddress; 
import java.net.SocketAddress; 
import java.nio.ByteBuffer;
/*
import com.sun.nio.sctp.MessageInfo; 
import com.sun.nio.sctp.SctpChannel; 
import com.sun.nio.sctp.SctpServerChannel;
*/
public class SCTPServer {
	
	private static final int SERVER_PORT = 0;
	private static final int BUF_SIZE = 0;
	private static final int MY_STREAM = 0;

	public static void main(String[] args) throws IOException {
/*		SocketAddress servAddr = new InetSocketAddress(SERVER_PORT);
		SctpServerChannel sctpServChan = SctpServerChannel.open().bind(servAddr);
		ByteBuffer buf = ByteBuffer.allocate(BUF_SIZE); 

		while (true)  {
			SctpChannel sctpcan = sctpServChan.accept();
			MessageInfo msgInfo = sctpcan.receive(buf, null, null);
			System.out.println(new String(buf.array());
			
			String hi = "Hello from the server!  We now have an association!";
			buf.put(hi.getBytes());
            byteBuffer.flip();
            MessageInfo messageInfo = MessageInfo.createOutgoing(null,         // peer primary addr
                                                                 MY_STREAM);   // user defined
            try { 
            	sctpcan.send(buf, msgInfo); 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
            sctpcan.close();           // close connection
		}
*/		
	}
}
