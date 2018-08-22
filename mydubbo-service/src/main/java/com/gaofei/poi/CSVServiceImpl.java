/*
package com.gaofei.poi;

import au.com.bytecode.opencsv.CSVReader;
import com.gaofei.dto.PersonDetailDTO;
import com.gaofei.persist.dao.PeopleDetailMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

*/
/**
 * Created by GaoQingming on 2018/3/1 0001.
 *//*

@Service
public class CSVServiceImpl {
    @Autowired
    private PeopleDetailMapper peopleDetailMapper;
    private final Logger logger = LoggerFactory.getLogger(CSVServiceImpl.class);
    DataFormatter formatter = new DataFormatter();

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

    public static void main(String[] args) {
        new CSVServiceImpl().loadCSVTest();
    }

    public void loadCSV() {
        File file = new File("D:\\testFile\\400W-600W.csv");
        FileReader fReader = null;
        try {
            fReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CSVReader csvReader = new CSVReader(fReader);
        String[] strs = null;
        List<PersonDetailDTO> personDetailDTOList = new LinkedList<PersonDetailDTO>();
        while (true) {

            PersonDetailDTO person = null;
            try {
                strs = csvReader.readNext();

                try {
                    person = getPerson(strs);
                    personDetailDTOList.add(person);
                } catch (IllegalDataException e) {
                    logger.info(e.getMessage());
                    continue;
                } catch (ArrayIndexOutOfBoundsException e) {
                    logger.info("ArrayIndexOutOfBoundsException:" + e.getMessage());
                    continue;
                } catch (NullPointerException e) {
                    try {
                        if (personDetailDTOList.size() > 0) {
                            peopleDetailMapper.saveDetails(personDetailDTOList);
                            personDetailDTOList = new LinkedList<PersonDetailDTO>();
                        }
                    } catch (DataIntegrityViolationException e2) {
                        logger.warn("数据库存储错误:{} 以及前:{}个有效数据存储失败,原因:{}", person.getId(), personDetailDTOList.size(), e2);
                        continue;
                    }
                    e.printStackTrace();
                    continue;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (personDetailDTOList.size() == 100) {
                try {
                    peopleDetailMapper.saveDetails(personDetailDTOList);
                } catch (DataIntegrityViolationException e) {
                    logger.warn("数据库存储错误:{} 以及前99个有效数据存储失败,原因:{}", person.getId(), person.getId(), e);
                    personDetailDTOList = new LinkedList<PersonDetailDTO>();
                    continue;
                }
                personDetailDTOList = new LinkedList<PersonDetailDTO>();
            }
        }
    }

    public void loadCSVTest() {
        File file = new File("D:\\testFile\\1-200W.csv");
        FileReader fReader = null;
        try {
            fReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CSVReader csvReader = new CSVReader(fReader);
        String[] strs = new String[0];

        while (true) {
            try {
                strs = csvReader.readNext();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
            if (strs != null && strs.length > 0) {
                for (String str : strs)
                    if (null != str && !str.equals(""))
                        System.out.print(str + " , ");
                System.out.println("\n---------------");
            }

        }
    }

    private PersonDetailDTO getPerson(String[] strs) {
        PersonDetailDTO person = new PersonDetailDTO();
        person.setId(getCellLongNumber(idIndex, strs));
        person.setAddress(getAddressString(addressIndex, strs));
        person.setCtfId(getCtfId(ctfIdIndex, strs));
        person.setBirthday(getBirthdayFromId(person.getCtfId()));
        person.setCompany(getCompanyString(companyIndex, strs));
        person.setDistrictId(getCellNumber(districtIndex, strs));
        person.seteMail(getCelleMailString(eMailIndex, strs));
        person.setGender(getCellString(genderIndex, strs));
        person.setMobile(getCellString(mobileIndex, strs));
        person.setName(getCellNameString(nameIndex, strs));
        person.setProvinceId(getCellNumber(provinceIdIndex, strs));
        person.setTel(getCellString(telIndex, strs));

        checkTelephone(person);
        System.out.println(person.getId());
        return person;
    }

    private String getCompanyString(int index, String[] strs) {
        String text = getCellString(index, strs);
        if (StringUtils.isBlank(text) || text.length() > 255) {
            return "";
        }
        return text;
    }

    private String getCelleMailString(int index, String[] strs) {
        String text = getCellString(index, strs);
        if (StringUtils.isBlank(text) || text.length() > 64) {
            return "";
        }
        return text;
    }

    private String getCellNameString(int index, String[] strs) {
        String text = getCellString(index, strs);
        if (StringUtils.isNotBlank(text) && text.length() > 16) {
            throw new IllegalDataException("名称过长:" + text);
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
            throw new IllegalDataException("手机号不合法,tel:" + person.getTel() + "  mobile:" + person.getMobile() );
        }
    }

    private boolean isTelephone(String tel) {
        return org.apache.commons.lang3.StringUtils.isNotBlank(tel) && tel.length() == 11;
    }

    private String getAddressString(int index, String[] strs) {
        String text = getCellString(index, strs);
        if (StringUtils.isEmpty(text) && text.equals("-")) {
            return "";
        }
        return text;
    }

    private long getCellLongNumber(int index, String[] strs) {
        String text = getCellString(index, strs);
        try {
            return Long.parseLong(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int getCellNumber(int index, String[] strs) {
        String text = getCellString(index, strs);
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String getCtfId(int ctfIdIndex, String[] strs) {
        String ctfId = getCellString(ctfIdIndex, strs);
        if (org.apache.commons.lang3.StringUtils.isBlank(ctfId) || ctfId.length() != 18) {
            throw new IllegalDataException("身份证id错误:" + ctfId);
        }
        return ctfId;
    }

    private String getBirthdayFromId(String ctfId) {
        return ctfId.substring(6, 14);
    }

    private String getCellString(int index, String[] strs) {

        return strs[index];
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
*/
