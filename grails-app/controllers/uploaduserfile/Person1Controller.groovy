package uploaduserfile

import co.UploadUserFileCO
import jxl.LabelCell
import jxl.NumberCell
import jxl.Sheet
import jxl.Workbook

import java.time.LocalDate
import java.time.format.DateTimeFormatter


class Person1Controller {

    private final static int COLUMN_LAST_NAME = 0
    private final static int COLUMN_FIRST_NAME = 1
    private final static int COLUMN_DATE_OF_BIRTH = 2
    private final static int COLUMN_NUMBER_OF_CHILDREN = 3

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [personInstanceList: Person1.list(params), personInstanceTotal: Person1.count()]
    }

    def upload() {
    }

    def doUpload(UploadUserFileCO co) {
        Workbook workbook = Workbook.getWorkbook(co.myFile.inputStream);
        Sheet sheet = workbook.getSheet(0);

        // skip first row (row 0) by starting from 1
        for (int row = 1; row < sheet.getRows(); row++) {
            LabelCell lastName = sheet.getCell(COLUMN_LAST_NAME, row) as LabelCell
            LabelCell firstName = sheet.getCell(COLUMN_FIRST_NAME, row) as LabelCell
            LabelCell dateOfBirth = sheet.getCell(COLUMN_DATE_OF_BIRTH, row) as LabelCell
            NumberCell numberOfChildren = sheet.getCell(COLUMN_NUMBER_OF_CHILDREN, row) as NumberCell

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(dateOfBirth.string, formatter);

            new Person1(lastName:lastName.string , firstName:firstName.string , dateOfBirth:localDate, numberOfChildren:numberOfChildren.value).save()

        }
        redirect(controller: 'person1')
    }

}