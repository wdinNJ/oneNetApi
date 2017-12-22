package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.UploadSoftwareBodyReqEntity;
import com.privateOneNetApi.entity.UploadSoftwareReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.UploadSoftwareRequest;
import com.privateOneNetApi.response.UploadSoftwareResponse;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/22
 * @description 上传固件
 */
public class UploadSoftwareTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        UploadSoftwareRequest uploadSoftwareRequest = new UploadSoftwareRequest();
        UploadSoftwareReqEntity uploadSoftwareReqEntity = new UploadSoftwareReqEntity();
        uploadSoftwareReqEntity.setProductId(104018);
        uploadSoftwareReqEntity.setToken("GpFYrITcRH3p0HBomsc5QnCQEMJbNDzUUXUyufbvkZqNikWStfyVZHIjTnIbY0VE");
        uploadSoftwareReqEntity.setVersion("2");
        uploadSoftwareReqEntity.setFileName("upload");
        uploadSoftwareReqEntity.setDescription("test");
        //文件路径
        uploadSoftwareReqEntity.setFilePath("C:\\Users\\liaoyubo\\Desktop\\SDK_2b0f0437-9764-53db-a9af-0978cc54830d_20171113.zip");
        //文件的最大限制大小,以K位单位
        //uploadSoftwareReqEntity.setMaxFileSize(15*1024);
        uploadSoftwareRequest.setUploadSoftwareReqEntity(uploadSoftwareReqEntity);

        //uploadSoftwareRequest.setFilePath("C:\\Users\\liaoyubo\\Desktop\\SDK_2b0f0437-9764-53db-a9af-0978cc54830d_20171113.zip");

        /*File file = new File("C:\\Users\\liaoyubo\\Desktop\\SDK_2b0f0437-9764-53db-a9af-0978cc54830d_20171113.zip");

        if(!file.exists() || !file.isFile()){
            throw new OneNetException("文件不存在或不是文件");
        }

        long fileSize = file.length();
        //1M=1024k=1048576字节
        if(fileSize > 15 * 1048576){
            throw new OneNetException("文件不能超过15M");
        }

        byte[] uploadFileBytes = new byte[(int)fileSize];
        InputStream is = new FileInputStream(file);
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        byte[] bb = new byte[2048];
        int ch;
        ch = is.read(bb);
        while (ch != -1) {
            bytestream.write(bb, 0, ch);
            ch = is.read(bb);
        }
        uploadFileBytes = bytestream.toByteArray();
        UploadSoftwareBodyReqEntity uploadSoftwareBodyReqEntity = new UploadSoftwareBodyReqEntity();
        uploadSoftwareBodyReqEntity.setName(uploadFileBytes);
        uploadSoftwareRequest.setEntity(uploadSoftwareBodyReqEntity);*/

        UploadSoftwareResponse uploadSoftwareResponse = oneNetClient.execute(uploadSoftwareRequest);

        if(uploadSoftwareResponse.getErrno() != 0){
            System.out.println("上传固件失败:" + uploadSoftwareResponse.getErrno() + uploadSoftwareResponse.getError());
        }else {
            System.out.println("上传固件成功");
        }


        //连接参数设定
        /*String BOUNDARY = java.util.UUID.randomUUID().toString();
        String PREFIX = "--", LINEND = "\r\n";
        String MULTIPART_FROM_DATA = "multipart/form-data";
        String CHARSET = "UTF-8";
        URL uri = new URL("http://api.heclouds.com/pp/software");//据实填写
        HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
        conn.setReadTimeout(5 * 1000); // 缓存的最长时间
        conn.setDoInput(true);// 允许输入
        conn.setDoOutput(true);// 允许输出
        conn.setUseCaches(false); // 不允许使用缓存
        conn.setRequestMethod("POST");
        conn.setRequestProperty("connection", "keep-alive");
        conn.setRequestProperty("Charsert", "UTF-8");
        conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA + ";boundary=" + BOUNDARY);
        *//** -------组拼参数数据-----------**//*
        Map<String, String> params = new HashMap<>();
        params.put("version","5");//据实填写
        params.put("file_name","upload1");//据实填写
        params.put("description","uploadTest");//据实填写
        params.put("token","wQHzCNDGZ5QOkv0tbPVkrzTJY6ld9ML5XkO30yrgCssdUIIIYqAoUIG5v85b2aGR");//据实填写
        params.put("product_id","104018");//据实填写
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet())
        {
            sb.append(PREFIX);
            sb.append(BOUNDARY);
            sb.append(LINEND);
            sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + LINEND);
            sb.append("Content-Type: text/plain; charset=" + CHARSET + LINEND);
            sb.append("Content-Transfer-Encoding: 8bit" + LINEND);
            sb.append(LINEND);
            sb.append(entry.getValue());
            sb.append(LINEND);
        }
        DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
        outStream.write(sb.toString().getBytes());
        *//** -------组拼文件数据-----------**//*
        File file = new File("C:\\Users\\liaoyubo\\Desktop\\SDK_2b0f0437-9764-53db-a9af-0978cc54830d_20171113.zip");
        StringBuilder sb1 = new StringBuilder();
        sb1.append(PREFIX);
        sb1.append(BOUNDARY);
        sb1.append(LINEND);
        // name是post中传参的键 filename是文件的名称
        sb1.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"" + LINEND);
        sb1.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINEND);
        sb1.append(LINEND);
        outStream.write(sb1.toString().getBytes());
        InputStream is = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1)
        {
            outStream.write(buffer, 0, len);
        }
        is.close();
        outStream.write(LINEND.getBytes());
        //结束标志
        byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINEND).getBytes();
        outStream.write(end_data);
        outStream.flush();
        *//**------ 发送请求---------*********//*
        InputStream in;
        int res = conn.getResponseCode();
        if (res == 200)
        {
            in = conn.getInputStream();
            int ch;
            StringBuilder sb2 = new StringBuilder();
            while ((ch = in.read()) != -1)
            {
                sb2.append((char) ch);
            }
            System.out.print(sb2.toString());
        }
        outStream.close();
        conn.disconnect();*/

    }

}
