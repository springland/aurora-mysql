package com.springland365.auroramysql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.Properties;

@SpringBootApplication
public class AuroraMysqlApplication implements ApplicationRunner {


	@Value("${region}")
	String region ;

	@Value("${host}")
	String host ;

	@Value("${port}")
	int port ;

	@Value("${dbuser}")
	String dbuser ;
	public static void main(String[] args) {
		SpringApplication.run(AuroraMysqlApplication.class, args);
	}

	private static final String CONNECTION_STRING = "jdbc:mysql://db-identifier.cluster-XYZ.us-east-2.rds.amazonaws.com:3306/employees";
	private static final String USER = "username";



	@Override
	public void run(ApplicationArguments arg0) throws Exception {

		try
		{
			runAuroraSDKV2Test();
			//IAMDatabaseAuthentication  auth = new IAMDatabaseAuthentication();
			//auth.runAuroraTest(region , host , port , dbuser);
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
			ex.printStackTrace();;
		}

	}



	protected void runAuroraSDKV2Test() throws SQLException
	{

		String jdbcurl = "jdbc:mysql:aws://" + host + ":" + port ;

		System.out.println(" Begin Aurora test");
		System.out.println(jdbcurl);
		final Properties properties = new Properties();
		// Enable AWS IAM database authentication
		properties.setProperty("useAwsIam", "true");
		properties.setProperty("user", dbuser);

		try (final Connection conn = DriverManager.getConnection(jdbcurl, properties);
			 final Statement myQuery = conn.createStatement()) {
			try (final ResultSet rs = myQuery.executeQuery("SELECT * FROM test.employees")) {
				while (rs.next()) {
					System.out.print(rs.getInt(1));
					System.out.println("   :    " + rs.getString(2));
				}
			}
		}


		System.out.println("End AUrora test");
	}
}
