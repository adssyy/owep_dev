package com.kclm.owep.utils.util;

import com.kclm.owep.entity.DbCopy;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackUpSqlUtil {


    /**
     * 备份数据库到指定路径
     *
     * @param hostIP ip地址，可以是本机也可以是远程
     * @param userName 数据库的用户名
     * @param password 数据库的密码
     * @param savePath 备份的路径
     * @param databaseName 需要备份的数据库的名称
     * @return 备份的结果，包括备份的文件名、路径以及备份是否成功
     * @throws IOException 如果备份失败，抛出IOException异常
     */
    public static DbCopy backUpSql(String hostIP,String userName,String password,String savePath,String databaseName) throws IOException {
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }
        // 备份时的文件名
        // 创建一个DateTimeFormatter，定义时间的格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        // 获取当前的日期时间并格式化
        String currentTime = LocalDateTime.now().format(formatter);
        // 拼接文件名
        String fileName = "backup_" + databaseName + "_" + currentTime + ".sql";

        DbCopy dbCopy = new DbCopy();
        dbCopy.setFileName(fileName);
        dbCopy.setFilePath(savePath);

        // 拼接mysqldump的完整路径（假设这是你的mysqldump安装路径）
        String mysqldumpPath = "D:\\Mysql\\mysql-8.1.0-winx64\\bin\\mysqldump";

//        // 拼接命令
//        StringBuilder sql = new StringBuilder();
//        sql.append(mysqldumpPath).append(" -h").append(hostIP)
//                .append(" -u").append(userName).append(" -p").append(password).append(" ")
//                .append(databaseName).append(" > ").append(savePath + fileName);
        // 执行备份命令
        try {
//            System.out.println("执行命令====================》》》》》" + sql.toString());
//            Process process = Runtime.getRuntime().exec(sql.toString());

            System.out.println("执行命令==========》》》》》" + mysqldumpPath + " -h" + hostIP + " -u" + userName
                    + " --password=" + password + " " + databaseName + " > " + savePath + fileName);
            // 使用 ProcessBuilder 来设置输出重定向
            ProcessBuilder processBuilder = new ProcessBuilder(
                    mysqldumpPath, "-h" + hostIP, "-u" + userName, "--password=" + password,
                    databaseName
            );
            processBuilder.redirectOutput(new File(savePath + fileName));
            Process process = processBuilder.start();
            // 等待命令行执行完成
            int exitCode = process.waitFor();
            if(exitCode == 0){
                dbCopy.setStatus(true);
                return dbCopy;
            }else{
                dbCopy.setStatus(false);
                return dbCopy;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("InterruptedException备份失败");
        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("IOException备份失败");
        }
    }


    /**
     * 删除指定路径下的备份文件
     *
     * @param fileName 要删除的文件名
     * @param savePath 文件保存的路径
     * @return 如果文件存在并且删除成功，返回true；否则返回false
     * @throws IOException 如果在删除过程中发生IO异常，则抛出该异常
     */
    public static boolean deleteBackupFile(String savePath, String fileName) throws IOException {
        // 文件路径
        File file = new File(savePath, fileName);
        // 检查文件是否存在
        if (file.exists()) {
            // 删除文件
            boolean success = file.delete();
            if (success) {
                return true;
            } else {
                System.err.println("删除文件失败: " + file.getAbsolutePath());
                return false;
            }
        } else {
            System.out.println("文件不存在: " + file.getAbsolutePath());
            return false;
        }
    }
}
