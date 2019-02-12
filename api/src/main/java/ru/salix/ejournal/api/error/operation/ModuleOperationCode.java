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
    PUPILS_FIND_BY_ID("0301", "pupilsFindById"),
    PUPILS_FILTER("0303", "pupilsFilter"),
    PUPILS_CREATE("0304", "pupilsCreate"),
    PUPILS_UPDATE("0305", "pupilsUpdate"),
    PUPILS_DELETE("0306", "pupilsDelete"),

    EXAMS_FIND("0401", "examsFind"),
    EXAMS_FIND_BY_ID("0401", "examsFindById"),
    EXAMS_FILTER("0403", "examsFilter"),
    EXAMS_CREATE("0404", "examsCreate"),
    EXAMS_UPDATE("0405", "examsUpdate"),
    EXAMS_DELETE("0406", "examsDelete"),

    CLASSES_FIND("0501", "classesFind"),
    CLASSES_FIND_BY_ID("0501", "classesFindById"),
    CLASSES_FILTER("0503", "classesFilter"),
    CLASSES_CREATE("0504", "classesCreate"),
    CLASSES_UPDATE("0505", "classesUpdate"),
    CLASSES_DELETE("0506", "classesDelete"),
    CLASSES_PUPILS_ADD("0507", "classesPupilsAdd"),
    CLASSES_PUPILS_DELETE("0508", "classesPupilsDelete"),

    TIMETABLES_FIND("0601", "timetablesFind"),
    TIMETABLES_FIND_BY_ID("0601", "timetablesFindById"),
    TIMETABLES_FILTER("0603", "timetablesFilter"),
    TIMETABLES_CREATE("0604", "timetablesCreate"),
    TIMETABLES_UPDATE("0605", "timetablesUpdate"),
    TIMETABLES_DELETE("0606", "timetablesDelete");

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
