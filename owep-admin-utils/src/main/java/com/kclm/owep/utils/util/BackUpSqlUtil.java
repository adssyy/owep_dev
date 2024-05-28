package com.kclm.owep.utils.util;

import com.kclm.owep.entity.DbCopy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.*;
//import java.net.http.HttpResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackUpSqlUtil {


    /**
     * 备份数据库到指定路径
     *
     * @param hostIP       ip地址，可以是本机也可以是远程
     * @param userName     数据库的用户名
     * @param password     数据库的密码
     * @param savePath     备份的路径
     * @param databaseName 需要备份的数据库的名称
     * @return 备份的结果，包括备份的文件名、路径以及备份是否成功
     * @throws IOException 如果备份失败，抛出IOException异常
     */
    public static DbCopy backUpSql(String hostIP, String userName, String password, String savePath, String databaseName) throws IOException {
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
            if (exitCode == 0) {
                dbCopy.setStatus(true);
                return dbCopy;
            } else {
                dbCopy.setStatus(false);
                return dbCopy;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("InterruptedException备份失败");
        } catch (IOException e) {
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



    /**
     * 下载数据库备份文件
     *
     * @param savePath 备份文件保存路径
     * @param fileName 备份文件名
     * @param response HTTP响应对象
     * @param request HTTP请求对象
     * @throws IOException 当文件不存在或下载文件失败时抛出异常
     */
    public static void downloadDbCopy(String savePath, String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException {
        try {
            File file = new File(savePath, fileName);
            if (!file.exists()) {
                throw new RuntimeException("文件不存在");
            }
            // 中文乱码解决
            String userAgent = request.getHeader("User-Agent").toLowerCase();
            if (userAgent.contains("firefox") || userAgent.contains("chrome")) {
                fileName = URLEncoder.encode(new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8.name());
            } else {
                fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name());
            }
            // 设置响应的头部信息
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            // 设置响应内容的类型
            response.setContentType(getFileContentType(fileName) + "; charset=" + CHARSET_CODE);
            // 设置响应内容的长度
            response.setContentLengthLong(file.length());
            // 输出
            outStream(new FileInputStream(file), response.getOutputStream());
        } catch (IOException e) {
            throw new IOException("下载文件失败", e); // 封装底层异常，提供更清晰的异常信息
        }

    }


    //
//        try {
//
//            if (file.exists()) {
//                /**
//                 * 中文乱码解决
//                 */
//                String type = request.getHeader("User-Agent").toLowerCase();
//                System.out.println("type:" + type);
//                if (type.indexOf("firefox") > 0 || type.indexOf("chrome") > 0) {
//                    /**
//                     * 谷歌或火狐
//                     */
//                    fileName = new String(fileName.getBytes(charsetCode), "iso8859-1");
//                    fileName = new String(fileName.getBytes(charsetCode), "utf-8");
//                    fileName = URLEncoder.encode(fileName, charsetCode);
//                } else {
//                    /**
//                     * IE
//                     */
//                    fileName = URLEncoder.encode(fileName, charsetCode);
//                }
//                // 设置响应的头部信息
//                response.setHeader("content-disposition", "attachment;filename=" + fileName);
//                // 设置响应内容的类型
//                response.setContentType(getFileContentType(fileName)+"; charset=" + charsetCode);
//                // 设置响应内容的长度
//                response.setContentLength((int) file.length());
//                // 输出
//                outStream(new FileInputStream(file), response.getOutputStream());
//                return 1;
//            }else{
//                throw new RuntimeException("文件不存在");
//            }
//        } catch (Exception e) {
//            System.out.println("执行downloadFile发生了异常：" + e.getMessage());
//            throw new RuntimeException("下载文件失败");
//        }


    // 字符编码格式
//    private static String charsetCode = "utf-8";

    // 字符编码格式，使用标准常量
    private static final String CHARSET_CODE = StandardCharsets.UTF_8.name();

    /**
     * 文件的内容类型
     */
    private static String getFileContentType(String name) {
        String result = "";
        String fileType = name.toLowerCase();
        if (fileType.endsWith(".png")) {
            result = "image/png";
        } else if (fileType.endsWith(".gif")) {
            result = "image/gif";
        } else if (fileType.endsWith(".jpg") || fileType.endsWith(".jpeg")) {
            result = "image/jpeg";
        } else if (fileType.endsWith(".svg")) {
            result = "image/svg+xml";
        } else if (fileType.endsWith(".doc")) {
            result = "application/msword";
        } else if (fileType.endsWith(".xls")) {
            result = "application/x-excel";
        } else if (fileType.endsWith(".zip")) {
            result = "application/zip";
        } else if (fileType.endsWith(".pdf")) {
            result = "application/pdf";
        } else if (fileType.endsWith(".sql")) {
            result = "text/plain";
        } else {
            result = "application/octet-stream";
        }
        return result;
    }

    /**
     * 基础字节数组输出
     */
    private static void outStream(InputStream is, OutputStream os) {
        try {
            byte[] buffer = new byte[10240];
            int length = -1;
            while ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
                os.flush();
            }
        } catch (Exception e) {
            System.out.println("执行 outStream 发生了异常：" + e.getMessage());
        } finally {
            try {
                os.close();
            } catch (IOException e) {
            }
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }


}
