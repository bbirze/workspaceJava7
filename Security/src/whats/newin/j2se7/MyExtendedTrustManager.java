package whats.newin.j2se7;

import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.*;

import javax.net.ssl.*;

public class MyExtendedTrustManager extends X509ExtendedTrustManager {

	 /*
	  * The default PKIX X509ExtendedTrustManager.  We'll delegate
	  * decisions to it, and fall back to the logic in this class if the
	  * default X509ExtendedTrustManager doesn't trust it.
	  */
	 X509ExtendedTrustManager pkixTrustManager;

	 MyExtendedTrustManager() throws Exception {
		 // create a "default" JSSE X509ExtendedTrustManager.

		 KeyStore ks = KeyStore.getInstance("JKS");
		 ks.load(new FileInputStream("trustedCerts"),
			 "passphrase".toCharArray());

		 TrustManagerFactory tmf =
				TrustManagerFactory.getInstance("PKIX");
		 tmf.init(ks);

		 TrustManager tms [] = tmf.getTrustManagers();

		 /*
		  * Iterate over the returned trustmanagers, look
		  * for an instance of X509TrustManager.  If found,
		  * use that as our "default" trust manager.
		  */
		 for (int i = 0; i <= tms.length; i++) {
			if (tms[i] instanceof X509ExtendedTrustManager) { 
				pkixTrustManager = (X509ExtendedTrustManager) tms[i];
				 return;
			 }
		 }

		 /*
		  * Find some other way to initialize, or else we have to fail the
		  * constructor.
		  */
		 throw new Exception("Couldn't initialize");
	 }

	 /*
	  * Delegate to the default trust manager.
	  */
	 public void checkClientTrusted(X509Certificate[] chain, String authType)
				 throws CertificateException {
		 try {
			 pkixTrustManager.checkClientTrusted(chain, authType);
		 } catch (CertificateException excep) {
			 // do any special handling here, or rethrow exception.
		 }
	 }

	 /*
	  * Delegate to the default trust manager.
	  */
	 public void checkServerTrusted(X509Certificate[] chain, String authType)
				 throws CertificateException {
		 try {
			 pkixTrustManager.checkServerTrusted(chain, authType);
		 } catch (CertificateException excep) {
			 /*
			  * Possibly pop up a dialog box asking whether to trust the
			  * cert chain.
			  */
		 }
	 }

	 /*
	  * Connection-sensitive verification.
	  */
	 public void checkClientTrusted(X509Certificate[] chain, String authType,
				  Socket socket)
				 throws CertificateException {
	   try {
		   pkixTrustManager.checkClientTrusted(chain, authType, socket);
	   } catch (CertificateException excep) {
		   // do any special handling here, or rethrow exception.
	   }
	 }

	 public void checkClientTrusted(X509Certificate[] chain, String authType,
				  SSLEngine engine)
				 throws CertificateException {
	   try {
		   pkixTrustManager.checkClientTrusted(chain, authType, engine);
	   } catch (CertificateException excep) {
		   // do any special handling here, or rethrow exception.
	   }
	 }

	 public void checkServerTrusted(X509Certificate[] chain, String authType,
				  Socket socket)
				 throws CertificateException {
	   try {
		   pkixTrustManager.checkServerTrusted(chain, authType, socket);
	   } catch (CertificateException excep) {
		   // do any special handling here, or rethrow exception.
	   }
	 }

	 public void checkServerTrusted(X509Certificate[] chain, String authType,
				  SSLEngine engine)
				 throws CertificateException {
	   try {
		   pkixTrustManager.checkServerTrusted(chain, authType, engine);
	   } catch (CertificateException excep) {
		   // do any special handling here, or rethrow exception.
	   }
	 }
	 
	 /*
	  * Merely pass this through.
	  */
	 public X509Certificate[] getAcceptedIssuers() {
		 return pkixTrustManager.getAcceptedIssuers();
	 }
}