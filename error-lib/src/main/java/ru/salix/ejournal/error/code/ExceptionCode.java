package ru.salix.ejournal.error.code;

import ru.salix.ejournal.error.exception.BaseException;

public interface ExceptionCode<T extends BaseException> {

    String OTHER = "999";

    String getCode();

}
