DROP SCHEMA IF EXISTS ejournal CASCADE;

CREATE SCHEMA ejournal;

CREATE TABLE ejournal.class (
  id         integer  NOT NULL,
  number     smallint NOT NULL,
  liter      "char"   NOT NULL,
  id_teacher smallint NOT NULL,
  id_period  smallint NOT NULL
);

CREATE SEQUENCE ejournal.class_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.class_id_seq
  OWNED BY ejournal.class.id;

------------------------------------------------------------

CREATE TABLE ejournal.exam (
  id         integer                     NOT NULL,
  id_class   integer                     NOT NULL,
  id_subject smallint                    NOT NULL,
  datetime   timestamp without time zone NOT NULL
);

CREATE SEQUENCE ejournal.exam_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.exam_id_seq
  OWNED BY ejournal.exam.id;

------------------------------------------------------------

CREATE TABLE ejournal.exam_mark (
  id       integer                     NOT NULL,
  value    smallint                    NOT NULL,
  id_exam  integer                     NOT NULL,
  id_pupil integer                     NOT NULL,
  datetime timestamp without time zone NOT NULL
);

CREATE SEQUENCE ejournal.exam_mark_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.exam_mark_id_seq
  OWNED BY ejournal.exam_mark.id;

--------------------------------------------------------------

CREATE TABLE ejournal.homework (
  id                 integer NOT NULL,
  id_lesson_receive  integer NOT NULL,
  id_lesson_complete integer,
  description        text    NOT NULL
);

CREATE SEQUENCE ejournal.homework_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.homework_id_seq
  OWNED BY ejournal.homework.id;

------------------------------------------------------------

CREATE TABLE ejournal.lesson (
  id           integer NOT NULL,
  id_timetable integer NOT NULL,
  date         date    NOT NULL,
  comment      text
);

CREATE SEQUENCE ejournal.lesson_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.lesson_id_seq
  OWNED BY ejournal.lesson.id;

------------------------------------------------------------

CREATE TABLE ejournal.lesson_mark (
  id          integer                     NOT NULL,
  value       smallint                    NOT NULL,
  id_pupil    integer                     NOT NULL,
  id_lesson   integer,
  id_homework integer,
  id_test     integer,
  comment     character varying(200),
  datetime    timestamp without time zone NOT NULL
);

CREATE SEQUENCE ejournal.lesson_mark_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.lesson_mark_id_seq
  OWNED BY ejournal.lesson_mark.id;

------------------------------------------------------------

CREATE TABLE ejournal.lesson_period (
  id         integer                NOT NULL,
  number     smallint               NOT NULL,
  time_start time without time zone NOT NULL,
  time_end   time without time zone NOT NULL,
  shift      smallint               NOT NULL
);

CREATE SEQUENCE ejournal.lesson_period_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.lesson_period_id_seq
  OWNED BY ejournal.lesson_period.id;

------------------------------------------------------------

CREATE TABLE ejournal.period (
  id             integer  NOT NULL,
  id_period_type smallint NOT NULL,
  date_start     date     NOT NULL,
  date_end       date     NOT NULL
);

CREATE SEQUENCE ejournal.period_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.period_id_seq
  OWNED BY ejournal.period.id;

------------------------------------------------------------

CREATE TABLE ejournal.period_mark (
  id         integer                     NOT NULL,
  value      smallint                    NOT NULL,
  id_pupil   bigint                      NOT NULL,
  id_subject smallint                    NOT NULL,
  id_period  smallint                    NOT NULL,
  datetime   timestamp without time zone NOT NULL
);

CREATE SEQUENCE ejournal.period_mark_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.period_mark_id_seq
  OWNED BY ejournal.period_mark.id;

------------------------------------------------------------

CREATE TABLE ejournal.period_type (
  id   integer               NOT NULL,
  name character varying(30) NOT NULL
);

CREATE SEQUENCE ejournal.period_type_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.period_type_id_seq
  OWNED BY ejournal.period_type.id;

------------------------------------------------------------

CREATE TABLE ejournal.pupil (
  id          integer               NOT NULL,
  description text,
  id_class    integer               NOT NULL,
  name        character varying(30) NOT NULL,
  surname     character varying(30) NOT NULL,
  patronymic  character varying(30) NOT NULL
);

CREATE SEQUENCE ejournal.pupil_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.pupil_id_seq
  OWNED BY ejournal.pupil.id;

------------------------------------------------------------

CREATE TABLE ejournal.subject (
  id   smallint               NOT NULL,
  name character varying(150) NOT NULL
);

CREATE SEQUENCE ejournal.subject_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.subject_id_seq
  OWNED BY ejournal.subject.id;

------------------------------------------------------------

CREATE TABLE ejournal.subject_teacher (
  id         integer  NOT NULL,
  id_subject smallint NOT NULL,
  id_teacher smallint NOT NULL
);

CREATE SEQUENCE ejournal.subject_teacher_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.subject_teacher_id_seq
  OWNED BY ejournal.subject_teacher.id;

------------------------------------------------------------

CREATE TABLE ejournal.teacher (
  id          integer               NOT NULL,
  name        character varying(30) NOT NULL,
  surname     character varying(30) NOT NULL,
  patronymic  character varying(30) NOT NULL,
  description text
);

CREATE SEQUENCE ejournal.teacher_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.teacher_id_seq
  OWNED BY ejournal.teacher.id;

------------------------------------------------------------

CREATE TABLE ejournal.test (
  id        integer NOT NULL,
  id_lesson integer NOT NULL
);

CREATE SEQUENCE ejournal.test_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.test_id_seq
  OWNED BY ejournal.test.id;

------------------------------------------------------------

CREATE TABLE ejournal.timetable (
  id               integer  NOT NULL,
  id_class         integer  NOT NULL,
  id_subject       integer  NOT NULL,
  id_teacher       smallint NOT NULL,
  id_lesson_period smallint NOT NULL,
  id_period        smallint NOT NULL,
  day_of_week      smallint NOT NULL
);

CREATE SEQUENCE ejournal.timetable_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.timetable_id_seq
  OWNED BY ejournal.timetable.id;

------------------------------------------------------------

ALTER TABLE ONLY ejournal.class
  ALTER COLUMN id SET DEFAULT nextval('ejournal.class_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.exam
  ALTER COLUMN id SET DEFAULT nextval('ejournal.exam_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.exam_mark
  ALTER COLUMN id SET DEFAULT nextval('ejournal.exam_mark_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.homework
  ALTER COLUMN id SET DEFAULT nextval('ejournal.homework_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.lesson
  ALTER COLUMN id SET DEFAULT nextval('ejournal.lesson_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.lesson_mark
  ALTER COLUMN id SET DEFAULT nextval('ejournal.lesson_mark_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.lesson_period
  ALTER COLUMN id SET DEFAULT nextval('ejournal.lesson_period_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.period
  ALTER COLUMN id SET DEFAULT nextval('ejournal.period_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.period_mark
  ALTER COLUMN id SET DEFAULT nextval('ejournal.period_mark_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.period_type
  ALTER COLUMN id SET DEFAULT nextval('ejournal.period_type_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.pupil
  ALTER COLUMN id SET DEFAULT nextval('ejournal.pupil_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.subject
  ALTER COLUMN id SET DEFAULT nextval('ejournal.subject_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.subject_teacher
  ALTER COLUMN id SET DEFAULT nextval('ejournal.subject_teacher_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.teacher
  ALTER COLUMN id SET DEFAULT nextval('ejournal.teacher_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.test
  ALTER COLUMN id SET DEFAULT nextval('ejournal.test_id_seq' :: regclass);


ALTER TABLE ONLY ejournal.timetable
  ALTER COLUMN id SET DEFAULT nextval('ejournal.timetable_id_seq' :: regclass);

------------------------------------------------------------

SELECT pg_catalog.setval('ejournal.class_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.exam_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.exam_mark_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.homework_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.lesson_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.lesson_mark_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.lesson_period_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.period_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.period_mark_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.period_type_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.pupil_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.subject_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.subject_teacher_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.teacher_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.test_id_seq', 1, false);

SELECT pg_catalog.setval('ejournal.timetable_id_seq', 1, false);

------------------------------------------------------------

ALTER TABLE ONLY ejournal.class
  ADD CONSTRAINT class_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.exam_mark
  ADD CONSTRAINT exam_mark_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.exam
  ADD CONSTRAINT exam_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.homework
  ADD CONSTRAINT homework_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.subject_teacher
  ADD CONSTRAINT id_subject_id_teacher_ukey UNIQUE (id_subject, id_teacher);

ALTER TABLE ONLY ejournal.lesson_mark
  ADD CONSTRAINT lesson_mark_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.lesson_period
  ADD CONSTRAINT lesson_period_number_shift_ukey UNIQUE (number, shift);

ALTER TABLE ONLY ejournal.lesson_period
  ADD CONSTRAINT lesson_period_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.lesson_period
  ADD CONSTRAINT lesson_period_time_end_ukey UNIQUE (time_end);

ALTER TABLE ONLY ejournal.lesson_period
  ADD CONSTRAINT lesson_period_time_start_ukey UNIQUE (time_start);

ALTER TABLE ONLY ejournal.lesson
  ADD CONSTRAINT lesson_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.period_mark
  ADD CONSTRAINT period_mark_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.period
  ADD CONSTRAINT period_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.period_type
  ADD CONSTRAINT period_type_name_ukey UNIQUE (name);

ALTER TABLE ONLY ejournal.period_type
  ADD CONSTRAINT period_type_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.pupil
  ADD CONSTRAINT pupil_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.subject
  ADD CONSTRAINT subject_name_ukey UNIQUE (name);

ALTER TABLE ONLY ejournal.subject
  ADD CONSTRAINT subject_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.subject_teacher
  ADD CONSTRAINT subject_teacher_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.teacher
  ADD CONSTRAINT teacher_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.test
  ADD CONSTRAINT test_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.timetable
  ADD CONSTRAINT timetable_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.class
  ADD CONSTRAINT class_id_period_fkey FOREIGN KEY (id_period) REFERENCES ejournal.period (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.class
  ADD CONSTRAINT class_id_teacher_fkey FOREIGN KEY (id_teacher) REFERENCES ejournal.teacher (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.exam
  ADD CONSTRAINT exam_id_class_fkey FOREIGN KEY (id_class) REFERENCES ejournal.class (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.exam
  ADD CONSTRAINT exam_id_subject_fkey FOREIGN KEY (id_subject) REFERENCES ejournal.subject (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.exam_mark
  ADD CONSTRAINT exam_mark_id_exam_fkey FOREIGN KEY (id_exam) REFERENCES ejournal.exam (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.exam_mark
  ADD CONSTRAINT exam_mark_id_pupil_fkey FOREIGN KEY (id_pupil) REFERENCES ejournal.pupil (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.homework
  ADD CONSTRAINT homework_id_lesson_complete_fkey FOREIGN KEY (id_lesson_complete) REFERENCES ejournal.lesson (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.homework
  ADD CONSTRAINT homework_id_lesson_receive_fkey FOREIGN KEY (id_lesson_receive) REFERENCES ejournal.lesson (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.lesson
  ADD CONSTRAINT lesson_id_timetable_fkey FOREIGN KEY (id_timetable) REFERENCES ejournal.timetable (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.lesson_mark
  ADD CONSTRAINT lesson_mark_id_homework_fkey FOREIGN KEY (id_homework) REFERENCES ejournal.homework (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.lesson_mark
  ADD CONSTRAINT lesson_mark_id_lesson_fkey FOREIGN KEY (id_lesson) REFERENCES ejournal.lesson (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.lesson_mark
  ADD CONSTRAINT lesson_mark_id_pupil_fkey FOREIGN KEY (id_pupil) REFERENCES ejournal.pupil (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.lesson_mark
  ADD CONSTRAINT lesson_mark_id_test_fkey FOREIGN KEY (id_test) REFERENCES ejournal.test (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.period
  ADD CONSTRAINT period_id_period_type_fkey FOREIGN KEY (id_period_type) REFERENCES ejournal.period_type (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.period_mark
  ADD CONSTRAINT period_mark_id_period_fkey FOREIGN KEY (id_period) REFERENCES ejournal.period (id);

ALTER TABLE ONLY ejournal.period_mark
  ADD CONSTRAINT period_mark_id_pupil_fkey FOREIGN KEY (id_pupil) REFERENCES ejournal.pupil (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.period_mark
  ADD CONSTRAINT period_mark_id_subject_fkey FOREIGN KEY (id_subject) REFERENCES ejournal.subject (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.pupil
  ADD CONSTRAINT pupil_id_class_fkey FOREIGN KEY (id_class) REFERENCES ejournal.class (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.subject_teacher
  ADD CONSTRAINT subject_teacher_id_subject_fkey FOREIGN KEY (id_subject) REFERENCES ejournal.subject (id);

ALTER TABLE ONLY ejournal.subject_teacher
  ADD CONSTRAINT subject_teacher_id_teacher_fkey FOREIGN KEY (id_teacher) REFERENCES ejournal.teacher (id);

ALTER TABLE ONLY ejournal.test
  ADD CONSTRAINT test_id_lesson_fkey FOREIGN KEY (id_lesson) REFERENCES ejournal.lesson (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.timetable
  ADD CONSTRAINT timetable_id_class_fkey FOREIGN KEY (id_class) REFERENCES ejournal.class (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.timetable
  ADD CONSTRAINT timetable_id_lesson_period_fkey FOREIGN KEY (id_lesson_period) REFERENCES ejournal.lesson_period (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.timetable
  ADD CONSTRAINT timetable_id_subject_fkey FOREIGN KEY (id_subject) REFERENCES ejournal.subject (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY ejournal.timetable
  ADD CONSTRAINT timetable_id_teacher_fkey FOREIGN KEY (id) REFERENCES ejournal.teacher (id) ON UPDATE CASCADE ON DELETE CASCADE;
