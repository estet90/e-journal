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
    SUBJECTS_FILTER("0203", "subjectsFilter");

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
