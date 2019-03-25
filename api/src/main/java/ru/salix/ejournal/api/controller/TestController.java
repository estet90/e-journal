package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.handler.TestControllerHandler;
import ru.salix.ejournal.api.model.api.TestDto;
import ru.salix.ejournal.api.model.api.filter.TestFilterDto;

import java.time.LocalDate;
import java.util.List;

import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestController {

    private final TestControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<TestDto>> findTests() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findTests()), TESTS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestDto> findTestById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findTestById(id)), TESTS_FIND_BY_ID);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TestDto>> filter(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "dateFrom", required = false) LocalDate dateFrom,
            @RequestParam(value = "dateTo", required = false) LocalDate dateTo,
            @RequestParam(value = "subject", required = false) String subject,
            @RequestParam(value = "className", required = false) String className
    ) {
        var filter = TestFilterDto.builder()
                .id(id)
                .dateFrom(dateFrom)
                .dateTo(dateTo)
                .subject(subject)
                .className(className)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), TESTS_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createTest(
            @RequestBody TestDto testDto
    ) {
        return fillOperationName(() -> ResponseEntity.status(HttpStatus.CREATED).body(handler.createTest(testDto)), TESTS_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateTest(
            @RequestBody TestDto testDto,
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updateTest(testDto, id)), TESTS_UPDATE);
    }

}
