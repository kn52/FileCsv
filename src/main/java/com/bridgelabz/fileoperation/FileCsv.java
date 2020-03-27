package com.bridgelabz.fileoperation;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.opencsv.*;
import com.opencsv.bean.*;

import java.io.*;

public class FileCsv {


    public static void main(String[] args) {
        FileCsv fc=new FileCsv();
        fc.readCSV1();
        fc.readCSV2();
        fc.readCSV3();
        fc.readCSV4();
        fc.readCSV5();
        fc.readCSVPojo0();
        fc.readCSVPojo1();
        fc.readCSVPojo2();
        fc.csvWriter0();
        fc.csvWriter1();
    }

    private void csvWriter1() {
        File file=new File("D:\\AAA\\IdeaProjects\\FileOperation\\userDemo.csv");
        try(FileWriter writer=new FileWriter(file);){
            CSVWriter csvWriter=new CSVWriter(writer);
            String[] str={"Name","Class","Marks"};
            csvWriter.writeNext(str);
            String[] data = { "Aman", "10", "620" };
            csvWriter.writeNext(data);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void csvWriter0() {
        {
            String filePath="D:\\AAA\\IdeaProjects\\FileOperation\\userDemo.csv";

            try(Writer writer = Files.newBufferedWriter(Paths.get(filePath));){
                StatefulBeanToCsv<ColumnMapping> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                        .build();
                List<ColumnMapping> list=new ArrayList<>();
                String[] columnMap={"name","email","phone","country"};
                //list.add(new ColumnMapping("Sundar Pichai ♥", "sundar.pichai@gmail.com", "+1-1111111111", "India"));
                list.add(new ColumnMapping("Sat della", "satya.nadella@outlook.com", "+1-1111111112", "India"));

                beanToCsv.write(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void readCSVPojo2() {
        {
            String filePath="D:\\AAA\\IdeaProjects\\FileOperation\\userHeader0.csv";

            try (Reader fileName = Files.newBufferedReader(Paths.get(filePath));){
                ColumnPositionMappingStrategy stat=new ColumnPositionMappingStrategy();
                stat.setType(ColumnMapping.class);
                String[] columnMap={"name","email","phone","country"};
                stat.setColumnMapping(columnMap);
                CsvToBean<ColumnMapping> csvbean=new CsvToBeanBuilder(fileName)
                        .withMappingStrategy(stat)
                        .withSkipLines(1)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                Iterator<ColumnMapping> csvUser=csvbean.iterator();
                while (csvUser.hasNext()) {
                    ColumnMapping csv = csvUser.next();
                    System.out.println("Name : " + csv.getName());
                    System.out.println("Email : " + csv.getEmail());
                    System.out.println("PhoneNo : " + csv.getPhoneNo());
                    System.out.println("Country : " + csv.getCountry());
                    System.out.println("==========================");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void readCSVPojo1() {
        {
            String filePath="D:\\AAA\\IdeaProjects\\FileOperation\\user.csv";

            try (Reader fileName = Files.newBufferedReader(Paths.get(filePath));){

                CsvToBean<CsvUser1> csvbean=new CsvToBeanBuilder(fileName)
                        .withType(CsvUser1.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                Iterator<CsvUser1> csvUser=csvbean.iterator();
                while (csvUser.hasNext()) {
                    CsvUser1 csv = csvUser.next();
                    System.out.println("Name : " + csv.name);
                    System.out.println("Email : " + csv.email);
                    System.out.println("PhoneNo : " + csv.phoneNo);
                    System.out.println("Country : " + csv.country);
                    System.out.println("==========================");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void readCSVPojo0() {

        {
            String filePath="D:\\AAA\\IdeaProjects\\FileOperation\\userHeader0.csv";

            try (Reader fileName = Files.newBufferedReader(Paths.get(filePath));){

                CsvToBean<CsvUser0> csvbean=new CsvToBeanBuilder(fileName)
                        .withType(CsvUser0.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                Iterator<CsvUser0> csvUser=csvbean.iterator();
                while (csvUser.hasNext()) {
                    CsvUser0 csv = csvUser.next();
                    System.out.println("Name : " + csv.name);
                    System.out.println("Email : " + csv.email);
                    System.out.println("PhoneNo : " + csv.phoneNo);
                    System.out.println("Country : " + csv.country);
                    System.out.println("==========================");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void readCSV5() {
        FileReader file;

        {
            try {
                file = new FileReader("D:\\AAA\\IdeaProjects\\FileOperation\\Insurance.csv");
                CSVParser parser=new CSVParserBuilder().withSeparator(',').build();
                CSVReader reader=new CSVReaderBuilder(file).withCSVParser(parser).build();
                List<String[]> line=reader.readAll();
                for (String[] str : line){
                    System.out.print(str + " ");
                }
                System.out.println();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readCSV4() {
        FileReader file;

        {
            try {
                file = new FileReader("D:\\AAA\\IdeaProjects\\FileOperation\\Insurance.csv");
                CSVReader reader=new CSVReaderBuilder(file).withSkipLines(1).build();
                List<String[]> line=reader.readAll();
                for (String[] str : line){
                    System.out.print(str + " ");
                }
                System.out.println();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readCSV3() {
        FileReader file;

        {
            try {
                file = new FileReader("D:\\AAA\\IdeaProjects\\FileOperation\\Insurance.csv");
                CSVReader reader=new CSVReader(file);
                List<String[]> line=reader.readAll();
                for (String[] str : line){
                    System.out.print(str + " ");
                }
                System.out.println();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readCSV2(){
        FileReader file;

        {
            try {
                String filePath="D:\\AAA\\IdeaProjects\\FileOperation\\Insurance.csv";
                Reader fileName = Files.newBufferedReader(Paths.get(filePath));
                CSVReader reader=new CSVReader(fileName);
                String []line;
                while ((line=reader.readNext()) !=null){
                    for (String str : line){
                        System.out.print(str + " ");
                    }
                    System.out.println();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readCSV1(){
        FileReader file;

        {
            try {
                file = new FileReader("D:\\AAA\\IdeaProjects\\FileOperation\\Insurance.csv");
                CSVReader reader=new CSVReader(file);
                String []line;
                while ((line=reader.readNext()) !=null){
                    for (String str : line){
                        System.out.print(str + " ");
                    }
                    System.out.println();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
