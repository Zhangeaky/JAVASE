## cd实验手册

实现LVS负载均衡服务器

1. vmware 创建服务器节点

2. node01节点 LVS 负载均衡服务器

   ```
   ifconfig eth0:8 192.168.150.100/24 #vip
   ```

3. node02 -03节点

   ```bash
   修改内核参数：
   cd /proc/sys/net/ipv4/conf/eth0
   echo 1 > arp_ignore
   echo 2 > arp_announce
   cd /proc/sys/net/ipv4/conf/all
   echo 1 > arp_ignore
   echo 2 > arp_announce
   
   #设置VIP隐藏
   ifconfig lo:3 192.168.150.100 netmask 255.255.255.255
   # 四个255 的问题 
   ```

4. 搭建RealServer中的http服务

   ```bash
   node02-node3:
   yum install httpd -y
   service httpd start 
   #创建 默认主页
   vi /var/www/html/index.html
   ```

5. 配置负载均衡服务器

```bash
# 配置入口规则
# -t 基于tcp协议的包
# -s rr 轮询算法
ipvsadm -A -t 192.168.150.100:80 -s rr
# 配置分发规则
ipvsadm -a -t 192.168.150.100:80 -r 192.168.150.12 -g -w 1
# 权重为1
ipvsadm -ln

```

6. 验证

```bash
1. 浏览器访问 192.168.150.100
2. node1
netstat -natp
3. node2
netstat -natp
4. node3
netstat -natp

#结论
无法在1上看到连接

# 在node1 上查看偷窥记录本
ipvsadm -lnc
FIN_WAIT

#排错实验
在node3上 ifconfig lo:2 down
再从node1上进行查看记录本
ipvsadm -lnc
SYN_RECV  # LVS 没有出现问题，网络层出现了问题


```

   