package com.example.vo;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author: ckx
 * @date: 2020/4/1
 * @description:
 */
public class Test {

    public static void main(String[] args) {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
// 最大连接数
        poolConfig.setMaxTotal(1);
// 最大空闲数
        poolConfig.setMaxIdle(1);

// 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
// Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(1000);
        Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
//        nodes.add(new HostAndPort("112.74.63.19", 6379));
        nodes.add(new HostAndPort("112.74.63.19", 6479));
//        nodes.add(new HostAndPort("120.77.145.166", 6379));
        nodes.add(new HostAndPort("120.77.145.166", 6479));
//        nodes.add(new HostAndPort("112.74.54.153", 6379));
        nodes.add(new HostAndPort("112.74.54.153", 6479));
        JedisCluster cluster = new JedisCluster(nodes, poolConfig);
        String name = cluster.get("test");
        System.out.println(name);
        cluster.set("asssse", "12222");
        System.out.println(cluster.get("asssse"));
        try {
            cluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
