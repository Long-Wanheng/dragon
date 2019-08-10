package com.dragon.common.config;

import com.dragon.model.entity.SeleniumCloudMusicUser;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-11 00:10
 * @Description: ${Description}
 */
@Configuration
public class ExcelConfig {
    private void write(OutputStream outputStream, List<SeleniumCloudMusicUser> userList) throws SQLException {
        //初始一个workbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建单个sheet
        HSSFSheet sheet = workbook.createSheet("sheet0");
        //创建多行
        //创建第一行，设置列名
        HSSFRow row0 = sheet.createRow(0);
        for (int cellIndex = 0; cellIndex < 3; cellIndex++) {
            HSSFCell cell = row0.createCell(cellIndex);
            switch (cellIndex) {
                case 0:
                    cell.setCellValue("URL");
                    //调整第一列宽度
                    sheet.autoSizeColumn((short)0);
                    break;
                case 1:
                    cell.setCellValue("昵称");
                    //调整第二列宽度
                    sheet.autoSizeColumn((short)1);
                    break;
                case 2:
                    cell.setCellValue("用户id");
                    //调整第三列宽度
                    sheet.autoSizeColumn((short)2);
                    break;
                default:
                    break;
            }
        }
        //创建剩余行
        for (int rowIndex = 1; rowIndex <= userList.size(); rowIndex++) {
            HSSFRow row = sheet.createRow(rowIndex);
            SeleniumCloudMusicUser user = userList.get(rowIndex - 1);
            //创建多列
            for (int cellIndex = 0; cellIndex < 8; cellIndex++) {
                HSSFCell cell = row.createCell(cellIndex);
                switch (cellIndex) {
                    case 0:
                        cell.setCellValue(user.getUserUrl());
                        break;
                    case 1:
                        cell.setCellValue(user.getMusicNickName());
                        break;
                    case 2:
                        cell.setCellValue(user.getMusicId());
                        break;
                    default:
                        break;
                }
            }
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String writeExcel(List<SeleniumCloudMusicUser> users, String excelName) {
        OutputStream out = null;
        String path = "E:\\userExcel\\" + excelName + ".xls";
        try {
            out = new FileOutputStream(new File(path));
            write(out, users);
            return path;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}