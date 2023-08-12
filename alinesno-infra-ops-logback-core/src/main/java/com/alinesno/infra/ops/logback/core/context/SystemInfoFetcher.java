package com.alinesno.infra.ops.logback.core.context;

import com.alinesno.infra.common.core.utils.Arith;
import com.alinesno.infra.ops.logback.core.dto.*;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * SystemInfoUtil类提供了获取系统信息的实用方法。
 * 使用oshi库获取CPU和内存相关信息，并将其封装到对应的数据传输对象中返回。
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
public class SystemInfoFetcher {
    /**
     * 获取CPU相关信息
     *
     * @return CPUDto对象，包含CPU相关信息
     */
    public static CPUDto getCPUDetails() throws InterruptedException {

        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();

        TimeUnit.SECONDS.sleep(1);

        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;

        CPUDto cpuDto = new CPUDto();

        cpuDto.setCpuCores(processor.getLogicalProcessorCount());
        cpuDto.setCpuSystemUsage(cSys * 1.0 / totalCpu);
        cpuDto.setCpuUserUsage(user * 1.0 / totalCpu);
        cpuDto.setCpuWaitRate(iowait * 1.0 / totalCpu);
        cpuDto.setCpuCurrentUsage(100 - Arith.mul(Arith.div(idle , totalCpu, 4), 100));

        return cpuDto;
    }

    /**
     * 获取内存相关信息
     *
     * @return MenDto对象，包含内存相关信息
     */
    public static MemDto getMemoryDetails() {
        SystemInfo systemInfo = new SystemInfo();
        GlobalMemory memory = systemInfo.getHardware().getMemory();

        MemDto memDto = new MemDto();
        memDto.setTotalMemory(FormatUtil.formatBytes(memory.getTotal()));
        memDto.setUsedMemory(FormatUtil.formatBytes(memory.getTotal() - memory.getAvailable()));
        memDto.setRemainingMemory(FormatUtil.formatBytes(memory.getAvailable()));
        memDto.setMemoryUsage(100 - Arith.mul(Arith.div(memory.getAvailable(), memory.getTotal(), 4), 100));

        return memDto;
    }

    /**
     * 获取操作系统相关信息
     *
     * @return OsDto对象，包含操作系统相关信息
     */
    public static OsDto getOperatingSystemDetails() {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem os = systemInfo.getOperatingSystem();

        OsDto osDto = new OsDto();
        osDto.setOperatingSystemName(os.toString());
        osDto.setSystemArchitecture(System.getProperty("os.arch"));
        osDto.setCpu(os.getManufacturer() + " " + os.getFamily());

        List<DiskInfo> diskInfoList = new ArrayList<>();

        FileSystem fileSystem = os.getFileSystem();
        List<OSFileStore> fsArray = fileSystem.getFileStores();

        for (OSFileStore fs : fsArray) {

            long free = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            long used = total - free;

            DiskInfo diskInfo = new DiskInfo();

            diskInfo.setDriver(fs.getName());
            diskInfo.setTotal(Arith.convertFileSize(total));
            diskInfo.setUsage(Arith.convertFileSize(used));
            diskInfo.setPercentUsage(Arith.mul(Arith.div(used, total, 4), 100));

            diskInfoList.add(diskInfo);
        }

        osDto.setDisk(diskInfoList);

        osDto.setMemory(FormatUtil.formatBytes(systemInfo.getHardware().getMemory().getTotal()));

        return osDto;
    }

    /**
     * 获取磁盘信息
     */
    private static HashMap<String, Long> getDiskUsage() {
        HashMap<String, Long> hashMap = new HashMap<>();
        File[] files = File.listRoots();
        long total = 0;
        long used = 0;
        for (File file : files) {
            total = total + file.getTotalSpace() / 1024 / 1024 / 1024;
            used = used + file.getFreeSpace() / 1024 / 1024 / 1024;
        }
        hashMap.put("total", total);
        hashMap.put("used", used);

        return hashMap;
    }

    /**
     * 获取线程相关信息
     */
    public static List<ThreadDto> getThreadInfo() {
        List<ThreadDto> threadInfoList = new ArrayList<>();

        Thread[] threads = getAllThreads();
        for (Thread thread : threads) {
            ThreadDto threadDto = new ThreadDto();
            threadDto.setThreadId((int) thread.getId());
            threadDto.setThreadName(thread.getName());
            threadDto.setThreadStatus(thread.getState().toString());
            threadDto.setMemoryOccupied(getMemoryUsage(thread.getId()));
            threadInfoList.add(threadDto);
        }

        return threadInfoList;
    }

    /**
     * 获取所有线程
     */
    private static Thread[] getAllThreads() {
        ThreadGroup rootThreadGroup = getRootThreadGroup();
        ThreadGroup parentThreadGroup = rootThreadGroup.getParent();
        while (parentThreadGroup != null) {
            rootThreadGroup = parentThreadGroup;
            parentThreadGroup = rootThreadGroup.getParent();
        }
        int threadCount = rootThreadGroup.activeCount();
        Thread[] threads = new Thread[threadCount];
        rootThreadGroup.enumerate(threads);
        return threads;
    }

    /**
     * 获取根线程组
     */
    private static ThreadGroup getRootThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }

    /**
     * 获取线程占用的内存
     */
    private static String getMemoryUsage(long threadId) {
        SystemInfo systemInfo = new SystemInfo();

        OperatingSystem os = systemInfo.getOperatingSystem();
        OSProcess process = os.getProcess((int)threadId);

        return "10" ; // Arith.convertFileSize(process.getResidentSetSize());
    }

    public static JVMDto getJVMInfo() {
        JVMDto jvmDto = new JVMDto();

        // 获取 JVM 内存信息
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long usedMemory = totalMemory - runtime.freeMemory();
        long maxMemory = runtime.maxMemory();

        jvmDto.setJvmTotalMemory(Arith.convertFileSize(totalMemory));
        jvmDto.setJvmUsedMemory(Arith.convertFileSize(usedMemory));
        jvmDto.setJvmRemainingMemory(Arith.convertFileSize(maxMemory - usedMemory));
        jvmDto.setJvmMemoryUsage(Arith.mul(Arith.div(usedMemory, maxMemory, 4), 100));

        // 获取 Java 版本信息
        String javaVersion = System.getProperty("java.version");
        jvmDto.setJavaVersion(javaVersion);

        // 获取 Java 运行时环境
        String javaRuntime = System.getProperty("java.runtime.name");
        jvmDto.setJavaRuntime(javaRuntime);

        return jvmDto;
    }

}
