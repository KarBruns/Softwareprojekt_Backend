package awk.softwareprojekt.rest;


import de.kursverwaltung.security.PlainSHA512PasswordHash;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@BasicAuthenticationMechanismDefinition()
@DatabaseIdentityStoreDefinition(

		dataSourceLookup = "app/OracleDS",
        callerQuery = "select PASSWORD from User where USERNAME=?",
        groupsQuery = "select ROLENAME as GROUPNAME from User_Roles where USERNAME=?",
        hashAlgorithm = PlainSHA512PasswordHash.class
)


@ApplicationScoped
@Named
@ApplicationPath("api")
public class ApplicationConfig extends Application {

	
}