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