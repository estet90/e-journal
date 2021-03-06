package ru.salix.ejournal.api.error.operation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.salix.ejournal.error.operation.OperationCode;

import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static org.apache.logging.log4j.ThreadContext.get;
import static ru.salix.ejournal.api.constant.ThreadContextField.OPERATION_NAME;

@Getter
@RequiredArgsConstructor
public enum ModuleOperationCode implements OperationCode {

    TEACHERS_FIND("0101", "teachersFind"),
    TEACHERS_FIND_BY_ID("0102", "teachersFindById"),
    TEACHERS_FILTER("0103", "teachersFilter"),
    TEACHERS_CREATE("0104", "teachersCreate"),
    TEACHERS_UPDATE("0105", "teachersUpdate"),
    TEACHERS_DELETE("0106", "teachersDelete"),
    TEACHERS_SUBJECTS_FIND("0107", "teachersSubjectsFind"),
    TEACHERS_SUBJECTS_ADD("0108", "teachersSubjectsAdd"),
    TEACHERS_SUBJECTS_DELETE("0109", "teachersSubjectsDelete"),
    TEACHERS_CLASSES("0110", "teachersClasses"),

    SUBJECTS_FIND("0201", "subjectsFind"),
    SUBJECTS_FIND_BY_ID("0202", "subjectsFindById"),
    SUBJECTS_FILTER("0203", "subjectsFilter"),
    SUBJECTS_CREATE("0204", "subjectsCreate"),
    SUBJECTS_UPDATE("0205", "subjectsUpdate"),
    SUBJECTS_DELETE("0206", "subjectsDelete"),

    PUPILS_FIND("0301", "pupilsFind"),
    PUPILS_FIND_BY_ID("0302", "pupilsFindById"),
    PUPILS_FILTER("0303", "pupilsFilter"),
    PUPILS_CREATE("0304", "pupilsCreate"),
    PUPILS_UPDATE("0305", "pupilsUpdate"),
    PUPILS_DELETE("0306", "pupilsDelete"),

    EXAMS_FIND("0401", "examsFind"),
    EXAMS_FIND_BY_ID("0402", "examsFindById"),
    EXAMS_FILTER("0403", "examsFilter"),
    EXAMS_CREATE("0404", "examsCreate"),
    EXAMS_UPDATE("0405", "examsUpdate"),
    EXAMS_DELETE("0406", "examsDelete"),

    CLASSES_FIND("0501", "classesFind"),
    CLASSES_FIND_BY_ID("0502", "classesFindById"),
    CLASSES_FILTER("0503", "classesFilter"),
    CLASSES_CREATE("0504", "classesCreate"),
    CLASSES_UPDATE("0505", "classesUpdate"),
    CLASSES_DELETE("0506", "classesDelete"),
    CLASSES_PUPILS_ADD("0507", "classesPupilsAdd"),
    CLASSES_PUPILS_DELETE("0508", "classesPupilsDelete"),

    TIMETABLES_FIND("0601", "timetablesFind"),
    TIMETABLES_FIND_BY_ID("0602", "timetablesFindById"),
    TIMETABLES_FILTER("0603", "timetablesFilter"),
    TIMETABLES_CREATE("0604", "timetablesCreate"),
    TIMETABLES_UPDATE("0605", "timetablesUpdate"),
    TIMETABLES_DELETE("0606", "timetablesDelete"),

    EXAM_MARKS_FIND("0701", "examMarksFind"),
    EXAM_MARKS_FIND_BY_ID("0702", "examMarksFindById"),
    EXAM_MARKS_FILTER("0703", "examMarksFilter"),
    EXAM_MARKS_CREATE("0704", "examMarksCreate"),
    EXAM_MARKS_UPDATE("0705", "examMarksUpdate"),
    EXAM_MARKS_DELETE("0706", "examMarksDelete"),

    LESSON_MARKS_FIND("0801", "lessonMarksFind"),
    LESSON_MARKS_FIND_BY_ID("0802", "lessonMarksFindById"),
    LESSON_MARKS_FILTER("0803", "lessonMarksFilter"),
    LESSON_MARKS_CREATE("0804", "lessonMarksCreate"),
    LESSON_MARKS_UPDATE("0805", "lessonMarksUpdate"),
    LESSON_MARKS_DELETE("0806", "lessonMarksDelete"),

    PERIOD_MARKS_FIND("0901", "periodMarksFind"),
    PERIOD_MARKS_FIND_BY_ID("0902", "periodMarksFindById"),
    PERIOD_MARKS_FILTER("0903", "periodMarksFilter"),
    PERIOD_MARKS_CREATE("0904", "periodMarksCreate"),
    PERIOD_MARKS_UPDATE("0905", "periodMarksUpdate"),
    PERIOD_MARKS_DELETE("0906", "periodMarksDelete"),

    HOMEWORK_MARKS_FIND("1001", "homeworkMarksFind"),
    HOMEWORK_MARKS_FIND_BY_ID("1002", "homeworkMarksFindById"),
    HOMEWORK_MARKS_FILTER("1003", "homeworkMarksFilter"),
    HOMEWORK_MARKS_CREATE("1004", "homeworkMarksCreate"),
    HOMEWORK_MARKS_UPDATE("1005", "homeworkMarksUpdate"),
    HOMEWORK_MARKS_DELETE("1006", "homeworkMarksDelete"),

    LESSON_PERIODS_FIND("1101", "lessonPeriodsFind"),
    LESSON_PERIODS_FIND_BY_ID("1102", "lessonPeriodsFindById"),
    LESSON_PERIODS_FILTER("1103", "lessonPeriodsFilter"),

    PERIOD_TYPES_FIND("1201", "periodTypesFind"),
    PERIOD_TYPES_FIND_BY_ID("1202", "periodTypesFindById"),
    PERIOD_TYPES_FILTER("1203", "periodTypesFilter"),

    PERIODS_FIND("1301", "periodsFind"),
    PERIODS_FIND_BY_ID("1302", "periodsFindById"),
    PERIODS_FILTER("1303", "periodsFilter"),
    PERIODS_CREATE("1304", "periodsCreate"),
    PERIODS_UPDATE("1305", "periodsUpdate"),

    TESTS_FIND("1401", "testsFind"),
    TESTS_FIND_BY_ID("1402", "testsFindById"),
    TESTS_FILTER("1403", "testsFilter"),
    TESTS_CREATE("1404", "testsCreate"),
    TESTS_UPDATE("1405", "testsUpdate");

    private final String code;
    private final String name;

    public static OperationCode resolve() {
        Optional<OperationCode> operationCode = ofNullable(get(OPERATION_NAME)).map(ModuleOperationCode::find);
        return operationCode.orElse(() -> OTHER);
    }

    private static ModuleOperationCode find(String name) {
        return stream(values())
                .filter(operationCode -> operationCode.name.equals(name))
                .findAny()
                .orElse(null);
    }

}
