package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public class ACLprocessing {

	public static void main(String[] args) {
		Path dPath = Paths.get("C:\\Users");
		
		try {
			// Get ACL of O/S Users directory
			//
			AclFileAttributeView view  = Files.getFileAttributeView(dPath, AclFileAttributeView.class);

			System.out.println("ACL for directory: " + dPath + " in view:"+ view.name());
			for (AclEntry aclEntry : view.getAcl()) {
				System.out.println("Principal: " + aclEntry.principal() + ":");
				System.out.println("   has permissions:"
						+ aclEntry.permissions());
			}

			// Get ACL of newly created directory
			//
			dPath = Paths.get("C:\\myDir");
			pauseConsole("See ACL for new directory " + dPath);
			Files.deleteIfExists(dPath);           
			Files.createDirectory(dPath);      
			
			view = Files.getFileAttributeView(dPath, AclFileAttributeView.class);
			System.out.println("\nACL for directory: " + dPath + " in view:"+ view.name());
			for (AclEntry aclEntry : view.getAcl()) {
				System.out.println("Principal: " + aclEntry.principal() + ":");
				System.out.println("   has permissions:"	+ aclEntry.permissions());
			}

			// Get Add an ACE entry to an ACL
			//
			pauseConsole("Add a new ACE to the ACL of " + dPath);
			UserPrincipal user = dPath.getFileSystem()
						.getUserPrincipalLookupService()
						.lookupPrincipalByName("bbirze");
			AclEntry entry = AclEntry
						.newBuilder()
						.setType(AclEntryType.ALLOW)
						.setPrincipal(user)
						.setPermissions(AclEntryPermission.READ_DATA,
										AclEntryPermission.READ_ATTRIBUTES).build();

			System.out.println("\nAdding AclEntry to :" + dPath);
			List<AclEntry> acl = view.getAcl();
			acl.add(0, entry); // insert before any DENY entries
			view.setAcl(acl);
			System.out.println("\nUpdated ACL for directory: " + dPath + " in view:"+ view.name());
			for (AclEntry aclEntry : view.getAcl()) {
				System.out.println("Principal: " + aclEntry.principal() + ":");
				System.out.println("   has permissions:" + aclEntry.permissions());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void pauseConsole(String doNext) {
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			System.out.println("\nHit Enter to "+ doNext +":>");
			cin.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
