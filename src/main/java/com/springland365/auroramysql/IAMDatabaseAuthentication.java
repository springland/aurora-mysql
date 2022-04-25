package com.springland365.auroramysql;

//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.auth.EC2ContainerCredentialsProviderWrapper;
//import com.amazonaws.services.rds.auth.GetIamAuthTokenRequest;
//import com.amazonaws.services.rds.auth.RdsIamAuthTokenGenerator;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.net.URL;
//import java.security.KeyStore;
//import java.security.cert.CertificateFactory;
//import java.security.cert.X509Certificate;
//import java.sql.*;
//import java.util.Properties;

/**
 * Based on sdk v1.x
 */
public class IAMDatabaseAuthentication {
/*
    private static final String SSL_CERTIFICATE = "global-bundle.pem";

    private static final String KEY_STORE_TYPE = "JKS";
    private static final String KEY_STORE_PROVIDER = "SUN";
    private static final String KEY_STORE_FILE_PREFIX = "sys-connect-via-ssl-test-cacerts";
    private static final String KEY_STORE_FILE_SUFFIX = ".jks";
    private static final String DEFAULT_KEY_STORE_PASSWORD = "changeit";

    public  void runAuroraTest(String region , String host , int port , String user) throws Exception
    {


        Connection  conn = getDBConnectionUsingIam(region , host , port , user);

        //verify the connection is successful
        final Statement myQuery = conn.createStatement();
        try (final ResultSet rs = myQuery.executeQuery("SELECT * FROM test.employees")) {
            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.println("   :    " + rs.getString(2));
            }
        }

        myQuery.close();
        conn.close();

        clearSslProperties();
    }

    private  Connection getDBConnectionUsingIam(String region , String host , int port , String user) throws Exception {
        String url ="jdbc:mysql://" + host + ":" + port;

        System.out.println(" URL is " + url);
        setSslProperties();
        return DriverManager.getConnection(url, setMySqlConnectionProperties(region , host , port ,user));
    }

    private  void setSslProperties() throws Exception {
        System.setProperty("javax.net.ssl.trustStore", createKeyStoreFile());
        System.setProperty("javax.net.ssl.trustStoreType", KEY_STORE_TYPE);
        System.setProperty("javax.net.ssl.trustStorePassword", DEFAULT_KEY_STORE_PASSWORD);
    }

    private  String createKeyStoreFile() throws Exception {
        return createKeyStoreFile(createCertificate()).getPath();
    }
    private  File createKeyStoreFile(X509Certificate rootX509Certificate) throws Exception {
        File keyStoreFile = File.createTempFile(KEY_STORE_FILE_PREFIX, KEY_STORE_FILE_SUFFIX);
        try (FileOutputStream fos = new FileOutputStream(keyStoreFile.getPath())) {
            KeyStore ks = KeyStore.getInstance(KEY_STORE_TYPE, KEY_STORE_PROVIDER);
            ks.load(null);
            ks.setCertificateEntry("rootCaCertificate", rootX509Certificate);
            ks.store(fos, DEFAULT_KEY_STORE_PASSWORD.toCharArray());
        }
        return keyStoreFile;
    }
    private  Properties setMySqlConnectionProperties(String region , String hostname , int port ,String user) {
        Properties mysqlConnectionProperties = new Properties();
        mysqlConnectionProperties.setProperty("verifyServerCertificate","false");
        mysqlConnectionProperties.setProperty("useSSL", "true");
        mysqlConnectionProperties.setProperty("user",user);


        String token = generateAuthToken(region , hostname , port , user);

        System.out.println("User: " + user);

        System.out.println(" Token: " + token);
        mysqlConnectionProperties.setProperty("password",token);
        return mysqlConnectionProperties;
    }

    private  String generateAuthToken(String  region , String hostname , int port ,  String user) {

        RdsIamAuthTokenGenerator generator = RdsIamAuthTokenGenerator.builder()
                .credentials(new EC2ContainerCredentialsProviderWrapper()).region(region).build();
        return generator.getAuthToken(GetIamAuthTokenRequest.builder()
                .hostname(hostname).port(port).userName(user).build());
    }


    private  void clearSslProperties() throws Exception {
        System.clearProperty("javax.net.ssl.trustStore");
        System.clearProperty("javax.net.ssl.trustStoreType");
        System.clearProperty("javax.net.ssl.trustStorePassword");
    }


    private X509Certificate createCertificate() throws Exception {
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        URL url = new File(SSL_CERTIFICATE).toURI().toURL();
        if (url == null) {
            throw new Exception();
        }
        try (InputStream certInputStream = url.openStream()) {
            return (X509Certificate) certFactory.generateCertificate(certInputStream);
        }
    }
*/
}
