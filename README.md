This is an experiment to try to solve [LPS-83704](https://issues.liferay.com/browse/LPS-83704). Here we try to clean up Netty thread locals in Tomcat. To do it, we created a Tomcat's Lifecycle listener which would call `io.netty.util.concurrent.FastThreadLocal.destroy()` when shutting down Tomcat. Sadly, it didn't work so far.

# Installing it

To install this listener:

1. Run `mvn jar` in this project's directory.
2. Copy `target/netty-shutdown-listener-0.0.1-SNAPSHOT.jar` to `$liferay_home/tomcat-9.0.6/lib/`.
3. Also copy `netty-all-4.1.0.jar` to to `$liferay_home/tomcat-9.0.6/lib/`.
4. Edit to `$liferay_home/tomcat-9.0.6/conf/server.xml`, adding this line:

    <Listener className="com.liferay.netty.shutdown.listener.NettyThreadLocalCleanUpListener" />

