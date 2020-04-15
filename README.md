#Test

#可以通过如下两种方式来运行generator
##第一种，输入如下的命令
'''
java -jar 路径指向mybatis-generator-core-1.3.5.jar -configfile 路径指向generatorConfig.xml -overwrite
'''

##第二种，使用maven的方式来构建。此种方式下貌似generator的配置文件名称必须为generatorConfig.xml
'''
mvn mybatis-generator:generate
'''

更详尽的文档可以参考http://mbg.cndocs.tk/quickstart.html

在实际生产环境中，应该将mybatis集成到spring当中，让spring来管理mybatis的session；
并在spring中配置指向生成的mapper配置文件，类似如下的配置
'''
<bean id="xxxSqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="xxxDataSource"/>
        <property name="configLocation" value="classpath:dao/mybatis-config.xml"/>
        <property name="mapperLocations" value="classpath:dao/xxx/mappers/*.xml"/>
    </bean>
'''
其中xxx为定制化的项目信息