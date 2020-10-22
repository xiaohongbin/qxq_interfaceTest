package QXQ.Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ReadExcel {
    public String readdata(int rownum, int cellnum) {
        try {
            // 指定excel的路径
            File src = new File(".\\datafile\\qxqInterface.xlsx");
            // 加载文件
            FileInputStream fis = new FileInputStream(src);
            // 加载workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            //加载PLP sheet
            XSSFSheet sh1 = wb.getSheetAt(0);

            // 读取指定行列数据(rownum-1,cellnum-1）
            String data1 = sh1.getRow(rownum - 1).getCell(cellnum - 1).getStringCellValue();

//			//写入excel数据
            sh1.getRow(rownum - 1).createCell(cellnum + 1).setCellValue("Pass");
//			// 保存文件(同一个文件名);结果另存为文件(不同的文件名)
            FileOutputStream fout = new FileOutputStream(new File(".\\datafile\\huluInterfaceStatus.xlsx"));
//			//覆盖写入内容
            wb.write(fout);
//			// 关闭文件
            wb.close();
            return data1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 已将 表格数值类型转换成 string类型
     *
     * @param rownum
     * @param cellnum
     * @return
     */
    public String read1(int rownum, int cellnum) {
        try {
            // 指定excel的路径
            File src = new File(".\\datafile\\hulu.xlsx");
            // 加载文件
            FileInputStream fis = new FileInputStream(src);
            // 加载workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            //加载PLP sheet
            XSSFSheet sh1 = wb.getSheetAt(0);

            // 读取指定行列数据(rownum-1,cellnum-1）
            String data1 = sh1.getRow(rownum - 1).getCell(cellnum - 1).getRawValue();
            String str = data1.replaceAll("\\p{Punct}", "");
            String str1 = str.replaceAll("[A-Za-z]+", "");
            String str2 = str1.substring(0, str1.length() - 1);


//			//写入excel数据
         /*   sh1.getRow(rownum - 1).createCell(cellnum + 1).setCellValue("Pass");
//			// 保存文件(同一个文件名);结果另存为文件(不同的文件名)
            FileOutputStream fout = new FileOutputStream(src);
//			//覆盖写入内容
            wb.write(fout);
//			// 关闭文件
            wb.close();*/
            return str2;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 返回类型为 String 类型
     *
     * @param rownum
     * @param cellnum
     * @return
     */
    public String read2(int rownum, int cellnum) {
        try {
            // 指定excel的路径
            File src = new File(".\\datafile\\hulu.xlsx");
            // 加载文件
            FileInputStream fis = new FileInputStream(src);
            // 加载workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            //加载PLP sheet
            XSSFSheet sh1 = wb.getSheetAt(0);

            // 读取指定行列数据(rownum-1,cellnum-1）
            String data1 = sh1.getRow(rownum - 1).getCell(cellnum - 1).getStringCellValue();

//			//写入excel数据
            /*sh1.getRow(rownum - 1).createCell(cellnum + 1).setCellValue("Pass");*/
//			// 保存文件(同一个文件名);结果另存为文件(不同的文件名)
         /*   FileOutputStream fout = new FileOutputStream(src);
//			//覆盖写入内容
            wb.write(fout);
//			// 关闭文件
            wb.close();*/
            return data1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 读取账号信息
     *
     * @param rownum
     * @param cellnum
     * @return
     */
    public String readLoginInformation(int rownum, int cellnum) {
        try {
            // 指定excel的路径
            File src = new File(".\\datafile\\hulu.xlsx");
            // 加载文件
            FileInputStream fis = new FileInputStream(src);
            // 加载workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            //加载 sheet
            XSSFSheet sh1 = wb.getSheetAt(0);

            // 读取指定行列数据(rownum-1,cellnum-1）
            String data1 = sh1.getRow(rownum - 1).getCell(cellnum - 1).getStringCellValue();


//			//写入excel数据
//            sh1.getRow(rownum-1).createCell(cellnum+1).setCellValue("Pass");
//			// 保存文件(同一个文件名);结果另存为文件(不同的文件名)
           /* FileOutputStream fout = new FileOutputStream(new File(".\\datafile\\hulu.xlsx"));
//			//覆盖写入内容
            wb.write(fout);
//			// 关闭文件
            wb.close();*/
            return data1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 写入
     *
     * @param rownum     行
     * @param cellnum    列
     * @param totalCount 信的数量
     */
    public void setPass(int rownum, int cellnum, int totalCount) {
        try {
            // 指定excel的路径
            File src = new File(".\\datafile\\hulu.xlsx");
            // 加载文件
            FileInputStream fis = new FileInputStream(src);
            // 加载workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            //加载PLP sheet
            XSSFSheet sh1 = wb.getSheetAt(0);
//
//            // 读取指定行列数据(rownum-1,cellnum-1）
//            String data1=sh1.getRow(rownum-1).getCell(cellnum-1).getStringCellValue();

//			//写入excel数据
            sh1.getRow(rownum - 1).createCell(cellnum - 1).setCellValue(totalCount);

//			// 保存文件(同一个文件名);结果另存为文件(不同的文件名)
            FileOutputStream fout = new FileOutputStream(src);
//			//覆盖写入内容
            wb.write(fout);
//			// 关闭文件
            wb.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 写入
     *
     * @param rownum  行
     * @param cellnum 列
     * @param Zero    O/1 判断数值
     */
    public void setPassZero(int rownum, int cellnum, int Zero) {
        try {
            // 指定excel的路径
            File src = new File(".\\datafile\\hulu.xlsx");
            // 加载文件
            FileInputStream fis = new FileInputStream(src);
            // 加载workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            //加载PLP sheet
            XSSFSheet sh1 = wb.getSheetAt(0);
//
//            // 读取指定行列数据(rownum-1,cellnum-1）
//            String data1=sh1.getRow(rownum-1).getCell(cellnum-1).getStringCellValue();

//			//写入excel数据
            sh1.getRow(rownum - 1).createCell(cellnum + 7).setCellValue(Zero);

//			// 保存文件(同一个文件名);结果另存为文件(不同的文件名)
            FileOutputStream fout = new FileOutputStream(src);
//			//覆盖写入内容
            wb.write(fout);
//			// 关闭文件
            wb.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 写入信息
     *
     * @param rownum    行
     * @param cellnum   列
     * @param account   账号
     * @param password  密码
     * @param SessionId session
     * @param token     token
     * @param time      时间
     */
    public void setPass(int rownum, int cellnum, String account, String password, String SessionId, String token, int time, String qudao) {
        try {
            // 指定excel的路径
            File src = new File(".\\datafile\\hulu.xlsx");
            // 加载文件
            FileInputStream fis = new FileInputStream(src);
            // 加载workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            //加载PLP sheet
            XSSFSheet sh1 = wb.getSheetAt(0);

//            // 读取指定行列数据(rownum-1,cellnum-1）
//            String data1=sh1.getRow(rownum-1).getCell(cellnum-1).getStringCellValue();

//			//写入excel数据                                   cellnum ：列的下标从0开始
            sh1.getRow(rownum - 1).createCell(cellnum).setCellValue(account);
            sh1.getRow(rownum - 1).createCell(cellnum + 1).setCellValue(password);
            sh1.getRow(rownum - 1).createCell(cellnum + 3).setCellValue(SessionId);
            sh1.getRow(rownum - 1).createCell(cellnum + 4).setCellValue(token);
            sh1.getRow(rownum - 1).createCell(cellnum + 5).setCellValue(time);
            sh1.getRow(rownum - 1).createCell(cellnum + 6).setCellValue(qudao);
//			// 保存文件(同一个文件名);结果另存为文件(不同的文件名)
            FileOutputStream fout = new FileOutputStream(src);
//			//覆盖写入内容
            wb.write(fout);
//			// 关闭文件
            wb.close();
        } catch (Exception e) {
            System.out.println("setPass:" + e.getMessage());
        }
    }

    public void setPass(int rownum, int cellnum) {
        try {
            // 指定excel的路径
            File src = new File(".\\datafile\\huluInterface.xlsx");
            // 加载文件
            FileInputStream fis = new FileInputStream(src);
            // 加载workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            //加载PLP sheet
            XSSFSheet sh1 = wb.getSheetAt(0);
//
//            // 读取指定行列数据(rownum-1,cellnum-1）
//            String data1=sh1.getRow(rownum-1).getCell(cellnum-1).getStringCellValue();

//			//写入excel数据
            sh1.getRow(rownum - 1).createCell(cellnum + 1).setCellValue("pass");
//			// 保存文件(同一个文件名);结果另存为文件(不同的文件名)
            FileOutputStream fout = new FileOutputStream(new File(".\\datafile\\huluInterfaceStatus.xlsx"));
//			//覆盖写入内容
            wb.write(fout);
//			// 关闭文件
            wb.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void WriteData(int rownum, int cellnum, String num)  {
         try {
        // 指定excel的路径
        File src = new File(".\\datafile\\hulu.xlsx");
        // 加载文件
        FileInputStream fis = new FileInputStream(src);
        // 加载workbook
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        //加载PLP sheet
        XSSFSheet sh1 = wb.getSheetAt(1);

            // 读取指定行列数据(rownum-1,cellnum-1）
            String data1=sh1.getRow(rownum-1).getCell(cellnum).getStringCellValue();

//			//写入excel数据                                   cellnum ：列的下标从0开始
        sh1.getRow(rownum - 1).createCell(cellnum).setCellValue(num);
//			// 保存文件(同一个文件名);结果另存为文件(不同的文件名)
        FileOutputStream fout = new FileOutputStream(src);
//			//覆盖写入内容
        wb.write(fout);
//			// 关闭文件
        wb.close();
        } catch (Exception e) {
            System.out.println("WriteData"+e.getMessage());
        }
    }


    public void setFail(int rownum, int cellnum) {
        try {
            // 指定excel的路径
            File src = new File(".\\datafile\\huluInterface.xlsx");
            // 加载文件
            FileInputStream fis = new FileInputStream(src);
            // 加载workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            //加载PLP sheet
            XSSFSheet sh1 = wb.getSheetAt(0);
//
//            // 读取指定行列数据(rownum-1,cellnum-1）
//            String data1=sh1.getRow(rownum-1).getCell(cellnum-1).getStringCellValue();

//			//写入excel数据
            sh1.getRow(rownum - 1).createCell(cellnum + 1).setCellValue("Fail");
//			// 保存文件(同一个文件名);结果另存为文件(不同的文件名)
            FileOutputStream fout = new FileOutputStream(new File(".\\datafile\\huluInterfaceStatus.xlsx"));
//			//覆盖写入内容
            wb.write(fout);
//			// 关闭文件
            wb.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
