package com.gaofei.poi;

import com.gaofei.dto.PersonDetailDTO;
import com.gaofei.persist.dao.PeopleDetailMapper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GaoQingming on 2018/3/1 0001.
 *
 * poi官网使用案例
 * https://poi.apache.org/spreadsheet/quick-guide.html#ReadWriteWorkbook
 */
@Service
public class PoiServiceImpl {
    private final int nameIndex = 0;
    private final int ctfIdIndex = 4;
    private final int genderIndex = 5;
    private final int addressIndex = 7;
    private final int provinceIdIndex = 12;
    private final int districtIndex = 13;
    private final int mobileIndex = 19;
    private final int telIndex = 20;
    private final int eMailIndex = 22;
    private final int companyIndex = 26;
    private final int idIndex = 32;


    @Autowired
    private PeopleDetailMapper peopleDetailMapper;
    DataFormatter formatter = new DataFormatter();

    public static void main(String[] args) {
    }

    public void loadPoiTest() {
        Workbook wb = getWorkBook();
        Sheet sheet1 = wb.getSheetAt(0);

        int begin = sheet1.getFirstRowNum();
        int end = sheet1.getLastRowNum();
        for (int rowNum = begin + 1; rowNum<=end; rowNum++) {

            Row row = sheet1.getRow(rowNum);
            if (row == null) continue;
            PersonDetailDTO person = null;
            try {
                person = getPerson(row);
            } catch (IllegalDataException e) {
                continue;
            }
            System.out.println(person.toString());
        }
    }

    public void loadPoi() {
        Workbook wb = getWorkBook();
        Sheet sheet1 = wb.getSheetAt(0);

        int begin = sheet1.getFirstRowNum();
        int end = sheet1.getLastRowNum();
        List<PersonDetailDTO> personDetailDTOList = new LinkedList<PersonDetailDTO>();
        for (int rowNum = begin + 1; rowNum<=end; rowNum++) {
            if (personDetailDTOList.size() == 100) {
                peopleDetailMapper.saveDetails(personDetailDTOList);
                personDetailDTOList = new LinkedList<PersonDetailDTO>();
            }

            Row row = sheet1.getRow(rowNum);
            if (row == null) continue;
            PersonDetailDTO person = null;
            try {
                person = getPerson(row);
            } catch (IllegalDataException e) {
                continue;
            }

            personDetailDTOList.add(person);
        }
        peopleDetailMapper.saveDetails(personDetailDTOList);
    }

    private PersonDetailDTO getPerson(Row row) {
        PersonDetailDTO person = new PersonDetailDTO();
        person.setId(getCellLongNumber(idIndex,row));
        person.setAddress(getAddressString(addressIndex,row));
        person.setCtfId(getCtfId(ctfIdIndex,row));
        person.setBirthday(getBirthdayFromId(person.getCtfId()));
        person.setCompany(getCellString(companyIndex,row));
        person.setDistrictId(getCellNumber(districtIndex,row));
        person.seteMail(getCellString(eMailIndex,row));
        person.setGender(getCellString(genderIndex,row));
        person.setMobile(getCellString(mobileIndex,row));
        person.setName(getCellNameString(nameIndex,row));
        person.setProvinceId(getCellNumber(provinceIdIndex,row));
        person.setTel(getCellString(telIndex,row));

        checkTelephone(person);
        System.out.println(person.getId());
        return person;
    }

    private String getCellNameString(int index, Row row) {
        String text = getCellString(index,row);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(text) && text.length() > 16) {
            throw new IllegalDataException("名称过长");
        }
        return text;
    }

    private void checkTelephone(PersonDetailDTO person) {
        if (isTelephone(person.getTel()) || isTelephone(person.getMobile())) {
            //如果其中一个不合法，设置为空
            if (!isTelephone(person.getTel())) {
                person.setTel("");
            }
            if (!isTelephone(person.getMobile())) {
                person.setMobile("");
            }
        } else {
            throw new IllegalDataException("手机号不合法");
        }
    }

    private boolean isTelephone(String tel) {
        return org.apache.commons.lang3.StringUtils.isNotBlank(tel) && tel.length() == 11;
    }

    private String getAddressString(int index, Row row) {
        String text = getCellString(index,row);
        if (StringUtils.isEmpty(text)) {
            return "";
        }
        return text;
    }

    private long getCellLongNumber(int index, Row row) {
        String text = getCellString(index,row);
        try {
            return Long.parseLong(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int getCellNumber(int index, Row row) {
        String text = getCellString(index,row);
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String getCtfId(int ctfIdIndex, Row row) {
        String ctfId = getCellString(ctfIdIndex,row);
        if (org.apache.commons.lang3.StringUtils.isBlank(ctfId) || ctfId.length() != 18) {
            throw new IllegalDataException("身份证id错误");
        }
        return ctfId;
    }

    private String getBirthdayFromId(String ctfId) {
        return ctfId.substring(6,14);
    }

    private String getCellString(int index, Row row) {
        Cell cell = row.getCell(index);
        return formatter.formatCellValue(cell);
    }

    private Workbook getWorkBook() {
        File file = new File("D:\\testFile\\1-200W.xls");
        //try {
        //    inp = new FileInputStream("D:\\testFile\\last5000.csv");
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        //InputStream inp = new FileInputStream("workbook.xlsx");

        Workbook wb = null;
        try {
            //wb = WorkbookFactory.create(inp);
            wb = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return wb;
    }


}
