package com.springland365.auroramysql;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.Properties;

@SpringBootApplication
public class AuroraMysqlApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(AuroraMysqlApplication.class, args);
	}

	private static final String CONNECTION_STRING = "jdbc:mysql:aws://db-identifier.cluster-XYZ.us-east-2.rds.amazonaws.com:3306/employees";
	private static final String USER = "username";
	@Override
	public void run(ApplicationArguments arg0) throws Exception {

		try
		{
			runAuroraTest();
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
			ex.printStackTrace();;
		}

	}

	protected void runAuroraTest() throws SQLException
	{
		System.out.println(" Begin Aurora test");

		final Properties properties = new Properties();
		// Enable AWS IAM database authentication
		properties.setProperty("useAwsIam", "true");
		properties.setProperty("user", USER);

		try (final Connection conn = DriverManager.getConnection(CONNECTION_STRING, properties);
			 final Statement myQuery = conn.createStatement()) {
			try (final ResultSet rs = myQuery.executeQuery("SELECT * FROM employees")) {
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
			}
		}


		System.out.println("End AUrora test");
	}
}
