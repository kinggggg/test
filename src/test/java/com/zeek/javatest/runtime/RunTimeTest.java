package com.zeek.javatest.runtime;

import org.apache.commons.lang3.StringUtils;

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

//        String command = "/usr/bin/split -l 2 log.csv csv-data-" ;
//        executeCommand(command);

//        command = "/usr/bin/touch new.csv" ;
//        executeCommand(command);

//        command = "/bin/cat csv-data-aa" ;
//        String [] cmd={"/bin/cat","csv-data-a*",">>", "new.csv"};
//        executeCommand(cmd);

        /*
         *
         *  /bin/mkdir
         *  /usr/bin/split
         *  /bin/cat
         *  /bin/ls
         *
         *  linux:
         *  /bin/touch
         *  /bin/sed
         *
         *  mac:
         *  /usr/bin/touch
         *  /usr/bin/sed
         *
         *
         *
         *
         *
         **/

        String [] command = new String[]{"/bin/bash", "-c", "/usr/bin/split -l 2 log.csv csv-data-"};
        executeCommand(command);

        command = new String[]{"/bin/bash", "-c", "/bin/ls csv-data-*"};
        String fileNames = executeCommand(command);

        command = new String[]{"/bin/bash", "-c", "/bin/ls csv-data-* | wc -l"};
        executeCommand(command);

        command = new String[]{"/bin/bash", "-c", "/usr/bin/touch new.csv"};
        executeCommand(command);

        command = new String[]{"/bin/bash", "-c", "/bin/cat csv-data-a* >> new.csv"};
        executeCommand(command);


    }

    // 执行命令
    private static String executeCommand(String [] command) {
        System.out.println("执行当前命令为:" + StringUtils.join(command, " "));

        StringBuilder resultIn = new StringBuilder();
        StringBuilder resultError = new StringBuilder();
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
                resultIn.append(line).append('\n');
            }
            while ((line = bufrError.readLine()) != null) {
                resultError.append(line).append('\n');
            }

            System.out.println("标准信息输出为: " + resultIn);
            System.out.println("标准错误输出为: " + bufrError);

            int status = process.waitFor();
            if(status != 0) {
                System.out.println("调用shell命令失败");
            }else {
                System.out.println("调用shell命令成功");
            }

            System.out.println("---------------");

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

        return resultIn.toString();

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
