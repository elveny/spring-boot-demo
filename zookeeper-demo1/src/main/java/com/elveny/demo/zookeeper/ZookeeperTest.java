package com.elveny.demo.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by Administrator on 2016/9/6.
 */
public class ZookeeperTest {

    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        Watcher watcher = new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println("::::::"+event.toString());
            }
        };

        ZooKeeper zk = new ZooKeeper("101.200.189.84:2180", 2000, watcher);
        Stat stat = zk.exists("/zk_test", watcher);
        System.out.println(stat.getDataLength());

        System.out.println(new String(zk.getData("/zk_test", false, null)));

        stat = zk.exists("/elven1", false);
        if(stat == null){
            zk.create("/elven1", "elven test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }


        System.out.println(stat.getDataLength());
    }


}
