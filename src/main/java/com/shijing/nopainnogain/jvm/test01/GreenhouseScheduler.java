package com.shijing.nopainnogain.jvm.test01;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: shijing
 * @Date: 18/11/21 17 07
 * @Description:
 */
public class GreenhouseScheduler {
    private volatile boolean light = false;

    private volatile boolean water = false;

    private String thermostat = "Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String value) {
        thermostat = value;
    }

    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    public void schedule(Runnable event, long delay) {
        scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable event, long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    class LightOn implements Runnable {

        @Override
        public void run() {
            //硬件控制代码用于打开灯
            System.out.println("Turning on lights");
            light = true;
        }
    }

    class LightOff implements Runnable {

        @Override
        public void run() {
            //硬件控制代码，用于关闭灯
            System.out.println("Turning off lights");
            light = false;
        }
    }

    class WaterOn implements Runnable {

        @Override
        public void run() {
            //硬件控制代码
            System.out.println("Turning greenhouse water on");
            water = true;
        }
    }

    class WaterOff implements Runnable {

        @Override
        public void run() {
            //硬件控制代码
            System.out.println("Turning greenhouse water off");
            water = false;
        }
    }

    class ThermostatNight implements Runnable {

        @Override
        public void run() {
            //硬件控制代码
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable {

        @Override
        public void run() {
            //硬件控制代码
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }
    }

    class Bell implements Runnable {

        @Override
        public void run() {
            System.out.println("Bing!");
        }
    }

    class Terminate implements Runnable {

        @Override
        public void run() {
            System.out.println("Terminating");
            scheduler.shutdownNow();
            //必须启动一个独立的任务，因为调度服务已经关闭
            new Thread() {
                public void run() {
                    for (DataPoint d: data)
                        System.out.println(d);
                }
            }.start();
        }
    }

    //新的特征数据收集
    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;
        }
        @Override
        public String toString() {
            return time.getTime() +
                    String.format(" temperature: %1$.1f humidity: %2$.2f", temperature, humidity);
        }
    }
    private Calendar lastTime = Calendar.getInstance();
    {
        //调试时间为半小时
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }
    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());
    class CollectData implements Runnable {

        @Override
        public void run() {
            System.out.println("Collecting data");
            synchronized (GreenhouseScheduler.this) {
                //假装时间间隔比它长
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
                // 1/5的机会转变方向
                if (rand.nextInt(5) == 4)
                    tempDirection = -tempDirection;
                //存储前一个值：
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                if (rand.nextInt(5) == 4)
                    humidityDirection = -humidityDirection;
                lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();
                //日历可以复制，否则所有的数据点保持
                //上一时间段的属性，对于类似于日历这
                //样的对象，clone()方法就可以了。
                data.add(new DataPoint((Calendar)lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }
    public static void main(String[] args) {
        GreenhouseScheduler gh = new GreenhouseScheduler();
        gh.schedule(gh.new Terminate(), 5000);
        //不需要“Restart”类；
        gh.repeat(gh.new Bell(), 0, 1000);
        gh.repeat(gh.new ThermostatNight(), 0, 2000);
        gh.repeat(gh.new LightOn(), 0, 200);
        gh.repeat(gh.new LightOff(), 0, 400);
        gh.repeat(gh.new WaterOn(), 0, 600);
        gh.repeat(gh.new WaterOff(), 0, 800);
        gh.repeat(gh.new ThermostatDay(), 0, 1400);
        gh.repeat(gh.new CollectData(), 500, 500);

    }
}
