

dbuser=jane_doe
host=database-1-instance-1.czk296redlz1.us-west-2.rds.amazonaws.com
port=3306
region=us-west-2

scp -i "~/keys/minecraft.pem" aurora-mysql-0.0.1-SNAPSHOT.jar  ubuntu@ec2-34-218-44-130.us-west-2.compute.amazonaws.com:/home/ubuntu

ssh -i "~/keys/minecraft.pem"   ubuntu@ec2-34-218-44-130.us-west-2.compute.amazonaws.com

GRANT ALL PRIVILEGES ON test.employees to 'jane_doe'@'%';


Access denied for user 'jane_doe'@'172.31.0.5' (using password: YES)
java.sql.SQLException: Access denied for user 'jane_doe'@'172.31.0.5' (using password: YES)


export RDSHOST="database-1-instance-1.czk296redlz1.us-west-2.rds.amazonaws.com"
TOKEN="$(aws rds generate-db-auth-token --hostname $RDSHOST --port 3306 --region us-west-2 --username jane_doe )"
echo $TOKEN
mysql --host=$RDSHOST --port=3306 --ssl-ca=global-bundle.pem --enable-cleartext-plugin --user=jane_doe --password=$TOKEN

This is interesting.
aws-mysql-jdbc should be a sdk 2.x project (https://github.com/awslabs/aws-mysql-jdbc/blob/main/build.gradle.kts)

It depends on implementation("software.amazon.awssdk:rds:2.17.165")

However it only works after the 1.x dependency was added. The 2.x rds dependency always throw
<dependency>
<groupId>com.amazonaws</groupId>
<artifactId>aws-java-sdk-rds</artifactId>
<version>1.12.205</version>
</dependency>