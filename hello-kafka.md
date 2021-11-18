# hello-kafka

## zookeeper 安装配置

1. 下载

   ```tex
   https://downloads.apache.org/zookeeper/zookeeper-3.5.9/
   ```

2. 传输到服务器上

3. 解压

   ```tex
   tar -zxvf apache-zookeeper-3.5.9-bin.tar.gz
   ```

4. 配置

   ```tex
   1.新建数据存放位置
   mkdir /leon/datas/zookeeper-datas
   2.copy zoo_sample.cfg to zoo.cfg 并修改
   dataDir=/tmp/zookeeper ---> dataDir=/leon/datas/zookeeper-datas
   # 指定日志文件存放位置（没有则新增）
   dataLogDir=/leon/logs/zookeeper-logs
   3.启动server
   sh zkServer.sh start
   4.查看启动状态
   sh zkServer.sh status
   5.启动client
   sh zkCli.sh
   ```

5. xxx

## kafka 安装

1. 下载

   ```tex
   http://kafka.apache.org/downloads
   ```

2. 传输到服务器上

3. 解压

   ```tex
   tar -zxvf kafka_2.13-3.0.0.tgz
   ```

4. 配置

   ```tex
   1.新建数据存放位置
   mkdir /leon/logs/kafka-logs
   2.修改kafka/config/server.properties文件
   log.dirs=/tmp/kafka-logs ---> log.dirs=/leon/logs/kafka-logs
   ```

5. xxx

## kafka 启动（kafka bin目录下）

1. 启动zookeeper（自带或默认的）

2. 启动kafka

   ```tex
   sh kafka-server-start.sh -daemon ../config/server.properties
   ```

3. 关闭kafka

   ```tex
   sh kafka-server-stop.sh
   ```

4. 查看kafka运行状态

   ```tex
   ps -ef | grep kafka
   ```

## kafka 使用 (bin 目录下)

### 坑 注意坑新版本kafka不用直连zookeeper

```tex
Error while executing topic command : Timed out waiting for a node assignment. Call: listTopics
https://stackoverflow.com/questions/58376644/error-while-executing-kafka-on-port-2181-topic-command-timed-out-waiting-for

设置listener
https://blog.csdn.net/admi_nistrator/article/details/104017389

server.properties 文件
listeners=PLAINTEXT://zhouchun:9092 或者 listeners=PLAINTEXT://yourip:9092
```

1. 查看当前服务器中的所有 topic

   ```tex
   -- 老版本
   sh kafka-topics.sh --bootstrap-server localhost:2181 --list
   -- 新版本不用直接连zookeeper
   sh kafka-topics.sh --bootstrap-server zhouchun:9092 --list
   ```

2. 创建topic

   ```tex
   --topic 定义 topic 名
   --replication-factor 定义副本数
   --partitions 定义分区数
   
   sh kafka-topics.sh --bootstrap-server zhouchun:9092 --create --replication-factor 1 --partitions 1 --topic topic-first
   ```

3. 查看topic

   ```tex
   sh kafka-topics.sh --bootstrap-server zhouchun:9092 --describe --topic topic-first
   ```

4. 删除topic

   ```tex
   sh kafka-topics.sh --bootstrap-server zhouchun:9092 --delete --topic topic-first
   ```

5. 修改分区数

   ```tex
   sh kafka-topics.sh --bootstrap-server zhouchun:9092 --alter --topic topic-first --partitions 6
   ```

6. 生产消息

   ```tex
   sh kafka-console-producer.sh --bootstrap-server zhouchun:9092 --topic topic-first
   ```

7. 消费消息

   ```tex
   sh kafka-console-consumer.sh --bootstrap-server zhouchun:9092 --topic topic-first
   
   --from-beginning： 会把主题中以往所有的数据都读取出来
   sh kafka-console-consumer.sh --bootstrap-server zhouchun:9092 --topic topic-first --from-beginning
   ```

8. xxx