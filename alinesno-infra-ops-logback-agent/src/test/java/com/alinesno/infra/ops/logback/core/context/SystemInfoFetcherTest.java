package com.alinesno.infra.ops.logback.core.context;

import com.alinesno.infra.ops.logback.core.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SystemInfoFetcherTest {

    @Test
    public void testGetCPUDetails() throws InterruptedException {
        CPUDto cpuDto = SystemInfoFetcher.getCPUDetails();

        // Assert CPU details
        Assertions.assertNotNull(cpuDto);
        Assertions.assertTrue(cpuDto.getCpuCores() > 0);
        Assertions.assertTrue(cpuDto.getCpuSystemUsage() >= 0 && cpuDto.getCpuSystemUsage() <= 1);
        Assertions.assertTrue(cpuDto.getCpuUserUsage() >= 0 && cpuDto.getCpuUserUsage() <= 1);
        Assertions.assertTrue(cpuDto.getCpuWaitRate() >= 0 && cpuDto.getCpuWaitRate() <= 1);
        Assertions.assertTrue(cpuDto.getCpuCurrentUsage() >= 0 && cpuDto.getCpuCurrentUsage() <= 100);
    }

    @Test
    public void testGetMemoryDetails() {
        MemDto memDto = SystemInfoFetcher.getMemoryDetails();

        // Assert memory details
        Assertions.assertNotNull(memDto);
        Assertions.assertNotNull(memDto.getTotalMemory());
        Assertions.assertNotNull(memDto.getUsedMemory());
        Assertions.assertNotNull(memDto.getRemainingMemory());
        Assertions.assertTrue(memDto.getMemoryUsage() >= 0 && memDto.getMemoryUsage() <= 100);
    }

    @Test
    public void testGetOperatingSystemDetails() {
        OsDto osDto = SystemInfoFetcher.getOperatingSystemDetails();

        // Assert operating system details
        Assertions.assertNotNull(osDto);
        Assertions.assertNotNull(osDto.getOperatingSystemName());
        Assertions.assertNotNull(osDto.getSystemArchitecture());
        Assertions.assertNotNull(osDto.getCpu());
        Assertions.assertNotNull(osDto.getDisk());
        Assertions.assertNotNull(osDto.getMemory());
    }

    @Test
    public void testGetThreadInfo() {
        List<ThreadDto> threadInfoList = SystemInfoFetcher.getThreadInfo();

        // 断言线程信息列表不为空
        Assertions.assertNotNull(threadInfoList);

        // 断言线程信息列表不为空列表
        Assertions.assertFalse(threadInfoList.isEmpty());

        // 遍历线程信息列表
        for (ThreadDto threadDto : threadInfoList) {
            // 断言线程 ID 不为空
            Assertions.assertNotNull(threadDto.getThreadId());

            // 断言线程名称不为空
            Assertions.assertNotNull(threadDto.getThreadName());

            // 断言线程状态不为空
            Assertions.assertNotNull(threadDto.getThreadStatus());

            // 断言线程内存占用不为空
            Assertions.assertNotNull(threadDto.getMemoryOccupied());
        }
    }

    @Test
    public void testGetJVMInfo() {
        JVMDto jvmInfo = SystemInfoFetcher.getJVMInfo();

        // 断言 JVM 内存信息不为空
        Assertions.assertNotNull(jvmInfo.getJvmTotalMemory());
        Assertions.assertNotNull(jvmInfo.getJvmUsedMemory());
        Assertions.assertNotNull(jvmInfo.getJvmRemainingMemory());
        Assertions.assertNotNull(jvmInfo.getJvmMemoryUsage());

        // 断言 Java 版本信息不为空
        Assertions.assertNotNull(jvmInfo.getJavaVersion());

        // 断言 Java 运行时环境不为空
        Assertions.assertNotNull(jvmInfo.getJavaRuntime());
    }
}
