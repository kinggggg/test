package com.zeek.javatest.runtime;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RunTimeTest
 * @Description
 * @Author liweibo
 * @Date 2019/5/9 10:55 AM
 * @Version v1.0
 **/
public class RunTimeTest {

    public static void main(String[] args) {

        String command = "/usr/bin/split -l 2 log.csv csv-data-" ;

        StringBuilder result = new StringBuilder();
        BufferedReader bufrIn = null;
        BufferedReader bufrError = null;
        Process process = null;

        try {
            process = Runtime.getRuntime().exec(command);

            bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
            // 读取输出
            String line = null;
            while ((line = bufrIn.readLine()) != null) {
                result.append(line).append('\n');
            }
            while ((line = bufrError.readLine()) != null) {
                result.append(line).append('\n');
            }

            System.out.println(result);

            int status = process.waitFor();
            if(status != 0) {
                System.out.println("调用shell命令失败");
            }else {
                System.out.println("调用shell命令成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeStream(bufrIn);
            closeStream(bufrError);

            // 销毁子进程
            if (process != null) {
                process.destroy();
            }
        }


    }

    private static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                // nothing
            }
        }
    }
}
